/**
 * @author
 * @version
 * 2018年7月9日 上午9:54:17
 */
package com.icloud.bms.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.icloud.bms.model.BmsLogs;
import com.icloud.bms.model.BmsLogsWithBLOBs;
import com.icloud.bms.service.BmsLogsService;
import com.icloud.common.DateTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 类名称: BmsLogsController
 * 类描述: 日志列表
 * 创建人: zhangdehai
 * 创建时间:2018年7月9日 上午9:54:17
 */
@Controller
@RequestMapping(value = "${backPath}/bmsLogs")
public class BmsLogsController{


	@Autowired 
	private BmsLogsService bmsLogsService;

	@InitBinder
	public void intDate(WebDataBinder dataBinder){
		dataBinder.addCustomFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));
	}


	@RequestMapping("/list")
	public String list(HttpServletRequest request, BmsLogsWithBLOBs t)
			throws Exception {
		PageInfo<BmsLogsWithBLOBs> page = bmsLogsService.findByPage(1, 10, t);
		request.setAttribute("page", page);
		request.setAttribute("record", t);
		return "bms/bms_logs_list";
	}


	@RequestMapping("/getList")
	@ResponseBody
	public JSONObject getList(HttpServletRequest request,
			HttpServletResponse response,BmsLogsWithBLOBs t,int pageNo,int pageSize) throws Exception {

		PageInfo<BmsLogsWithBLOBs> page = bmsLogsService.findByPage(pageNo>0?pageNo:1,pageSize>1?pageSize:10, t);
		List<BmsLogsWithBLOBs> list = page.getList();
		JSONObject json = new JSONObject();
		json.put("pages",page.getPages());
		JSONArray array = new JSONArray();
		for(BmsLogs s:list){
			JSONObject sub = new JSONObject();
			sub.put("id",s.getId());
			sub.put("logTitle",s.getLogTitle());
			sub.put("requestUri",s.getRequestUri());
			sub.put("requestMethod",s.getRequestMethod());
			sub.put("remoteAddr",s.getRemoteAddr());
			sub.put("serverAddr", s.getServerAddr());
			sub.put("isException","1".equals(s.getIsException())?"是":"否");
			sub.put("userAgent", s.getUserAgent());
			sub.put("deviceName", s.getDeviceName());
			sub.put("browserName", s.getBrowserName());
			sub.put("executeTime",s.getExecuteTime()!=null?s.getExecuteTime()/1000:0);
			sub.put("createBy", s.getCreateBy());
			sub.put("createTime",DateTools.date2Str(s.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
			array.add(sub);
		}
		json.put("list", array);
		return json;
	}

	@RequestMapping("/toinput")
	public String toinput(Long id, HttpServletRequest request)
			throws Exception {
		return "appointment/back/appointment_activity_input";
	}



	@RequestMapping("/del")
	public String del(Long id, HttpServletResponse response)
			throws Exception {

		return null;
	}


	
}
