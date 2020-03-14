package com.mindtree.comics.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class PowerDto {

	private int powerId;
	private String powerName;
	private int powerDamage;
	
	@JsonBackReference
	private SuperHeroDto superHero;

	public PowerDto() {
		super();
	}

	public PowerDto(int powerId, String powerName, int powerDamage, SuperHeroDto superHero) {
		super();
		this.powerId = powerId;
		this.powerName = powerName;
		this.powerDamage = powerDamage;
		this.superHero = superHero;
	}

	public int getPowerId() {
		return powerId;
	}

	public void setPowerId(int powerId) {
		this.powerId = powerId;
	}

	public String getPowerName() {
		return powerName;
	}

	public void setPowerName(String powerName) {
		this.powerName = powerName;
	}

	public int getPowerDamage() {
		return powerDamage;
	}

	public void setPowerDamage(int powerDamage) {
		this.powerDamage = powerDamage;
	}

	public SuperHeroDto getSuperHero() {
		return superHero;
	}

	public void setSuperHero(SuperHeroDto superHero) {
		this.superHero = superHero;
	}

	@Override
	public String toString() {
		return "Power [powerId=" + powerId + ", powerName=" + powerName + ", powerDamage=" + powerDamage
				+ ", superHero=" + superHero + "]";
	}
	
}
