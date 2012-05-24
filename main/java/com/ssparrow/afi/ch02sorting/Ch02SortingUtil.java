 package com.ssparrow.afi.ch02sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

import com.ssparrow.algorithm.heap.MinHeap;
import com.ssparrow.algorithm.misc.Pair;

public class Ch02SortingUtil {
	/**
	 * find min and max simultaneously, the comparison should be less than 3n/2-1 
	 * @param array
	 * @return
	 */
	public static Pair p204FindMinMax(int [] array){
		int length = array.length;
		int [] upArray =new int[length/2];
		int [] downArray=new int[length/2];
		
		int upIndex=0;
		int downIndex=0;
		for(int index=0;index<length-1;index+=2){
			upArray[upIndex++]=Math.max(array[index], array[index+1]);
			downArray[downIndex++]=Math.min(array[index], array[index+1]);
		}
		
		int max=Integer.MIN_VALUE;
		int min=Integer.MAX_VALUE;
		
		for (upIndex = 0; upIndex < upArray.length; upIndex++) {
			if(upArray[upIndex]>max){
				max=upArray[upIndex];
			}
		}
		
		for (downIndex = 0; downIndex < downArray.length; downIndex++) {
			if(downArray[downIndex]<min){
				min=downArray[downIndex];
			}
		}
		
		if(length%2==1){
			if(array[length-1]>max){
				max=array[length-1];
			}else if(array[length-1]<min){
				min=array[length-1];
			}
		}
		
		return new Pair(min, max);
	}
	
	/**
	 * @param array
	 * @return
	 */
	public static int[] p209RemoveDuplicateItems(int [] array){
		int j=0;
		
		for(int i=1;i<array.length;i++){
			if(array[i]!=array[j]){
				array[++j]=array[i];
			}
		}
		
		int [] result=new int[j+1];
		System.arraycopy(array, 0, result, 0, j+1);
		return result;
	}
	
	/**
	 * @throws Exception 
	 * 
	 */
	public static void p210MergeStockQuotes(String output) throws Exception{
		BufferedReader reader1=new BufferedReader(new FileReader("test/data/ch02/p210/stocklist1.txt"));
		BufferedReader reader2=new BufferedReader(new FileReader("test/data/ch02/p210/stocklist2.txt"));
		BufferedReader reader3=new BufferedReader(new FileReader("test/data/ch02/p210/stocklist3.txt"));
		
		BufferedReader[] readers=new BufferedReader[]{reader1, reader2, reader3};
		
		BufferedWriter writer=new BufferedWriter(new FileWriter(output));
		
		String line1=reader1.readLine();
		String line2=reader2.readLine();
		String line3=reader3.readLine();
		
		MinHeap<StockQuote> minHeap=new MinHeap<StockQuote>(3);
		minHeap.push(new StockQuote(1,line1));
		minHeap.push(new StockQuote(2,line2));
		minHeap.push(new StockQuote(3,line3));
		
		String line=null;;
		do{
			StockQuote quote = minHeap.peek();
			writer.write(quote.getQuote());
			writer.newLine();
			writer.flush();
			
			int fileIndex = quote.getFileIndex();
			int begin=fileIndex;
			boolean isLoop=false;
			
			while((line=readers[fileIndex-1].readLine())==null){
				fileIndex++;
				
				if(fileIndex>3){
					isLoop=true;
				}
				
				fileIndex = (fileIndex<=3?fileIndex:fileIndex%3);
				
				if(isLoop && fileIndex>=begin){
					break;
				}
			}
			
			if(line!=null){
				minHeap.setValue(0, new StockQuote(fileIndex, line));
				minHeap.heapify(0);
			}
			
		}while(line!=null);
		
		minHeap.pop();
		
		while(minHeap.getHeapSize()>0){
			StockQuote quote = minHeap.pop();
			writer.write(quote.getQuote());
			writer.newLine();
			writer.flush();
		}
	}
	
}
