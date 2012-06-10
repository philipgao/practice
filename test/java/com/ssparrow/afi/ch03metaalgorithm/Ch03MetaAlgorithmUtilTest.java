package com.ssparrow.afi.ch03metaalgorithm;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.ssparrow.afi.ch04graph.ComparationResult;
import com.ssparrow.afi.ch04graph.Player;
import com.ssparrow.afi.ch04graph.Team;
import com.ssparrow.algorithm.misc.Pair;

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
	
	@Test
	public void testP317FindPointsCoverIntervals(){
		List<Pair> intervals=new LinkedList<Pair>();
		intervals.add(new Pair(0, 5));
		intervals.add(new Pair(2, 6));
		intervals.add(new Pair(4, 6));
		List<Integer> points = Ch03MetaAlgorithmUtil.p317FindPointsCoverIntervals(intervals);
		assertEquals(1, points.size());
		assertEquals(5, points.get(0).intValue());
		
		intervals=new LinkedList<Pair>();
		intervals.add(new Pair(0, 2));
		intervals.add(new Pair(2, 4));
		intervals.add(new Pair(3, 5));
		intervals.add(new Pair(4, 6));
		points = Ch03MetaAlgorithmUtil.p317FindPointsCoverIntervals(intervals);
		assertEquals(2, points.size());
		assertEquals(2, points.get(0).intValue());
		assertEquals(5, points.get(1).intValue());
	}
	
	@Test
	public void testTeamComparation(){
		Team team1=new Team("A");
		Player a1=new Player("A1");
		a1.setHeight(3);
		team1.addPlayer(a1);
		Player a2=new Player("A2");
		a2.setHeight(5);
		team1.addPlayer(a2);
		Player a3=new Player("A3");
		a3.setHeight(1);
		team1.addPlayer(a3);
		Player a4=new Player("A4");
		a4.setHeight(4);
		team1.addPlayer(a4);
		Player a5=new Player("A5");
		a5.setHeight(2);
		team1.addPlayer(a5);
		

		Team team2=new Team("B");
		Player b1=new Player("B1");
		b1.setHeight(1);
		team2.addPlayer(b1);
		Player b2=new Player("B2");
		b2.setHeight(2);
		team2.addPlayer(b2);
		Player b3=new Player("B3");
		b3.setHeight(3);
		team2.addPlayer(b3);
		Player b4=new Player("B4");
		b4.setHeight(4);
		team2.addPlayer(b4);
		Player b5=new Player("B5");
		b5.setHeight(5);
		team2.addPlayer(b5);
		
		assertEquals(ComparationResult.EQUAL, team1.compareTo(team2));
		
		//B: 1 2 3 4 6
		b5.setHeight(6);
		assertEquals(ComparationResult.LOWER, team1.compareTo(team2));
		
		//A: 1 2 3 5 6
		a4.setHeight(6);
		assertEquals(ComparationResult.HIGHER, team1.compareTo(team2));
		
		//B: 2 2 3 4 6
		b1.setHeight(2);
		assertEquals(ComparationResult.INCONSISTENT, team1.compareTo(team2));
		
		//A: 1 2 3 4 5 B: 2 3 4 5 6
		a1.setHeight(3);
		a2.setHeight(1);
		a3.setHeight(4);
		a4.setHeight(5);
		a5.setHeight(2);
		b1.setHeight(2);
		b2.setHeight(3);
		b3.setHeight(4);
		b4.setHeight(5);
		b5.setHeight(6);
		assertEquals(ComparationResult.LOWER, team1.compareTo(team2));
	}
}
