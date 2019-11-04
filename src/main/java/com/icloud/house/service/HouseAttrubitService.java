package com.icloud.house.service;

import com.icloud.house.dao.HouseAttrubitMapper;
import com.icloud.house.model.HouseAttrubit;
import com.icloud.basecommon.service.MybaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author Mr.Z
 * @email 512162086@qq.com
 * @date 2019-11-01 21:46:50
 */
@Service
@Transactional
public class HouseAttrubitService extends MybaseServiceImpl<HouseAttrubitMapper,HouseAttrubit> {

}