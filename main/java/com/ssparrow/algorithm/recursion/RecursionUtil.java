package com.ssparrow.algorithm.recursion;

import java.util.ArrayList;

public class RecursionUtil {

	/**
	 * @param n
	 * @param map
	 * @return
	 */
	public static int findPossibleHops(int n, int[] map){
		if(n<0){
			return 0;
		}else if(n==0){
			return 1;
		}else if(map[n]>=0){
			return map[n];
		}else{
			map[n] = findPossibleHops(n-3, map)+findPossibleHops(n-2, map)+findPossibleHops(n-1, map);
			return map[n];
		}
	}
	
	/**
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 */
	public static int findMagicIndex(int[] array, int start, int end){
		if(start>end){
			return -1;
		}
		int mid=start+(end-start)/2;
		if(array[mid]==mid){
			return mid;
		}else if(array[mid]<mid){
			return findMagicIndex(array, mid+1, end);
		}else{
			return findMagicIndex(array, start, mid-1);
		}
	}
	
	/**
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 */
	public static int findMagicIndexWIthDuplicate(int [] array, int start, int end){
		if(start>end || start<0 || end>=array.length){
			return -1;
		}
		
		int mid=start+(end-start)/2;
		if(array[mid]==mid){
			return mid;
		}
		
		int left=Math.min(array[mid], mid-1);
		int leftMatch = findMagicIndexWIthDuplicate(array, start, left);
		if(leftMatch>=0){
			return leftMatch;
		}

		int right=Math.max(array[mid], mid+1);
		return findMagicIndexWIthDuplicate(array, right, end);
	}
	
	/**
	 * @param n
	 * @return
	 */
	public static  ArrayList<String> generateparen(int n){
		char[] str=new char[n*2];
		ArrayList<String> result=new ArrayList<String>();
		addParen(result, n, n, str, 0);
		return result;
	}
	
	private static void addParen(ArrayList<String> result, int leftRem, int rightRem, char[] str, int count){
		if(leftRem<0 || leftRem>rightRem){
			return;
		}
		if(leftRem==0&&rightRem==0){
			result.add(new String(str));
		}else{
			if(leftRem>0){
				str[count]='(';
				addParen(result, leftRem-1, rightRem, str, count+1);
			}
			
			if(leftRem<rightRem){
				str[count]=')';
				addParen(result, leftRem, rightRem-1, str, count+1);
			}
		}
		
	}
}
