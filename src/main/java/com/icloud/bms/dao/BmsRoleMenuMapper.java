package com.icloud.bms.dao;


import com.icloud.bms.model.BmsRoleMenu;

import java.util.List;

public interface BmsRoleMenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BmsRoleMenu record);

    int insertSelective(BmsRoleMenu record);

    BmsRoleMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BmsRoleMenu record);

    int updateByPrimaryKey(BmsRoleMenu record);
    
    void delete(BmsRoleMenu roleMenu);
    
    void batchInsert(List<BmsRoleMenu> list);
}