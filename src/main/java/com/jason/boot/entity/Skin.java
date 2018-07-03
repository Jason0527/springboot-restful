package com.jason.boot.entity;
/**
 * 皮肤类
 * @author jason
 *
 */
public class Skin {
	private String id;			//主键id	
	private String heroName;	//所属英雄名
	private String grade;		//皮肤等级1-传说  2-史诗   3-王者
	private String description;	//等级描述 传说   史诗  王者
	private Integer price;		//出售价格
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHeroName() {
		return heroName;
	}
	public void setHeroName(String heroName) {
		this.heroName = heroName;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String toString(){
		return this.heroName+"["+this.description+"]";
	}
}
