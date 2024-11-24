package com.springBoot.web.payloads;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.springBoot.web.exception.ResourceNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleNoArgumentValidException(MethodArgumentNotValidException ex) {
		Map<String, String> res = new HashMap<String, String>();
		ex.getBindingResult().getAllErrors().forEach(error -> {
	        String field = (error instanceof FieldError) ? ((FieldError) error).getField() : error.getObjectName();
			String message = error.getDefaultMessage();
			res.put(field, message);
		});
		return new ResponseEntity<Map<String,String>>(res, HttpStatus.BAD_REQUEST);

	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> handleResourceNoFoundException(ResourceNotFoundException ex)
	{
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);

	}
	
}
