package com.icloud.house.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.icloud.basecommon.model.Query;
import com.icloud.house.dao.HouseFollowRecordsMapper;
import com.icloud.house.model.HouseFollowRecords;
import com.icloud.basecommon.service.MybaseServiceImpl;
import com.icloud.house.model.HouseHousing;
import com.icloud.wx.model.WxUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.ws.Action;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author Mr.Z
 * @email 512162086@qq.com
 * @date 2019-11-25 10:02:55
 */
@Service
@Transactional
public class HouseFollowRecordsService extends MybaseServiceImpl<HouseFollowRecordsMapper,HouseFollowRecords> {

    @Autowired
   private HouseFollowRecordsMapper houseFollowRecordsMapper;


    /**
     * 查询我的关注过的房源
     * @param pageNum
     * @param pageSize
     * @param query
     * @return
     */
    public PageInfo<HouseHousing> findHouseHousingPage(int pageNum, int pageSize, Query query) {
        PageHelper.startPage(pageNum, pageSize);
        List<HouseHousing> list = houseFollowRecordsMapper.findForList(query);
        PageInfo<HouseHousing> page = new PageInfo<HouseHousing>(list);
        return page;
    }


    public void saveOrUpdate(HouseHousing house, WxUser user,String status){
        List<HouseFollowRecords> list = houseFollowRecordsMapper.selectList(new QueryWrapper<HouseFollowRecords>()
                .eq("house_id",house.getId()).eq("user_id",user.getId()));
        if(!"0".equals(status) && !"1".equals(status) ){
            status = "1";
        }
        if(list!=null && list.size()>0){
            HouseFollowRecords obj = list.get(0);
            obj.setModifyTime(new Date());
            obj.setStatus(status);
            houseFollowRecordsMapper.updateById(obj);
        }else{
            HouseFollowRecords obj = new HouseFollowRecords();
            obj.setUserId(user.getId());
            obj.setHouseId(house.getId());
            obj.setCreateTime(new Date());
            obj.setStatus(status);
            houseFollowRecordsMapper.insert(obj);
        }

    }
}