package com.icloud.house.web;

import com.icloud.house.service.HouseApplyService;
import com.icloud.house.model.HouseApply;
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
 * @date 2019-11-01 21:46:50
 * 菜单主连接： ./backpage/houseApply/list
 */
@Controller
@RequestMapping(value = "${backPath}/houseApply")
public class HouseApplyController extends BaseIdLongController<HouseApplyService,HouseApply> {

    @Override
	public String list(HouseApply t, @RequestParam Map<String, Object> params) {
		Query query =  new Query(params);
		PageInfo<HouseApply> page = baseService.findByPage(query.getPageNum(), query.getPageSize(), query);
		request.setAttribute("page", page);
		request.setAttribute("record", t);
        return "house/house_apply_list";
	}

	@Override
	public String toinput(Long id) {
		Object houseApply = baseService.getById(id);
		request.setAttribute("record", houseApply);
		return "house/house_apply_input";
	}
}