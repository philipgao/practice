package com.ssparrow.afi.ch02sorting;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ssparrow.algorithm.misc.Pair;


public class Ch02SortingUtilTest {

	@Test
	public void testP204FindMinMax() {
		int [] array=new int[]{2,3,3,7,10,12,16,30,50,100};
		assertEquals(new Pair(2, 100), Ch02SortingUtil.p204FindMinMax(array));
	}

}
