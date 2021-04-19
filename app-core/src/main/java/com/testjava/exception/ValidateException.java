package com.testjava.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.testjava.model.Error;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Object defined for the exception control.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
public class ValidateException extends RuntimeException {

	@Getter
	private Error error;

	public ValidateException(final Error error) {
		super();
		this.error = error;
	}
}