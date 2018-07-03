package com.jason.boot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.jason.boot.entity.Hero;
import com.jason.boot.entity.SqlProvider;
@Mapper
public interface HeroDao {
	@SelectProvider(type=SqlProvider.class,method="selectHero")
	public List<Hero> getHeroList(Hero hero);
	@Insert("insert into hero(id,name,type,sign) values(#{id},#{name},#{type},#{sign})")
	public int postHero(Hero hero);
	@Update("update hero set name = #{hero.name},type = #{hero.type},sign = #{hero.sign} from hero where name = #{name}")
	public int putHero(@Param("name")String name,@Param("hero")Hero hero);
}
