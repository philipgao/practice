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
		int squreRoot=Ch01SearchUtil.p101FIndSquareRootFloor(0);
		assertEquals(0, squreRoot);

		squreRoot=Ch01SearchUtil.p101FIndSquareRootFloor(1);
		assertEquals(1, squreRoot);
		
		squreRoot=Ch01SearchUtil.p101FIndSquareRootFloor(3);
		assertEquals(1, squreRoot);
		
		squreRoot=Ch01SearchUtil.p101FIndSquareRootFloor(4);
		assertEquals(2, squreRoot);
		
		squreRoot=Ch01SearchUtil.p101FIndSquareRootFloor(5);
		assertEquals(2, squreRoot);
		
		squreRoot=Ch01SearchUtil.p101FIndSquareRootFloor(121);
		assertEquals(11, squreRoot);
		
		squreRoot=Ch01SearchUtil.p101FIndSquareRootFloor(125);
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

}
