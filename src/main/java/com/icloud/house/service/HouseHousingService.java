package com.icloud.house.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.icloud.common.MapEntryUtils;
import com.icloud.house.dao.HouseHousingMapper;
import com.icloud.house.model.HouseHousing;
import com.icloud.basecommon.service.MybaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Mr.Z
 * @email 512162086@qq.com
 * @date 2019-11-01 21:46:51
 */
@Service
@Transactional
public class HouseHousingService extends MybaseServiceImpl<HouseHousingMapper,HouseHousing> {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public PageInfo<HouseHousing> findByPage(int pageNo, int pageSize, Map<String, Object> query) {
        Map<String, Object> oldquery = query;
        try {
            query =  MapEntryUtils.mapvalueToBeanValueAndBeanProperyToColum(query, HouseHousing.class);
            for (String temp : query.keySet()) {
                log.info(temp + "=====" + query.get(temp));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        QueryWrapper qw = new QueryWrapper();
        //数据库对应字段
        if(query.entrySet().size()>0) {
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                if(entry.getValue()!=null && !"".equals(entry.getValue().toString())) {
                    if ("village".equals(entry.getKey()) || "title".equals(entry.getKey()) || "describes".equals(entry.getKey())) {
                        qw.like(entry.getKey(), entry.getValue());
                    }else{
                        qw.eq(entry.getKey(), entry.getValue());
                    }
                }
            }
        }
        //自定义字段 ,比如时间查询返回、其他返回查询参数
        //查询范围  1、单价 2、总价 3、面积
        if(oldquery.entrySet().size()>0) {
            for (Map.Entry<String, Object> entry : oldquery.entrySet()) {
                if(entry.getValue()!=null && !"".equals(entry.getValue().toString())) {
                   if("minTotalPriceStart".equals(entry.getKey())) {//总价
                        qw.gt("min_total_price", entry.getKey());
                    }else if("minTotalPriceEnd".equals(entry.getKey())) {
                        qw.lt("min_total_price", entry.getKey());
                    }else if("minUnitPriceStart".equals(entry.getKey())) {//单价
                        qw.gt("min_unit_price", entry.getKey());
                    }else if("minUnitPriceEnd".equals(entry.getKey())) {
                        qw.lt("min_unit_price", entry.getKey());
                    }else if("minHouseAreaStart".equals(entry.getKey())) {//面积
                        qw.gt("min_house_area", entry.getKey());
                    }else if("minHouseAreaEnd".equals(entry.getKey())) {
                        qw.lt("min_house_area", entry.getKey());
                    }
                }
            }
        }
        //排序：0、新房 1单价 、2 总价、3面积
        if(oldquery.entrySet().size()>0) {
            for (Map.Entry<String, Object> entry : oldquery.entrySet()) {
                if(entry.getValue()!=null && !"".equals(entry.getValue().toString())) {
                    if("latestSort".equals(entry.getKey())) {//最新倒序
                        qw.orderByDesc("latest");
                    }
                    if("minUnitPriceSort".equals(entry.getKey())) {
                        if("asc".equals(entry.getKey().toString())) qw.orderByAsc("min_unit_price");
                        if("desc".equals(entry.getKey().toString())) qw.orderByDesc("min_unit_price");
                    }
                    if("minTotalPriceSort".equals(entry.getKey())) {
                        if("asc".equals(entry.getKey().toString())) qw.orderByAsc("min_total_price");
                        if("desc".equals(entry.getKey().toString())) qw.orderByDesc("min_total_price");
                    }
                    if("minHouseAreaSort".equals(entry.getKey())) {
                        if("asc".equals(entry.getKey().toString())) qw.orderByAsc("min_house_area");
                        if("desc".equals(entry.getKey().toString())) qw.orderByDesc("min_house_area");
                    }
                }
            }
        }

        PageHelper.startPage(pageNo, pageSize);
        List<HouseHousing> list = super.list(qw);
        PageInfo<HouseHousing> page = new PageInfo<HouseHousing>(list);
        return page;
    }
}