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
	
	/**
	 * @param d
	 * @param digits
	 * @param precision
	 * @return
	 */
	public static double getSquareRoot(double d, int digits,double precision){
		double start = 0;
		double end= d<1?1:d;
		
		while(start<end){
			double mid=start +(end-start)/2;
			
			double floats=mid - (int)mid;
			double shiftedFloats = Math.pow(10, digits)*floats;
			int round=(shiftedFloats - (int)shiftedFloats)>=0.5?1:0;
			int cutFloat=(int) shiftedFloats+round;
			double cutMid=(int)mid + cutFloat/Math.pow(10,digits);
			
			double square=cutMid*cutMid;
			if(Math.abs(square-d)<=precision){
				return cutMid;
			}else if(square>d){
				end=cutMid;
			}else{
				start=cutMid;
			}
		}
		
		return 0;
	}
	
	/**
	 * Given a set of non overlapping intervals
	 * Example 1 :(1,4) (6,10) (14, 19) and another interval (13, 17) merge them as (1,4) (6,10) (13,19)
	 * 
	 * Example 2: (1,5) (6, 15) (20, 21) (23, 26) (27, 30) (35, 40)
	 * New interval (14, 33)
	 * Output should be 
	 * (1,5) (6, 33) (35, 40)
	 * 
	 * This is because the new interval overlaps with (6, 15) (20, 21) (23, 26) (27, 30)
	 * 
	 * 
	 * @param intervals
	 * @param newInterval
	 * @return
	 */
	public static List<Pair> mergeNonOverlappingIntervalWithNewInterval(List<Pair> intervals, Pair addedInterval){
		List<Pair> result = new ArrayList<Pair>();
		
		int newStart=0;
		int newEnd=0;
		
		boolean merged=false;
		int previousEnd=Integer.MIN_VALUE;
		for(int index=0;index<intervals.size();index++){
			Pair interval=intervals.get(index);
					
			if(merged){
				result.add(interval);
			}else{
				if(addedInterval.getA()>previousEnd && addedInterval.getA()<=interval.getB()){
					newStart=Math.min(addedInterval.getA(), interval.getA());
				}
				
				if(addedInterval.getB()>previousEnd){ 
					if(addedInterval.getB()<interval.getA()){
						newEnd=addedInterval.getB();
					}else if(addedInterval.getB()<=interval.getB()){
						newEnd=Math.max(addedInterval.getB(), interval.getB());
					}
				}
				
				if(newStart==0 && newEnd==0){
					result.add(interval);
				}else if(newStart>0 && newEnd>0){
					result.add(new Pair(newStart, newEnd));
					
					if(addedInterval.getB()<interval.getA()){
						result.add(interval);
					}
					
					merged=true;
				}
			}
			
			previousEnd=interval.getB();
		}
		
		return result;
	}
	
	/**
	 * determine winner of 2/9 number game
	 * 
	 * Two players play the following game: they pick a random number N (less than 2 billion) then, 
	 * starting from 1, take turns multiplying the number from the previous turn with either 2 or 9 (their choice). 
	 * Whoever reaches N first wins. 
	 * The candidate should write a function that given N decides who wins (first or second player)?
	 * 
	 * @param n
	 * @return
	 */
	public static int findWinnerOf2and9Game(int n){
		return findWinnerOf2and9Game(n, 1, 1);
	}
	
	private static int findWinnerOf2and9Game(int n, int current, int player){
		if(current*2>=n){
			return player;
		}else if(current*9>=n){
			return player;
		}else {
			int nextPlayer=player==1?2:1;
			
			int result2 = findWinnerOf2and9Game(n, current*2, nextPlayer);
			if(result2==player){
				return player;
			}
			
			int result9 = findWinnerOf2and9Game(n, current*9, nextPlayer);
			if(result9==player){
				return player;
			}

			return nextPlayer;
		}
	}
	
	/**
	 * @param digits
	 * @return
	 */
	public static List<String> getAllPossibleStrFromPhoneDigits(int [] digits){
		char [][] possibleChars = new char[9][]; 

		int number=26;
		int avg=26/9+1;
		
		for(int i=0;i<9;i++){
			int count=number>=avg?avg:number;
			
			char [] candidate=new char[count];
			for(int j=0;j<count;j++){
				candidate[j]=(char) ('a'+i*avg+j);
			}
			possibleChars[i]=candidate;
			
			number=number-count;
		}
		
		List<String> result=new ArrayList<String>();
		char [] str = new char[digits.length];
		
		getAllPossibleStrFromPhoneDigits(result, possibleChars, digits, str, 0);
		
		return result;
		
	}
	
	private static void getAllPossibleStrFromPhoneDigits(List<String> result, char [][] possibleChars, int []  digits, char [] str, int position){
		if(position==digits.length){
			result.add(new String(str));
			return;
		}
		
		char[] cand=possibleChars[digits[position]-1];
		
		for(int i=0;i<cand.length;i++){
			str[position]=cand[i];
			
			getAllPossibleStrFromPhoneDigits(result, possibleChars, digits, str, position+1);
		}
	}
	
	/**
	 * suppose number 1-26 represent character a-z,please find all the possible translation when convert a number string to characters
	 * for example:
	 *    112 -> aab, al, kb
	 *    
	 *    102
	 *
	 * @param numberStr
	 * @return
	 */
	public static List<String> getAllPossibleStrFrom1To26Number(String numberStr){
		List<String> result=new ArrayList<String>();
		char[] chars=new char[numberStr.length()];
		
		getAllPossibleStrFrom1To26Number(result, chars, 0, numberStr, 0);
		
		return result;
	}
	
	private static void getAllPossibleStrFrom1To26Number(List<String> result, char[] chars, int position, String numberStr, int start){
		
		for(int end=start+1;end<=numberStr.length();end++){
			int number=Integer.parseInt(numberStr.substring(start, end));
			
			if(number>=1 && number<=26){
				chars[position]=(char) ('a'+number-1);
				
				if(end==numberStr.length()){
					result.add(new String(chars, 0, position+1));
				}else{
					getAllPossibleStrFrom1To26Number(result, chars, position+1, numberStr, end);
				}
			}else{
				break;
			}
		}
	}
	
	/**
	 * suppose number 1-26 represent character a-z,please find all the possible translation when convert a number string to characters
	 * for example:
	 *    112 -> aab, al, kb
	 *       ~
	 *      2
	 *     1
	 *     
	 *    102
	 *       ~
	 *      2
	 *     0
	 * @param numberStr
	 * @return
	 */
	public static int getPossibleStrNumFrom1To26NumberWithoutRecursion(String numberStr){
		int temp0=1;
		int temp1=numberStr.charAt(numberStr.length()-1)=='0'?0:1;
		
		int index=numberStr.length()-2;
		
		while(index>=0){
			char currentChar = numberStr.charAt(index);
			
			if(currentChar=='0'){
				temp0=temp1;
				temp1=0;
			}else if(currentChar>='1' && currentChar<='9'){
				int value2=Integer.parseInt(numberStr.substring(index, index+2));
				
				int temp=temp1;
				temp1=(value2<=26)?(temp0+temp1):temp1;
				temp0=temp;
			}else{
				return -1;
			}
			
			index--;
		}
		
		return temp1;
	}
	
	/**
	 * @return
	 */
	public static List<List<Integer>> findAllPossible8QueenPlacement(){
		List<List<Integer>> result=new ArrayList<List<Integer>>();
		
		int [] columns=new int[8];
		placeQueen(result, columns, 0);
		
		return result;
	}
	
	private static void placeQueen(List<List<Integer>> result, int [] columns, int row){
		if(row==columns.length){
			List<Integer> placement=new ArrayList<Integer>();
			for(int i=0;i<columns.length;i++){
				placement.add(columns[i]);
			}
			result.add(placement);
			return;
		}
		
		for(int column=0;column<=8;column++){
			boolean isValid=true;
			for(int previousRow=0;previousRow<row;previousRow++){
				if(column==columns[previousRow] || row-previousRow==Math.abs(column-columns[previousRow])){
					isValid=false;
					break;
				}
			}
			if(isValid){
				columns[row]=column;
				placeQueen(result, columns, row+1);
			}
		}
	}
}
