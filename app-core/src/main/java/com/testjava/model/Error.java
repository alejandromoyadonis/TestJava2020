package com.testjava.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@ToString
public class Error implements Serializable {

	private static final long serialVersionUID = -5412668021650873270L;

	private String uri;
	private String message;
	private Date timestamp;

	public Error(final String msgText) {
		this.message = msgText;
		this.timestamp = new Date();
	}
}
