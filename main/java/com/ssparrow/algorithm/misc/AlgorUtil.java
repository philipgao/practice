package com.ssparrow.algorithm.misc;

import java.util.Arrays;
import java.util.Random;

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
	
	public static void shuffleCards(int []array){
		for(int i=0;i<array.length; i++){
			int index=new Random().nextInt(52-i)+i;
			
			int tmp=array[i];
			array[i]=array[index];
			array[index]=tmp;
		}
		System.out.println(Arrays.toString(array));
	}
	
	
	/**
	 * @param a
	 * @param b
	 * @return
	 */
	public static int addTwoNumbers(int a, int b){
		if(b==0){
			return a;
		}
		
		int sumWithoutCarry=a^b;
		int carryOnly=(a&b)<<1;
		
		return addTwoNumbers(sumWithoutCarry, carryOnly);
	}
}
