package com.Demo.hero.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Hero {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	private int power;
	private String image;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Hero(String name, int power, String image) {
		super();
		this.name = name;
		this.power = power;
		this.image = image;
	}
	public Hero() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	

}
