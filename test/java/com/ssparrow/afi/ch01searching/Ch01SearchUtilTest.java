package com.ssparrow.afi.ch01searching;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.ssparrow.afi.ch01searching.Ch01SearchUtil;
import com.ssparrow.algorithm.misc.Pair;

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
	
	@Test
	public void testP105SearchInUnkownLengthArray(){
		int [] array=new int[]{2,3,3,7,10,12,16,30,50,100};
		
		assertEquals(-1, Ch01SearchUtil.p105SearchInUnkownLengthArray(array, 0));

		assertEquals(-1, Ch01SearchUtil.p105SearchInUnkownLengthArray(array, 1));

		assertEquals(0, Ch01SearchUtil.p105SearchInUnkownLengthArray(array, 2));

		assertEquals(1, Ch01SearchUtil.p105SearchInUnkownLengthArray(array, 3));

		assertEquals(-1, Ch01SearchUtil.p105SearchInUnkownLengthArray(array, 6));

		assertEquals(5, Ch01SearchUtil.p105SearchInUnkownLengthArray(array, 12));

		assertEquals(9, Ch01SearchUtil.p105SearchInUnkownLengthArray(array, 100));
		
		array=new int[]{2,4,5,7,10,12,16,30,50,100};
		assertEquals(-1, Ch01SearchUtil.p105SearchInUnkownLengthArray(array, 3));
	}
	
	@Test
	public void testP107FindArraysIntersection(){
		int [] array1=new int[]{2,3,3,7,10,12,16,30,50,100};
		int [] array2=new int[]{0,0,1,2,3,3,3,5,6,12,17,19,20,30,40,45,50,100,120,200};
		
		int [] expected=new int []{2,3,12,30,50,100}; 
		int[] intersection = Ch01SearchUtil.p107FindArraysIntersection(array1, array2);
		assertArrayEquals(expected, intersection);

		array1=new int[]{0,0,1,2,3,3,3,5,6,12,17,19,20,30,40,45,50,100,120,200};
		array2=new int[]{2,3,3,7,10,12,16,30,50,100};
		
		intersection = Ch01SearchUtil.p107FindArraysIntersection(array1, array2);
		assertArrayEquals(expected, intersection);

		array1=new int[]{0,0,1,2,3,3,3,5,6,6};
		array2=new int[]{0,0,1,2,3,3,3,5,6,6};
		
		expected=new int []{0,1,2,3,5,6}; 
		intersection = Ch01SearchUtil.p107FindArraysIntersection(array1, array2);
		assertArrayEquals(expected, intersection);
		
	}
	
	@Test
	public void testP108FindAnagramSet(){
		char [] array=new char[]{'a','n','a','g','r','a','m'};
		char [] sortedArray=new char[]{'a','a','a','g','m','n','r'};
		
		Ch01SearchUtil.quickSort(array, 0, array.length-1);
		assertArrayEquals(sortedArray, array);
		
		List<String> words=new ArrayList<String>();
		words.add("word");
		words.add("one");
		words.add("matrix");
		words.add("xamtir");
		words.add("neo");
		
		List<Set<String>> anagramSet = Ch01SearchUtil.p108FindAnagramSet(words);
		assertEquals(3, anagramSet.size());
		assertArrayEquals(new String[]{"word"}, anagramSet.get(0).toArray());
		assertArrayEquals(new String[]{"one","neo"}, anagramSet.get(1).toArray());
		assertArrayEquals(new String[]{"matrix","xamtir"}, anagramSet.get(2).toArray());
	}

	@Test
	public void testP109FindPairWithSum(){
		int [] array=new int[]{2,3,3,7,10,12,16,30,50,100};
		
		Pair pair = Ch01SearchUtil.p109FindPairWithSum(array, 5);
		assertEquals(new Pair(0, 2), pair);
		
		pair = Ch01SearchUtil.p109FindPairWithSum(array, 7);
		assertNull(pair);
		
		pair = Ch01SearchUtil.p109FindPairWithSum(array, 28);
		assertEquals(new Pair(5, 6), pair);
	}
	
	@Test
	public void testP103FindMaxiumDiff(){
		int [] array=new int[]{2,3,3,7,10,12,16,30,50,100};
		assertEquals(98, Ch01SearchUtil.p113FindMaxiumDiff(array));
		
		array=new int[]{1,5,3,2,9,10,0,5,3,1,9};
		assertEquals(9, Ch01SearchUtil.p113FindMaxiumDiff(array));
	}
	
	@Test
	public void testP114FindMajorityWord() throws Exception{
		assertEquals("philip", Ch01SearchUtil.p114FindMajorityWord("wordlist.txt"));
	}
	
	@Test
	public void testP115FindFrequentWord(){
		String line="1 2 1 3 1 4 5 6 7 8";
		assertEquals("1",Ch01SearchUtil.p115FindFrequentWord(line, 5));
	}
	
	@Test
	public void testP118FindKthSmallestNumber(){
		int [] array1=new int[]{2,3,5,7,10,12,16,30,50,100};
		int [] array2=new int[]{0,1,2,3,5,6,12,17,19,20,30,40,45,50,100,120,200};
		
		assertEquals(3, Ch01SearchUtil.p118FindKthSmallestNumber(array1, array2, 5));

		assertEquals(6, Ch01SearchUtil.p118FindKthSmallestNumber(array1, array2, 9));
	}
}
