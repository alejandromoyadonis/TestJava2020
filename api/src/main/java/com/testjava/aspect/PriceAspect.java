package com.testjava.aspect;

import com.testjava.exception.ValidateException;
import com.testjava.model.ApiRQ;
import com.testjava.model.Error;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@Aspect
public class PriceAspect {

	@Around(value = "within(@org.springframework.web.bind.annotation.RestController *) && execution(* com.testjava.api.PriceController.price*(..)) && args(request)", argNames = "point,request")
	public Object price(final ProceedingJoinPoint point, final ApiRQ request) throws Throwable {
		if (this.invalidRQ(request)) {
			throw new ValidateException(new Error("Invalid request"));
		}
		return point.proceed();
	}

	private boolean invalidRQ(final ApiRQ request) {
		return request == null
				|| (request.getBrand() == null && request.getProduct() == null)
				|| !StringUtils.hasText(request.getFrom())
				|| !StringUtils.hasText(request.getTime());
	}
}
