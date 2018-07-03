package com.jason.boot.entity;
/**
 * 用户资产类
 * @author jason
 *
 */
public class UserAsset {
	private String id;		//主键id
	private String userNo;	//用户账号
	private String type;	//资产类型  1-英雄  2-皮肤
	private String heroName;//英雄名
	private String skinGrade;//皮肤等级
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getHeroName() {
		return heroName;
	}
	public void setHeroName(String heroName) {
		this.heroName = heroName;
	}
	public String getSkinGrade() {
		return skinGrade;
	}
	public void setSkinGrade(String skinGrade) {
		this.skinGrade = skinGrade;
	}
}
