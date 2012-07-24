package com.ssparrow.algorithm.array;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ssparrow.algorithm.misc.Pair;

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
	
	@Test
	public void testSearchInRotatedArray(){
		int[] array=new int[]{50,5,20,30,40};
		
		assertEquals(-1, ArrayUtil.searchInRtatedArray(array, 25));
		assertEquals(-1, ArrayUtil.searchInRotatedArrayOptimized(array, 25));
		
		assertEquals(2, ArrayUtil.searchInRtatedArray(array, 20));
		assertEquals(2, ArrayUtil.searchInRotatedArrayOptimized(array, 20));
		
		array=new int[]{30,45,50,5,2,6,10,20};
		assertEquals(5, ArrayUtil.searchInRtatedArray(array, 6));
		assertEquals(5, ArrayUtil.searchInRotatedArrayOptimized(array, 6));

		assertEquals(1, ArrayUtil.searchInRtatedArray(array, 45));
		assertEquals(1, ArrayUtil.searchInRotatedArrayOptimized(array, 45));
		
	}
	
	@Test
	public void testSearchInSortedMatrix(){
		int[][] matrix = new int[][]{
				{15,20,70,85},
				{20,35,80,95},
				{30,55,95,105},
				{40,80,120,120}
		};
		
		assertNull(ArrayUtil.searchInSortedMatrix(matrix, 100, 0,3	, 0, 3));
		
		Pair result=ArrayUtil.searchInSortedMatrix(matrix, 85, 0,3	, 0, 3);
		assertNotNull(result);
		assertEquals(0, result.getA());
		assertEquals(3, result.getB());
	}

	@Test
	public void testFindLongestDistance(){

	        int [] array = new int []{4,3,5,2,1,3,2,3};
	        assertEquals(4, ArrayUtil.findLongestDistance(array));
	        
	        array = new int []{4,3,5,2,1,3,2,4};
	        assertEquals(6, ArrayUtil.findLongestDistance(array));
	        
	        array = new int []{4,3,5,2,1,3,2,6};
	        assertEquals(7, ArrayUtil.findLongestDistance(array));
	    
	}
	
	@Test
	public void testFindMaxSum(){
		int [] array=new int[]{1,2, -2,0,-1, 3, -2, 4, 6,-5,10};
		assertEquals(new Pair(5, 10), ArrayUtil.findMaxSum(array));
		
		array=new int[]{1,2, -2,0,-1, 3, -2, 4, 6,-5,-5};
		assertEquals(new Pair(5, 8), ArrayUtil.findMaxSum(array));

		array=new int[]{1,2, -1,0,-1, 3, -2, 4, 6,-5,10};
		assertEquals(new Pair(0, 10), ArrayUtil.findMaxSum(array));
	}
	
	@Test
	public void testMultiplyNumbersInArray(){
		int [] input=new int[]{4, 3, 2, 1, 2};
		int [] output=new int[]{12, 16, 24, 48, 24};
		
		assertArrayEquals(output, ArrayUtil.multiplyNumbersInArray(input));
		

		assertArrayEquals(output, ArrayUtil.multiplyNumbersInArrayWithNoExtraSpace(input));
	}
	
	@Test
	public void testSetZeroForWholeRowAndColumn(){
		int[][] matrix=new int[][]{
				{ 1, 0, 3, 4, 5},
				{11,12,13,14,15},
				{21,22,23,0,25},
				{31,32,33,34,35},
				{0,42,43,44,45}
			};

		int[][] result=new int[][]{
			{0, 0, 0, 0, 0},
			{0, 0,13,0,15},
			{0, 0, 0, 0, 0},
			{0, 0,33,0,35},
			{0, 0, 0, 0, 0}
		};
		
		ArrayUtil.setZeroForWholeRowAndColumn(matrix);
		assertArrayEquals(result, matrix);
	}
	
	@Test
	public void testFindConsecutiveSubarrayWithSum(){
		int [] array = new int []{1,6,3,3,1,2,3,};
		
		int [] result = ArrayUtil.findConsecutiveSubarrayWithSum(array, 5);
		assertArrayEquals(new int [] {2, 3}, result);
		
		array = new int []{1,7,3,4,1,2,2,3,1};
		
		result = ArrayUtil.findConsecutiveSubarrayWithSum(array, 6);
		assertArrayEquals(new int [] {2, 3, 1}, result);
		
	}
	
	@Test
	public void testPushZerosToEnd(){
		int [] array = new int [] {1,2,0,4,0,0,8};
		
		ArrayUtil.pushZerosToEnd(array);
		assertArrayEquals(new int []{1,2,4,8,0,0,0}, array);
	}
	
	@Test
	public void testFindMaxSumSubarray(){
		int [] array=new int[]{1,2, -2,0,-1, 3, -2, 4, 6,-5,10};
		assertArrayEquals(new int[]{ 3, -2, 4, 6,-5,10}, ArrayUtil.findMaxSumSubarray(array));
		
		array=new int[]{1,2, -2,0,-1, 3, -2, 4, 6,-5,-5};
		assertArrayEquals(new int[]{ 3, -2, 4, 6}, ArrayUtil.findMaxSumSubarray(array));

		array=new int[]{1,2, -1,0,-1, 3, -2, 4, 6,-5,10};
		assertArrayEquals(new int[]{1,2, -1,0,-1, 3, -2, 4, 6,-5,10}, ArrayUtil.findMaxSumSubarray(array));
	}
	
	@Test
	public void testIsArrayPartitionable(){
		int [] array = new int [] {1, 5, 11, 5};
		assertTrue(ArrayUtil.isArrayPartitionable(array));
		
		array = new int [] {1, 5, 3};
		assertFalse(ArrayUtil.isArrayPartitionable(array));
		
		array = new int [] {1, -5, 11, 5, 12};
		assertTrue(ArrayUtil.isArrayPartitionable(array));
	}
}
