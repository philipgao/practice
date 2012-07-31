package com.ssparrow.algorithm.dp;

import static org.junit.Assert.*;

import org.junit.Test;


public class DPUtilTest {

	@Test
	public void testMatrixChain() {
		Matrix[] matrixs=new Matrix[]{
			new Matrix(new int[30][35]),
			new Matrix(new int[35][15]),
			new Matrix(new int[15][5]),
			new Matrix(new int[5][10]),
			new Matrix(new int[10][20]),
			new Matrix(new int[20][25]),
		};
		
		int[][] s = DPUtil.findOptimalMatrixChain(matrixs);
		
		StringBuffer sb=new StringBuffer();
		DPUtil.printMatrixChain(sb, s, 0, matrixs.length-1);
		assertEquals("((A[0](A[1]A[2]))((A[3]A[4])A[5]))", sb.toString());
	}
	
	@Test
	public void testFindLongestCommonSubsequence(){
		String str1="AGCAT";
		String str2="GAC";
		
		char[][][] map = new char[str1.length()+1][str2.length()+1][];
		char[] lcs = DPUtil.findLongestCommonSubsequence(map, str1.toCharArray(), str1.length(), str2.toCharArray(), str2.length());
		assertEquals("AC", new String(lcs));

		str1="CACAATTCCCATGGGTTGTGGAG";
		str2="GAGGTGTTGGGTACCCTTAACAC";map = new char[str1.length()+1][str2.length()+1][];
		lcs = DPUtil.findLongestCommonSubsequence(map, str1.toCharArray(), str1.length(), str2.toCharArray(), str2.length());
		assertEquals("ATTTGGGTTTA", new String(lcs));
	}
	
	@Test
	public void testFindLongestIncreasingSubsequence(){
		int [] array=new int[]{1,3,5,2,7};
		int [][] result=new int[array.length][];
		int[] lis = DPUtil.findLongestIncreasingSubsequence(result, array, array.length-1);
		assertArrayEquals(new int[]{1,3,5,7}, lis);
		
		
		array=new int[]{1,7,5,2,10,3,8,9};
		result=new int[array.length][];
		lis = DPUtil.findLongestIncreasingSubsequence(result, array, array.length-1);
		assertArrayEquals(new int[]{1,2,3,8,9}, lis);
		
//		array = new int []{1, 11, 2, 10, 4, 5, 2, 1};
//		result=new int[array.length][];
//		lis = DPUtil.findLongestIncreasingSubsequence(result, array, array.length-1);
//		assertArrayEquals(new int[]{1,2,4,5}, lis);
	}

	
//	@Test
//	public void testFindLongestIncreasingSubsequenceWithoutRecursion(){
//		int [] array=new int[]{1,3,5,2,7};
//		int [][] result=new int[array.length][];
//		int[] lis = DPUtil.findLongestIncreasingSubsequenceWithoutRecursion(array);
//		assertArrayEquals(new int[]{1,3,5,7}, lis);
//		
//		
//		array=new int[]{1,7,5,2,10,3,8,9};
//		result=new int[array.length][];
//		lis = DPUtil.findLongestIncreasingSubsequenceWithoutRecursion(array);
//		assertArrayEquals(new int[]{1,2,3,8,9}, lis);
//	}
	
	@Test
	public void testFindlongestDecreasingSubsequence(){
		int [] array =new int[]{12, 11, 40, 5, 3, 1};
		
		int [][] result =new int[array.length][];
		int [] lds= DPUtil.findlongestDecreasingSubsequence(result, array, 0);
		
		assertArrayEquals(new int []{12, 11, 5, 3, 1}, lds);
	}
	
	@Test
	public void testFindLongestBitonicSubsequence(){
//		int [] array = new int []{1, 11, 2, 10, 4, 5, 2, 1};
//		assertArrayEquals(new int []{1, 2, 10, 4, 2, 1}, DPUtil.findLongestBitonicSubsequence(array));
//		
//		array = new int []{12, 11, 40, 5, 3, 1};
//		assertArrayEquals(new int []{12, 11, 5, 3, 1}, DPUtil.findLongestBitonicSubsequence(array));
//		
//		array = new int []{80, 60, 30, 40, 20, 10};
//		assertArrayEquals(new int []{80, 60, 30, 20, 10}, DPUtil.findLongestBitonicSubsequence(array));
	}
}
