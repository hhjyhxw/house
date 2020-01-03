package com.icloud.house.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.icloud.house.dao.HouseAttrubitMapper;
import com.icloud.house.model.HouseAttrubit;
import com.icloud.basecommon.service.MybaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 
 * @author Mr.Z
 * @email 512162086@qq.com
 * @date 2019-11-01 21:46:50
 */
@Service
@Transactional
public class HouseAttrubitService extends MybaseServiceImpl<HouseAttrubitMapper,HouseAttrubit> {


    public void updateBath(List<HouseAttrubit> list) {
        for (HouseAttrubit temp:list){
            QueryWrapper<HouseAttrubit> queryWrapper = new QueryWrapper<HouseAttrubit>();
            queryWrapper.eq("name",temp.getName()).eq("value",temp.getValue());
           List<HouseAttrubit> queryList = list(queryWrapper);
           if(queryList==null || queryList.size()==0){
               save(temp);
           }
        }
    }
}