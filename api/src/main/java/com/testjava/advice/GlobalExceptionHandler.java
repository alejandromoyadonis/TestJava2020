package com.testjava.advice;

import com.testjava.exception.ValidateException;
import com.testjava.model.ApiRS;
import com.testjava.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
class GlobalExceptionHandler {

	/**
	 * Validation handler exception.
	 *
	 * @param request   Request.
	 * @param exception Exception.
	 * @return Error message.
	 */
	@ExceptionHandler({ValidateException.class})
	ResponseEntity<ApiRS> handleValidateException(final HttpServletRequest request, final ValidateException exception) {
		return this.buildResponse(exception.getError(), request.getRequestURI(), HttpStatus.BAD_REQUEST);
	}

	/**
	 * Handler exception.
	 *
	 * @param request   Request.
	 * @param exception Exception.
	 * @return Error message.
	 */
	@ExceptionHandler(Exception.class)
	ResponseEntity<ApiRS> handleException(final HttpServletRequest request, final Exception exception) {
		return this.buildResponse(new Error(exception.getMessage()), request.getRequestURI(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private ResponseEntity<ApiRS> buildResponse(final Error error, final String uri, final HttpStatus status) {
		error.setUri(uri);
		return new ResponseEntity<>(new ApiRS(error, status.value()), status);
	}


}