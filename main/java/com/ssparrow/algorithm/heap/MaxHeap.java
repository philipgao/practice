package com.ssparrow.algorithm.heap;

public class MaxHeap extends AbstractHeap {
	public MaxHeap(int[] array){
		super.setData(array);
	}
	
	/* (non-Javadoc)
	 * @see com.ssparrow.algorithm.heap.Heap#heapify(int)
	 */
	@Override
	public void heapify(int index){
		if(index>=heapSize){
			return;
		}
		
		int largest=index;
		if(left(index)<heapSize && data[left(index)]>data[index]){
			largest=left(index);
		}
		if(right(index)<heapSize && data[right(index)]>data[largest]){
			largest=right(index);
		}
		if(largest!=index){
			int tmp=data[index];
			data[index]=data[largest];
			data[largest]=tmp;
			
			heapify(largest);
		}
	}
}
