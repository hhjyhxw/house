package com.icloud.house.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.icloud.basecommon.model.Query;
import com.icloud.house.dao.HouseBrowseRecordsMapper;
import com.icloud.house.model.HouseBrowseRecords;
import com.icloud.basecommon.service.MybaseServiceImpl;
import com.icloud.house.model.HouseHousing;
import com.icloud.wx.model.WxUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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

    @Autowired
   private HouseBrowseRecordsMapper houseBrowseRecordsMapper;
    @Autowired
    private HouseHousingService houseHousingService;
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

    public void saveOrUpdate(HouseHousing house, WxUser user){
        List<HouseBrowseRecords> list = houseBrowseRecordsMapper.selectList(new QueryWrapper<HouseBrowseRecords>()
                .eq("house_id",house.getId()).eq("user_id",user.getId()));
        if(list!=null && list.size()>0){
            HouseBrowseRecords obj = list.get(0);
            obj.setModifyTime(new Date());
            houseBrowseRecordsMapper.updateById(obj);
        }else{
            HouseBrowseRecords obj = new HouseBrowseRecords();
            obj.setUserId(user.getId());
            obj.setHouseId(house.getId());
            obj.setCreateTime(new Date());
            houseBrowseRecordsMapper.insert(obj);
        }

    }
}