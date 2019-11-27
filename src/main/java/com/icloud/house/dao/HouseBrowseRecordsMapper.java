package com.icloud.house.dao;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.icloud.basecommon.model.Query;
import com.icloud.house.model.HouseBrowseRecords;
import com.icloud.house.model.HouseHousing;

import java.util.List;
import java.util.Map;


/**
 * 
 * @author Mr.Z
 * @email 512162086@qq.com
 * @date 2019-11-01 21:46:51
 */
public interface HouseBrowseRecordsMapper extends BaseMapper<HouseBrowseRecords> {

    List<HouseHousing> findForList(Map<String,Object> params);
}
