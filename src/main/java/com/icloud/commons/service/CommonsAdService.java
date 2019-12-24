package com.icloud.commons.service;

import com.icloud.commons.dao.CommonsAdMapper;
import com.icloud.commons.model.CommonsAd;
import com.icloud.basecommon.service.MybaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author Mr.Z
 * @email 512162086@qq.com
 * @date 2019-12-24 09:06:27
 */
@Service
@Transactional
public class CommonsAdService extends MybaseServiceImpl<CommonsAdMapper,CommonsAd> {

}