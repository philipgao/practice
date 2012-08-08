package com.ssparrow.projecteuler;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProjectEulerTest {

	@Test
	public void testP001Find3or5MultipleSum() {
		assertEquals(0, ProjectEuler.p001Find3or5MultipleSum(0));

		assertEquals(0, ProjectEuler.p001Find3or5MultipleSum(1));

		assertEquals(0, ProjectEuler.p001Find3or5MultipleSum(2));

		assertEquals(0, ProjectEuler.p001Find3or5MultipleSum(3));

		assertEquals(3, ProjectEuler.p001Find3or5MultipleSum(4));

		assertEquals(8, ProjectEuler.p001Find3or5MultipleSum(6));

		assertEquals(23, ProjectEuler.p001Find3or5MultipleSum(10));
		
		//3 5 6 9 10 12 15 18
		assertEquals(78, ProjectEuler.p001Find3or5MultipleSum(20));
		
		assertEquals(233168, ProjectEuler.p001Find3or5MultipleSum(1000));
	}
	
	
	@Test
	public void testP002FindEvenFibonacciNumberSum(){
		assertEquals(0, ProjectEuler.p002FindEvenFibonacciNumberSum(0));

		assertEquals(0, ProjectEuler.p002FindEvenFibonacciNumberSum(1));

		assertEquals(2, ProjectEuler.p002FindEvenFibonacciNumberSum(2));

		assertEquals(2, ProjectEuler.p002FindEvenFibonacciNumberSum(3));

		assertEquals(2, ProjectEuler.p002FindEvenFibonacciNumberSum(5));

		assertEquals(10, ProjectEuler.p002FindEvenFibonacciNumberSum(10));

		assertEquals(44, ProjectEuler.p002FindEvenFibonacciNumberSum(100));

		assertEquals(4613732, ProjectEuler.p002FindEvenFibonacciNumberSum(4000000));
	}

}
