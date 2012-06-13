package com.ssparrow.algorithm.recursion;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;

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
	
	@Test
	public void testFindAllSubset(){
		ArrayList<String> set=new ArrayList<String>();
		set.add("philip");
		set.add("jamie");
		set.add("taotao");
		
		LinkedList<ArrayList<String>> allSubsets = RecursionUtil.findAllSubset(set, 0);
		assertEquals(8, allSubsets.size());
	}

	
	@Test
	public void testMakeChanges(){
		assertEquals(242, RecursionUtil.makeChanges(100, 25));	
	}

	@Test
	public void testPlaceQueen(){
		RecursionUtil.placeQueen(new int[8], 0);
	}
	
}
