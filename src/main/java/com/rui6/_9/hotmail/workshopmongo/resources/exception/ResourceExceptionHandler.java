package com.rui6._9.hotmail.workshopmongo.resources.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.rui6._9.hotmail.workshopmongo.services.exception.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> obejectNotFound(ObjectNotFoundException e, HttpServletRequest request)
	{
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Not Found",e.getMessage(),request.getRequestURI());
	    return ResponseEntity.status(status).body(err);
	}

}
