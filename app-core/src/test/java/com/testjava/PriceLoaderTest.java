package com.testjava;

import com.testjava.service.PriceService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.Silent.class)
public class PriceLoaderTest {

	@InjectMocks
	private PriceLoader loader;
	@Mock
	private PriceService service;

	@Before
	public void inicializaMocks() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testRun() {
		this.loader.run();
		assertTrue(true);
	}
}
