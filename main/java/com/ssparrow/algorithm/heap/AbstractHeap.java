package com.ssparrow.algorithm.heap;

public abstract class AbstractHeap<T extends Comparable<? super T>>  implements Heap<T>{

	protected Object[] data;
	protected int heapSize=0;

	public AbstractHeap() {
		super();
	}
	
	public AbstractHeap(int maxSize){
		data=new Object[maxSize];
	}
	
	public AbstractHeap(T[] array){
		this.setData(array);
	}

	@Override
	public T[] getData() {
		return (T[]) data;
	}

	@Override
	public void setData(T[] array) {
		data=new Object[array.length];
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
	public T getTopValue() {
		return this.getValue(0);
	}

	@Override
	public T getValue(int index) {
		return (T) data[index];
	}

	@Override
	public void setValue(int index, T value) {
		data[index]=value;
	}
	
	/* (non-Javadoc)
	 * @see com.ssparrow.algorithm.heap.Heap#buildHeap()
	 */
	@Override
	public void buildHeap(){
		for(int index=heapSize/2;index>=0;index--){
			heapify(index);
		}
	}
	
	@Override
	public T peek() {
		if(heapSize>0){
			return (T) data[0];
		}
		return null;
	}

	@Override
	public T pop() {
		if(heapSize>0){
			T top = (T) data[0];
			
			data[0]=data[heapSize-1];
			heapSize--;
			heapify(0);
			
			return top;
		}
		return null;
	}

	@Override
	public void push(T value) {
		if(heapSize==data.length){
			return;
		}
		
		data[heapSize]=value;
		heapSize++;
		buildHeap();
	}

	protected void heapify(int index, boolean isMaxHeap){
		if(index>=heapSize){
			return;
		}
		
		int topIndex=index;
		
		if(left(index)<heapSize){
			boolean compareLeft = isMaxHeap? (((T)data[left(index)]).compareTo((T)data[index])>0):(((T)data[left(index)]).compareTo((T)data[index])<0);
			if(compareLeft){
				topIndex=left(index);
			}
		}
		
		if(right(index)<heapSize){
			boolean compareRight = isMaxHeap?(((T)data[right(index)]).compareTo((T)data[topIndex])>0):(((T)data[right(index)]).compareTo((T)data[topIndex])<0);
			if(compareRight){
				topIndex=right(index);
			}
		}
		if(topIndex!=index){
			T tmp=(T) data[index];
			data[index]=data[topIndex];
			data[topIndex]=tmp;
			
			heapify(topIndex);
		}
	}
	
	
}