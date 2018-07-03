package com.jason.boot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import com.jason.boot.entity.SqlProvider;
import com.jason.boot.entity.UserAsset;
@Mapper
public interface UserAssetDao {
	@SelectProvider(type=SqlProvider.class,method="selectUserAsset")
	public List<UserAsset> getUserAssetList(UserAsset asset);
	@Insert("INSERT INTO user_asset(id,user_no,type,hero_name,skin_grade) VALUES(#{id},#{userNo},#{type}，#{heroName}，#{skinGrade})")
	public int postUserAsset(UserAsset asset);
}
