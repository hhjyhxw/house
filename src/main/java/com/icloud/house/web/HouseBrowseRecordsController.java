package com.icloud.house.web;

import com.icloud.house.service.HouseBrowseRecordsService;
import com.icloud.house.model.HouseBrowseRecords;
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
 * 菜单主连接： ./backpage/houseBrowseRecords/list
 */
@Controller
@RequestMapping(value = "${backPath}/houseBrowseRecords")
public class HouseBrowseRecordsController extends BaseIdLongController<HouseBrowseRecordsService,HouseBrowseRecords> {

    @Override
	public String list(HouseBrowseRecords t, @RequestParam Map<String, Object> params) {
		Query query =  new Query(params);
		PageInfo<HouseBrowseRecords> page = baseService.findByPage(query.getPageNum(), query.getPageSize(), query);
		request.setAttribute("page", page);
		request.setAttribute("record", t);
        return "house/house_browse_records_list";
	}

	@Override
	public String toinput(Long id) {
		Object houseBrowseRecords = baseService.getById(id);
		request.setAttribute("record", houseBrowseRecords);
		return "house/house_browse_records_input";
	}
}