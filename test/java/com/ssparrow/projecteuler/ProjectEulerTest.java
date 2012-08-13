package com.ssparrow.projecteuler;

import static org.junit.Assert.*;

import java.math.BigInteger;

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
	
	
	@Test
	public void testP003FindLargestPrimeFactor(){
		assertEquals(BigInteger.valueOf(1), ProjectEuler.p003FindLargestPrimeFactor(BigInteger.valueOf(1)));

		assertEquals(BigInteger.valueOf(2), ProjectEuler.p003FindLargestPrimeFactor(BigInteger.valueOf(2)));

		assertEquals(BigInteger.valueOf(3), ProjectEuler.p003FindLargestPrimeFactor(BigInteger.valueOf(3)));

		assertEquals(BigInteger.valueOf(2), ProjectEuler.p003FindLargestPrimeFactor(BigInteger.valueOf(4)));

		assertEquals(BigInteger.valueOf(5), ProjectEuler.p003FindLargestPrimeFactor(BigInteger.valueOf(5)));

		assertEquals(BigInteger.valueOf(5), ProjectEuler.p003FindLargestPrimeFactor(BigInteger.valueOf(10)));

		assertEquals(BigInteger.valueOf(5), ProjectEuler.p003FindLargestPrimeFactor(BigInteger.valueOf(15)));

		assertEquals(BigInteger.valueOf(2), ProjectEuler.p003FindLargestPrimeFactor(BigInteger.valueOf(16)));

		assertEquals(BigInteger.valueOf(17), ProjectEuler.p003FindLargestPrimeFactor(BigInteger.valueOf(17)));

		assertEquals(BigInteger.valueOf(5), ProjectEuler.p003FindLargestPrimeFactor(BigInteger.valueOf(20)));
		
		assertEquals(BigInteger.valueOf(11), ProjectEuler.p003FindLargestPrimeFactor(BigInteger.valueOf(22)));

		assertEquals(BigInteger.valueOf(6857), ProjectEuler.p003FindLargestPrimeFactor(new BigInteger("600851475143",10)));
	}

	@Test
	public void testP004FindLargestPalindromicNumber(){
		assertTrue(ProjectEuler.isPalindrome(101));

		assertTrue(ProjectEuler.isPalindrome(111));

		assertTrue(ProjectEuler.isPalindrome(1001));

		assertFalse(ProjectEuler.isPalindrome(1011));
		
		assertTrue(ProjectEuler.isPalindrome(11211));
		
		assertEquals(906609, ProjectEuler.p004FindLargestPalindromicNumber());
	}
	
	@Test
	public void testP005FindSmallestDivisibleBy1ToN(){
		
		assertEquals(1, ProjectEuler.p005FindSmallestDivisibleBy1ToN(1));
		
		assertEquals(2, ProjectEuler.p005FindSmallestDivisibleBy1ToN(2));

		assertEquals(6, ProjectEuler.p005FindSmallestDivisibleBy1ToN(3));
		
		assertEquals(2520, ProjectEuler.p005FindSmallestDivisibleBy1ToN(10));
		
		assertEquals(232792560, ProjectEuler.p005FindSmallestDivisibleBy1ToN(20));
	}
	
	@Test
	public void testP006FindDiffSumSquareAndSquareSum(){
		assertEquals(0, ProjectEuler.p006FindDiffSumSquareAndSquareSum(1));
		
		assertEquals(4, ProjectEuler.p006FindDiffSumSquareAndSquareSum(2));

		assertEquals(2640, ProjectEuler.p006FindDiffSumSquareAndSquareSum(10));

		assertEquals(25164150, ProjectEuler.p006FindDiffSumSquareAndSquareSum(100));
	}
	
	@Test
	public void testP007FindNthPrimeNumber(){
		assertEquals(2, ProjectEuler.p007FindNthPrimeNumber(1));
		
		assertEquals(3, ProjectEuler.p007FindNthPrimeNumber(2));
		
		assertEquals(5, ProjectEuler.p007FindNthPrimeNumber(3));
		
		assertEquals(7, ProjectEuler.p007FindNthPrimeNumber(4));
		
		assertEquals(11, ProjectEuler.p007FindNthPrimeNumber(5));
		
		assertEquals(104743, ProjectEuler.p007FindNthPrimeNumber(10001));
	}
}
