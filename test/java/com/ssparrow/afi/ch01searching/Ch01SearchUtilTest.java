package com.ssparrow.afi.ch01searching;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ssparrow.afi.ch01searching.Ch01SearchUtil;

public class Ch01SearchUtilTest {

	@Test
	public void testP101FindSquareRoot() {
		int squreRoot=Ch01SearchUtil.p101FindSquareRoot(0);
		assertEquals(0, squreRoot);

		squreRoot=Ch01SearchUtil.p101FindSquareRoot(1);
		assertEquals(1, squreRoot);
		
		squreRoot=Ch01SearchUtil.p101FindSquareRoot(3);
		assertEquals(-1, squreRoot);
		
		squreRoot=Ch01SearchUtil.p101FindSquareRoot(4);
		assertEquals(2, squreRoot);
		
		squreRoot=Ch01SearchUtil.p101FindSquareRoot(121);
		assertEquals(11, squreRoot);
		
	}

	@Test
	public void testP101FindSquareRootFloor() {
		int squreRoot=Ch01SearchUtil.p101FindSquareRootFloor(0);
		assertEquals(0, squreRoot);

		squreRoot=Ch01SearchUtil.p101FindSquareRootFloor(1);
		assertEquals(1, squreRoot);
		
		squreRoot=Ch01SearchUtil.p101FindSquareRootFloor(3);
		assertEquals(1, squreRoot);
		
		squreRoot=Ch01SearchUtil.p101FindSquareRootFloor(4);
		assertEquals(2, squreRoot);
		
		squreRoot=Ch01SearchUtil.p101FindSquareRootFloor(5);
		assertEquals(2, squreRoot);
		
		squreRoot=Ch01SearchUtil.p101FindSquareRootFloor(121);
		assertEquals(11, squreRoot);
		
		squreRoot=Ch01SearchUtil.p101FindSquareRootFloor(125);
		assertEquals(11, squreRoot);
		
	}
	
	@Test
	public void testP102BinarySearch(){
		int [] array=new int[]{2,3,5,7,10,12,16,30,50,100};
		
		assertEquals(-1, Ch01SearchUtil.p102BinarySearch(array, 0));

		assertEquals(0, Ch01SearchUtil.p102BinarySearch(array, 2));

		assertEquals(-1, Ch01SearchUtil.p102BinarySearch(array, 6));

		assertEquals(5, Ch01SearchUtil.p102BinarySearch(array, 12));

		assertEquals(9, Ch01SearchUtil.p102BinarySearch(array, 100));
	}
	
	@Test
	public void testP103FindNumberCeling(){
		int [] array=new int[]{2,3,5,7,10,12,16,30,50,100};
		
		assertEquals(0, Ch01SearchUtil.p103FindNumberCeling(array, 0));

		assertEquals(0, Ch01SearchUtil.p103FindNumberCeling(array, 1));

		assertEquals(3, Ch01SearchUtil.p103FindNumberCeling(array, 5));

		assertEquals(4, Ch01SearchUtil.p103FindNumberCeling(array, 8));
		
		assertEquals(9, Ch01SearchUtil.p103FindNumberCeling(array, 60));
		
		assertEquals(-1, Ch01SearchUtil.p103FindNumberCeling(array, 100));
		
		assertEquals(-1, Ch01SearchUtil.p103FindNumberCeling(array, 100));
	}
	
	@Test
	public void testP104FindMagicIndexWithDuplicate(){
		int [] array=new int []{-3,-1,0,1,3,5,7,9,11,20,30,40,50};
		
		assertEquals(5, Ch01SearchUtil.p104FindMagicIndexWithDuplicate(array, 0, array.length-1));
		
		array=new int []{-3,-1,0,1,3,6,7,9,11,20,30,40,50};
		
		assertEquals(-1, Ch01SearchUtil.p104FindMagicIndexWithDuplicate(array, 0, array.length-1));
		
		array=new int []{0,-1,0,1,3,6,7,9,11,20,30,40,50};
		
		assertEquals(0, Ch01SearchUtil.p104FindMagicIndexWithDuplicate(array, 0, array.length-1));
		

		array=new int []{-10,1,1,1,3,3,5,7,9,11,20,20,20,20};
		
		assertEquals(1, Ch01SearchUtil.p104FindMagicIndexWithDuplicate(array, 0, array.length-1));
	}

}
