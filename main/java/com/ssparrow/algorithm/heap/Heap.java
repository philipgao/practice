package com.ssparrow.algorithm.heap;

public interface Heap<T extends Comparable<? super T>> {

	public abstract T[] getData();

	public abstract void setData(T[] array);

	public abstract int getHeapSize();

	public abstract void setHeapSize(int heapSize);

	public abstract void buildHeap();

	public abstract void heapify(int index);

	public abstract T getTopValue();

	public abstract T getValue(int index);

	public abstract void setValue(int index, T value);

	public abstract T peek();

	public abstract T pop();

	public abstract void push(T value);
}