package com.ecpbm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ecpbm.pojo.AdminInfo;
import com.ecpbm.service.AdminInfoService;

@SessionAttributes(value="admin")
@Controller
@RequestMapping(value="/admininfo")
public class AdminInfpController {

	@Autowired
	private AdminInfoService adminInfoService;
	
	@RequestMapping(value="/login",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String login(AdminInfo ai,ModelMap model) {
		//后台登陆验证
		AdminInfo admininfo= adminInfoService.login(ai);
		if(admininfo != null && admininfo.getName()!=null) {
			//验证通过，判断是否有权限
			if(adminInfoService.getAdminInfoAndFunctions(admininfo.getId()).getFs().size()>0) {
				model.put("admin", admininfo);
				//返回JSON数据
				return "{\"success\":\"true\",\"message\":\"登陆成功\"}";
			}else {
				return "{\"success\":\"false\",\"message\":\"您没有权限\"}";
			}
		}
		return "{\"success\":\"false\",\"message\":\"登陆失败\"}";
	}
}
