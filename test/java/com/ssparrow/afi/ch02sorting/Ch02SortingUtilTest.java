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

	@Test
	public void testP209RemoveDuplicateItems(){
		int [] array = new int[]{0,1,2,3,4,5,6,7};
		assertArrayEquals(new int[]{0,1,2,3,4,5,6,7}, Ch02SortingUtil.p209RemoveDuplicateItems(array));
		
		array = new int[]{1,1,2,2,2,3,4,5,6,6,7,10,10};
		assertArrayEquals(new int[]{1,2,3,4,5,6,7,10}, Ch02SortingUtil.p209RemoveDuplicateItems(array));
	}
}
