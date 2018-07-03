package com.jason.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jason.boot.dao.UserAssetDao;
import com.jason.boot.entity.UserAsset;
import com.jason.boot.utils.StringUtil;
@Service
public class UserAssetService {
	@Autowired
	UserAssetDao dao;
	public List<UserAsset> getUserAsset(String userNo){
		UserAsset asset = new UserAsset();
		asset.setUserNo(userNo);
		return dao.getUserAssetList(asset);
	}
	public int postUserAsset(UserAsset asset){
		asset.setId(StringUtil.createUUID());
		return dao.postUserAsset(asset);
	}
}
