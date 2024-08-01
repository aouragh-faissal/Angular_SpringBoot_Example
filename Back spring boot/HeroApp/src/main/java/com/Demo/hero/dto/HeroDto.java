package com.Demo.hero.dto;

import org.springframework.web.multipart.MultipartFile;

public class HeroDto {
	
	private String name;
	private int power;
	private MultipartFile image;
	
	
	public HeroDto(String name, int power, MultipartFile image) {
		super();
		this.name = name;
		this.power = power;
		this.image = image;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPower() {
		return power;
	}


	public void setPower(int power) {
		this.power = power;
	}


	public MultipartFile getImage() {
		return image;
	}


	public void setImage(MultipartFile image) {
		this.image = image;
	}
	
	
	
	

}
