package com.icloud.bms.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.icloud.bms.dao.BmsRoleMapper;
import com.icloud.bms.model.BmsRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

	@Autowired
	private BmsRoleMapper bmsRoleMapper;
	
	

	public int insertSelective(BmsRole record) {
		// TODO Auto-generated method stub
		return bmsRoleMapper.insertSelective(record);
	}


	public List<BmsRole> selectByAdmin(Integer adminId) {
		// TODO Auto-generated method stub
		return bmsRoleMapper.selectByAdmin(adminId);
	}

	public List<BmsRole> selectAll() {
		// TODO Auto-generated method stub
		return bmsRoleMapper.selectAll();
	}


	public void save(BmsRole t) throws Exception {
		// TODO Auto-generated method stub
		bmsRoleMapper.insert(t);
	}


	public void update(BmsRole t) throws Exception {
		// TODO Auto-generated method stub
		bmsRoleMapper.updateByPrimaryKey(t);
	}


	public List<BmsRole> findList(BmsRole t) throws Exception {
		// TODO Auto-generated method stub
		return bmsRoleMapper.findForList(t);
	}


	public void delete(Integer id) throws Exception {
		// TODO Auto-generated method stub
		bmsRoleMapper.deleteByPrimaryKey(id);
	}


	public BmsRole findByKey(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return bmsRoleMapper.selectByPrimaryKey(id);
	
	}

	public PageInfo<BmsRole> findByPage(int pageNo, int pageSize, BmsRole t)
			throws Exception {
		 PageHelper.startPage(pageNo, pageSize);
		 PageInfo<BmsRole> page = new PageInfo<BmsRole>(bmsRoleMapper.findForList(t));
		 return page;
	}


	public int selectCountByName(String roleName) {
		// TODO Auto-generated method stub
		return bmsRoleMapper.selectCountByName(roleName);
	}

}
