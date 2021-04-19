package com.testjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@ToString
public class PriceItem implements Serializable {

	private static final long serialVersionUID = -6950828213846529317L;

	@JsonIgnore
	private String id;
	@JsonProperty("brd")
	private Integer brand;
	@JsonProperty("rate")
	private int rate;
	@JsonProperty("prd")
	private Long product;
	@JsonIgnore
	private int priority;
	@JsonProperty("pvp")
	private double price;
	@JsonIgnore
	private String currency;
	@JsonProperty("aplDate")
	private DateRange dates;
}
