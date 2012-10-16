package com.ssparrow.algorithm.recursion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
	
	/**
	 * @param set
	 * @param index
	 * @return
	 */
	public static List<List<String>>  findAllSubset(ArrayList<String> set, int index){
		List<List<String>> allSubsets =new LinkedList<List<String>>();
		
		if(index>=set.size()){
			ArrayList<String> subset=new ArrayList<String>();
			allSubsets.add(subset);
		}else{
			String item = set.get(index);
			
			List<List<String>> subResult = findAllSubset(set, index+1);
			
			for (Iterator iterator = subResult.iterator(); iterator.hasNext();) {
				ArrayList<String> subset = (ArrayList<String>) iterator.next();
				ArrayList<String> extendedSubset=new ArrayList<String>();
				extendedSubset.add(item);
				extendedSubset.addAll(subset);
				
				allSubsets.add(extendedSubset);
			}
			
			allSubsets.addAll(subResult);
		}
		
		return allSubsets;
	}
	
	/**
	 * @param list
	 * @return
	 */
	public static List<List<String>> findAllSubSetByCombination(List<String> list){
		List<List<String>> allSubSet=new ArrayList<List<String>>();
		
		int max=(1<<list.size());
		for(int number=0;number<max;number++){
			List<String> subset=new ArrayList<String>();
			int temp=number;
			
			int index=0;
			while(temp>0){
				if((temp&1)>0){
					subset.add(list.get(index));
				}
				
				temp=temp>>1;
				index++;
			}
			allSubSet.add(subset);
		}
		
		return allSubSet;
	}
	
	/**
	 * @param n
	 * @param denom
	 * @return
	 */
	public static int makeChanges(int n, int denom){
		int nextDenom=0;
		
		switch (denom) {
		case 25:
			nextDenom=10;
			break;
		case 10:
			nextDenom=5;
			break;
		case 5:
			nextDenom=1;
			break;
		case 1:
			return 1;

		default:
			break;
		}
		
		int sum=0;
		for(int i=0;i*denom<=n;i++){
			sum+=makeChanges(n-i*denom, nextDenom);
		}
		
		return sum;
	}
	
	/**
	 * @param columns
	 * @param row
	 */
	public static void placeQueen(int [] columns, int row){
		if(row==8){
			for(int index=0;index<columns.length;index++){
				System.out.println(index+":"+columns[index]);
			}
			return;
		}
		
		for(int index=0; index<columns.length;index++){
			columns[row]=index;
			if(checkRow(columns, row)){
				placeQueen(columns, row+1);
			}
		}
	}
	
	private static boolean checkRow(int [] columns, int row){
		for(int index=0;index<row;index++){
			int diff=Math.abs(columns[index]-columns[row]);
			if(diff==0 || diff==row-index){
				return false;
			}
		}
		return true;
	}
	
	public static List<Integer> findXNMultiplcationPath(int n){
	    Queue<List<Integer>> allPartialPaths=new LinkedList<List<Integer>>();
	    int shortestPartialPath=Integer.MAX_VALUE;
	    List<Integer> result=null;
	    
	    List<Integer> initalPath=new ArrayList<Integer>();
	    initalPath.add(1);
	    allPartialPaths.offer(initalPath);
	    
	    while(!allPartialPaths.isEmpty()){
		List<Integer> partialPath=allPartialPaths.poll();
		
		for(Integer value1:partialPath){
		    for(Integer value2:partialPath){
			int sum=value1+value2;
			
			if(sum==n){
			    if(partialPath.size()<shortestPartialPath){
				shortestPartialPath=partialPath.size();
				
				result=new ArrayList<Integer>(partialPath);
				result.add(n);
			    }
			}else if(sum<n){
			    if(!partialPath.contains(sum) && partialPath.size()<shortestPartialPath &&partialPath.get(partialPath.size()-1)<sum){
				List<Integer> newPartialPath=new ArrayList<Integer>(partialPath);
				newPartialPath.add(sum);
				allPartialPaths.offer(newPartialPath);
			    }
			}
		    }
		}
		
	    }
	    
	    return result;
	}
}
