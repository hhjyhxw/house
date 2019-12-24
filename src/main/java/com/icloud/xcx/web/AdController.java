package com.icloud.xcx.web;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageInfo;
import com.icloud.annotation.AuthIgnore;
import com.icloud.annotation.LoginUser;
import com.icloud.basecommon.model.Query;
import com.icloud.commons.model.CommonsAd;
import com.icloud.commons.service.CommonsAdService;
import com.icloud.house.model.HouseBrowseRecords;
import com.icloud.house.model.HouseHousing;
import com.icloud.house.model.HouseShareItem;
import com.icloud.house.service.HouseBrowseRecordsService;
import com.icloud.house.service.HouseHousingService;
import com.icloud.house.service.HouseShareItemService;
import com.icloud.wx.model.WxUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "${xcxPath}/ad")
public class AdController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private CommonsAdService commonsAdService;

    /**
     *
     * @param request
     * @return
     */
    @AuthIgnore
    @ResponseBody
    @RequestMapping(value = "/list")
    public Object list(HttpServletRequest request) {
        JSONObject resultJson = new JSONObject();
        try {
//            Query query = new Query(params);
            List<CommonsAd> list = commonsAdService.list(
                    new QueryWrapper<CommonsAd>().eq("status","1")
            );
            JSONObject resultData = new JSONObject();
            resultData.put("dataList",list);

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