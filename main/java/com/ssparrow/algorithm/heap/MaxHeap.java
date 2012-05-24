package com.ssparrow.algorithm.heap;

public class MaxHeap<T extends Comparable<? super T>> extends AbstractHeap<T> {
	
	public MaxHeap(int maxSize) {
		super(maxSize);
	}

	public MaxHeap(T[] array){
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
