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
}
