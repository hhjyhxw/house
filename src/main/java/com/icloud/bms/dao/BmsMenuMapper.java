package com.icloud.bms.dao;

import com.icloud.basecommon.dao.BaseDao;
import com.icloud.bms.model.BmsAdmin;
import com.icloud.bms.model.BmsMenu;

import java.util.List;

public interface BmsMenuMapper extends BaseDao<BmsMenu> {
    int deleteByPrimaryKey(Integer id);

    int insert(BmsMenu record);

    int insertSelective(BmsMenu record);

    BmsMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BmsMenu record);

    int updateByPrimaryKey(BmsMenu record);
    
    List<BmsMenu> selectMenuByUser(BmsAdmin admin);

    List<BmsMenu> selectParentMenu();
    
    List<BmsMenu> selectAllList();
    
    List<BmsMenu> selectByRole(Integer roleId);
    
    int selectCountByName(String menuName);
    
    int countByParent(Integer parentId);

    List<BmsMenu>  selectByUrl(BmsMenu bmsMenu);
    
    
    
}