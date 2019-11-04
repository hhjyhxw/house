package com.icloud.bms.dao;

import com.icloud.basecommon.dao.BaseDao;
import com.icloud.bms.model.BmsRole;

import java.util.List;

public interface BmsRoleMapper extends BaseDao<BmsRole> {
    int deleteByPrimaryKey(Integer id);

    int insert(BmsRole record);

    int insertSelective(BmsRole record);

    BmsRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BmsRole record);

    int updateByPrimaryKey(BmsRole record);
    
    
    List<BmsRole> selectByAdmin(Integer adminId);
    
    List<BmsRole> selectAll();
    
    int selectCountByName(String roleName);
}