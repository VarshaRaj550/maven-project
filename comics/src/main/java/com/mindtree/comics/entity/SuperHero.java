package com.mindtree.comics.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SUPERHERO_DETAILS")
public class SuperHero {

	@Id
	@Column(name = "SUPERHHERO_ID")
	private int superHeroId;
	@Column(name = "SUPERHHERO_NAME")
	private String superHeroName;
	@OneToMany(mappedBy = "superHero")
	private Set<Power>powers ;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "COMIC_ID")
	private Comic comic;
	public SuperHero() {
		super();
	}
	public SuperHero(int superHeroId, String superHeroName, Set<Power> powers, Comic comic) {
		super();
		this.superHeroId = superHeroId;
		this.superHeroName = superHeroName;
		this.powers = powers;
		this.comic = comic;
	}
	public int getSuperHeroId() {
		return superHeroId;
	}
	public void setSuperHeroId(int superHeroId) {
		this.superHeroId = superHeroId;
	}
	public String getSuperHeroName() {
		return superHeroName;
	}
	public void setSuperHeroName(String superHeroName) {
		this.superHeroName = superHeroName;
	}
	public Set<Power> getPowers() {
		return powers;
	}
	public void setPowers(Set<Power> powers) {
		this.powers = powers;
	}
	public Comic getComic() {
		return comic;
	}
	public void setComic(Comic comic) {
		this.comic = comic;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((powers == null) ? 0 : powers.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SuperHero other = (SuperHero) obj;
		if (powers == null) {
			if (other.powers != null)
				return false;
		} else if (!powers.equals(other.powers))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SuperHero [superHeroId=" + superHeroId + ", superHeroName=" + superHeroName + ", powers=" + powers
				+ ", comic=" + comic + "]";
	}
	
	
}
