package com.icloud.basecommon.util.logs;

import com.icloud.basecommon.util.http.UserAgentUtils;
import com.icloud.basecommon.util.lang.ExceptionUtils;
import com.icloud.basecommon.util.lang.StringUtils;
import com.icloud.bms.model.BmsAdmin;
import com.icloud.bms.model.BmsLogs;
import com.icloud.bms.model.BmsLogsWithBLOBs;
import com.icloud.bms.model.BmsMenu;
import com.icloud.bms.service.BmsLogsService;
import com.icloud.common.IpUtil;
import com.icloud.common.SpringContextHolder;
import com.icloud.common.util.StringUtil;
import eu.bitwalker.useragentutils.UserAgent;
import org.apache.commons.lang.ObjectUtils;
import org.apache.ibatis.mapping.SqlCommandType;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

//import com.icloud.common.util.StringUtil;

//import com.icloud.common.util.StringUtil;

/**
 * Created by 512162086@qq.com on 2018/12/3 .
 */
public class LogUtils {

    private static final class Static {
        private static BmsLogsService logService = SpringContextHolder.getBean(BmsLogsService.class);
    }

//    public static void saveLog(BmsAdmin obj, HttpServletRequest request, Object handler, Exception ex, Object o, Object o1, long executeTime){
//        saveLog
//    }

    /**
     * 保存日志
     * @param executeTime
     */
    public static void saveLog(BmsAdmin user, HttpServletRequest request, Object handler, Exception ex, String logTitle, String logType, long executeTime){
        if (user == null || StringUtils.isBlank(user.getAccount()) || request == null){
            return;
        }
        BmsLogsWithBLOBs log = new BmsLogsWithBLOBs();
        log.setLogTitle(logTitle);
        log.setLogType(logType);
        if (StringUtils.isBlank(log.getLogType())){
            String sqlCommandTypes = ObjectUtils.toString(request.getAttribute(SqlCommandType.class.getName()));
            if (StringUtils.containsAny(","+sqlCommandTypes+",", ",INSERT,", ",UPDATE,", ",DELETE,")){
                log.setLogType(BmsLogs.TYPE_UPDATE);
            }else if (StringUtils.contains(","+sqlCommandTypes+",", ",SELECT,")){
                log.setLogType(BmsLogs.TYPE_SELECT);
            }else{
                log.setLogType(BmsLogs.TYPE_ACCESS);
            }
        }
        log.setServerAddr(request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort());
        log.setRemoteAddr(IpUtil.getIpAddr(request));
        UserAgent userAgent = UserAgentUtils.getUserAgent(request);
        log.setDeviceName(userAgent.getOperatingSystem().getName());
        log.setBrowserName(userAgent.getBrowser().getName());
        log.setUserAgent(request.getHeader("User-Agent"));
        log.setRequestUri(StringUtils.abbr(request.getRequestURI(), 255));
        log.setRequestParams(request.getParameterMap());
        log.setRequestMethod(request.getMethod());
        log.setExecuteTime(executeTime);
        log.setCreateBy(user.getAccount());
        log.setCreateTime(new Date());
        // 获取异常对象
        Throwable throwable = null;
        if (ex != null){
            throwable = ExceptionUtils.getThrowable(request);
        }

        // 异步保存日志
        new SaveLogThread(log, handler, request.getContextPath(), throwable).start();
    }
    /**
     * 保存日志线程
     */
    public static class SaveLogThread extends Thread{

        private BmsLogsWithBLOBs log;
        private Object handler;
        private String contextPath;
        private Throwable throwable;

        public SaveLogThread(BmsLogsWithBLOBs log, Object handler, String contextPath, Throwable throwable){
            super(SaveLogThread.class.getSimpleName());
            this.log = log;
            this.handler = handler;
            this.contextPath = contextPath;
            this.throwable = throwable;
        }

        @Override
        public void run() {
            // 获取日志标题
            if (StringUtils.isBlank(log.getLogTitle())){

                String href = log.getRequestUri();
                if(StringUtil.checkObj(href)){
                    int index =  href.lastIndexOf("/");
                    if(index>-1){
                        href =  href.substring(0,index);
                        if(href.indexOf("zlbean")>-1){
                            href =href.replaceAll("/zlbean/","/");
                        }
                        BmsMenu bmsMenu = new BmsMenu();
                        bmsMenu.setMenuUrl(href);
                        List<BmsMenu> bmsMenulist = Static.logService.selectMenuByUrl(bmsMenu);
                        if(bmsMenulist!=null && bmsMenulist.size()>0){
                            log.setLogTitle(bmsMenulist!=null?bmsMenulist.get(0).getMenuName():"未知操作");
                        }
                    }
                }
            }
            if (StringUtils.isBlank(log.getLogTitle())){
                log.setLogTitle("未知操作");
            }
            // 如果有异常，设置异常信息（将异常对象转换为字符串）
            log.setIsException(throwable != null ?"1":"0");
            log.setExceptionInfo(ExceptionUtils.getStackTraceAsString(throwable));
            // 如果无地址并无异常日志，则不保存信息
            if (StringUtils.isBlank(log.getRequestUri()) && StringUtils.isBlank(log.getExceptionInfo())){
                return;
            }
            // 保存日志信息
            Static.logService.save(log);

        }
    }
}
