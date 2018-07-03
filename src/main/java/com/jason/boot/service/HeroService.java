package com.jason.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jason.boot.dao.HeroDao;
import com.jason.boot.entity.Hero;
@Service
public class HeroService {
	@Autowired
	HeroDao heroDao;
	public List<Hero> getHeroList(Hero hero){
		return heroDao.getHeroList(hero);
	}
	public int postHero(Hero Hero){
		return heroDao.postHero(Hero);
	}
	public List<Hero> getHero(String name){
		Hero hero = new Hero();
		hero.setName(name);
		return heroDao.getHeroList(hero);
	}
	public int putHero(String HeroNo,Hero Hero){
		return heroDao.putHero(HeroNo,Hero);
	}
	
}
