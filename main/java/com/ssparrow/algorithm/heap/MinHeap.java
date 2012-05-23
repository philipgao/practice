package com.ssparrow.algorithm.heap;

public class MinHeap extends AbstractHeap {
	public MinHeap(Comparable[] array){
		super.setData(array);
	}
	
	/* (non-Javadoc)
	 * @see com.ssparrow.algorithm.heap.Heap#heapify(int)
	 */
	public void heapify(int index){
		this.heapify(index, false);
	}
}
