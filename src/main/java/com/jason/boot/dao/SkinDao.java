package com.jason.boot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.jason.boot.entity.Skin;
import com.jason.boot.entity.SqlProvider;

@Mapper
public interface SkinDao {
	@SelectProvider(type=SqlProvider.class,method="selectSkin")
	public List<Skin> getSkinList();
	@Select("select id as id,hero_name as heroName,grade as grade,description as description,price as price where hero_name=#{heroName}")
	public List<Skin> getHeroSkinList(String heroName);
	@Select("select id as id,hero_name as heroName,grade as grade,description as description,price as price where hero_name=#{heroName} and grade = #{grade}")
	public List<Skin> getSkin(String heroName,String grade);
	@Insert("insert into skin(id,hero_name,grade,description,price) values(id,heroName,grade,description,price)")
	public int postSkin(Skin skin);
	@Update("update skin set grade=#{skin.grade},description=#{skin.description},price=#{skin.price} where hero_name=#{heroName} and grade = #{grade} ")
	public int putSkin(@Param("skin")Skin skin,@Param("heroName")String heroName,@Param("grade")String grade);
}
