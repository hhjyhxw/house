package com.icloud.xcx.web;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageInfo;
import com.icloud.annotation.AuthIgnore;
import com.icloud.annotation.LoginUser;
import com.icloud.basecommon.model.Query;
import com.icloud.common.MapEntryUtils;
import com.icloud.house.model.HouseFollowRecords;
import com.icloud.house.model.HouseHousing;
import com.icloud.house.model.HouseShareItem;
import com.icloud.house.service.HouseBrowseRecordsService;
import com.icloud.house.service.HouseFollowRecordsService;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 我的足迹
 */
@Controller
@RequestMapping(value = "${xcxPath}/userSpace")
public class WxUserSpaceController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private HouseHousingService houseHousingService;
    @Autowired
    private HouseBrowseRecordsService houseBrowseRecordsService;
    @Autowired
    private HouseFollowRecordsService houseFollowRecordsService;




    /**
     * 我的足迹
     * @param request
     * @param params
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/myStepList")
    public Object myStepList(HttpServletRequest request, @RequestBody Map<String, Object> params, @LoginUser WxUser user) {
        JSONObject resultJson = new JSONObject();
        try {
//            Map<String, Object> map = MapEntryUtils.objectToMap(t);
//            params.putAll(map);
            for (String temp : params.keySet()) {
                log.info(temp + "=====" + params.get(temp));
            }
            if(user==null){
                return null;
            }

            Query query = new Query(params);
            query.put("userId",user.getId());
            PageInfo<HouseHousing> page = houseBrowseRecordsService.findHouseHousingPage(query.getPageNum(), query.getPageSize(), query);
            JSONObject resultData = new JSONObject();
            resultData.put("dataList", page.getList());
            resultData.put("hasMore", page.getPageNum() < page.getPages());
            resultData.put("totalCount", page.getTotal());
            resultData.put("pageNo", page.getPageNum());
            resultData.put("pageSize", page.getPageSize());

            resultJson.put("errCode", "0000");
            resultJson.put("resultMsg", "获取数据成功");
            resultJson.put("resultData", resultData);
        } catch (Exception ex) {
            log.error("error=====", ex);
            ex.printStackTrace();
            resultJson.put("errCode", "0001");
            resultJson.put("resultMsg", "获取数据失败");
        }
        log.error("resultJson=====" + resultJson);
        return resultJson;
    }


    /**
     * 查询是否关注房源
     * @param request
     * @param params
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/checkFollow")
    public Object checkFollow(HttpServletRequest request, @RequestBody Map<String, Object> params,@LoginUser WxUser user) {
        JSONObject resultJson = new JSONObject();
        try {
            for (String temp : params.keySet()) {
                log.info(temp + "=====" + params.get(temp));
            }
            log.info("follow_user=====" + (user!=null?user:null));
            if (params.get("id") == null) {
                resultJson.put("errCode", "1000");
                resultJson.put("resultMsg", "id参数不能为空");
                log.error("resultJson=====" + resultJson);
                return resultJson;
            }
            if (params.get("status") == null) {
                resultJson.put("errCode", "1000");
                resultJson.put("resultMsg", "status参数不能为空");
                log.error("resultJson=====" + resultJson);
                return resultJson;
            }
            JSONObject resultData = new JSONObject();
            Object houseHousing = houseHousingService.getById(Long.valueOf(params.get("id").toString()));
            HouseHousing house = null;
            if(houseHousing!=null){
                house = (HouseHousing) houseHousing;
                //保存或者更新我的足迹
                if(user!=null && user.getId()!=null){
                    Object houseFollowRecordsObj = houseFollowRecordsService.getOne(new QueryWrapper<HouseFollowRecords>()
                            .eq("house_id",house.getId()).eq("user_id",user.getId()));
                    if(houseFollowRecordsObj!=null){
                        HouseFollowRecords records = (HouseFollowRecords) houseFollowRecordsObj;
                        if("1".equals(records.getStatus())){

                            resultData.put("status", "1");
                            resultData.put("resultMsg", "用户已关注");

                            resultJson.put("resultData", resultData);
                            resultJson.put("errCode", "0000");
                            resultJson.put("resultMsg", "用户已关注");
                            log.error("resultJson=====" + resultJson);
                            return resultJson;
                        }
                    }
                    resultData.put("status", "0");
                    resultData.put("resultMsg", "用户未关注");

                    resultJson.put("resultData", resultData);
                    resultJson.put("errCode", "0000");
                    resultJson.put("status", "0");
                    resultJson.put("resultMsg", "用户未关注");
                    return resultJson;
                }else {
                    resultJson.put("errCode", "1000");
                    resultJson.put("resultMsg", "用户没登陆");
                    log.error("resultJson=====" + resultJson);
                    return resultJson;
                }
            }else {
                resultJson.put("errCode", "1000");
                resultJson.put("resultMsg", "关注的房子id为空");
                log.error("resultJson=====" + resultJson);
                return resultJson;
            }
        } catch (Exception ex) {
            log.error("error=====", ex);
            ex.printStackTrace();
            resultJson.put("errCode", "0001");
            resultJson.put("resultMsg", "保存失败");
        }
        log.error("resultJson=====" + resultJson);
        return resultJson;
    }


    /**
     * 添加关注房源
     * @param request
     * @param params
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/follow")
    public Object follow(HttpServletRequest request, @RequestBody Map<String, Object> params,@LoginUser WxUser user) {
        JSONObject resultJson = new JSONObject();
        try {
            for (String temp : params.keySet()) {
                log.info(temp + "=====" + params.get(temp));
            }
            log.info("follow_user=====" + (user!=null?user:null));
            if (params.get("id") == null) {
                resultJson.put("errCode", "1000");
                resultJson.put("resultMsg", "id参数不能为空");
                log.error("resultJson=====" + resultJson);
                return resultJson;
            }
            if (params.get("status") == null) {
                resultJson.put("errCode", "1000");
                resultJson.put("resultMsg", "status参数不能为空");
                log.error("resultJson=====" + resultJson);
                return resultJson;
            }
            JSONObject resultData = new JSONObject();
            Object houseHousing = houseHousingService.getById(Long.valueOf(params.get("id").toString()));
            HouseHousing house = null;
            if(houseHousing!=null){
                house = (HouseHousing) houseHousing;
                //保存或者更新我的足迹
                if(user!=null && user.getId()!=null){
                    houseFollowRecordsService.saveOrUpdate(house,user,params.get("status").toString());
                }else {
                    resultJson.put("errCode", "1000");
                    resultJson.put("resultMsg", "用户没登陆");
                    log.error("resultJson=====" + resultJson);
                    return resultJson;
                }
            }else {
                resultJson.put("errCode", "1000");
                resultJson.put("resultMsg", "关注的房子id为空");
                log.error("resultJson=====" + resultJson);
                return resultJson;
            }
            resultJson.put("errCode", "0000");
            resultJson.put("resultMsg", "保存成功");
        } catch (Exception ex) {
            log.error("error=====", ex);
            ex.printStackTrace();
            resultJson.put("errCode", "0001");
            resultJson.put("resultMsg", "保存失败");
        }
        log.error("resultJson=====" + resultJson);
        return resultJson;
    }


    /**
     * 我的关注
     * @param request
     * @param params
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/myFollowList")
    public Object myFollowList(HttpServletRequest request, @RequestBody Map<String, Object> params, @LoginUser WxUser user) {
        JSONObject resultJson = new JSONObject();
        try {
//            Map<String, Object> map = MapEntryUtils.objectToMap(t);
//            params.putAll(map);
            for (String temp : params.keySet()) {
                log.info(temp + "=====" + params.get(temp));
            }
            if(user==null){
                return null;
            }

            Query query = new Query(params);
            query.put("userId",user.getId());
            query.put("status","1");//关注的消息
            PageInfo<HouseHousing> page = houseFollowRecordsService.findHouseHousingPage(query.getPageNum(), query.getPageSize(), query);
            JSONObject resultData = new JSONObject();
            resultData.put("dataList", page.getList());
            resultData.put("hasMore", page.getPageNum() < page.getPages());
            resultData.put("totalCount", page.getTotal());
            resultData.put("pageNo", page.getPageNum());
            resultData.put("pageSize", page.getPageSize());

            resultJson.put("errCode", "0000");
            resultJson.put("resultMsg", "获取数据成功");
            resultJson.put("resultData", resultData);
        } catch (Exception ex) {
            log.error("error=====", ex);
            ex.printStackTrace();
            resultJson.put("errCode", "0001");
            resultJson.put("resultMsg", "获取数据失败");
        }
        log.error("resultJson=====" + resultJson);
        return resultJson;
    }

}