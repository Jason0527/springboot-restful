package com.jason.boot.entity;
/**
 * 英雄类
 * @author jason
 *
 */
public class Hero {
	private String id;	//主键id
	private String name;	//英雄名
	private String type;	//英雄定位
	private String sign;	//英雄标签、台词
	private String variable;	//变量
	private Integer price;	//出售价格
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String toString(){
		return this.name+"："+this.sign;
		
	}
	public String getVariable() {
		return variable;
	}
	public void setVariable(String variable) {
		this.variable = variable;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
}
