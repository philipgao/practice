package com.ssparrow.afi.ch02sorting;

import com.ssparrow.algorithm.misc.Pair;

public class Ch02SortingUtil {
	/**
	 * find min and max simultaneously, the comparison should be less than 3n/2-1 
	 * @param array
	 * @return
	 */
	public static Pair p204FindMinMax(int [] array){
		int length = array.length;
		int [] upArray =new int[length/2];
		int [] downArray=new int[length/2];
		
		int upIndex=0;
		int downIndex=0;
		for(int index=0;index<length-1;index+=2){
			upArray[upIndex++]=Math.max(array[index], array[index+1]);
			downArray[downIndex++]=Math.min(array[index], array[index+1]);
		}
		
		int max=Integer.MIN_VALUE;
		int min=Integer.MAX_VALUE;
		
		for (upIndex = 0; upIndex < upArray.length; upIndex++) {
			if(upArray[upIndex]>max){
				max=upArray[upIndex];
			}
		}
		
		for (downIndex = 0; downIndex < downArray.length; downIndex++) {
			if(downArray[downIndex]<min){
				min=downArray[downIndex];
			}
		}
		
		if(length%2==1){
			if(array[length-1]>max){
				max=array[length-1];
			}else if(array[length-1]<min){
				min=array[length-1];
			}
		}
		
		return new Pair(min, max);
	}
}
