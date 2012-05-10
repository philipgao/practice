package com.ssparrow.algorithm.heap;

public class MinHeap extends AbstractHeap {
	public MinHeap(int[] array){
		super.setData(array);
	}
	
	/* (non-Javadoc)
	 * @see com.ssparrow.algorithm.heap.Heap#heapify(int)
	 */
	public void heapify(int index){
		if(index>=heapSize){
			return;
		}
		
		int smallest=index;
		if(left(index)<heapSize && data[left(index)]<data[index]){
			smallest=left(index);
		}
		if(right(index)<heapSize && data[right(index)]<data[smallest]){
			smallest=right(index);
		}
		if(smallest!=index){
			int tmp=data[index];
			data[index]=data[smallest];
			data[smallest]=tmp;
			
			heapify(smallest);
		}
	}
}
