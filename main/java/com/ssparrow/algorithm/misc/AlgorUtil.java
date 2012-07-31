package com.ssparrow.algorithm.misc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

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
	
	public static BigDecimal power(double a, int b){
		if(b==0){
			return new BigDecimal(1);
		}
		
		BigDecimal base = new BigDecimal(a);
		BigDecimal result=base;
		for (int i = 1; i < b; i++) {
			result = result.multiply(base);
		}
		return result;
	}
	
	/**
	 * Given a number n, find all primes smaller than or equal to n. It is also given that n is a small number.
	 * For example, if n is 10, the output should be “2, 3, 5, 7″. If n is 20, the output should be “2, 3, 5, 7, 11, 13, 17, 19″.
	 * 
	 * Here we are using Sieve of Eratosthenes, a simple, ancient algorithm, with the following steps
	 * 	1.Create a list of consecutive integers from 2 to n: (2, 3, 4, ..., n).
	 * 	2.Initially, let p equal 2, the first prime number.
	 * 	3.Starting from p, count up in increments of p and mark each of these numbers greater than p itself in the list. These numbers will be 2p, 3p, 4p, etc.; note that some of them may have already been marked.
	 * 	4. Find the first number greater than p in the list that is not marked. If there was no such number, stop. Otherwise, let p now equal this number (which is the next prime), and repeat from step 3.
	 * 
	 * @param n
	 * @return
	 */
	public static int [] findAllPrimeNumber(int n){
		int [] temp =new int [n];
		int index=0;
		
		int prime=2;
		boolean [] flags= new boolean[n+1];

		while(prime<=n){
			temp[index++]=prime;
			
			for(int i=2;i*prime<=n;i++){
				flags[i*prime]=true;
			}
			
			boolean found=false;
			for(int i=prime+1; i<=n;i++){
				if(!flags[i]){
					prime=i;
					found=true;
					break;
				}
			}
			
			if(!found){
				break;
			}
		}
		
		int [] result = new int[index];
		System.arraycopy(temp, 0, result, 0, index);
		
		return result;
	}
	
	/**
	 * You are given a number of points on the XY-plane, [(x0,y0),(x1,y1),(x2,y2),...].
	 * A point (xi,yi) is dominant to another point (xj,yj) iff xi>xj and yi>yj.
	 * Calculate all pairs of points such that one dominates the other.
	 * 
	 * A time complexity less then O(n*n) was required.
	 * @param points
	 * @return
	 */
	public static Set<PointPair> findAllDominatePairs(List<Point> points){
		Set<PointPair> result = new HashSet<PointPair>();
		
		Comparator<Point> xComparator=new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				return o1.getX()-o2.getX();
			}
		};
		
		List<Point> xSortedPoints= new ArrayList<Point>(points);
		Collections.sort(xSortedPoints, xComparator);
		
		for(int i=xSortedPoints.size()-1;i>=0;i--){
			Point point1=xSortedPoints.get(i);
			
			for(int j=i-1;j>=0;j--){
				Point point2 = xSortedPoints.get(j);
				
				if(point2.getX()<point1.getX() && point2.getY()<point1.getY()){
					result.add(new PointPair(point1, point2));
				}
			}
		}
		
		return result;
	}
}
