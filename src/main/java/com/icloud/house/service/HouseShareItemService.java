package com.icloud.house.service;

import com.icloud.house.dao.HouseShareItemMapper;
import com.icloud.house.model.HouseShareItem;
import com.icloud.basecommon.service.MybaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author Mr.Z
 * @email 512162086@qq.com
 * @date 2019-11-14 09:40:23
 */
@Service
@Transactional
public class HouseShareItemService extends MybaseServiceImpl<HouseShareItemMapper,HouseShareItem> {

}