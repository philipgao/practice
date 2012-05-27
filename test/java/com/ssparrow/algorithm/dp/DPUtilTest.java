package com.ssparrow.algorithm.dp;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ssparrow.afi.ch05string.Ch05StringUtil;

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

}
