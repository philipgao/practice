package com.ssparrow.afi.ch03metaalgorithm;

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
	
}
