package com.icloud.wx.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.icloud.basecommon.model.Query;
import com.icloud.wx.dao.WxUserMapper;
import com.icloud.wx.model.WxUser;
import com.icloud.basecommon.service.MybaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author Mr.Z
 * @email 512162086@qq.com
 * @date 2019-11-01 21:46:51
 */
@Service
@Transactional
public class WxUserService extends MybaseServiceImpl<WxUserMapper,WxUser> {

    public WxUser findByOpenId(String openId) {
        QueryWrapper<WxUser> queryWrapper = new QueryWrapper<WxUser>();
        queryWrapper.eq("openid",openId);
        return (WxUser) getOne(queryWrapper);
    }

}