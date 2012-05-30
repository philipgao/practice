package com.ssparrow.afi.ch05string;

import static org.junit.Assert.*;

import org.junit.Test;

public class Ch05StringUtilTest {
	
	@Test
	public void testP506FindLongestPalindrome(){
		String str="CACAATTCCCATGGGTTGTGGAG";
		assertEquals("TGGGT", Ch05StringUtil.p506FindLongestPalindrome(str));
	}
	
	@Test
	public void testP508CalculateEditDistance(){
		
		assertEquals(0, Ch05StringUtil.p508CalculateEditDistance("word", 0, "word", 0));
		
		assertEquals(1, Ch05StringUtil.p508CalculateEditDistance("word", 0, "words", 0));

		assertEquals(1, Ch05StringUtil.p508CalculateEditDistance("word", 0, "sword", 0));

		assertEquals(1, Ch05StringUtil.p508CalculateEditDistance("distat", 0, "distant", 0));

		assertEquals(2, Ch05StringUtil.p508CalculateEditDistance("distatl", 0, "distant", 0));

		assertEquals(5, Ch05StringUtil.p508CalculateEditDistance("abcd", 0, "def", 0));

		assertEquals(8, Ch05StringUtil.p508CalculateEditDistance("source", 0, "target", 0));
	}

}
