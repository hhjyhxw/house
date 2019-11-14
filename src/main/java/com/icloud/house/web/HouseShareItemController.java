package com.icloud.house.web;

import com.icloud.annotation.SysLog;
import com.icloud.house.service.HouseShareItemService;
import com.icloud.house.model.HouseShareItem;
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
 * @date 2019-11-14 09:40:23
 * 菜单主连接： ./backpage/houseShareItem/list
 */
@Controller
@RequestMapping(value = "${backPath}/houseShareItem")
public class HouseShareItemController extends BaseIdLongController<HouseShareItemService,HouseShareItem> {

    @Override
	public String list(HouseShareItem t, @RequestParam Map<String, Object> params) {
		Query query =  new Query(params);
		PageInfo<HouseShareItem> page = baseService.findByPage(query.getPageNum(), query.getPageSize(), query);
		request.setAttribute("page", page);
		request.setAttribute("record", t);
        return "house/house_share_item_list";
	}

	@Override
	public String toinput(Long id) {
		Object houseShareItem = baseService.getById(id);
		request.setAttribute("record", houseShareItem);
		return "house/house_share_item_input";
	}

    @SysLog("跳转更新页面")
    @RequestMapping(value = "/toinputnew")
    public String toinputnew(Long id,HouseShareItem t) {
        Object houseShareItem = baseService.getById(id);
        if(houseShareItem==null){
            houseShareItem = t;
        }
        request.setAttribute("record", houseShareItem);
        return "house/house_share_item_input";
    }
}