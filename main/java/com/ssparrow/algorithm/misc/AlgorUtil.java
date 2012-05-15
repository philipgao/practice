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
	
	/**
	 * @param number
	 * @return
	 */
	public static int count2InRange(int number){
		int length = String.valueOf(number).length();
		
		int sum=0;
		for(int digit=0;digit<length;digit++){
			sum+=count2InRangeAtDigit(number, digit);
		}
		
		return sum;
	}
	
	private static int count2InRangeAtDigit(int number, int d){
		int power10=(int) Math.pow(10, d);
		int nextPower10=(int) Math.pow(10, d+1);
		
		int value=(number/power10)%10;
		
		if(value<2){
			return ((number/nextPower10)%10)*nextPower10/10;
		}else if(value>2){
			return ((number/nextPower10)%10+1)*nextPower10/10;
		}else{
			return ((number/nextPower10)%10)*nextPower10/10+number%power10+1;
		}
	}
}
