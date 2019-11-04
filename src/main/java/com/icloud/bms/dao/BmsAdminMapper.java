package com.icloud.bms.dao;

import com.icloud.basecommon.dao.BaseDao;
import com.icloud.bms.model.BmsAdmin;

import java.util.List;

public interface BmsAdminMapper extends BaseDao<BmsAdmin> {
    int deleteByPrimaryKey(Integer id);

    int insert(BmsAdmin record);

    int insertSelective(BmsAdmin record);

    BmsAdmin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BmsAdmin record);

    int updateByPrimaryKey(BmsAdmin record);
    
    int deleteByPrimaryKey(Long id);

    public List<BmsAdmin> findForConditions(BmsAdmin record);
    
    Integer findCountByAccount(BmsAdmin record);
}