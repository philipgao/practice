package com.ssparrow.afi.ch01searching;

public class Ch01SearchUtil {
	/**
	 * find square root floor 
	 * 
	 * @param value
	 * @return
	 */
	public static int p101FindSquareRoot(int value){
		return p101FindSquareRoot(value, 0, (value-1)/2 +1);
	}
	private static int p101FindSquareRoot(int value, int start, int end){
		if(start>end){
			return -1;
		}
		int mid=start+(end-start)/2;
		int square=mid*mid;
		if(square==value){
			return mid;
		}else if(square<value){
			return p101FindSquareRoot(value, mid+1, end);
		}else{
			return p101FindSquareRoot(value, start, mid-1);
		}
	}
	
	/**
	 * @param value
	 * @return
	 */
	public static int p101FIndSquareRootFloor(int value){
		int start=0;
		int end=65536;
		
		while(end>start+1){
			int mid=start+(end-start)/2;
			int square=mid*mid;
			if(square==value){
				return mid;
			}else if(square<value){
				//since we are finding the floor, we should keep the mid for next search
				start=mid;
			}else{
				//since we are finding the floor, we should keep the mid for next search
				end=mid;
			}
		}
		
		return start;
	}
	
	public static int p102BinarySearch(int[] array, int value){
		int start=0;
		int end=array.length-1;
		
		while(start<=end){
			int mid=start+(end-start)/2;
			if(array[mid]==value){
				return mid;
			}else if(array[mid]>value){
				end=mid-1;
			}else{
				start=mid+1;
			}
		}
		
		return -1;
	}
}
