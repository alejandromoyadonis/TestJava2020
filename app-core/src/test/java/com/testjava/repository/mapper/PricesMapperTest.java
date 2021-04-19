package com.testjava.repository.mapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class PricesMapperTest {

	@InjectMocks
	private PricesMapper itemMapper;
	@Mock
	private ResultSet resultSet;

	@Before
	public void inicializaMocks() {
		MockitoAnnotations.openMocks(this);
		this.itemMapper = new PricesMapper();
	}

	@Test
	public void testMapRow() throws SQLException {
		when(this.resultSet.getString("id")).thenReturn("token");
		assertNotNull(this.itemMapper.mapRow(this.resultSet, 1));
	}
}
