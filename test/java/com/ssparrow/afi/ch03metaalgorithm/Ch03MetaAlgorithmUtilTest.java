package com.ssparrow.afi.ch03metaalgorithm;

import static org.junit.Assert.*;

import org.junit.Test;

public class Ch03MetaAlgorithmUtilTest {

	@Test
	public void testP301FindLongestNondecreasingSubsequence() {
		int [] array=new int[]{1,3,5,2,7};
		int [][] result=new int[array.length][];
		int[] lns = Ch03MetaAlgorithmUtil.p301FindLongestNondecreasingSubsequence(result, array, array.length-1);
		assertArrayEquals(new int[]{1,3,5,7}, lns);
		
		
		array=new int[]{1,7,5,2,10,3,8,9};
		result=new int[array.length][];
		lns = Ch03MetaAlgorithmUtil.p301FindLongestNondecreasingSubsequence(result, array, array.length-1);
		assertArrayEquals(new int[]{1,2,3,8,9}, lns);
	}
	
	@Test
	public void testP302CanFrogCrossRiver(){
		boolean [] stones = new boolean[]{false,true,false,true,false,false,true,false,false,false};
		assertTrue(Ch03MetaAlgorithmUtil.p302CanFrogCrossRiver(stones));
		
		stones = new boolean[]{false,true,false,true,false,false,true,false,false,false,false};
		assertFalse(Ch03MetaAlgorithmUtil.p302CanFrogCrossRiver(stones));
	}

}
