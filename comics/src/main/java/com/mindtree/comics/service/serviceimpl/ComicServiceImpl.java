package com.mindtree.comics.service.serviceimpl;

import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.comics.dto.ComicDto;
import com.mindtree.comics.dto.SuperHeroDto;
import com.mindtree.comics.entity.Comic;
import com.mindtree.comics.entity.Power;
import com.mindtree.comics.entity.SuperHero;
import com.mindtree.comics.exception.serviceexception.ComicServiceException;
import com.mindtree.comics.exception.serviceexception.PowerNotFoundException;
import com.mindtree.comics.repository.ComicRepository;
import com.mindtree.comics.repository.PowerRepository;
import com.mindtree.comics.repository.SuperHeroRepository;
import com.mindtree.comics.service.ComicService;

@Service
public class ComicServiceImpl implements ComicService {

	@Autowired
	ComicRepository comicRepository;
	@Autowired
	PowerRepository powerRepository;
	@Autowired
	SuperHeroRepository superHeroRepository;

	ModelMapper modelMapper = new ModelMapper();

	@Override
	public String insertComicWithOthers(ComicDto comicDto) {

		Comic comic = modelMapper.map(comicDto, Comic.class);
		Set<SuperHero> superHeroes = comic.getSuperHeroes();
		comicRepository.save(comic);
		superHeroes.forEach(i -> {
			i.setComic(comic);
			i.getPowers().forEach(j -> {
				j.setSuperHero(i);
				superHeroRepository.save(i);
				powerRepository.save(j);

			});
		});

		return "inserted";
	}

	@Override
	public Set<SuperHeroDto> getAllSuperHeroesByGivenPowerDescription() {

		java.util.List<Power> powers = powerRepository.findAll();
		Set<SuperHeroDto> superHeroDtos = new HashSet<SuperHeroDto>();

		for (Power power : powers) {
			if (power.getPowerName().equalsIgnoreCase("flying")
					|| power.getPowerName().equalsIgnoreCase("invisisbility")) {
//		 		int superHeroId = power.getSuperHero().getSuperHeroId();
//				Optional<SuperHero> superHeroes = superHeroRepository.findById(superHeroId);
				SuperHero superHero = power.getSuperHero();
				SuperHeroDto superHeroDto = modelMapper.map(superHero, SuperHeroDto.class);
				superHeroDtos.add(superHeroDto);
			}
		}

		return superHeroDtos;
	}

	@Override
	public int getCombinedDamageBySuperHeroId(int superHeroId) throws ComicServiceException {

		int total = 0;
		SuperHero superHero;

		superHero = superHeroRepository.findById(superHeroId)
				.orElseThrow(() -> new PowerNotFoundException("No such power Found"));

		for (Power power : superHero.getPowers()) {
			total = total + power.getPowerDamage();

		}

		return total;
	}

}
