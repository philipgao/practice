package com.ssparrow.algorithm.heap;

public class MaxHeap extends AbstractHeap {
	public MaxHeap(Comparable[] array){
		super.setData(array);
	}
	
	/* (non-Javadoc)
	 * @see com.ssparrow.algorithm.heap.Heap#heapify(int)
	 */
	@Override
	public void heapify(int index){
		this.heapify(index, true);
	}
}
