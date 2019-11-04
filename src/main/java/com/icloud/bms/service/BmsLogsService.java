package com.icloud.bms.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.icloud.bms.dao.BmsLogsMapper;
import com.icloud.bms.dao.BmsMenuMapper;
import com.icloud.bms.model.BmsLogs;
import com.icloud.bms.model.BmsLogsWithBLOBs;
import com.icloud.bms.model.BmsMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BmsLogsService{

	@Autowired
	private BmsLogsMapper bmsLogsMapper;
	@Autowired
	private BmsMenuMapper bmsMenuMapper;

    public BmsLogsService(BmsLogsMapper bmsLogsMapper) {
        this.bmsLogsMapper = bmsLogsMapper;
    }

    public void save(BmsLogsWithBLOBs t) {
		// TODO Auto-generated method stub
		bmsLogsMapper.insert(t);
	}

	public void update(BmsLogsWithBLOBs t) throws Exception {
		// TODO Auto-generated method stub
		bmsLogsMapper.updateByPrimaryKeySelective(t);
	}

	public List<BmsLogsWithBLOBs> findList(BmsLogsWithBLOBs t) throws Exception {
		// TODO Auto-generated method stub
		return bmsLogsMapper.findForList(t);
	}

	public Integer findCount(BmsLogsWithBLOBs t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Long id) throws Exception {
		// TODO Auto-generated method stub
		bmsLogsMapper.deleteByPrimaryKey(id);
	}

	public BmsLogs findByKey(Long id) throws Exception {
		// TODO Auto-generated method stub
		return bmsLogsMapper.selectByPrimaryKey(id);
	}

	
	public PageInfo<BmsLogsWithBLOBs> findByPage(int pageNo, int pageSize,
										BmsLogsWithBLOBs t) throws Exception {
		// TODO Auto-generated method stub
		 PageHelper.startPage(pageNo, pageSize);
		 PageInfo<BmsLogsWithBLOBs> page = new PageInfo<BmsLogsWithBLOBs>(bmsLogsMapper.findForList(t));
		 return page;
	}

    public List<BmsMenu> selectMenuByUrl(BmsMenu bmsMenu){
        return bmsMenuMapper.selectByUrl(bmsMenu);
    }
}
