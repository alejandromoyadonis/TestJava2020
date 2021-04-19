package com.testjava.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Object defined for the API request.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ApiRQ implements Serializable {

	private static final long serialVersionUID = 3229336432402420710L;

	@JsonProperty("brd")
	private Integer brand;
	@JsonProperty("prd")
	private Long product;
	@JsonProperty("from")
	private String from;
	@JsonProperty("time")
	private String time;
}
