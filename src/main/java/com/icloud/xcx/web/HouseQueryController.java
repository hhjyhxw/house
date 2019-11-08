package com.icloud.xcx.web;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.icloud.annotation.AuthIgnore;
import com.icloud.basecommon.model.Query;
import com.icloud.house.model.HouseHousing;
import com.icloud.house.service.HouseHousingService;
import com.icloud.wx.model.WxUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping(value = "${xcxPath}/houseQuery")
public class HouseQueryController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private HouseHousingService houseHousingService;

    /**
     * 房源查询，各种查询参数布一样，详解文档
     *
     * @param request
     * @param params
     * @return
     */
    @AuthIgnore
    @ResponseBody
    @RequestMapping(value = "/list")
    public Object list(HttpServletRequest request, @RequestParam Map<String, Object> params) {
        JSONObject resultJson = new JSONObject();
        try {
            for (String temp : params.keySet()) {
                log.info(temp + "=====" + params.get(temp));
            }
            Query query = new Query(params);
            PageInfo<HouseHousing> page = houseHousingService.findByPage(query.getPageNum(), query.getPageSize(), query);
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
     * 房源详细查询
     * @param request
     * @param params
     * @return
     */
    @AuthIgnore
    @ResponseBody
    @RequestMapping(value = "/detail")
    public Object detail(HttpServletRequest request, @RequestParam Map<String, Object> params) {
        JSONObject resultJson = new JSONObject();
        try {
            for (String temp : params.keySet()) {
                log.info(temp + "=====" + params.get(temp));
            }
            if (params.get("id") == null) {
                resultJson.put("errCode", "1000");
                resultJson.put("resultMsg", "id参数不能为空");
                return resultJson;
            }
            JSONObject resultData = new JSONObject();
            Object houseHousing = houseHousingService.getById(Long.valueOf(params.get("id").toString()));
            resultJson.put("errCode", "0000");
            resultJson.put("resultMsg", "获取数据成功");
            resultJson.put("errCode", "0000");
            resultJson.put("resultMsg", "获取数据成功");
            resultJson.put("resultData", houseHousing);
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