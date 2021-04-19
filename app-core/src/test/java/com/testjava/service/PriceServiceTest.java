package com.testjava.service;

import com.testjava.HelperTest;
import com.testjava.exception.ValidateException;
import com.testjava.model.PriceItem;
import com.testjava.repository.PriceRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
@Slf4j
public class PriceServiceTest extends HelperTest {

	@InjectMocks
	private PriceService service;
	@Mock
	private PriceRepository repository;

	@Before
	public void inicializaMocks() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testCreateItem() {
		when(this.repository.insert(any())).thenReturn(1);
		assertEquals(1, this.service.createItem(new PriceItem()));
	}

	@Test(expected = ValidateException.class)
	public void testFindBestRate() {
		when(this.repository.findAll()).thenReturn(new ArrayList<>());
		this.service.findBestRate(1, 35455L, "14/06/2020", "10:00");
	}

	@Test
	public void testFindBestRateTest1() {
		assertEquals(1, this.getResult("14/06/2020", "10:00"));
	}

	@Test
	public void testFindBestRateTest2() {
		assertEquals(2, this.getResult("14/06/2020", "16:00"));
	}

	@Test
	public void testFindBestRateTest3() {
		assertEquals(1, this.getResult("14/06/2020", "21:00"));
	}

	@Test
	public void testFindBestRateTest4() {
		assertEquals(3, this.getResult("15/06/2020", "10:00"));
	}

	@Test
	public void testFindBestRateTest5() {
		assertEquals(4, this.getResult("16/06/2020", "21:00"));
	}

	private int getResult(final String date, final String time) {
		when(this.repository.findAll()).thenReturn(prices());
		PriceItem response = this.service.findBestRate(1, 35455L, date, time);
		PriceServiceTest.log.info("Resultado: " + response.toString());
		return response.getRate();
	}
}
