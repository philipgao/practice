package com.ssparrow.projecteuler;

public class ProjectEuler {

	/**
	 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. 
	 * The sum of these multiples is 23.
	 * 
	 * Find the sum of all the multiples of 3 or 5 below 1000.
	 * @param n
	 * @return
	 */
	public static int p001Find3or5MultipleSum(int n){
		int sum=0;
		
		int threeMultiple=0;
		int fiveMultiple=0;
		
		while(threeMultiple+3<n || fiveMultiple+5<n){
			if(threeMultiple+3==fiveMultiple){
				threeMultiple=threeMultiple+3;
			}else if(threeMultiple+3<=fiveMultiple+5){
				threeMultiple=threeMultiple+3;
				sum+=threeMultiple;
			}else if(fiveMultiple+5==threeMultiple){
				fiveMultiple=fiveMultiple+5;
			}else if(fiveMultiple+5<threeMultiple+3){
				fiveMultiple=fiveMultiple+5;
				sum+=fiveMultiple;
			}
			
			if(threeMultiple+3>=n && fiveMultiple+5>=n){
				break;
			}
		}
		
		return sum;
		
	}
	
	/**
	 * Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:
	 *
	 *					1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
	 *
	 *By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
	 * 
	 * @param n
	 * @return
	 */
	public static int p002FindEvenFibonacciNumberSum(int n){
		int f1=1;
		int f2=2;
		
		if(n<2){
			return 0;
		}
		
		int sum=2;
		int f=f1+f2;
		while(f<=n){
			if(f%2==0){
				sum+=f;
			}
			
			f1=f2;
			f2=f;
			f=f1+f2;
		}
		
		return sum;
	}
}
