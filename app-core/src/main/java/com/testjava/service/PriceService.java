package com.testjava.service;

import com.testjava.exception.ValidateException;
import com.testjava.model.Error;
import com.testjava.model.PriceItem;
import com.testjava.repository.PriceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PriceService {

	private static final String STRING_FORMAT = "%s %s";
	private final SimpleDateFormat formatterDB = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
	private final SimpleDateFormat formatterFilter = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	@Autowired
	private PriceRepository repository;

	public int createItem(final PriceItem item) {
		return this.repository.insert(item);
	}

	public PriceItem findBestRate(final Integer brand, final Long product, final String from, final String time) {
		List<PriceItem> result = this.repository.findAll().stream().filter(p -> this.rateAllowed(p, brand, product, from, time)).collect(Collectors.toList());

		if (result.isEmpty()) {
			throw new ValidateException(new Error("Tarifa no encontrada"));
		}
		this.getPriorityRate(result);
		return result.get(result.size() -1);
	}

	private void getPriorityRate(final List<PriceItem> result) {
		result.sort(Comparator.comparing(PriceItem::getPriority));
	}

	private boolean rateAllowed(final PriceItem item, final Integer brand, final Long product, final String date, final String time) {
		return brand.equals(item.getBrand()) && product.equals(item.getProduct()) && this.isDateAplicable(item, date, time);
	}

	private boolean isDateAplicable(final PriceItem item, final String date, final String time) {
		boolean result = false;
		try {
			Date dateFrom = this.formatterDB.parse(String.format(PriceService.STRING_FORMAT, item.getDates().getFrom(), item.getDates().getTimeFrom()));
			Date dateTo = this.formatterDB.parse(String.format(PriceService.STRING_FORMAT, item.getDates().getTo(), item.getDates().getTimeTo()));

			Date dateFilter = this.formatterFilter.parse(String.format(PriceService.STRING_FORMAT, date, time));
			result = dateFilter.after(dateFrom) && dateFilter.before(dateTo);
		} catch (ParseException p) {
			PriceService.log.error("Incorrect format date");
		}
		return result;
	}
}