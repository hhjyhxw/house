package com.icloud.house.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.icloud.basecommon.model.Query;
import com.icloud.house.dao.HouseBrowseRecordsMapper;
import com.icloud.house.model.HouseBrowseRecords;
import com.icloud.basecommon.service.MybaseServiceImpl;
import com.icloud.house.model.HouseHousing;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 
 * @author Mr.Z
 * @email 512162086@qq.com
 * @date 2019-11-01 21:46:51
 */
@Service
@Transactional
public class HouseBrowseRecordsService extends MybaseServiceImpl<HouseBrowseRecordsMapper,HouseBrowseRecords> {

   private HouseBrowseRecordsMapper houseBrowseRecordsMapper;

    /**
     * 查询我的浏览过的房源
     * @param pageNum
     * @param pageSize
     * @param query
     * @return
     */
    public PageInfo<HouseHousing> findHouseHousingPage(int pageNum, int pageSize, Query query) {
        PageHelper.startPage(pageNum, pageSize);
        List<HouseHousing> list = houseBrowseRecordsMapper.selectList(query);
        PageInfo<HouseHousing> page = new PageInfo<HouseHousing>(list);
        return page;
    }
}