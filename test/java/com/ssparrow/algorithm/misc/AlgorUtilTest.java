package com.ssparrow.algorithm.misc;

import static org.junit.Assert.*;

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
}
