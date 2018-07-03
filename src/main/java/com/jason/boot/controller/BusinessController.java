package com.jason.boot.controller;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jason.boot.entity.Record;
import com.jason.boot.entity.Result;
import com.jason.boot.entity.UserAsset;
import com.jason.boot.entity.UserSen;
import com.jason.boot.service.UserAssetService;
import com.jason.boot.service.HeroService;
import com.jason.boot.service.RecordService;
import com.jason.boot.service.UserSenService;
/**
 * 处理一些具体的业务
 * @author jason
 *
 */
@RestController
@RequestMapping("business")
@Transactional
public class BusinessController {
	@Autowired
	UserAssetService assetService;
	@Autowired
	UserSenService userService;
	@Autowired
	HeroService heroService;
	@Autowired
	RecordService recordService;
	/**
	 * 购买英雄
	 * @param userNo     账号
	 * @param heroName	英雄名
	 * @return
	 */
	
	@RequestMapping(value="/buy-hero/{userNo}",method=RequestMethod.POST)
	public Result buyHero(@PathVariable String userNo,String heroName){
		List<UserAsset> assetList = assetService.getUserAsset(userNo); 
		//判断是否已经拥有该英雄
		for(UserAsset asset:assetList){
			if("1".equals(asset.getType()) && asset.getHeroName().equals(heroName)){
				return new Result(Result.OTHER_CODE,"已拥有该英雄");
			}
		}
		//判断余额是否充足
		UserSen user = userService.getUserList(userNo).get(0);
		int userAccount = user.getAccount();
		int price = heroService.getHero(heroName).get(0).getPrice();
		if(price > userAccount){
			return new Result(Result.OTHER_CODE,"用户账户余额不足，请充值后购买！");
		}
		//满足条件，开始购买
			//1-扣除余额
		user.setAccount(userAccount-price);
		userService.putUser(userNo, user);
			//2-增加资产
		UserAsset newAsset = new UserAsset();
		newAsset.setType("1");//购买类型-英雄
		newAsset.setHeroName(heroName);
		newAsset.setUserNo(userNo);
		newAsset.setSkinGrade("");
		assetService.postUserAsset(newAsset);
			//增加交易记录
		Record record = new Record();
		record.setHeroName(heroName);
		record.setMoney(price);
		record.setType("1");
		record.setUserNo(userNo);
		record.setSkinGrade("");
		recordService.postRecord(record);
		return new Result(Result.SUCCESS_CODE,Result.SUCCESS_MSG);
	}
}
