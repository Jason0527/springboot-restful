package com.jason.boot.entity;

import java.util.Date;

/**
 * 消费记录
 * @author jason
 *
 */
public class Record {
	private String id;			//主键id
	private String userNo;		//消费账户
	private String type;		//消费类型  1-购买英雄   2-购买皮肤
	private String heroName;	//英雄名称
	private String skinGrade;	//皮肤等级
	private Integer money;		//本次消费金额
	private Date createDate;	//交易时间
	private Integer totalMoney;	//游戏公司总收入
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}
	public Integer getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(Integer totalMoney) {
		this.totalMoney = totalMoney;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getSkinGrade() {
		return skinGrade;
	}
	public void setSkinGrade(String skinGrade) {
		this.skinGrade = skinGrade;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
