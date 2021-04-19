package com.testjava.aspect;

import com.testjava.exception.ValidateException;
import com.testjava.model.ApiRQ;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
@WebAppConfiguration
public class PriceAspectTest {

	@InjectMocks
	private PriceAspect aspect;
	@Mock
	private ProceedingJoinPoint joinPoint;
	@Mock
	private MethodSignature signature;

	@Before
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		when(this.joinPoint.getSignature()).thenReturn(this.signature);
	}

	@Test(expected = ValidateException.class)
	public void testPriceNullRequest() throws Throwable {
		this.aspect.price(this.joinPoint, null);
	}

	@Test(expected = ValidateException.class)
	public void testPriceNullBrandAndProduct() throws Throwable {
		this.aspect.price(this.joinPoint, new ApiRQ());
	}

	@Test(expected = ValidateException.class)
	public void testPriceNullDate() throws Throwable {
		ApiRQ request = new ApiRQ();
		request.setBrand(1);
		request.setProduct(35455L);
		this.aspect.price(this.joinPoint, request);
	}

	@Test(expected = ValidateException.class)
	public void testPriceNullTime() throws Throwable {
		ApiRQ request = new ApiRQ();
		request.setBrand(1);
		request.setProduct(35455L);
		request.setFrom("date");
		this.aspect.price(this.joinPoint, request);
	}

	@Test
	public void testPrice() throws Throwable {
		ApiRQ request = new ApiRQ();
		request.setBrand(1);
		request.setProduct(35455L);
		request.setFrom("date");
		request.setTime("hour");
		when(this.joinPoint.proceed()).thenReturn("OK");
		assertNotNull(this.aspect.price(this.joinPoint, request));
	}
}