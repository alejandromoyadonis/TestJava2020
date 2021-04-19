package com.testjava.api;

import com.testjava.model.ApiRQ;
import com.testjava.model.ApiRS;
import com.testjava.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class PriceController {

	@Autowired
	private PriceService service;

	@PostMapping(value = "/price")
	public ResponseEntity<ApiRS> price(@RequestBody final ApiRQ request) {
		ApiRS response = new ApiRS();
		response.setResponse(this.service.findBestRate(request.getBrand(), request.getProduct(), request.getFrom(), request.getTime()));
		response.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
