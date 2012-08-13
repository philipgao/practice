package com.ssparrow.projecteuler;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

import com.ssparrow.algorithm.array.Triplet;

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
	
	@Test
	public void testP008FindLargest5DigitProduct(){
		String input="73167176531330624919225119674426574742355349194934"+
				"96983520312774506326239578318016984801869478851843"+
				"85861560789112949495459501737958331952853208805511"+
				"12540698747158523863050715693290963295227443043557"+
				"66896648950445244523161731856403098711121722383113"+
				"62229893423380308135336276614282806444486645238749"+
				"30358907296290491560440772390713810515859307960866"+
				"70172427121883998797908792274921901699720888093776"+
				"65727333001053367881220235421809751254540594752243"+
				"52584907711670556013604839586446706324415722155397"+
				"53697817977846174064955149290862569321978468622482"+
				"83972241375657056057490261407972968652414535100474"+
				"82166370484403199890008895243450658541227588666881"+
				"16427171479924442928230863465674813919123162824586"+
				"17866458359124566529476545682848912883142607690042"+
				"24219022671055626321111109370544217506941658960408"+
				"07198403850962455444362981230987879927244284909188"+
				"84580156166097919133875499200524063689912560717606"+
				"05886116467109405077541002256983155200055935729725"+
				"71636269561882670428252483600823257530420752963450";
		assertEquals(40824, ProjectEuler.p008FindLargest5DigitProduct(input));
	}
	
	@Test
	public void testP009FindTheLargestPythagorean(){
		assertEquals(new Triplet(3,4,5), ProjectEuler.p009FindTheLargestPythagorean(12));
		

		assertEquals(new Triplet(200,375,425), ProjectEuler.p009FindTheLargestPythagorean(1000));
	}
	
	@Test
	public void testP010FindProductOfPrimeBelowN(){
		assertEquals(BigInteger.valueOf(2), ProjectEuler.p010FindSumOfPrimeBelowN(2));

		assertEquals(BigInteger.valueOf(5), ProjectEuler.p010FindSumOfPrimeBelowN(3));
		
		assertEquals(BigInteger.valueOf(5), ProjectEuler.p010FindSumOfPrimeBelowN(4));

		assertEquals(BigInteger.valueOf(10), ProjectEuler.p010FindSumOfPrimeBelowN(5));

		assertEquals(BigInteger.valueOf(77), ProjectEuler.p010FindSumOfPrimeBelowN(20));
		
		assertEquals(BigInteger.valueOf(21171191), ProjectEuler.p010FindSumOfPrimeBelowN(20000));

		assertEquals(new BigInteger("142913828922",10), ProjectEuler.p010FindSumOfPrimeBelowN(2000000));
	}
}
