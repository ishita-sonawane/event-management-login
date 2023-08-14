package com.rigeltech.eventmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserCredentialMismatchExceptionController {

	@ExceptionHandler(value = UserCredentialNotFoundException.class)
	public ResponseEntity<Object> exception(UserCredentialNotFoundException exception) {
	      return new ResponseEntity<>("User Credential mismatch", HttpStatus.NOT_FOUND);

	}

}
