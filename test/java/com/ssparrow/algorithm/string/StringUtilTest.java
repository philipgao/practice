package com.ssparrow.algorithm.string;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilTest {

	@Test
	public void testConvertStringToInt() {
		int result=StringUtil.convertStringtoInt(null);
		assertEquals(result, -1);
		
		result=StringUtil.convertStringtoInt("12345");
		assertEquals(12345, result);
	}
	
	@Test
	public void testReverseWords(){
		String result=StringUtil.reverseWords(null);
		assertNull(result);
		
		result=StringUtil.reverseWords("word");
		assertEquals("drow", result);
		
		result=StringUtil.reverseWords("word abcde");
		assertEquals("drow edcba", result);
	}

	@Test
	public void testCharUnique(){
		String str="abcdef";
		assertTrue(StringUtil.checkCharUnique(str));
		
		str="abcdefgfijakl";
		assertFalse(StringUtil.checkCharUnique(str));
		
	}
	
	@Test
	public void testReplaceSpaceInStr(){
		String str="";
		char[] array=new char[100];
		System.arraycopy(str.toCharArray(), 0, array, 0, str.length());
		int newLength = StringUtil.replaceSpaceInStr(array, str.length());
		assertEquals(0, newLength);
		
		str=" ";
		array=new char[100];
		System.arraycopy(str.toCharArray(), 0, array, 0, str.length());
		newLength = StringUtil.replaceSpaceInStr(array, str.length());
		assertEquals(3, newLength);
		assertEquals("%20", new String(array,0,newLength));
		
		str="   ";
		array=new char[100];
		System.arraycopy(str.toCharArray(), 0, array, 0, str.length());
		newLength = StringUtil.replaceSpaceInStr(array, str.length());
		assertEquals(9, newLength);
		assertEquals("%20%20%20", new String(array,0,newLength));
		
		str="abcde";
		array=new char[100];
		System.arraycopy(str.toCharArray(), 0, array, 0, str.length());
		newLength = StringUtil.replaceSpaceInStr(array, str.length());
		assertEquals(5, newLength);
		assertEquals("abcde", new String(array,0,newLength));
		
		str="ab cde";
		array=new char[100];
		System.arraycopy(str.toCharArray(), 0, array, 0, str.length());
		newLength = StringUtil.replaceSpaceInStr(array, str.length());
		assertEquals(8, newLength);
		assertEquals("ab%20cde", new String(array,0,newLength));
		
		str="ab   cde";
		array=new char[100];
		System.arraycopy(str.toCharArray(), 0, array, 0, str.length());
		newLength = StringUtil.replaceSpaceInStr(array, str.length());
		assertEquals(14, newLength);
		assertEquals("ab%20%20%20cde", new String(array,0,newLength));
		
		str=" ab cde ";
		array=new char[100];
		System.arraycopy(str.toCharArray(), 0, array, 0, str.length());
		newLength = StringUtil.replaceSpaceInStr(array, str.length());
		assertEquals(14, newLength);
		assertEquals("%20ab%20cde%20", new String(array,0,newLength));
	}
	
	
	@Test
	public void testCountCompress(){
		String str="";
		String result=StringUtil.countCompress(str);
		assertEquals("", result);
		
		str="aa";
		result=StringUtil.countCompress(str);
		assertEquals("aa", result);
		
		str="aaa";
		result=StringUtil.countCompress(str);
		assertEquals("a3", result);
	}
}
