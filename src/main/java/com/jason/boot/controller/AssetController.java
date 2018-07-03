package com.jason.boot.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jason.boot.entity.Result;
import com.jason.boot.entity.UserAsset;
import com.jason.boot.service.UserAssetService;
/**
 * 处理一些有关客户资产的操作
 * @author jason
 *
 */
@Transactional
@RestController
@RequestMapping("asset")
public class AssetController {
	@Autowired
	UserAssetService service;
	/**
	 * 查询某用户资产
	 * @param userNo
	 * @return
	 */
	@RequestMapping(value="/{userNo}",method=RequestMethod.GET)
	public Result getUserAsset(@PathVariable String userNo){
		List<UserAsset> list = service.getUserAsset(userNo);
		return new Result(Result.SUCCESS_CODE,Result.SUCCESS_MSG,list);
	}
}
