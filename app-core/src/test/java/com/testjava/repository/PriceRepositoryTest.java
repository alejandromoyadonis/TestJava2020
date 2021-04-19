package com.testjava.repository;

import com.testjava.model.DateRange;
import com.testjava.model.PriceItem;
import com.testjava.repository.mapper.PricesMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class PriceRepositoryTest {

	@InjectMocks
	private PriceRepository repository;
	@Mock
	private JdbcTemplate jdbcTemplate;

	@Before
	public void inicializaMocks() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testInsert() {
		PriceItem price = new PriceItem();
		price.setDates(new DateRange());

		when(this.jdbcTemplate.update(anyString(), (Object) any())).thenReturn(1);
		assertEquals(1, this.repository.insert(price));
	}

	@Test
	public void testFindAll() {
		when(this.jdbcTemplate.query(anyString(), any(PricesMapper.class))).thenReturn(List.of(new PriceItem()));
		assertEquals(1, this.repository.findAll().size());
	}
}
