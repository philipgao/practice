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
	

	
	public static char[] findLongestCommonSubsequence(char[][][] map,char[] array1, int length1,char array2[], int length2){
		System.out.println(length1+":"+length2);
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
}
