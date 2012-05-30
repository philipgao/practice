package com.ssparrow.afi.ch06intractability;

import java.util.Map;

public class IntractabilityUtil {

	/**
	 * @param map
	 * @param weight
	 * @param price
	 * @param maxWeight
	 * @return
	 */
	public static int findOptimal01Knapstack(Map<Integer, Integer> map, int [] weight, int []price, boolean[] used,int maxWeight){
		if(maxWeight<=0){
			return 0;
		}
		
		int maxIndex=0;
		int maxValue=0;
		
		for (int index = 0; index < weight.length; index++) {
			if(!used[index] &&weight[index]<=maxWeight){
				used[index] = true;
				int value = findOptimal01Knapstack(map, weight, price, used,maxWeight-weight[index])+price[index];
				if(value>maxValue){
					maxValue=value;
					maxIndex=index;
				}
				used[index] = false;
			}
		}
		
		System.out.println(maxWeight+":"+maxIndex);
		map.put(maxWeight, maxValue);
		return maxValue;
		
	}

}
