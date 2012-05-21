package com.ssparrow.afi.ch01searching;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import com.ssparrow.algorithm.misc.Pair;

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
	
	/**
	 * @param array
	 * @param value
	 * @return
	 */
	public static int p105SearchInUnkownLengthArray(int []array, int value){
		int k=0;
		
		while(true){
			int index=(1<<k)-1;
			try{
				int tailValue = array[index];
				if(tailValue==value){
					return index;
				}else if(tailValue>value){
					break;
				}
				k++;
			}catch(ArrayIndexOutOfBoundsException exception){
				break;
			}
		}
		
		int start=k>0?(1<<(k-1)):0;
		int end=(1<<k)-1;
		
		while(start+1<end){
			int mid=start+(end-start)/2;
			
			try{
				int midValue=array[mid];
				if(midValue==value){
					return mid;
				}else if(midValue<value){
					start=mid;
				}else{
					end=mid;
				}
			}catch(ArrayIndexOutOfBoundsException exception){
				end=mid;
			}
		}
		
		return -1;
	}
	
	private static int p105SearchInUnkownLengthArray1(int []array, int value){
		int start=0;
		int end=Integer.MAX_VALUE;
		
		while(start<=end){
			int mid=start+(end-start)/2;
			
			try{
				int midValue=array[mid];
				if(midValue==value){
					return mid;
				}else if(midValue<value){
					start=mid+1;
				}else{
					end=mid-1;
				}
			}catch(ArrayIndexOutOfBoundsException exception){
				end=mid-1;
			}
		}
		
		return -1;
	}
	
	/**
	 * @param array1
	 * @param array2
	 * @return
	 */
	public static int[] p107FindArraysIntersection(int [] array1, int [] array2){
		int index1=0;
		int length1=array1.length;
		int index2=0;
		int length2=array2.length;
		
		int resultIndex=-1;
		int [] result=new int[Math.min(length1, length2)];
		
		while(index1<length1 && index2<length2){
			int value1=array1[index1];
			int value2=array2[index2];
			
			if(value1==value2){
				if(resultIndex<0 || (resultIndex>=0 && result[resultIndex]!=value1)){
					resultIndex++;
					result[resultIndex]=value1;
				}
				index1++;
				index2++;
			}else if(value1<value2){
				index1++;
			}else{
				index2++;
			}
		}
		
		int[] intersection=new int[resultIndex+1];
		System.arraycopy(result, 0, intersection, 0, resultIndex+1);
		return intersection;
	}
	
	/**
	 * @param list
	 * @return
	 */
	public static List<Set<String>> p108FindAnagramSet(List<String> list){
		Map<String, Set<String>> map=new LinkedHashMap<String, Set<String>>();
		
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			String word = (String) iterator.next();
			
			char[] array = word.toCharArray();
			quickSort(array, 0, word.length()-1);
			String sortedStr=new String(array);
			
			if(map.containsKey(sortedStr)){
				Set<String> set=map.get(sortedStr);
				set.add(word);
			}else{
				Set<String> set=new LinkedHashSet<String>();
				set.add(word);
				map.put(sortedStr, set);
			}
		}
		
		List<Set<String>> results=new ArrayList<Set<String>>();
		for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			results.add(map.get(key));
		}
		
		return results;
	}
	
	public static void quickSort(char[] array, int start, int end){
		if(start>=end){
			return;
		}
		
		int p=partition(array, start, end);
		quickSort(array, start, p-1);
		quickSort(array, p,end);
	}
	
	private static int partition(char [] array, int start, int end){
		char pivot=array[end];
		int j=start-1;
		
		for(int i=start;i<end;i++){
			if(array[i]<=pivot){
				j++;
				
				char tmp=array[i];
				array[i]=array[j];
				array[j]=tmp;
			}
		}
		
		array[end]=array[j+1];
		array[j+1]=pivot;
		
		return j+1;
	}
	
	/**
	 * @param array
	 * @param sum
	 * @return
	 */
	public static Pair p109FindPairWithSum(int [] array, int sum){
		int frontIndex=0;
		int endIndex=array.length-1;
		
		while(frontIndex<endIndex){
			int currentSum=array[frontIndex]+array[endIndex];
			if(currentSum==sum){
				return new Pair(frontIndex,endIndex);
			}else if(currentSum<sum){
				frontIndex++;
			}else{
				endIndex--;
			}
		}
		
		return null;
	}
	
	/**
	 * @param array
	 * @return
	 */
	public static int p113FindMaxiumDiff(int[] array){
		if(array.length<2){
			return 0;
		}
		
		int result=0;
		int minIndex=0;
		
		for(int index=1;index<array.length;index++){
			if(array[index]<array[minIndex]){
				minIndex=index;
				continue;
			}
			
			int diff=array[index]-array[minIndex];
			if(diff>result){
				result=diff;
			}
		}
		
		return result;
	}
	
	/**
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public static String p114FindMajorityWord(String fileName) throws Exception{
		BufferedReader reader=new BufferedReader(new FileReader(fileName));
		
		String word=null;
		String candidate=null;
		int count=0;
		while((word=reader.readLine())!=null){
			if(count==0){
				candidate=word;
				count=1;
			}else if(word.equals(candidate)){
				count++;
			}else{
				count--;
			}
		}
		
		return candidate;
	}
	
	/**
	 * @param line
	 * @param k
	 * @return
	 */
	public static String p115FindFrequentWord(String line, int k){
		Map<String, Integer> map=new HashMap<String, Integer>();
		
		int count=0;
		StringTokenizer st=new StringTokenizer(line, " ");
		while(st.hasMoreTokens()){
			count++;
			
			String word = st.nextToken();
			
			if(map.containsKey(word)){
				map.put(word, map.get(word)+1);
			}else{
				if(map.size()==k){
					Object[] keys = map.keySet().toArray();
					for (int index=0;index<keys.length;index++) {
						String key = (String) keys[index];
						Integer value = map.get(key);
						if(value.intValue()>1){
							map.put(key, value-1);
						}else{
							map.remove(key);
						}
					}
				}
				map.put(word,1);
			}
		}
		
		if(map.size()>1){
			return map.keySet().iterator().next();
		}
		return null;
	}
	
	/**
	 * @param array1
	 * @param array2
	 * @param k
	 * @return
	 */
	public static int p118FindKthSmallestNumber(int[] array1, int [] array2, int k){
		int start=Math.max(0, k-array2.length);
		int end=Math.min(k, array1.length);
		
		while(start<=end){
			int l=start+(end-start)/2;
			
			if(l<array1.length && (k-l)>0 && array1[l]<array2[k-l-1]){
				start=l+1;
			}else if(l>0 && k-l<array2.length && array2[k-l]<array1[l-1]){
				end=l;
			}else{
				start=l;
				break;
			}
		}
		
		if(start==0){
			return array2[k-1];
		}else if(start==k){
			return array1[k-1];
		}else{
			return Math.max(array1[start-1], array2[k-start-1]);
		}
	}
}
