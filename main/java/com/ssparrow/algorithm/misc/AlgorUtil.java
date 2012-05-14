package com.ssparrow.algorithm.misc;

public class AlgorUtil {
	/**
	 * @param a
	 * @param b
	 * @return
	 */
	public static Pair swap(int a, int b){
		a=a^b;
		b=a^b;
		a=a^b;
		
		return new Pair(a,b);
	}
	
	/**
	 * @param n
	 * @return
	 */
	public static int findNumerOfZeros(int n){
		if(n<0){
			return -1;
		}
		
		int count=0;
		
		for(int i=5; n/i>0;i*=5){
			count+=n/i;
		}
		
		return count;
	}
	
	public static class Pair{
		int a;
		int b;
		
		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}

		public int getA() {
			return a;
		}

		public int getB() {
			return b;
		}
		
	}
}
