package com.ssparrow.afi.ch06intractability;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Ch06IntractabilityUtil {

	/**
	 * @param map
	 * @param weight
	 * @param price
	 * @param maxWeight
	 * @return
	 */
	public static int p601FindOptimal01Knapstack(Map<Integer, Integer> map, int [] weight, int []price, boolean[] used,int maxWeight){
		if(maxWeight<=0){
			return 0;
		}
		
		int maxIndex=0;
		int maxValue=0;
		
		for (int index = 0; index < weight.length; index++) {
			if(!used[index] &&weight[index]<=maxWeight){
				used[index] = true;
				int value = p601FindOptimal01Knapstack(map, weight, price, used,maxWeight-weight[index])+price[index];
				if(value>maxValue){
					maxValue=value;
					maxIndex=index;
				}
				used[index] = false;
			}
		}
		
//		System.out.println(maxWeight+":"+maxIndex);
		map.put(maxWeight, maxValue);
		return maxValue;
		
	}
	
	/**
	 * @param n
	 * @return
	 */
	public static List<Integer> p604FindXNMultiplcationPath(int n){
		List<Integer> initList=new LinkedList<Integer>();
		initList.add(1);
		
		List<List<Integer>> allPartials=new LinkedList<List<Integer>>();
		allPartials.add(initList);
		
		int shortedPathLength=Integer.MAX_VALUE;
		List<Integer> shortedPath=null;
		while(!allPartials.isEmpty()){
			List<Integer> currentPartial = allPartials.remove(0);
			
			for (int i=0; i< currentPartial.size();i++) {
				int value1=currentPartial.get(i);
				for (int j=0; j< currentPartial.size();j++) {
					int value2=currentPartial.get(j);
					
					int sum=value1+value2;
					
					if(sum>n){
						continue;
					}else if(sum==n){
						
						if(currentPartial.size()<shortedPathLength){
							shortedPathLength=currentPartial.size();

							shortedPath=new LinkedList<Integer>(currentPartial);
							shortedPath.add(sum);
						}
						
					}else{
						if(!currentPartial.contains(sum) && currentPartial.size()<shortedPathLength && sum>currentPartial.get(currentPartial.size()-1)){
							List<Integer> extension=new LinkedList<Integer>(currentPartial);
							extension.add(sum);
							allPartials.add(extension);
						}
					}
				}
			}
		}
		
		return shortedPath;
	}

}
