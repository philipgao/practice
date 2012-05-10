package com.ssparrow.algorithm.heap;

import static org.junit.Assert.*;

import org.junit.Test;

public class HeapSorterTest {

	@Test
	public void test() {
		int [] array=new int[]{6,5,4,3,2};
		int [] result=new int[]{2,3,4,5,6};
		assertArrayEquals(result, HeapSorter.sortWithMaxHeap(array));
		
		
		array=new int[]{6,5,4,3,2};
		result=new int[]{2,3,4,5,6};
		assertArrayEquals(result, HeapSorter.sortWithMinHeap(array));
	}

}
