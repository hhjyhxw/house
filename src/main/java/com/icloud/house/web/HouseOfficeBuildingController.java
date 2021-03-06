package com.icloud.house.web;

import com.github.pagehelper.PageInfo;
import com.icloud.annotation.SysLog;
import com.icloud.basecommon.model.Query;
import com.icloud.basecommon.util.BaiduMapUtil;
import com.icloud.basecommon.web.BaseIdLongController;
import com.icloud.common.msg.BaseResponse;
import com.icloud.common.util.StringUtil;
import com.icloud.house.model.HouseHousing;
import com.icloud.house.service.HouseAreaService;
import com.icloud.house.service.HouseHousingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Date;
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


    @Autowired
    private HouseAreaService houseAreaService;

    @Override
	public String list(HouseHousing t, @RequestParam Map<String, Object> params) {
		Query query =  new Query(params);
        query.put("houseType","1");//分类（1、写字楼、2 新房 3、共享办公、4租房）
        query.put("rentable","0");//是否可以租(0不可以组,1可以组
		PageInfo<HouseHousing> page = baseService.findByPage(query.getPageNum(), query.getPageSize(), query);
		request.setAttribute("page", page);
		request.setAttribute("record", t);
        request.getSession().setAttribute("arenList", houseAreaService.getList());
        return "house/housing/house_office_building_list";
	}

	@Override
	public String toinput(Long id) {
		Object houseHousing = baseService.getById(id);
		request.setAttribute("record", houseHousing);
		return "house/housing/house_office_building_input";
	}


    /**
     *新增
     * @return
     */
    @SysLog("添加写字楼售")
    @RequestMapping(value = "/add")
    @ResponseBody
    @Override
    public BaseResponse add(HouseHousing t){
        try {
            t.setHouseType(1);//分类（1、写字楼、2 新房 3、共享办公、4租房）
            t.setRentable("0");//是否可以租(0不可以组,1可以组)
            t.setPubUser(StringUtil.checkStr(getLoginAdmin().getShopIds())?Long.parseLong(getLoginAdmin().getShopIds()):null);
            t.setCreateMan(getLoginAdmin().getId().longValue());
            t.setPhone(getLoginAdmin().getPhone());
            t.setCreateTime(new Date());
            try {
                if(StringUtil.checkStr(t.getVillage())){
                    String[] coordinate = BaiduMapUtil.getCoordinate(t.getVillage());
                    t.setLng(coordinate[0]!=null?new BigDecimal(coordinate[0]):null);
                    t.setLat(coordinate[1]!=null?new BigDecimal(coordinate[1]):null);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            boolean result = baseService.save(t);
            if(result)
                return new BaseResponse(200,"0000","保存成功");
            else
                return new BaseResponse(200,"1000","保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return new BaseResponse(200,"2000","系统异常");
        }
    }

    /**
     *更新
     * @return
     */
    @SysLog("更新写字楼售")
    @RequestMapping(value = "/update")
    @ResponseBody
    @Override
    public  BaseResponse update(HouseHousing t){
        try {
            t.setHouseType(1);//分类（1、写字楼、2 新房 3、共享办公、4租房）
            t.setRentable("0");//是否可以租(0不可以组,1可以组)
            t.setModifyMan(getLoginAdmin().getId().longValue());
            t.setModifyTime(new Date());
            try {
                if(StringUtil.checkStr(t.getVillage())){
                    String[] coordinate = BaiduMapUtil.getCoordinate(t.getVillage());
                    t.setLng(coordinate[0]!=null?new BigDecimal(coordinate[0]):null);
                    t.setLat(coordinate[1]!=null?new BigDecimal(coordinate[1]):null);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            boolean result = baseService.updateById(t);
            if(result)
                return new BaseResponse(200,"0000","更新成功");
            else
                return new BaseResponse(200,"1000","更新失败");
        }catch (Exception e){
            e.printStackTrace();
            return new BaseResponse(200,"2000","系统异常");
        }
    }

}