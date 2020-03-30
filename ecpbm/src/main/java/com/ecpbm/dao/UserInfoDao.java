package com.ecpbm.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.ecpbm.dao.provider.UserInfoDynaSqlProvider;
import com.ecpbm.pojo.UserInfo;

public interface UserInfoDao {

	//获取合法用户
	@Select("select * from user_info where status=1")
	public List<UserInfo> getValidUser();
	
	//根据客户id获取对象
	@Select("select * from user_info where id=#{id}")
	public UserInfo getUserById(int id);
	
	//更新客户状态
	@Update("update user_info set status=#{flag} where id in ($(ids))")
	void updateStste(@Param("ids") String ids,@Param("flag") int flag);
	
	//根据条件查询客户总数
	@SelectProvider(type = UserInfoDynaSqlProvider.class,method="count")
	Integer cout(Map<String, Object> params);
	
	//分页获取
	@SelectProvider(type = UserInfoDynaSqlProvider.class,method="selectWithParam")
	List<UserInfo> selectByPage(Map<String, Object> params);
}
