package com.autocomplete.search.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.autocomplete.search.model.Pincode;

public interface PincodeRepository extends CrudRepository<Pincode, Long>{
	
    List<Pincode> findByDivisionNameIgnoreCaseStartsWith(String satrt);
} 