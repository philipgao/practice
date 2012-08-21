package com.ssparrow.algorithm.string;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

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
		String result=StringUtil.reverseCharsInWords(null);
		assertNull(result);
		
		result=StringUtil.reverseCharsInWords("word");
		assertEquals("drow", result);
		
		result=StringUtil.reverseCharsInWords("word abcde");
		assertEquals("drow edcba", result);
	}
	
	@Test
	public void testReverseWordsInSentence(){
		StringBuffer sb=new StringBuffer();
		String sentence="this is a cafe";
		StringUtil.reverseWordsInSentence(sb, sentence);
		
		assertEquals("cafe a is this", sb.toString());
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
	
	@Test
	public void testFindMajorityWord() throws Exception{
		String majorityWord = StringUtil.findMajorityWord("wordlist.txt");
		assertEquals("philip", majorityWord);
	}
	
	@Test
	public void testCheckPalindrome(){
		assertFalse(StringUtil.checkPalindrome(null));

		assertTrue(StringUtil.checkPalindrome("a"));
		
		assertFalse(StringUtil.checkPalindrome("ab"));

		assertTrue(StringUtil.checkPalindrome("aba"));
		
		assertFalse(StringUtil.checkPalindrome("abbc"));

		assertTrue(StringUtil.checkPalindrome("abba"));
	}
	
	@Test
	public void testFindLongestComboWords(){
		List<String> words = new ArrayList<String>();
		words.add("this");
		words.add("tv");
		words.add("couch");
		words.add("dog");
		words.add("mac");
		words.add("air");
		words.add("tvtable");
		words.add("macbookair");
		words.add("book");
		
		String combo = StringUtil.findLongestComboWords(words);
		assertEquals("macbookair", combo);
	}
	
	@Test
	public void testCreateInterleavingStrings(){
		assertEquals(6, StringUtil.createInterleavingStrings("AB", "CD").size());
	}
}
