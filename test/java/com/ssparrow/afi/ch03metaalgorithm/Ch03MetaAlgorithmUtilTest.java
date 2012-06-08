package com.ssparrow.afi.ch03metaalgorithm;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class Ch03MetaAlgorithmUtilTest {

	@Test
	public void testP301FindLongestNondecreasingSubsequence() {
		int [] array=new int[]{1,3,5,2,7};
		int [][] result=new int[array.length][];
		int[] lns = Ch03MetaAlgorithmUtil.p301FindLongestNondecreasingSubsequence(result, array, array.length-1);
		assertArrayEquals(new int[]{1,3,5,7}, lns);
		
		
		array=new int[]{1,7,5,2,10,3,8,9};
		result=new int[array.length][];
		lns = Ch03MetaAlgorithmUtil.p301FindLongestNondecreasingSubsequence(result, array, array.length-1);
		assertArrayEquals(new int[]{1,2,3,8,9}, lns);
	}
	
	@Test
	public void testP302CanFrogCrossRiver(){
		boolean [] stones = new boolean[]{false,true,false,true,false,false,true,false,false,false};
		assertTrue(Ch03MetaAlgorithmUtil.p302CanFrogCrossRiver(stones));
		
		stones = new boolean[]{false,true,false,true,false,false,true,false,false,false,false};
		assertFalse(Ch03MetaAlgorithmUtil.p302CanFrogCrossRiver(stones));
	}

	@Test
	public void testP304BreakLineToWords(){
		Set<String> dictionary=new HashSet<String>();
		dictionary.add("world");
		
		String domain="worldmarket";
		List<String> result = Ch03MetaAlgorithmUtil.p304BreakLineToWords(dictionary, domain);
		assertNull(result);

		dictionary.add("market");
		result = Ch03MetaAlgorithmUtil.p304BreakLineToWords(dictionary, domain);
		assertNotNull(result);
		assertEquals("world", result.get(0));
		assertEquals("market", result.get(1));
		
		dictionary.add("bed");
		dictionary.add("bath");
		dictionary.add("and");
		dictionary.add("beyond");
		domain="bedbathandbeyond";
		result = Ch03MetaAlgorithmUtil.p304BreakLineToWords(dictionary, domain);
		assertNotNull(result);
		assertEquals("bed", result.get(0));
		assertEquals("bath", result.get(1));
		assertEquals("and", result.get(2));
		assertEquals("beyond", result.get(3));

		//tricky test, although both bed and beds are valid word, if we take bed as first word,the whole line is not breakable
		dictionary.add("beds");
		domain="bedsbathandbeyond";
		result = Ch03MetaAlgorithmUtil.p304BreakLineToWords(dictionary, domain);
		assertNotNull(result);
		assertEquals("beds", result.get(0));
		assertEquals("bath", result.get(1));
		assertEquals("and", result.get(2));
		assertEquals("beyond", result.get(3));
	}
}
