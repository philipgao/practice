package com.ssparrow.algorithm.heap;

public interface Heap<T extends Comparable<? super T>> {

	public abstract Comparable[] getData();

	public abstract void setData(Comparable[] array);

	public abstract int getHeapSize();

	public abstract void setHeapSize(int heapSize);

	public abstract void buildHeap();

	public abstract void heapify(int index);

	public abstract Comparable getTopValue();

	public abstract Comparable getValue(int index);

	public abstract void setValue(int index, Comparable value);

}