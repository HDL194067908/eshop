package com.ecpbm.service;

import java.util.List;
import java.util.Map;

import com.ecpbm.pojo.Pager;
import com.ecpbm.pojo.UserInfo;

public interface UserInfoService {

	//获取合法用户
	public List<UserInfo> getValidUser();
	//根据id查用户
	public UserInfo getUserById(int id);
	//分页显示
	List<UserInfo> findUserInfo(UserInfo userInfo,Pager pager);
	//客户计数
	Integer count(Map<String, Object> params);
	//更新用户状态
	void modifyStatus(String ids,int flag);
}
