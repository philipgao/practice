package com.ssparrow.algorithm.array;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayUtilTest {

	@Test
	public void testArraySort() {
		int[] array=new int[]{6,5,4,3,2};
		ArrayUtil.quickSort(array, 0, array.length-1);
		assertArrayEquals(new int[]{2,3,4,5,6}, array);
		
		array=new int[]{6,5,4,3,2};
		ArrayUtil.insertSort(array);
		assertArrayEquals(new int[]{2,3,4,5,6}, array);
		
		array=new int[]{6,5,4,3,2};
		ArrayUtil.mergeSort(array, 0, array.length-1);
		assertArrayEquals(new int[]{2,3,4,5,6}, array);
		
		array=new int[]{6,5,4,3,2};
		ArrayUtil.heapSort(array);
		assertArrayEquals(new int[]{2,3,4,5,6}, array);
	}
	
	@Test
	public void testRotateMatrix(){
		int[][] matrix=new int[][]{
			{ 1, 2, 3, 4, 5},
			{11,12,13,14,15},
			{21,22,23,24,25},
			{31,32,33,34,35},
			{42,42,43,44,45}
		};
		
		ArrayUtil.rotateMatrix(matrix, 5);
		int[][] result=new int[][]{
				{42,31,21,11, 1},
				{42,32,22,12, 2},
				{43,33,23,13, 3},
				{44,34,24,14, 4},
				{45,35,25,15, 5}
			};
		assertArrayEquals(result, matrix);
	}

	@Test
	public void testConvertArrayToMatrix(){
	    int[] array=new int[]{1,2,3,4,5};    

	    int[][] matrix=new int[][]{
	    		{1},
	    		{2},
	    		{3},
	    		{4},
	    		{5}
	    };
	    int[][] result = ArrayUtil.convertArrayToMatrix(array, 1);
	    assertArrayEquals(matrix, result);
	    
	    matrix=new int[][]{
	    		{1,4},
	    		{2,5},
	    		{3,0}
	    };
	    result = ArrayUtil.convertArrayToMatrix(array, 2);
	    assertArrayEquals(matrix, result);
	    
	    matrix=new int[][]{
	    		{1,2,4},
	    		{0,3,5}
	    };
	    result = ArrayUtil.convertArrayToMatrix(array, 3);
	    assertArrayEquals(matrix, result);
	    
	    matrix=new int[][]{
	    		{1,3,4,5},
	    		{2,0,0,0}
	    };
	    result = ArrayUtil.convertArrayToMatrix(array, 4);
	    assertArrayEquals(matrix, result);
	}
}
