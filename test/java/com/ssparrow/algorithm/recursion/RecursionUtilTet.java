package com.ssparrow.algorithm.recursion;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class RecursionUtilTet {

	@Test
	public void testFindMagicIndex() {
		int[] array=new int[]{-30, -20, 0,2,3,5,8,15,20,21,22};
		assertEquals(5, RecursionUtil.findMagicIndex(array, 0, array.length-1));
		assertEquals(5, RecursionUtil.findMagicIndexWIthDuplicate(array, 0, array.length-1));
		
		array=new int[]{-30, -20, 0,2,5,6,8,15,20,21,22};
		assertEquals(-1, RecursionUtil.findMagicIndex(array, 0, array.length-1));
		assertEquals(-1, RecursionUtil.findMagicIndexWIthDuplicate(array, 0, array.length-1));
		
		array=new int[]{-10,-5,2,2,2,3,4,7,9,12,13};
		assertEquals(2, RecursionUtil.findMagicIndexWIthDuplicate(array, 0, array.length-1));
	}
	
	@Test
	public void testGenerateParen(){
		String[] result=new String[]{"((()))", "(()())", "(())()", "()(())", "()()()"};
		assertArrayEquals(result, RecursionUtil.generateparen(3).toArray());
	}

}
