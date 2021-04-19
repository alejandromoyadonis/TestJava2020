package com.testjava.repository;

import com.testjava.model.PriceItem;
import com.testjava.repository.mapper.PricesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class PriceRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int insert(final PriceItem price) {
		String query = "INSERT into prices(id, price_id, brand_id, product_id, priority, price, currency, start_date, start_time, end_date, end_time) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] params = new Object[]{UUID.randomUUID().toString(), price.getRate(), price.getBrand(), price.getProduct(), price.getPriority(), price.getPrice(), price.getCurrency()
				, price.getDates().getFrom(), price.getDates().getTimeFrom(), price.getDates().getTo(), price.getDates().getTimeTo()};
		return this.jdbcTemplate.update(query, params);
	}

	public List<PriceItem> findAll() {
		// Las consultas de BBDD las añadiria en algun servicio que permita refrescar las properties en caliente.
		String query = "SELECT id, price_id, brand_id, product_id, priority, price, currency, start_date, start_time, end_date, end_time FROM prices";
		return this.jdbcTemplate.query(query, new PricesMapper());
	}
}