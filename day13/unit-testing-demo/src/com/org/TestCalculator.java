package com.org;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCalculator {

	private Calculator calculator;
	
	@Before
	public void setup() {
		System.out.println("setup() is executed");
		calculator = new Calculator();
	}
	
	@Test
	public void test_AddMethod() {
		System.out.println("test_AddMethod is executed");
		int result = calculator.add(20, 30);
		assertEquals(50, result);
	}
	
	@Test
	public void test_SubMethod() {
		System.out.println("test_SubMethod is executed");
		int result = calculator.sub(30, 20);
		assertEquals(10, result);
	}
	
	@After
	public void tearDown() {
		System.out.println("tearDown() is executed");
		calculator = null;
	}
	
}
