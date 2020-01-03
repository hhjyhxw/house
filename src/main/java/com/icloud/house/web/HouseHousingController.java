package com.icloud.house.web;

import com.alibaba.fastjson.JSON;
import com.icloud.annotation.SysLog;
import com.icloud.common.msg.BaseResponse;
import com.icloud.common.util.StringUtil;
import com.icloud.house.model.HouseAttrubit;
import com.icloud.house.service.HouseAttrubitService;
import com.icloud.house.service.HouseHousingService;
import com.icloud.house.model.HouseHousing;
import com.icloud.basecommon.web.BaseIdLongController;
import com.icloud.basecommon.model.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Mr.Z
 * @email 512162086@qq.com
 * @date 2019-11-01 21:46:51
 * 菜单主连接： ./backpage/houseHousing/list
 */
@Controller
@RequestMapping(value = "${backPath}/houseHousing")
public class HouseHousingController extends BaseIdLongController<HouseHousingService,HouseHousing> {

    @Autowired
    private HouseAttrubitService houseAttrubitService;
    @Override
	public String list(HouseHousing t, @RequestParam Map<String, Object> params) {
		Query query =  new Query(params);
		PageInfo<HouseHousing> page = baseService.findByPage(query.getPageNum(), query.getPageSize(), query);
		request.setAttribute("page", page);
		request.setAttribute("record", t);
        return "house/house_housing_list";
	}

	@Override
	public String toinput(Long id) {
		Object houseHousing = baseService.getById(id);
		request.setAttribute("record", houseHousing);
		return "house/house_housing_input";
	}


    /**
     * @param id   房源id
     * @return
     */
    @SysLog("跳转房源属性编辑页")
    @RequestMapping(value = "/toEditTags")
    public String toEditTags(Long id) {
        HouseHousing houseHousing = (HouseHousing) baseService.getById(id);
        request.setAttribute("record", houseHousing);
        List<HouseAttrubit> attributList = houseAttrubitService.list();
        request.setAttribute("attributList", attributList!=null?JSON.toJSONString(attributList):null);
//        request.setAttribute("tagsList",  StringUtil.checkStr(houseHousing.getTags())? JSON.parseArray(houseHousing.getTags()):null);
        request.setAttribute("tagsList",  StringUtil.checkStr(houseHousing.getDescribes())? JSON.parseArray(houseHousing.getDescribes()):null);
        log.info("house_tags==="+(StringUtil.checkStr(houseHousing.getDescribes())? JSON.parseArray(houseHousing.getDescribes()):null));
        return "house/housing/house_jsonattrubit_input";
    }


    /**
     * @param id   房源id
     * @return
     */
    @SysLog("保存房源属性列表")
    @RequestMapping(value = "/saveAttributList")
    @ResponseBody
    public BaseResponse saveAttributList(Long id,String tags) {
        log.info("id=="+id);
        log.info("tags=="+tags);
        HouseHousing houseHousing = new HouseHousing();
        houseHousing.setId(id);
//        houseHousing.setTags(tags);
        houseHousing.setDescribes(tags);
        if(StringUtil.checkStr(tags)){
            houseAttrubitService.updateBath(JSON.parseArray(tags,HouseAttrubit.class));
            boolean result = baseService.updateById(houseHousing);
            if(result)
                return new BaseResponse(200,"0000","保存成功");
            else
                return new BaseResponse(200,"1000","保存失败");
        }
        return new BaseResponse(200,"1000","保存失败");

    }
}