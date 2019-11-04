package com.icloud.bms.service;

import com.icloud.bms.dao.BmsAdminRoleMapper;
import com.icloud.bms.model.BmsAdminRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminRoleService{

	@Autowired
	private BmsAdminRoleMapper bmsAdminRoleMapper;

    public AdminRoleService(BmsAdminRoleMapper bmsAdminRoleMapper) {
        this.bmsAdminRoleMapper = bmsAdminRoleMapper;
    }

    public int insert(BmsAdminRole record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insertSelective(BmsAdminRole record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void delele(Integer adminId) {
		// TODO Auto-generated method stub
		bmsAdminRoleMapper.deleleByAdmin(adminId);
	}

	public void batchInsert(List<BmsAdminRole> list) {
		// TODO Auto-generated method stub
		bmsAdminRoleMapper.batchInsert(list);
	}

}
