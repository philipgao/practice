package com.ssparrow.algorithm.dp;

import java.util.PriorityQueue;

public class MedianKeeper {
	private PriorityQueue<Integer> maxheap=new PriorityQueue<Integer>();
	private PriorityQueue<Integer> minHeap=new PriorityQueue<Integer>();
	
	public void addNumber(int number){
		if(maxheap.size()==minHeap.size()){
			if(minHeap.peek()!=null && number>minHeap.peek()){
				maxheap.offer(minHeap.poll());
				minHeap.offer(number);
			}else{
				maxheap.offer(number);
			}
		}else{
			if(maxheap.peek()!=null && number<maxheap.peek()){
				minHeap.offer(maxheap.poll());
				maxheap.offer(number);
			}else{
				minHeap.offer(number);
			}
		}
	}
	
	public int getMedian(){
		if(maxheap.isEmpty()){
			return 0;
		}
		
		if(maxheap.size()==minHeap.size()){
			return (maxheap.peek()+minHeap.peek())/2;
		}else{
			return maxheap.peek();
		}
	}

}
