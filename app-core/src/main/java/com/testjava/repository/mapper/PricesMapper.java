package com.testjava.repository.mapper;

import com.testjava.model.DateRange;
import com.testjava.model.PriceItem;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PricesMapper implements RowMapper<PriceItem> {

	@Override
	public PriceItem mapRow(final ResultSet resultSet, final int index) throws SQLException {
		PriceItem price = new PriceItem();
		price.setId(resultSet.getString("id"));
		price.setRate(resultSet.getInt("price_id"));
		price.setBrand(resultSet.getInt("brand_id"));
		price.setProduct(resultSet.getLong("product_id"));
		price.setPriority(resultSet.getInt("priority"));
		price.setPrice(resultSet.getDouble("price"));
		price.setCurrency(resultSet.getString("currency"));
		price.setDates(this.getDates(resultSet));
		return price;
	}

	private DateRange getDates(final ResultSet resultSet) throws SQLException {
		DateRange dates = new DateRange();
		dates.setFrom(resultSet.getString("start_date"));
		dates.setTimeFrom(resultSet.getString("start_time"));
		dates.setTo(resultSet.getString("end_date"));
		dates.setTimeTo(resultSet.getString("end_time"));
		return dates;
	}
}
