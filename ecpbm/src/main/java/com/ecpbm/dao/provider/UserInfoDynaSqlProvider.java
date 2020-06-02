package com.ecpbm.dao.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.ecpbm.pojo.UserInfo;

public class UserInfoDynaSqlProvider {
	//分页查询
	public String selectWithParam(final Map<String, Object> params) {
		String sql=new SQL() {
			{
			SELECT("*");
			FROM("user_info");
			if(params.get("userInfo")!=null) {
				UserInfo userInfo=(UserInfo)params.get("userInfo");
				if(userInfo.getUserName()!=null && !userInfo.getUserName().equals("")) {
					WHERE(" userName LIKE CONCAT('%',#{userInfo.userName},'%')");
				} 
			}
		}
	  }.toString();
	  if(params.get("pager") != null) {
		  sql += "limit #{pager.firstLimiParam},#{pager.perPageRows}";
	  }
		return sql;
		
	}
	
	//根据条件查询总记录数
	public String count(final Map<String,Object> params) {
		String sql=new SQL(){
			{
				SELECT("count(*)");
				FROM("user_info");
				if(params.get("userInfo")!=null) {
					UserInfo userInfo=(UserInfo)params.get("userInfo");
					if(userInfo.getUserName()!=null && !userInfo.getUserName().equals("")) {
						WHERE(" userName LIKE CONCAT('%',#{userIndo.userName},'%')");
					}
				}
			}
		}.toString();
		return sql;
	}
	
	
	

}
