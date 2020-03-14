package com.mindtree.comics.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "COMIC_DETAILS")
public class Comic {

	@Id
	@Column(name = "COMIC_ID")
	private int comicId;
	@Column(name = "COMIC_NAME")
	private String comicName;
	@Column(name = "COMIC_UNIVERSE")
	private String comicUniverse;
	@OneToMany(mappedBy = "comic", cascade = CascadeType.ALL)
	private Set<SuperHero>superHeroes ;

	
	
	public Comic() {
		super();
	}

	public Comic(int comicId, String comicName, String comicUniverse, Set<SuperHero> superHeroes) {
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

	public Set<SuperHero> getSuperHeroes() {
		return superHeroes;
	}

	public void setSuperHeroes(Set<SuperHero> superHeroes) {
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
		Comic other = (Comic) obj;
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
