package com.jason.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jason.boot.dao.UserSenDao;
import com.jason.boot.entity.UserSen;

@Service
public class UserSenService {
	@Autowired
	UserSenDao userDao;
	public List<UserSen> getUserList(UserSen user){
		return userDao.getUserList(user);
	}
	public List<UserSen> getUserList(String userNo){
		UserSen user = new UserSen();
		user.setUserNo(userNo);
		return userDao.getUserList(user);
	}
	public void postUser(UserSen user){
		userDao.postUser(user);
	}
	
	public void putUser(String userNo,UserSen user){
		userDao.putUser(userNo,user);
	}
	public void deleteUser(String userNo){
		userDao.deleteUser(userNo);
	}
}
