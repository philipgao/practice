package com.ssparrow.afi.ch06intractability;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class Ch06IntractabilityUtilTest {
	
	@Test
	public void testFindOptimal01Knapstack(){
		int [] weight =new int[]{1,2,3,4,5,6,7,8,9,10};
		int [] price  =new int[]{3,2,5,6,10,15,7,10,12,18};
		boolean[] used=new boolean[weight.length];
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		assertEquals(33, Ch06IntractabilityUtil.p601FindOptimal01Knapstack(map, weight, price, used, 15));
		

		weight =new int[]{1,2,3};
		price  =new int[]{3,6,2};
		used=new boolean[weight.length];
		
		assertEquals(9, Ch06IntractabilityUtil.p601FindOptimal01Knapstack(map, weight, price, used, 4));
	}
	
	@Test
	public void testP604FindXNMultiplcationPath(){
		
		List<Integer> multiplicationPath = Ch06IntractabilityUtil.p604FindXNMultiplcationPath(30);
		assertEquals(7, multiplicationPath.size());
		assertEquals(1, multiplicationPath.get(0).intValue());
		assertEquals(2, multiplicationPath.get(1).intValue());
		assertEquals(3, multiplicationPath.get(2).intValue());
		assertEquals(5, multiplicationPath.get(3).intValue());
		assertEquals(10, multiplicationPath.get(4).intValue());
		assertEquals(15, multiplicationPath.get(5).intValue());
		assertEquals(30, multiplicationPath.get(6).intValue());
	}
}
