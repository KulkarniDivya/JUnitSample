package com.capgemini.sample;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculationExTest {
	
	static CalculationEx calculationEx;
	@BeforeAll
	public static void init() {
		calculationEx = new CalculationEx();
	}
	
	@Test
	void testAdd() {
		assertEquals(9, calculationEx.add(4, 5));
	}
	
	@Test
	void testAdd1() {
		assertEquals(11, calculationEx.add(4, 7));
	}
	
	@Test
	void testSub() {
		assertEquals(2, calculationEx.sub(5, 3));
	}
	
	@Test
	void testMul() {
		assertEquals(30, calculationEx.mul(6, 5));
	}

	@Test
	void testMul1() {
		assertEquals(25, calculationEx.mul(5, 5));
	}
}
