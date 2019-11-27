package com.icloud.xcx.web;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.icloud.annotation.LoginUser;
import com.icloud.basecommon.model.Query;
import com.icloud.common.util.StringUtil;
import com.icloud.house.model.HouseHousing;
import com.icloud.house.service.HouseHousingService;
import com.icloud.wx.model.WxUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping(value = "${xcxPath}/housePub")
public class HousePubController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private HouseHousingService houseHousingService;


    /**
     * 1、新房原发布
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/newHousePub")
    public Object list(HttpServletRequest request, @RequestBody HouseHousing t, @LoginUser WxUser user) {
        JSONObject resultJson = new JSONObject();
        try {
            t.setHouseType(2);//分类（1、写字楼、2 新房 3、共享办公、4租房）
            t.setRentable("0");//是否可以租(0不可以组,1可以组)
            t.setPubUser(user.getId());
            t.setCreateMan(user.getId());
            t.setCreateTime(new Date());
            houseHousingService.save(t);
            resultJson.put("errCode", "0000");
            resultJson.put("resultMsg", "发布成功");
        } catch (Exception ex) {
            log.error("error=====", ex);
            ex.printStackTrace();
            resultJson.put("errCode", "0001");
            resultJson.put("resultMsg", "发布失败");
        }
        log.error("resultJson=====" + resultJson);
        return resultJson;
    }

    /**
     * 2、写字楼售发布
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/officeBuildingPub")
    public Object officeBuildingPub(HttpServletRequest request, @RequestBody HouseHousing t, @LoginUser WxUser user) {
        JSONObject resultJson = new JSONObject();
        try {
            t.setHouseType(1);//分类（1、写字楼、2 新房 3、共享办公、4租房）
            t.setRentable("0");//是否可以租(0不可以组,1可以组)
            t.setPubUser(user.getId());
            t.setCreateMan(user.getId());
            t.setCreateTime(new Date());
            houseHousingService.save(t);
            resultJson.put("errCode", "0000");
            resultJson.put("resultMsg", "发布成功");
        } catch (Exception ex) {
            log.error("error=====", ex);
            ex.printStackTrace();
            resultJson.put("errCode", "0001");
            resultJson.put("resultMsg", "发布失败");
        }
        log.error("resultJson=====" + resultJson);
        return resultJson;
    }

    /**
     * 3、写字楼租发布
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/officeBuildingRentPub")
    public Object officeBuildingRentPub(HttpServletRequest request, @RequestBody HouseHousing t, @LoginUser WxUser user) {
        JSONObject resultJson = new JSONObject();
        try {
            t.setHouseType(1);//分类（1、写字楼、2 新房 3、共享办公、4租房）
            t.setRentable("1");//是否可以租(0不可以组,1可以组)
            t.setPubUser(user.getId());
            t.setCreateMan(user.getId());
            t.setCreateTime(new Date());
            houseHousingService.save(t);
            resultJson.put("errCode", "0000");
            resultJson.put("resultMsg", "发布成功");
        } catch (Exception ex) {
            log.error("error=====", ex);
            ex.printStackTrace();
            resultJson.put("errCode", "0001");
            resultJson.put("resultMsg", "发布失败");
        }
        log.error("resultJson=====" + resultJson);
        return resultJson;
    }

    /**
     * 3、写字楼租发布
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/shareOfficePub")
    public Object shareOfficePub(HttpServletRequest request, @RequestBody HouseHousing t, @LoginUser WxUser user) {
        JSONObject resultJson = new JSONObject();
        try {
            t.setHouseType(3);//分类（1、写字楼、2 新房 3、共享办公、4租房）
            t.setRentable("0");//是否可以租(0不可以组,1可以组)
            t.setPubUser(user.getId());
            t.setCreateMan(user.getId());
            t.setCreateTime(new Date());
            houseHousingService.save(t);
            resultJson.put("errCode", "0000");
            resultJson.put("resultMsg", "发布成功");
        } catch (Exception ex) {
            log.error("error=====", ex);
            ex.printStackTrace();
            resultJson.put("errCode", "0001");
            resultJson.put("resultMsg", "发布失败");
        }
        log.error("resultJson=====" + resultJson);
        return resultJson;
    }
}