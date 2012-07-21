package com.ssparrow.afi.ch03metaalgorithm;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.ssparrow.algorithm.misc.Pair;

public class Ch03MetaAlgorithmUtil {

	/**
	 * @param result
	 * @param array
	 * @param position
	 * @return
	 */
	public static int [] p301FindLongestNondecreasingSubsequence(int [][] result, int [] array, int position){
		if(result[position]!=null){
			return result[position];
		}
		
		if(position==0){
			int [] lns=new int[1];
			lns[0]=array[0];
			result[0]=lns;
			return lns;
		}
		
		int [] lns=new int[1];
		lns[0]=array[position];
		
		for(int index=position-1;index>=0;index--){
			if(array[index]<=array[position]){
				int [] subLns=p301FindLongestNondecreasingSubsequence(result, array, index);
				
				if(subLns.length+1>lns.length){
					lns=new int[subLns.length+1];
					System.arraycopy(subLns, 0, lns, 0, subLns.length);
					lns[subLns.length]=array[position];
				}
			}
		}
		
		result[position]=lns;
		return lns;
	}
	
	/**
	 * @param stones
	 * @return
	 */
	public static boolean p302CanFrogCrossRiver(boolean [] stones){
		if(!stones[1]){
			return false;
		}
		
		boolean [][] result=new boolean[stones.length+1][stones.length+1];
		int maxJump=(int) Math.sqrt(2*stones.length);
		
		result[1][1]=true;
		
		for(int j=1;j<=maxJump;j++){
			result[0][j]=false;
		}
		
		for(int i=1;i<stones.length;i++){
			result[i][0]=false;
		}
		
		for(int i=1;i<stones.length;i++){
			for(int j=1;j<=maxJump;j++){
				if(stones[i]&&i-j>0){
					if(result[i-j][j]){
						result[i][j]=true;
					}else if(j>0 && result[i-j][j-1]){
						result[i][j]=true;
					}else if(result[i-j][j+1]){
						result[i][j]=true;
					}
				}
				
				if(result[i][j] && i+j+1>=stones.length){
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * break one line of consecutive characters into valid words according to dictionary
	 * @param dict
	 * @param line
	 * @return
	 *   if the line is not breakable, return null
	 *   otherwise, return list of the words
	 */
	public static List<String> p304BreakLineToWords(Set<String> dict, String line){
		for(int i=1;i<=line.length();i++){
			String prefix=line.substring(0, i);
			if(dict.contains(prefix)){
				if(i<line.length()){
					String subLine =line.substring(i);
					List<String> result = p304BreakLineToWords(dict, subLine);
					if(result!=null){
						result.add(0, prefix);
						return result;
					}
				}else{
					List<String> result=new LinkedList<String>();
					result.add(prefix);
					return result;
				}
			}
		}
		return null;
	}
	
	
	/**
	 * @param intervals
	 * @return
	 */
	public static List<Integer> p317FindPointsCoverIntervals(List<Pair> intervals){
		List<Integer> points=new LinkedList<Integer>();
		
		Comparator<Pair> startComparator=new Comparator<Pair>(){
			@Override
			public int compare(Pair o1, Pair o2) {
				return o1.getA()-o2.getA();
			}
		};
		List<Pair> startSortList=new LinkedList<Pair>(intervals);
		Collections.sort(startSortList, startComparator);
		
		Comparator<Pair> endComparator=new Comparator<Pair>(){
			@Override
			public int compare(Pair o1, Pair o2) {
				return o1.getB()-o2.getB();
			}
		};
		List<Pair> endSortList=new LinkedList<Pair>(intervals);
		Collections.sort(endSortList, endComparator);
		
		Set<Pair> deleteList=new HashSet<Pair>();
		for (Iterator iterator = endSortList.iterator(); iterator.hasNext();) {
			Pair pair = (Pair) iterator.next();
			
			if(!deleteList.contains(pair)){
				
				points.add(pair.getB());
				deleteList.add(pair);
				
				for (Iterator iterator2 = startSortList.iterator(); iterator2.hasNext();) {
					Pair pair2 = (Pair) iterator2.next();
					if(!deleteList.contains(pair2) && pair2.getA()<=pair.getB()){
						deleteList.add(pair2);
					}
				}
			}
		}
		
		return points;
	}
}
