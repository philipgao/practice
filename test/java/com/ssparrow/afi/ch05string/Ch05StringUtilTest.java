package com.ssparrow.afi.ch05string;

import static org.junit.Assert.*;

import org.junit.Test;

public class Ch05StringUtilTest {
	
	@Test
	public void testP506FindLongestPalindrome(){
		String str="CACAATTCCCATGGGTTGTGGAG";
		assertEquals("TGGGT", Ch05StringUtil.p506FindLongestPalindrome(str));
	}

}
