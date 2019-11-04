package com.icloud.house.service;

import com.icloud.house.dao.HouseAreaMapper;
import com.icloud.house.model.HouseArea;
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
public class HouseAreaService extends MybaseServiceImpl<HouseAreaMapper,HouseArea> {

    public List<HouseArea> getList(){
       return super.list();
    }
}