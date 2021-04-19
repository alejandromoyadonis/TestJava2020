package com.testjava.advice;

import com.testjava.exception.ValidateException;
import com.testjava.model.ApiRS;
import com.testjava.model.Error;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.Silent.class)
public class GlobalExceptionHandlerTest {

	@InjectMocks
	private GlobalExceptionHandler globalExceptionHandler;
	@Mock
	private HttpServletRequest request;

	private Error error;

	@Before
	public void inicializaMocks() {
		MockitoAnnotations.openMocks(this);
		this.error = new Error("test");
	}

	@Test
	public void testHandleValidateException() {
		ResponseEntity<ApiRS> response = this.globalExceptionHandler.handleValidateException(this.request, new ValidateException(this.error));
		assertNotNull(response);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}

	@Test
	public void testHandleException() {
		ResponseEntity<ApiRS> response = this.globalExceptionHandler.handleException(this.request, new Exception());
		assertNotNull(response);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
	}
}
