package com.icloud.house.web;

import com.icloud.house.service.HouseFollowRecordsService;
import com.icloud.house.model.HouseFollowRecords;
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
 * @date 2019-11-25 10:02:55
 * 菜单主连接： ./backpage/houseFollowRecords/list
 */
@Controller
@RequestMapping(value = "${backPath}/houseFollowRecords")
public class HouseFollowRecordsController extends BaseIdLongController<HouseFollowRecordsService,HouseFollowRecords> {

    @Override
	public String list(HouseFollowRecords t, @RequestParam Map<String, Object> params) {
		Query query =  new Query(params);
		PageInfo<HouseFollowRecords> page = baseService.findByPage(query.getPageNum(), query.getPageSize(), query);
		request.setAttribute("page", page);
		request.setAttribute("record", t);
        return "house/house_follow_records_list";
	}

	@Override
	public String toinput(Long id) {
		Object houseFollowRecords = baseService.getById(id);
		request.setAttribute("record", houseFollowRecords);
		return "house/house_follow_records_input";
	}
}