package com.autocomplete.search.controller;

import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.autocomplete.search.service.AutoSearchService;

@RestController
@Validated
public class AutoSearchController {

	private static final String ALPHA_REGEX = "^[a-zA-Z]+$";
	
	private Logger logger = LoggerFactory.getLogger(AutoSearchService.class);

	@Autowired
	AutoSearchService autoSearchService;

	@RequestMapping(name = "/suggest_cities", produces = { MediaType.TEXT_PLAIN_VALUE })
	public String suggestCities(@RequestParam(name = "start") @Valid @Pattern(regexp = ALPHA_REGEX) String start,
			@RequestParam(name = "atmost") int atmost) {

		logger.info("start: {}, atmost: {}", start, atmost);
		
		StringBuilder result = new StringBuilder();

		if (atmost < 1) {
			throw new ConstraintViolationException("invalid atmost", null);
		}
				
		//Get cities as list for start string(case ignorant)	
		List<String> cities = autoSearchService.getCitySuggestions(start.toUpperCase(), atmost);
		
		logger.info("cities: {}", cities);

		// append cities line by line
		cities.forEach(city -> result.append(city).append('\n'));

		return result.toString();
	}

}
