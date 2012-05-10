package com.ssparrow.algorithm.heap;

public abstract class AbstractHeap  implements Heap{

	protected int[] data;
	protected int heapSize;

	public AbstractHeap() {
		super();
	}
	
	public AbstractHeap(int[] array){
		this.setData(array);
	}

	@Override
	public int[] getData() {
		return data;
	}

	@Override
	public void setData(int[] array) {
		data=new int[array.length];
		this.heapSize=array.length;
		System.arraycopy(array, 0, data, 0, array.length);
		
		buildHeap();
	}

	@Override
	public int getHeapSize() {
		return heapSize;
	}

	@Override
	public void setHeapSize(int heapSize) {
		this.heapSize = heapSize;
	}

	private int parent(int index) {
		return index/2;
	}

	protected int left(int index) {
		return 2*index;
	}

	protected int right(int index) {
		return 2*index+1;
	}

	@Override
	public int getTopValue() {
		return this.getValue(0);
	}

	@Override
	public int getValue(int index) {
		return data[index];
	}

	@Override
	public void setValue(int index, int value) {
		data[index]=value;
	}
	
	/* (non-Javadoc)
	 * @see com.ssparrow.algorithm.heap.Heap#buildHeap()
	 */
	@Override
	public void buildHeap(){
		for(int index=data.length/2;index>=0;index--){
			heapify(index);
		}
	}
}