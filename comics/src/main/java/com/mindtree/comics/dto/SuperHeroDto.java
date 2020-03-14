package com.mindtree.comics.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

public class SuperHeroDto {

	private int superHeroId;
	private String superHeroName;
	@JsonManagedReference
	private Set<PowerDto>powers ;
	
	@JsonBackReference
	private ComicDto comic;
	public SuperHeroDto() {
		super();
	}
	public SuperHeroDto(int superHeroId, String superHeroName, Set<PowerDto> powers, ComicDto comic) {
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
	public Set<PowerDto> getPowers() {
		return powers;
	}
	public void setPowers(Set<PowerDto> powers) {
		this.powers = powers;
	}
	public ComicDto getComic() {
		return comic;
	}
	public void setComic(ComicDto comic) {
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
		SuperHeroDto other = (SuperHeroDto) obj;
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
