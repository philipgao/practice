package com.ssparrow.afi.ch05string;

import static org.junit.Assert.*;

import org.junit.Test;

public class Ch05StringUtilTest {
	
	@Test
	public void testFindLongestCommonSubsequence(){
		String str1="AGCAT";
		String str2="GAC";
		
		char[][][] map = new char[str1.length()+1][str2.length()+1][];
		char[] lcs = Ch05StringUtil.findLongestCommonSubsequence(map, str1.toCharArray(), str1.length(), str2.toCharArray(), str2.length());
		assertEquals("AC", new String(lcs));

		str1="CACAATTCCCATGGGTTGTGGAG";
		str2="GAGGTGTTGGGTACCCTTAACAC";map = new char[str1.length()+1][str2.length()+1][];
		lcs = Ch05StringUtil.findLongestCommonSubsequence(map, str1.toCharArray(), str1.length(), str2.toCharArray(), str2.length());
		assertEquals("ATTTGGGTTTA", new String(lcs));
	}
	
	@Test
	public void testP506FindLongestPalindrome(){
		String str="CACAATTCCCATGGGTTGTGGAG";
		assertEquals("ATTTGGGTTTA", Ch05StringUtil.p506FindLongestPalindrome(str));
	}

}
