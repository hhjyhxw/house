package com.icloud.house.web;

import com.icloud.house.service.HouseAreaService;
import com.icloud.house.model.HouseArea;
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
 * 菜单主连接： ./backpage/houseArea/list
 */
@Controller
@RequestMapping(value = "${backPath}/houseArea")
public class HouseAreaController extends BaseIdLongController<HouseAreaService,HouseArea> {

    @Override
	public String list(HouseArea t, @RequestParam Map<String, Object> params) {
		Query query =  new Query(params);
		PageInfo<HouseArea> page = baseService.findByPage(query.getPageNum(), query.getPageSize(), query);
		request.setAttribute("page", page);
		request.setAttribute("record", t);
        return "house/house_area_list";
	}

	@Override
	public String toinput(Long id) {
		Object houseArea = baseService.getById(id);
		request.setAttribute("record", houseArea);
		return "house/house_area_input";
	}
}