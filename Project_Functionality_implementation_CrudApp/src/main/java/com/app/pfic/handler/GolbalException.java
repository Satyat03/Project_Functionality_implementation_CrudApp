package com.app.pfic.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.pfic.dto.EmployeeResponce;
import com.app.pfic.exception.CaseMismatchException;
import com.app.pfic.exception.UserNotFoundException;
import com.app.pfic.exception.WrongUsernameException;


@RestControllerAdvice
public class GolbalException {

	@ExceptionHandler(CaseMismatchException.class)
	public ResponseEntity<EmployeeResponce> handelUserNotFoundException(CaseMismatchException ue)
	{
		String message = ue.getMessage();
		
		EmployeeResponce ur = new EmployeeResponce(message, new Date());
		
		return new ResponseEntity<EmployeeResponce>(ur, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(WrongUsernameException.class)
	public ResponseEntity<EmployeeResponce> wrongusernae(WrongUsernameException wm)
	{
		String message= wm.getMessage();
		EmployeeResponce ur = new EmployeeResponce(message, new Date());
		return new ResponseEntity<EmployeeResponce>(ur,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<EmployeeResponce> usernotfound(UserNotFoundException wm)
	{
		String message= wm.getMessage();
		EmployeeResponce ur = new EmployeeResponce(message, new Date());
		return new ResponseEntity<EmployeeResponce>(ur,HttpStatus.BAD_REQUEST);
		
	}
	
}
