package com.ssparrow.algorithm.heap;

public class MinHeap<T extends Comparable<? super T>> extends AbstractHeap<T> {
	public MinHeap(int maxSize) {
		super(maxSize);
	}
	
	public MinHeap(T[] array){
		super.setData(array);
	}
	
	/* (non-Javadoc)
	 * @see com.ssparrow.algorithm.heap.Heap#heapify(int)
	 */
	public void heapify(int index){
		this.heapify(index, false);
	}
}
