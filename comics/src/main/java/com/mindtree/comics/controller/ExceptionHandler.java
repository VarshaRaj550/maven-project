package com.mindtree.comics.controller;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mindtree.comics.exception.serviceexception.ComicServiceException;

@RestControllerAdvice
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(ComicServiceException.class)
	public ResponseEntity<Map<String,Object>> ServiceExceptionHandler(Exception e)
	{
		Map<String,Object> response = new LinkedHashMap<>();
		response.put("message", e.getMessage());
		response.put("time-stamp", new Date());
		response.put("Http-Status", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.BAD_REQUEST);
		
	}
}

