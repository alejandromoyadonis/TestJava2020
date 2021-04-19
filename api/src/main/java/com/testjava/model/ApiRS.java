package com.testjava.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class ApiRS implements Serializable {

	private static final long serialVersionUID = -5412668021650873270L;

	private int status;
	private transient Object response;

	public ApiRS(final Object obj, final int status) {
		this.status = status;
		this.response = obj;
	}
}
