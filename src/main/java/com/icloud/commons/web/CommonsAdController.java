package com.icloud.commons.web;

import com.icloud.annotation.SysLog;
import com.icloud.common.msg.BaseResponse;
import com.icloud.commons.service.CommonsAdService;
import com.icloud.commons.model.CommonsAd;
import com.icloud.basecommon.web.BaseIdLongController;
import com.icloud.basecommon.model.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.Map;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Mr.Z
 * @email 512162086@qq.com
 * @date 2019-12-24 09:06:27
 * 菜单主连接： ./backpage/commonsAd/list
 */
@Controller
@RequestMapping(value = "${backPath}/commonsAd")
public class CommonsAdController extends BaseIdLongController<CommonsAdService,CommonsAd> {

    @Override
	public String list(CommonsAd t, @RequestParam Map<String, Object> params) {
		Query query =  new Query(params);
		PageInfo<CommonsAd> page = baseService.findByPage(query.getPageNum(), query.getPageSize(), query);
		request.setAttribute("page", page);
		request.setAttribute("record", t);
        return "commons/commons_ad_list";
	}

	@Override
	public String toinput(Long id) {
		Object commonsAd = baseService.getById(id);
		request.setAttribute("record", commonsAd);
		return "commons/commons_ad_input";
	}

    /**
     *新增
     * @return
     */
    @SysLog("添加")
    @RequestMapping(value = "/add")
    @ResponseBody
    @Override
    public BaseResponse add(CommonsAd t){
        try {
            t.setCreateTime(new Date());
            t.setCreateOperator(getLoginAdmin().getAccount());
            boolean result = baseService.save(t);
            if(result)
                return new BaseResponse(200,"0000","保存成功");
            else
                return new BaseResponse(200,"1000","保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return new BaseResponse(200,"2000","系统异常");
        }
    }

    /**
     *更新
     * @return
     */
    @SysLog("更新")
    @RequestMapping(value = "/update")
    @ResponseBody
    @Override
    public  BaseResponse update(CommonsAd t){
        try {
            t.setModifyTime(new Date());
            t.setModifyOperator(getLoginAdmin().getAccount());
            boolean result = baseService.updateById(t);
            if(result)
                return new BaseResponse(200,"0000","更新成功");
            else
                return new BaseResponse(200,"1000","更新失败");
        }catch (Exception e){
            e.printStackTrace();
            return new BaseResponse(200,"2000","系统异常");
        }
    }

}