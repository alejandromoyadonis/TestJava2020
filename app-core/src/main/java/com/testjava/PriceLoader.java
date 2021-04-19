package com.testjava;

import com.testjava.model.DateRange;
import com.testjava.model.PriceItem;
import com.testjava.service.PriceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PriceLoader {

	private static final String FOURTEEN_JUNE = "2020-06-14";
	private static final String FIFTEEN_JUNE = "2020-06-15";
	private static final String LOG_TEXT = "Inserting -> %s";

	@Autowired
	private PriceService service;

	public void run() {
		PriceItem price = new PriceItem();
		price.setBrand(1);
		price.setRate(1);
		price.setProduct(Long.valueOf("35455"));
		price.setPriority(0);
		price.setPrice(Double.parseDouble("35.50"));
		price.setCurrency("EUR");
		price.setDates(new DateRange());
		price.getDates().setFrom(PriceLoader.FOURTEEN_JUNE);
		price.getDates().setTimeFrom("00.00.00");
		price.getDates().setTo("2020-12-31");
		price.getDates().setTimeTo("23.59.59");
		this.service.createItem(price);
		PriceLoader.log.info(String.format(PriceLoader.LOG_TEXT, price));

		price.setRate(2);
		price.setPriority(1);
		price.setPrice(Double.parseDouble("25.45"));
		price.getDates().setTimeFrom("15.00.00");
		price.getDates().setTo(PriceLoader.FOURTEEN_JUNE);
		price.getDates().setTimeTo("18.30.00");
		this.service.createItem(price);
		PriceLoader.log.info(String.format(PriceLoader.LOG_TEXT, price));

		price.setRate(3);
		price.setPrice(Double.parseDouble("30.50"));
		price.getDates().setFrom(PriceLoader.FIFTEEN_JUNE);
		price.getDates().setTimeFrom("00.00.00");
		price.getDates().setTo(PriceLoader.FIFTEEN_JUNE);
		price.getDates().setTimeTo("11.00.00");
		this.service.createItem(price);
		PriceLoader.log.info(String.format(PriceLoader.LOG_TEXT, price));

		price.setRate(4);
		price.setPrice(Double.parseDouble("38.95"));
		price.getDates().setTimeFrom("16.00.00");
		price.getDates().setTo("2020-12-31");
		price.getDates().setTimeTo("23.59.59");
		this.service.createItem(price);
		PriceLoader.log.info(String.format(PriceLoader.LOG_TEXT, price));
	}
}