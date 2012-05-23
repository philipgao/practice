package com.ssparrow.algorithm.heap;

public abstract class AbstractHeap<T extends Comparable<? super T>>  implements Heap{

	protected Comparable[] data;
	protected int heapSize;

	public AbstractHeap() {
		super();
	}
	
	public AbstractHeap(T[] array){
		this.setData(array);
	}

	@Override
	public Comparable[] getData() {
		return data;
	}

	@Override
	public void setData(Comparable[] array) {
		data=new Comparable[array.length];
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
	public Comparable getTopValue() {
		return this.getValue(0);
	}

	@Override
	public Comparable getValue(int index) {
		return data[index];
	}

	@Override
	public void setValue(int index, Comparable value) {
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
	

	protected void heapify(int index, boolean isMaxHeap){
		if(index>=heapSize){
			return;
		}
		
		int topIndex=index;
		
		if(left(index)<heapSize){
			boolean compareLeft = isMaxHeap? (data[left(index)].compareTo(data[index])>0):(data[left(index)].compareTo(data[index])<0);
			if(compareLeft){
				topIndex=left(index);
			}
		}
		
		if(right(index)<heapSize){
			boolean compareRight = isMaxHeap?(data[right(index)].compareTo(data[topIndex])>0):(data[right(index)].compareTo(data[topIndex])<0);
			if(compareRight){
				topIndex=right(index);
			}
		}
		if(topIndex!=index){
			Comparable tmp=data[index];
			data[index]=data[topIndex];
			data[topIndex]=tmp;
			
			heapify(topIndex);
		}
	}
}