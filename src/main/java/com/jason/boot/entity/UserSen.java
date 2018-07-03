package com.jason.boot.entity;
/**
 * 用户类
 * @author jason
 *
 */
public class UserSen {
	private String id;		//主键id
	private String name;	//用户昵称
	private String age;		//用户年龄
	private String userNo;	//用户账号
	private String password;	//用户密码
	private Integer account;	//用户账户余额
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getAccount() {
		return account;
	}
	public void setAccount(Integer account) {
		this.account = account;
	}
	
}
