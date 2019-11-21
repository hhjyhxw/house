package com.icloud.xcx.web;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.icloud.annotation.AuthIgnore;
import com.icloud.annotation.LoginUser;
import com.icloud.basecommon.model.Query;
import com.icloud.common.MapEntryUtils;
import com.icloud.house.model.HouseHousing;
import com.icloud.house.service.HouseBrowseRecordsService;
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
import java.util.Map;

@Controller
@RequestMapping(value = "${xcxPath}/userSpace")
public class WxUserSpaceController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private HouseHousingService houseHousingService;
    @Autowired
    private HouseBrowseRecordsService houseBrowseRecordsService;


    /**
     * 我的足迹
     * @param request
     * @param params
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/myStepList")
    public Object list(HttpServletRequest request, @RequestBody Map<String, Object> params, @LoginUser WxUser user) {
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

}