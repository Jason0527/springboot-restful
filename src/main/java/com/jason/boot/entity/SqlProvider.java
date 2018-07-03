package com.jason.boot.entity;

import org.apache.ibatis.jdbc.SQL;

import com.jason.boot.utils.StringUtil;

public class SqlProvider {
	public String selectUserSen(final UserSen user){
		return new SQL(){{
			SELECT("id AS id,name AS name,age AS age,user_no AS userNo,password AS password,account as account");
			FROM("USER_SEN");
			if(!StringUtil.isBlank(user.getUserNo())){
				WHERE("USER_NO = #{userNo}");
			}
			if(!StringUtil.isBlank(user.getName())){
				WHERE("name = #{name}");
			}
			if(!StringUtil.isBlank(user.getId())){
				WHERE("id = #{id}");
			}
		}}.toString();
	}
	public String selectUserAsset(final UserAsset asset){
		return new SQL(){{
			SELECT(" id as id,user_no as userNo,type as type,hero_name as heroName,skin_grade as skinGrade");
			FROM("user_asset");
			if(!StringUtil.isBlank(asset.getUserNo())){
				WHERE("user_no = #{userNo}");
			}
			if(!StringUtil.isBlank(asset.getType())){
				WHERE("type = #{type}");
			}
			if(!StringUtil.isBlank(asset.getHeroName())){
				WHERE("hero_name = #{heroName}");
			}
			if(!StringUtil.isBlank(asset.getHeroName())){
				WHERE("skin_grade = #{skinGrade}");
			}
		}}.toString();
	}
	public String selectHero(final Hero hero){
		return new SQL(){{
			SELECT("id as id,name as name,type as type,sign as sign,price as price");
			FROM("hero");
			if(!StringUtil.isBlank(hero.getName())){
				WHERE("name = #{name}");
			}
			if(!StringUtil.isBlank(hero.getType())){
				WHERE("type = #{type}");
			}
			if(!StringUtil.isBlank(hero.getPrice())){
				WHERE("price = #{price}");
			}
		}}.toString();
	}
	public String selectSkin(final Skin skin){
		return new SQL(){{
			SELECT("id as id,hero_name as heroName,grade as grade,description as description,price as price");
			FROM("skin");
			if(!StringUtil.isBlank(skin.getHeroName())){
				WHERE("name = #{name}");
			}
			if(!StringUtil.isBlank(skin.getGrade())){
				WHERE("grade = #{grade}");
			}
			if(!StringUtil.isBlank(skin.getDescription())){
				WHERE("description = #{description}");
			}
			if(!StringUtil.isBlank(skin.getPrice())){
				WHERE("price = #{price}");
			}
		}}.toString();
	}
}
