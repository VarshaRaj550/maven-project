package com.mindtree.comics.controller;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.comics.dto.ComicDto;
import com.mindtree.comics.exception.serviceexception.ComicServiceException;
import com.mindtree.comics.service.ComicService;

@RestController
public class ComicController {

	@Autowired
	ComicService comicService;

	@PostMapping("/insertcomic")
	public ResponseEntity<Map<String, Object>> insertComicWithOthers(@RequestBody ComicDto comicDto) {

		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("header", "comic details");
		response.put("error", false);
		response.put("message", comicService.insertComicWithOthers(comicDto));
		response.put("time-stamp", new Date());
		response.put("Http-Status", HttpStatus.OK);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}

	@GetMapping("/getcomic")
	public ResponseEntity<Map<String, Object>> getAllSuperHeroesByGivenPowerDescription() {

		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("header", "comic details");
		response.put("error", false);
		response.put("message", comicService.getAllSuperHeroesByGivenPowerDescription());
		response.put("time-stamp", new Date());
		response.put("Http-Status", HttpStatus.OK);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}

	@GetMapping("/gettotal/{superHeroId}")
	public ResponseEntity<Map<String, Object>> getAllSuperHeroesByGivenPowerDescription(@PathVariable int superHeroId)
			throws ComicServiceException {

		try {
			Map<String, Object> response = new LinkedHashMap<String, Object>();
			response.put("header", "total damage");
			response.put("error", false);

			response.put("total damage", comicService.getCombinedDamageBySuperHeroId(superHeroId));
			response.put("time-stamp", new Date());
			response.put("Http-Status", HttpStatus.OK);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		} catch (ComicServiceException e) {
			throw new ComicServiceException("no power found");
		}

	}

}
