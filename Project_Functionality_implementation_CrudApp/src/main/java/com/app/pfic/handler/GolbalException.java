package com.app.pfic.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.pfic.dto.EmployeeResponce;
import com.app.pfic.exception.CaseMismatchException;


@RestControllerAdvice
public class GolbalException {

	@ExceptionHandler(CaseMismatchException.class)
	public ResponseEntity<EmployeeResponce> handelUserNotFoundException(CaseMismatchException ue)
	{
		String message = ue.getMessage();
		
		EmployeeResponce ur = new EmployeeResponce(message, new Date());
		
		return new ResponseEntity<EmployeeResponce>(ur, HttpStatus.BAD_REQUEST);
	}
	
	
}
