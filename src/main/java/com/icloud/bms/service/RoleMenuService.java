package com.icloud.bms.service;

import com.icloud.bms.dao.BmsRoleMenuMapper;
import com.icloud.bms.model.BmsRoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleMenuService{

	@Autowired
	private BmsRoleMenuMapper bmsRoleMenuMapper;
	
	public int insert(BmsRoleMenu record) {
		// TODO Auto-generated method stub
		return bmsRoleMenuMapper.insert(record);
	}

	public int insertSelective(BmsRoleMenu record) {
		// TODO Auto-generated method stub
		return bmsRoleMenuMapper.insert(record);
	}

	public void delete(BmsRoleMenu record) {
		// TODO Auto-generated method stub
		bmsRoleMenuMapper.delete(record);
	}

	public void batchInsert(List<BmsRoleMenu> list) {
		bmsRoleMenuMapper.batchInsert(list);
	}

}
