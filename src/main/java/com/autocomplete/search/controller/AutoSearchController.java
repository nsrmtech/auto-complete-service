package com.autocomplete.search.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.autocomplete.search.model.Pincode;
import com.autocomplete.search.repository.PincodeRepository;

@RestController
@Validated
public class AutoSearchController {

	private static final String ALPHA_REGEX = "^[a-zA-Z]+$";

	@Autowired
	PincodeRepository repository;

	@RequestMapping(name = "/suggest_cities", produces = { MediaType.TEXT_PLAIN_VALUE })
	public String suggestCities(@RequestParam(name = "start") @Valid @Pattern(regexp = ALPHA_REGEX) String start,
			@RequestParam(name = "atmost") int atmost) {

		StringBuilder result = new StringBuilder();

		if (atmost < 1) {
			throw new ConstraintViolationException("invalid atmost", null);
		}

		// Extract city names from the pincode model rows
		List<String> cities = repository.findByDivisionNameIgnoreCaseStartsWith(start).stream()
				.map(Pincode::getDivisionName).distinct().collect(Collectors.toList());

		// Check if the city list more than atmost
		if (cities.size() > atmost) {
			cities = cities.subList(0, atmost);
		}

		// append cities line by line
		cities.forEach(city -> result.append(city).append('\n'));

		return result.toString();
	}

}
