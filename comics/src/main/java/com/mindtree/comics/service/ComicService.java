package com.mindtree.comics.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.mindtree.comics.dto.ComicDto;
import com.mindtree.comics.dto.SuperHeroDto;
import com.mindtree.comics.exception.serviceexception.ComicServiceException;

@Service
public interface ComicService {

	
	/**
	 * @param comicDto
	 * @return insertion status
	 */
	public String insertComicWithOthers(ComicDto comicDto);
	
	/**
	 * @return list of superheroes
	 */
	public Set<SuperHeroDto> getAllSuperHeroesByGivenPowerDescription();
	
	/**
	 * @param superHeroId
	 * @return powerdamage total
	 * @throws ComicServiceException
	 */
	public int getCombinedDamageBySuperHeroId(int superHeroId) throws ComicServiceException;
}
