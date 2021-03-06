package com.ecpbm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ecpbm.dao.UserInfoDao;
import com.ecpbm.pojo.Pager;
import com.ecpbm.pojo.UserInfo;
import com.ecpbm.service.UserInfoService;

@Service("userInfoService")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	UserInfoDao userInfoDao;
	public List<UserInfo> getValidUser() {
		return userInfoDao.getValidUser();
	}

	@Override
	public UserInfo getUserById(int id) {
		// TODO Auto-generated method stub
		return userInfoDao.getUserById(id);
	}


	@Override
	public Integer count(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return userInfoDao.cout(params);
	}

	@Override
	public void modifyStatus(String ids, int flag) {
		// TODO Auto-generated method stub
		userInfoDao.updateStste(ids,flag);
	}

	@Override
	public List<UserInfo> findUserInfo(UserInfo userInfo, Pager pager) {
		// TODO Auto-generated method stub
		Map<String, Object> params =new HashMap<String,Object>();
		params.put("userInfo", userInfo);
		int rowCount=userInfoDao.cout(params);
		pager.setRowCount(rowCount);
		if(rowCount>0) {
			params.put("pager", pager);
		}
		return userInfoDao.selectByPage(params);
	}

}
