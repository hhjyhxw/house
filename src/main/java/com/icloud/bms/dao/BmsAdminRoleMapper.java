package com.icloud.bms.dao;


import com.icloud.bms.model.BmsAdminRole;

import java.util.List;

public interface BmsAdminRoleMapper {
    int insert(BmsAdminRole record);

    int insertSelective(BmsAdminRole record);
    
	int deleleByAdmin(Integer adminId);
	
	
	int batchInsert(List<BmsAdminRole> list);
	
}