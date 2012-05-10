package com.ssparrow.algorithm.heap;

public interface Heap {

	public abstract int[] getData();

	public abstract void setData(int[] array);

	public abstract int getHeapSize();

	public abstract void setHeapSize(int heapSize);

	public abstract void buildHeap();

	public abstract void heapify(int index);

	public abstract int getTopValue();

	public abstract int getValue(int index);

	public abstract void setValue(int index, int value);

}