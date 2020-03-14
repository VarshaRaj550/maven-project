package com.mindtree.comics.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

public class ComicDto {

	private int comicId;
	private String comicName;
	private String comicUniverse;
	
	@JsonManagedReference
	private Set<SuperHeroDto>superHeroes ;

	
	
	public ComicDto() {
		super();
	}

	public ComicDto(int comicId, String comicName, String comicUniverse, Set<SuperHeroDto> superHeroes) {
		super();
		this.comicId = comicId;
		this.comicName = comicName;
		this.comicUniverse = comicUniverse;
		this.superHeroes = superHeroes;
	}

	public int getComicId() {
		return comicId;
	}

	public void setComicId(int comicId) {
		this.comicId = comicId;
	}

	public String getComicName() {
		return comicName;
	}

	public void setComicName(String comicName) {
		this.comicName = comicName;
	}

	public String getComicUniverse() {
		return comicUniverse;
	}

	public void setComicUniverse(String comicUniverse) {
		this.comicUniverse = comicUniverse;
	}

	public Set<SuperHeroDto> getSuperHeroes() {
		return superHeroes;
	}

	public void setSuperHeroes(Set<SuperHeroDto> superHeroes) {
		this.superHeroes = superHeroes;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((superHeroes == null) ? 0 : superHeroes.hashCode());
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
		ComicDto other = (ComicDto) obj;
		if (superHeroes == null) {
			if (other.superHeroes != null)
				return false;
		} else if (!superHeroes.equals(other.superHeroes))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comic [comicId=" + comicId + ", comicName=" + comicName + ", comicUniverse=" + comicUniverse
				+ ", superHeroes=" + superHeroes + "]";
	}
	
	
	
}
