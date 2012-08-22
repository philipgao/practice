package com.ssparrow.algorithm.misc;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class AlgorUtilTest {

	@Test
	public void testSwap() {
		Pair pair = AlgorUtil.swap(36, 79);
		assertEquals(79, pair.getA());
		assertEquals(36, pair.getB());
	}
	
	@Test
	public void testNumberOfZeros(){
		assertEquals(0, AlgorUtil.findNumerOfZeros(1));

		assertEquals(1, AlgorUtil.findNumerOfZeros(5));

		assertEquals(2, AlgorUtil.findNumerOfZeros(10));

		assertEquals(24, AlgorUtil.findNumerOfZeros(100));
	}
	
	@Test
	public void testAddTwoNumbers(){
		assertEquals(0, AlgorUtil.addTwoNumbers(0, 0));

		assertEquals(1, AlgorUtil.addTwoNumbers(0, 1));

		assertEquals(1, AlgorUtil.addTwoNumbers(1, 0));

		assertEquals(1181, AlgorUtil.addTwoNumbers(385	, 796));
	}
	
	@Test
	public void testShuffleCards(){
		int [] cards=new int[52];
		for(int index=0;index<52;index++){
			cards[index]=index+1;
		}
		
		AlgorUtil.shuffleCards(cards);
	}
	
	@Test
	public void testCount2InRange(){
		assertEquals(0, AlgorUtil.count2InRange(0));

		assertEquals(0, AlgorUtil.count2InRange(1));

		assertEquals(1, AlgorUtil.count2InRange(2));

		assertEquals(15, AlgorUtil.count2InRange(50));
	}
	
	@Test
	public void testPower(){
		System.out.println(AlgorUtil.power(1.1, 3));
	}
	
	@Test
	public void testFindAllPrimeNumber(){
		int [] expected =new int []{2, 3, 5, 7};
		
		assertArrayEquals(expected, AlgorUtil.findAllPrimeNumber(10));
		
		expected =new int []{2, 3, 5, 7, 11};
		
		assertArrayEquals(expected, AlgorUtil.findAllPrimeNumber(11));
		
		expected =new int []{2, 3, 5, 7, 11, 13, 17, 19};
		
		assertArrayEquals(expected, AlgorUtil.findAllPrimeNumber(20));
	}
	
	@Test
	public void testFindAllDominatePairs(){
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(1, 1));
		points.add(new Point(2, 1));
		points.add(new Point(2, 0));
		points.add(new Point(2, 2));
		points.add(new Point(3, 2));
		points.add(new Point(3, 3));
		
		Set<PointPair> dominatePairs = AlgorUtil.findAllDominatePairs(points);
		assertEquals(8, dominatePairs.size());
	}
	
	@Test
	public void testGetSquareRoot(){
		assertEquals(0.5, AlgorUtil.getSquareRoot(0.25, 8, 0.000001), 0.000001);

		assertEquals(0.6, AlgorUtil.getSquareRoot(0.36, 8, 0.000001), 0.000001);
		
		assertEquals(0.83666, AlgorUtil.getSquareRoot(0.7, 8, 0.000001), 0.000001);

		assertEquals(0.948683, AlgorUtil.getSquareRoot(0.9, 8, 0.000001), 0.000001);
		
		assertEquals(1.1, AlgorUtil.getSquareRoot(1.21, 8, 0.000001), 0.000001);

		assertEquals(2.64575148, AlgorUtil.getSquareRoot(7, 8, 0.000001), 0.000001);

		assertEquals(3, AlgorUtil.getSquareRoot(9, 8, 0.000001), 0.000001);
		
		assertEquals(10.04987565, AlgorUtil.getSquareRoot(101, 8, 0.000001), 0.000001);
	}
}
