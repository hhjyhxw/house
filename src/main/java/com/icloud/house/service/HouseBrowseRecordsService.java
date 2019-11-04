package com.icloud.house.service;

import com.icloud.house.dao.HouseBrowseRecordsMapper;
import com.icloud.house.model.HouseBrowseRecords;
import com.icloud.basecommon.service.MybaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author Mr.Z
 * @email 512162086@qq.com
 * @date 2019-11-01 21:46:51
 */
@Service
@Transactional
public class HouseBrowseRecordsService extends MybaseServiceImpl<HouseBrowseRecordsMapper,HouseBrowseRecords> {

}