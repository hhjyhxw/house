package com.icloud.house.web;

import com.icloud.house.service.HouseTagsService;
import com.icloud.house.model.HouseTags;
import com.icloud.basecommon.web.BaseIdLongController;
import com.icloud.basecommon.model.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Map;
import com.github.pagehelper.PageInfo;

/**
 * @author Mr.Z
 * @email 512162086@qq.com
 * @date 2019-11-01 21:46:51
 * 菜单主连接： ./backpage/houseTags/list
 */
@Controller
@RequestMapping(value = "${backPath}/houseTags")
public class HouseTagsController extends BaseIdLongController<HouseTagsService,HouseTags> {

    @Override
	public String list(HouseTags t, @RequestParam Map<String, Object> params) {
		Query query =  new Query(params);
		PageInfo<HouseTags> page = baseService.findByPage(query.getPageNum(), query.getPageSize(), query);
		request.setAttribute("page", page);
		request.setAttribute("record", t);
        return "house/house_tags_list";
	}

	@Override
	public String toinput(Long id) {
		Object houseTags = baseService.getById(id);
		request.setAttribute("record", houseTags);
		return "house/house_tags_input";
	}
}