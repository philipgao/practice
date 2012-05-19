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
	public static int p101FindSquareRootFloor(int value){
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
	
	/**
	 * @param array
	 * @param value
	 * @return
	 */
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
	
	/**
	 * @return
	 */
	public static int p103FindNumberCeling(int[] array, int value){
		
		if(array[0]>value){
			return 0;
		}else if(array[array.length-1]<=value){
			return -1;
		}
		
		int start=0;
		int end=array.length-1;
		
		return p103FindNumberCeling(array, value, start, end);
	}
	
	private static int p103FindNumberCeling(int[] array, int value, int start, int end){
		if(start>end){
			return -1;
		}else if(end==start+1){
			if(array[start]>value && array[end]>=value){
				return start;
			}else if(array[start]<value &&array[end]>value){
				return end;
			}else if(array[start]<value &&array[end]<value){
				return -1;
			}
		}
		
		int mid=start+(end-start)/2;
		
		if(array[mid]==value){
			return mid+1;
		}else if(array[mid]<value){
			return p103FindNumberCeling(array, value, mid, end);
		}else{
			return p103FindNumberCeling(array, value, start, mid);
		}
	}
	
	/**
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 */
	public static int p104FindMagicIndexWithDuplicate(int [] array, int start, int end){
		if(start>end){
			return -1;
		}
		
		int mid=start+(end-start)/2;
		if(array[mid]==mid){
			return mid;
		}
		
		int left=Math.min(array[mid], mid-1);
		int leftMatch = p104FindMagicIndexWithDuplicate(array, start, left);
		if(leftMatch>=0){
			return leftMatch;
		}
		int right=Math.max(array[mid], mid+1);
		return p104FindMagicIndexWithDuplicate(array, right, end);
	}
}
