package com.icloud.basecommon.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.icloud.basecommon.model.Query;
import com.icloud.common.MapEntryUtils;
import com.icloud.wx.model.WxUser;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

public class MybaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl implements MybaseService<T>{

    @Override
    public PageInfo<T> findByPage(int pageNo, int pageSize, Map<String, Object> query) {
        try {
            Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
            query =  MapEntryUtils.mapvalueToBeanValueAndBeanProperyToColum(query, clazz);
            for(String key:query.keySet()){
                System.out.println("key="+key+" and value=" +query.get(key));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        QueryWrapper qw = new QueryWrapper();
            if(query.entrySet().size()>0) {
                for (Map.Entry<String, Object> entry : query.entrySet()) {
                    if(entry.getValue()!=null && !"".equals(entry.getValue().toString())) {
                        qw.eq(entry.getKey(), entry.getValue());
                    }
                }
            }
            PageHelper.startPage(pageNo, pageSize);
            List<T> list = super.list(qw);
            PageInfo<T> page = new PageInfo<T>(list);
            return page;
    }
}
