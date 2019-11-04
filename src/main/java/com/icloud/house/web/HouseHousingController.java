package com.icloud.house.web;

import com.icloud.house.service.HouseHousingService;
import com.icloud.house.model.HouseHousing;
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
 * 菜单主连接： ./backpage/houseHousing/list
 */
@Controller
@RequestMapping(value = "${backPath}/houseHousing")
public class HouseHousingController extends BaseIdLongController<HouseHousingService,HouseHousing> {

    @Override
	public String list(HouseHousing t, @RequestParam Map<String, Object> params) {
		Query query =  new Query(params);
		PageInfo<HouseHousing> page = baseService.findByPage(query.getPageNum(), query.getPageSize(), query);
		request.setAttribute("page", page);
		request.setAttribute("record", t);
        return "house/house_housing_list";
	}

	@Override
	public String toinput(Long id) {
		Object houseHousing = baseService.getById(id);
		request.setAttribute("record", houseHousing);
		return "house/house_housing_input";
	}
}