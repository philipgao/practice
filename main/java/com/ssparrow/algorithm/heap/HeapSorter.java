package com.ssparrow.algorithm.heap;

public class HeapSorter {
	
	public static int[] sortWithMaxHeap(int[] array){
		int[] result=new int[array.length];
		MaxHeap maxHeap=new MaxHeap(array);
		
		int index=result.length-1;
		while(index>=1){
			result[index]=maxHeap.getTopValue();
			
			maxHeap.setValue(0, maxHeap.getValue(maxHeap.getHeapSize()-1));
			maxHeap.setHeapSize(maxHeap.getHeapSize()-1);
			maxHeap.heapify(0);
			
			index--;
		}
		result[0]=maxHeap.getTopValue();
		
		return result;
	}
	
	public static int[] sortWithMinHeap(int[] array){
		int[] result=new int[array.length];
		MinHeap minHeap=new MinHeap(array);
		
		int index=0;
		while(index<result.length-1){
			result[index]=minHeap.getTopValue();

			minHeap.setValue(0, minHeap.getValue(minHeap.getHeapSize()-1));
			minHeap.setHeapSize(minHeap.getHeapSize()-1);
			minHeap.heapify(0);
			
			index++;
		}
		result[result.length-1]=minHeap.getTopValue();
		
		return result;
	}
}
