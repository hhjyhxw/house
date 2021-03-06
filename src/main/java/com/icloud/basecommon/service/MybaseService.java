package com.icloud.basecommon.service;

import com.github.pagehelper.PageInfo;
import java.util.Map;

public interface MybaseService<T> {
    /**
     * 分页查找
     * @return
     * @throws Exception
     */
    public PageInfo<T> findByPage(int pageNo, int pageSize, Map<String, Object> query);
}
