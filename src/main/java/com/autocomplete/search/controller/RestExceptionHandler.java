package com.autocomplete.search.controller;

import javax.validation.ConstraintViolationException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
  
 
   @ExceptionHandler(ConstraintViolationException.class)
   protected ResponseEntity<Object> handleEntityNotFound(
		   ConstraintViolationException ex) {             
       return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
   }
}