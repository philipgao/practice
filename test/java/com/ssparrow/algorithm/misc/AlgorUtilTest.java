package com.ssparrow.algorithm.misc;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ssparrow.algorithm.misc.AlgorUtil.Pair;

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

}
