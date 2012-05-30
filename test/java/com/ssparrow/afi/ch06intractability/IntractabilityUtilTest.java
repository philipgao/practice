package com.ssparrow.afi.ch06intractability;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class IntractabilityUtilTest {
	
	@Test
	public void testFindOptimal01Knapstack(){
		int [] weight =new int[]{1,2,3,4,5,6,7,8,9,10};
		int [] price  =new int[]{3,2,5,6,10,15,7,10,12,18};
		boolean[] used=new boolean[weight.length];
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		assertEquals(33, IntractabilityUtil.findOptimal01Knapstack(map, weight, price, used, 15));
		

		weight =new int[]{1,2,3};
		price  =new int[]{3,6,2};
		used=new boolean[weight.length];
		
		assertEquals(9, IntractabilityUtil.findOptimal01Knapstack(map, weight, price, used, 4));
	}
}
