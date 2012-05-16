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

}
