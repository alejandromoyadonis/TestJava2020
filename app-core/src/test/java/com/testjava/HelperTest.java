package com.testjava;

import com.testjava.model.DateRange;
import com.testjava.model.PriceItem;

import java.util.List;

public abstract class HelperTest {

	private static final String FOURTEEN_JUNE = "2020-06-14";
	private static final String FIFTEEN_JUNE = "2020-06-15";

	public static List<PriceItem> prices() {
		PriceItem price = new PriceItem();
		price.setBrand(1);
		price.setRate(1);
		price.setProduct(35455L);
		price.setPriority(0);
		price.setPrice(Double.parseDouble("35.50"));
		price.setCurrency("EUR");
		price.setDates(new DateRange());
		price.getDates().setFrom(HelperTest.FOURTEEN_JUNE);
		price.getDates().setTimeFrom("00.00.00");
		price.getDates().setTo("2020-12-31");
		price.getDates().setTimeTo("23.59.59");

		PriceItem price1 = new PriceItem();
		price1.setBrand(1);
		price1.setRate(2);
		price1.setProduct(35455L);
		price1.setPriority(1);
		price1.setPrice(Double.parseDouble("25.45"));
		price1.setCurrency("EUR");
		price1.setDates(new DateRange());
		price1.getDates().setFrom(HelperTest.FOURTEEN_JUNE);
		price1.getDates().setTimeFrom("15.00.00");
		price1.getDates().setTo(HelperTest.FOURTEEN_JUNE);
		price1.getDates().setTimeTo("18.30.00");

		PriceItem price2 = new PriceItem();
		price2.setBrand(1);
		price2.setRate(3);
		price2.setProduct(35455L);
		price2.setPriority(1);
		price2.setPrice(Double.parseDouble("30.50"));
		price2.setCurrency("EUR");
		price2.setDates(new DateRange());
		price2.getDates().setFrom(HelperTest.FIFTEEN_JUNE);
		price2.getDates().setTimeFrom("00.00.00");
		price2.getDates().setTo(HelperTest.FIFTEEN_JUNE);
		price2.getDates().setTimeTo("11.00.00");

		PriceItem price3 = new PriceItem();
		price3.setBrand(1);
		price3.setRate(4);
		price3.setProduct(35455L);
		price3.setPriority(1);
		price3.setPrice(Double.parseDouble("38.95"));
		price3.setCurrency("EUR");
		price3.setDates(new DateRange());
		price3.getDates().setFrom(HelperTest.FIFTEEN_JUNE);
		price3.getDates().setTimeFrom("16.00.00");
		price3.getDates().setTo("2020-12-31");
		price3.getDates().setTimeTo("23.59.59");

		return  List.of(price, price1, price2, price3);
	}
}