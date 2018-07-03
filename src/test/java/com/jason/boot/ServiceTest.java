package com.jason.boot;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jason.boot.entity.Hero;
import com.jason.boot.entity.UserSen;
import com.jason.boot.service.HeroService;
import com.jason.boot.service.UserSenService;
import com.jason.boot.utils.StringUtil;
/**
 * 单元测试类
 * @author 宁无敌
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {
	@Autowired
	private UserSenService userSenService;
	@Autowired
	private HeroService heroService;
	@Before
	public void before(){
		System.out.println("开始测试");
	}
	@Test
	public void test1() {
		UserSen userSen = new UserSen();
		userSen.setName("秦问天");
		System.out.println(userSenService.getUserList(userSen));
	}
	@Test
	public void test2() {
		UserSen user = new UserSen();
		user.setAge("33");
		user.setId(StringUtil.createUUID());
		user.setName("张安");
		user.setPassword("22222222");
		user.setUserNo("1705289");
		userSenService.postUser(user);
	}
	@Test
	public void test3(){
		Hero hero = heroService.getHero("riven").get(0);
		System.out.println(hero);
	}

}
