package com.ssparrow.algorithm.dp;

public class DPUtil {
	/**
	 * @param matrixs
	 * @return
	 */
	public static int[][] findOptimalMatrixChain(Matrix[] matrixs){
		int[][] m=new int[matrixs.length][matrixs.length];
		int[][] s=new int[matrixs.length][matrixs.length];
		
		for(int i=0; i<matrixs.length;i++){
			m[i][i]=0;
		}
		
		for(int l=1; l<matrixs.length;l++){
			for(int i=0;i<matrixs.length-l;i++){
				int j=i+l;
				m[i][j]=Integer.MAX_VALUE;
				for(int k=i;k<j;k++){
					int q=m[i][k]+m[k+1][j]+matrixs[i].getRowSize()*matrixs[k].getColumnSize()*matrixs[j].getColumnSize();
					if(q<m[i][j]){
						m[i][j]=q;
						s[i][j]=k;
					}
				}
			}
		}
		
		return s;
	}
	
	/**
	 * @param sb
	 * @param s
	 * @param i
	 * @param j
	 */
	public static void printMatrixChain(StringBuffer sb, int[][] s, int i, int j){
		if(i==j){
			sb.append("A["+i+"]");
			return;
		}
		
		sb.append('(');
		
		int k=s[i][j];
		printMatrixChain(sb, s, i, k);
		printMatrixChain(sb, s, k+1, j);
		
		sb.append(')');
	}
	

	
	/**
	 * @param map
	 * @param array1
	 * @param length1
	 * @param array2
	 * @param length2
	 * @return
	 */
	public static char[] findLongestCommonSubsequence(char[][][] map,char[] array1, int length1,char array2[], int length2){
		//System.out.println(length1+":"+length2);
		if(length1==0||length2==0){
			return new char[0];
		}
		
		if(map[length1][length2]!=null){
			return map[length1][length2];
		}
		
		if(array1[length1-1]==array2[length2-1]){
			char[] subLCS = findLongestCommonSubsequence(map, array1, length1-1, array2, length2-1);
			char[] result=new char[subLCS.length+1];
			System.arraycopy(subLCS, 0, result, 0, subLCS.length);
			result[subLCS.length]=array1[length1-1];
			map[length1][length2]=result;
			return result;
		}else{
			char[] subLCS1=findLongestCommonSubsequence(map, array1, length1-1, array2, length2);
			char[] subLCS2=findLongestCommonSubsequence(map, array1, length1, array2, length2-1);
			
			char[] result;
			if(subLCS1.length>=subLCS2.length){
				result=subLCS1;
				
			}else{
				result=subLCS2;
			}
			map[length1][length2]=result;
			return result;
		}
	}
	
	/**
	 * @param result
	 * @param array
	 * @param position
	 * @return
	 */
	public static int [] findLongestIncreasingSubsequence(int [][]result, int [] array, int position){
		if(result[position]!=null){
			return result[position];
		}
		
		int [] lis=new int[1];
		lis[0]=array[position];
		
		for(int index=position-1;index>=0;index--){
			int [] subLis=findLongestIncreasingSubsequence(result, array, index);
			
			if(subLis[subLis.length-1]<array[position]){
				
				if(subLis.length+1>=lis.length){
					lis = new int[subLis.length+1];
					
					System.arraycopy(subLis, 0, lis, 0, subLis.length);
					lis[subLis.length]=array[position];
				}
			}else if(subLis.length>lis.length){
				lis=subLis;
			}
		}
		
		result[position]=lis;
		return lis;
	}
	
	
	/**
	 * @param result
	 * @param array
	 * @param position
	 * @return
	 */
	public static int [] findlongestDecreasingSubsequence(int [][] result, int [] array, int position){
		if(result[position]!=null){
			return result[position];
		}
		
		int [] lds =new int[1];
		lds[0]=array[position];
		
		for(int index=position+1;index<array.length;index++){
			int [] subLds=findlongestDecreasingSubsequence(result, array, index);
			
			if(array[index]<array[position]){
				
				if(subLds.length+1>=lds.length){
					lds=new int[subLds.length+1];
					lds[0]=array[position];
					System.arraycopy(subLds, 0, lds, 1, subLds.length);
				}
			}else if(subLds.length>lds.length){
				lds=subLds;
			}
		}
		
		result[position]=lds;
		return lds;
	}
	
	/**
	 * Given an array arr[0 ... n-1] containing n positive integers, a subsequence of arr[] is called Bitonic if it is first increasing, then decreasing. Write a function that takes an array as argument and returns the length of the longest bitonic subsequence.
	 * A sequence, sorted in increasing order is considered Bitonic with the decreasing part as empty. Similarly, decreasing order sequence is considered Bitonic with the increasing part as empty.
	 * 
	 * Examples:

	 * Input arr[] = {1, 11, 2, 10, 4, 5, 2, 1};
	 * Output: 6 (A Longest Bitonic Subsequence of length 6 is 1, 11, 10, 4, 2, 1)
	 * 
	 * Input arr[] = {12, 11, 40, 5, 3, 1}
	 * Output: 5 (A Longest Bitonic Subsequence of length 5 is 12, 11, 5, 3, 1)
	 * 
	 * Input arr[] = {80, 60, 30, 40, 20, 10}
	 * Output: 5 (A Longest Bitonic Subsequence of length 5 is 80, 60, 30, 20, 10)
	 * Source: Microsoft Interview Question
	 * @param array
	 * @return
	 */
	public static int [] findLongestBitonicSubsequence(int [] array){
		int [][] lisResult=new int[array.length][];
		findLongestIncreasingSubsequence(lisResult, array, array.length-1);
		
		int [][] ldsResult = new int[array.length][];
		findlongestDecreasingSubsequence(ldsResult, array, 0);
		
		int lbsLength=Integer.MIN_VALUE;
		int lbsIndex=0;
		
		for(int index=0;index<array.length;index++){
			int lisLength = lisResult[index]==null? 0: lisResult[index].length;
			int ldsLength = ldsResult[index]==null? 0: ldsResult[index].length;
			int value = lisLength+ldsLength-1;
			if(value>lbsLength){
				lbsLength=value;
				lbsIndex=index;
			}
		}
		
		int [] result = new int [lbsLength];
		System.arraycopy(lisResult[lbsIndex], 0, result, 0, lisResult[lbsIndex].length);
		System.arraycopy(ldsResult[lbsIndex], 1, result, lisResult[lbsIndex].length, ldsResult[lbsIndex].length-1);
		
		return result;
	}
	/**
	 * @param array
	 * @return
	 */
//	public static int [] findLongestIncreasingSubsequenceWithoutRecursion(int [] array){
//		int [] temp=new int [array.length];
//		int index=-1;
//		
//		
//		for(int i=0;i<array.length;i++){
//			if(index==-1 || array[i]>temp[index]){
//				temp[++index]=array[i];
//			}
//		}
//		
//		int [] lis =new int [index+1];
//		System.arraycopy(temp, 0, lis, 0, index+1);
//		
//		return lis;
//	}
	
	
	/**
	 * Find the subsequences whose elements should not be adjacent and their sum should be maximum from the given array (contains only positive integers).
	 * Eg: int[] A = {10, 1, 3, 25}
	 * Sol: Sum: {10, 3} = 13
	 * {1,25} = 26
	 * {10,25} = 35
	 * Here the Maximum subsequence is {10, 25}.
	 * @param array
	 * @return
	 */
	public static int [] findLargestNonConsecutiveSubArray(int [] array){
		boolean [] flags=new boolean[array.length];
		
		return findLargestNonConsecutiveSubArray(array, flags, 0);
	}
	
	private static int [] findLargestNonConsecutiveSubArray(int [] array, boolean[] flags, int position){
		if(position==array.length){
			return getSubArray(array, flags);
		}
		
		if(position==0 || !flags[position-1]){
			flags[position]=false;
			int[] result1 = findLargestNonConsecutiveSubArray(array, flags, position+1);

			flags[position]=true;
			int[] result2 = findLargestNonConsecutiveSubArray(array, flags, position+1);
			
			if(sum(result1)>=sum(result2)){
				return result1;
			}else{
				return result2;
			}
		}else{
			flags[position]=false;
			return findLargestNonConsecutiveSubArray(array, flags, position+1);
		}
	}
	
	private static int [] getSubArray(int [] array, boolean[] flags){
		int index=0;
		int [] temp=new int[array.length];
		
		for(int i=0;i<flags.length;i++){
			if(flags[i]){
				temp[index++]=array[i];
			}
		}
		
		int [] result=new int[index];
		System.arraycopy(temp, 0, result, 0, index);
		return result;
	}
	
	private static int sum(int []array){
		int sum=0;
		for(int i=0;i<array.length;i++){
			sum+=array[i];
		}
		return sum;
	}
}
