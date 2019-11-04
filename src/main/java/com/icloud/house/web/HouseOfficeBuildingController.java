package com.icloud.house.web;

import com.github.pagehelper.PageInfo;
import com.icloud.basecommon.model.Query;
import com.icloud.basecommon.web.BaseIdLongController;
import com.icloud.house.model.HouseHousing;
import com.icloud.house.service.HouseHousingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * 写字楼(只能销售)
 * @author Mr.Z
 * @email 512162086@qq.com
 * @date 2019-11-01 21:46:51
 * 菜单主连接： ./backpage/houseHousing/list
 */
@Controller
    @RequestMapping(value = "${backPath}/officeBuilding")
public class HouseOfficeBuildingController extends BaseIdLongController<HouseHousingService,HouseHousing> {

    @Override
	public String list(HouseHousing t, @RequestParam Map<String, Object> params) {
		Query query =  new Query(params);
        query.put("house_type","1");//分类（1、写字楼、2 新房 3、共享办公、4租房）
        query.put("rentable","0");//是否可以租(0不可以组,1可以组
		PageInfo<HouseHousing> page = baseService.findByPage(query.getPageNum(), query.getPageSize(), query);
		request.setAttribute("page", page);
		request.setAttribute("record", t);
        return "house/housing/house_office_building_list";
	}

	@Override
	public String toinput(Long id) {
		Object houseHousing = baseService.getById(id);
		request.setAttribute("record", houseHousing);
		return "house/housing/house_office_building_input";
	}
}