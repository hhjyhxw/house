package com.icloud.bms.web;

import com.icloud.config.configparam.Setting;
import com.icloud.config.configparam.SettingUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @filename      : SettingAction.java
 * @description   : 系统设置action
 * @create        :
 * Modification History:
 * Date             Author       Version
 * --------------------------------------
 */
@Controller
@RequestMapping(value = "${backPath}/setting")
public class SettingAction {

	public final static Logger log = LoggerFactory.getLogger(SettingAction.class);

//	@Autowired
//	private SettingUtil settingUtil;

	private Setting setting;

	@RequestMapping("/beforeUpdate")
	public String beforeUpdate(HttpServletRequest request) {
		setting = SettingUtil.getGloablSetting();
		request.setAttribute("setting",setting);
		return "bms/setting_input";
	}

	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
//	@RequestMapping("/update")
	public String update(Setting setting, HttpServletResponse response){
		try {
			SettingUtil.update(setting);
//			response.reset();
//			response.setContentType("application/json;charset=utf-8");
//			response.getWriter().print("0000");
//			response.reset();
//			OutputStream out = response.getOutputStream();
//			out.flush();
//			out.write("0000".getBytes("UTF-8"));
//			out.flush();
//			out.close();
		}catch (Exception e){
			e.printStackTrace();
		}
		return "0000";
	}
}
