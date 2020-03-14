package com.mindtree.comics.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "POWER_DETAILS")
public class Power {

	@Id
	@Column(name = "POWER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int powerId;

	@Column(name = "POWER_NAME")
	private String powerName;

	@Column(name = "POWER_DAMAGE")
	private int powerDamage;

	@ManyToOne(fetch = FetchType.LAZY)
	
	@JoinColumn(name = "SUPERHERO_ID")
	private SuperHero superHero;

	public Power() {
		super();
	}

	public Power(int powerId, String powerName, int powerDamage, SuperHero superHero) {
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

	public SuperHero getSuperHero() {
		return superHero;
	}

	public void setSuperHero(SuperHero superHero) {
		this.superHero = superHero;
	}

	@Override
	public String toString() {
		return "Power [powerId=" + powerId + ", powerName=" + powerName + ", powerDamage=" + powerDamage
				+ ", superHero=" + superHero + "]";
	}

}
