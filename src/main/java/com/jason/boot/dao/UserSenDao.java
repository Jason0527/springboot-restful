package com.jason.boot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.jason.boot.entity.SqlProvider;
import com.jason.boot.entity.UserSen;

@Mapper
public interface UserSenDao {
	@SelectProvider(type=SqlProvider.class,method="selectUserSen")
	public List<UserSen> getUserList(UserSen user);
	
	@Insert("INSERT INTO user_sen(id,name,age,user_no,password,account) VALUES(#{id},#{name},#{age},#{userNo},#{password},#{account})")
	public int postUser(UserSen user);
	
	@Update("UPDATE user_sen set name=#{user.name},age=#{user.age},password=#{user.password},account=#{user.account} WHERE user_no=#{userNo}")
	public int putUser(@Param("userNo")String userNo,@Param("user") UserSen user);
	
	@Delete("DELETE user_sen WHERE user_no=#{userNo}")
	public int deleteUser(String userNo);
}
