package com.testjava.api;

import com.testjava.model.ApiRQ;
import com.testjava.model.ApiRS;
import com.testjava.model.PriceItem;
import com.testjava.service.PriceService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class PriceControllerTest {

	@InjectMocks
	private PriceController controller;
	@Mock
	private PriceService service;

	@Before
	public void inicializaMocks() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testPriceController() {
		ApiRQ request = new ApiRQ();
		when(this.service.findBestRate(anyInt(), anyLong(), anyString(), anyString())).thenReturn(new PriceItem());

		ResponseEntity<ApiRS> response = this.controller.price(request);
		assertNotNull(response);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
}
