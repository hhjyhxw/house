package com.icloud.house.dao;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.icloud.house.model.HouseFollowRecords;
import com.icloud.house.model.HouseHousing;

import java.util.List;
import java.util.Map;


/**
 * 
 * @author Mr.Z
 * @email 512162086@qq.com
 * @date 2019-11-25 10:02:55
 */
public interface HouseFollowRecordsMapper extends BaseMapper<HouseFollowRecords> {
    List<HouseHousing> selectList(Map<String,Object> params);
}
