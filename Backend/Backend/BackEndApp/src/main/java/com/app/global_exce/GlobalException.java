package com.app.global_exce;

import java.time.LocalDate;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.app.dto.ErrorResponse;
import com.app.excepe.UserHandlingException;

public class GlobalException extends ResponseEntityExceptionHandler{
	@ExceptionHandler(UserHandlingException.class)
	public ResponseEntity<?> customerIsNull(EmptyResultDataAccessException e){
		System.out.println("in error response ");
		ErrorResponse resp = new ErrorResponse(e.getMessage(), LocalDate.now());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resp)  ;
	}
}
