package com.icloud.bms.dao;


import com.icloud.bms.model.BmsLogsWithBLOBs;

import java.util.List;

public interface BmsLogsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BmsLogsWithBLOBs record);

    int insertSelective(BmsLogsWithBLOBs record);

    BmsLogsWithBLOBs selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BmsLogsWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(BmsLogsWithBLOBs record);

    int updateByPrimaryKey(BmsLogsWithBLOBs record);

    List<BmsLogsWithBLOBs> findForList(BmsLogsWithBLOBs t);
}