package com.icloud.xcx.web;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageInfo;
import com.icloud.annotation.AuthIgnore;
import com.icloud.annotation.LoginUser;
import com.icloud.basecommon.model.Query;
import com.icloud.common.MapEntryUtils;
import com.icloud.house.model.HouseHousing;
import com.icloud.house.model.HouseShareItem;
import com.icloud.house.service.HouseBrowseRecordsService;
import com.icloud.house.service.HouseHousingService;
import com.icloud.house.service.HouseShareItemService;
import com.icloud.wx.model.WxUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "${xcxPath}/houseQuery")
public class HouseQueryController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private HouseHousingService houseHousingService;
    @Autowired
    private HouseShareItemService houseShareItemService;
    @Autowired
    private HouseBrowseRecordsService houseBrowseRecordsService;

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
    public Object list(HttpServletRequest request,@RequestBody Map<String, Object> params) {

        JSONObject resultJson = new JSONObject();
        try {
//            Map<String, Object> map = MapEntryUtils.objectToMap(t);
//            params.putAll(map);
            for (String temp : params.keySet()) {
                log.info(temp + "=====" + params.get(temp));
            }
            Query query = new Query(params);
            log.info("query.getPageNum()=====" + query.getPageNum());
            log.info("query.getPageSize()=====" + query.getPageSize());
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
    @ResponseBody
    @RequestMapping(value = "/detail")
    public Object detail(HttpServletRequest request, @RequestBody Map<String, Object> params,@LoginUser WxUser user) {
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
            HouseHousing house = null;

            if(houseHousing!=null){

                house = (HouseHousing) houseHousing;

                //子项列表
                List<HouseShareItem> itemList = null;
                QueryWrapper queryWrapper = new QueryWrapper();
                queryWrapper.eq("parent_id",house.getId());
                itemList = houseShareItemService.list(queryWrapper);
                if(itemList==null){
                    itemList = new ArrayList<HouseShareItem>();
                }
                //首页封面
                if(house.getHouseType()!=null && 3!=house.getHouseType().intValue()){//非共享办公下 加如首页封面图
                    HouseShareItem houseShareItem = new HouseShareItem();
                    houseShareItem.setImageUrl(house.getImageUrl());
                    itemList.add(houseShareItem);
                }
                house.setItemList(itemList);
                //保存或者更新我的足迹
                if(user!=null && user.getId()!=null){
                    houseBrowseRecordsService.saveOrUpdate(house,user);
                }
            }

            resultJson.put("errCode", "0000");
            resultJson.put("resultMsg", "获取数据成功");
            resultJson.put("errCode", "0000");
            resultJson.put("resultMsg", "获取数据成功");
            resultData.put("data",house);
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