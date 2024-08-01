package com.Demo.hero.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Demo.hero.model.Hero;

public interface IHero extends JpaRepository<Hero, Long>{
	
	Hero findByName(String name);

}
