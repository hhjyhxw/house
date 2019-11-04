package com.icloud.house.web;

import com.icloud.house.service.HouseAttrubitService;
import com.icloud.house.model.HouseAttrubit;
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
 * 菜单主连接： ./backpage/houseAttrubit/list
 */
@Controller
@RequestMapping(value = "${backPath}/houseAttrubit")
public class HouseAttrubitController extends BaseIdLongController<HouseAttrubitService,HouseAttrubit> {

    @Override
	public String list(HouseAttrubit t, @RequestParam Map<String, Object> params) {
		Query query =  new Query(params);
		PageInfo<HouseAttrubit> page = baseService.findByPage(query.getPageNum(), query.getPageSize(), query);
		request.setAttribute("page", page);
		request.setAttribute("record", t);
        return "house/house_attrubit_list";
	}

	@Override
	public String toinput(Long id) {
		Object houseAttrubit = baseService.getById(id);
		request.setAttribute("record", houseAttrubit);
		return "house/house_attrubit_input";
	}
}