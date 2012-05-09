package com.ssparrow.algorithm.array;

public final class ArrayUtil {
	/**
	 * @param array
	 * @param start
	 * @param end
	 */
	public static void quickSort(int[]array, int start, int end){
		if(start>=end){
			return;
		}
		
		int partition=partition(array, start, end);
		quickSort(array, start, partition-1);
		quickSort(array, partition, end);
	}
	
	private static int partition(int[]array,int start, int end){
		
		int pivot=array[end];
		int j=start-1;
		
		for(int index=start;index<end;index++){
			if(array[index]<=pivot){
				j++;
				
				int tmp=array[index];
				array[index]=array[j];
				array[j]=tmp;
			}
		}
		
		array[end]=array[j+1];
		array[j+1]=pivot;
		
		return j+1;
	}
	
	/**
	 * @param array
	 * @param start
	 * @param end
	 * @param k
	 * @return
	 */
	public static int findKthNumber(int[] array, int start, int end,int k){
		int partition=partition(array, start, end);
		
		if(partition==k-1){
			return array[partition];
		}else if(partition>k-1){
			return findKthNumber(array, 0, partition,k);
		}else{
			return findKthNumber(array, partition+1, end,k-partition-1);
		}
	}
	

	/**
	 * @param array
	 * @return
	 */
	public static int[] insertSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int j = i - 1;
			int k = array[i];
			while (j >= 0 && array[j] > k) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = k;
		}
		return array;
	}

	/**
	 * @param array
	 * @param start
	 * @param end
	 */
	public static void mergeSort(int[] array, int start, int end) {
		if (start >= end) {
			return;
		}

		int mid = (start + end) / 2;
		mergeSort(array, start, mid);
		mergeSort(array, mid + 1, end);
		merge(array, start, end, mid);
	}

	/**
	 * @param array
	 * @param start
	 * @param end
	 * @param mid
	 */
	private static void merge(int[] array, int start, int end, int mid) {
		int leftLen = mid - start + 1;
		int[] left = new int[leftLen + 1];

		int rightLen = end - mid;
		int[] right = new int[rightLen + 1];

		System.arraycopy(array, start, left, 0, leftLen);
		System.arraycopy(array, mid + 1, right, 0, rightLen);

		left[leftLen] = Integer.MAX_VALUE;
		right[rightLen] = Integer.MAX_VALUE;

		int i = 0, j = 0, k = start;

		while (k <= end) {
			if (left[i] <= right[j]) {
				array[k++] = left[i++];
			} else {
				array[k++] = right[j++];
			}
		}
	}

    /**
     * @param array
     */
	public static void heapSort(int[] array) {
		buildMaxHeap(array);

		int heapSize = array.length;
		for(int i=array.length-1;i>=1;i--) {
			int max = array[0];
			array[0] = array[i];
			array[i] = max;

			heapSize--;
			maxHeapify(array, 0, heapSize);
		}
	}

//	private static int heapParent(int i) {
//		return i / 2;
//	}

	private static int heapLeft(int i) {
		return 2 * i;
	}

	private static int heapRight(int i) {
		return 2 * i + 1;
	}
    
	private static void maxHeapify(int[] array, int i, int heapSize) {
		int largest = i;

		int left = heapLeft(i);
		int right = heapRight(i);
		if (left < heapSize && array[left] > array[largest]) {
			largest = left;
		}
		if (right < heapSize && array[right] > array[largest]) {
			largest = right;
		}
		if (largest != i) {
			int tmp = array[largest];
			array[largest] = array[i];
			array[i] = tmp;

			maxHeapify(array, largest, heapSize);
		}
	}

	private static void buildMaxHeap(int[] array) {
		for (int i = array.length / 2; i >= 0; i--) {
			maxHeapify(array, i, array.length);
		}
	}
    
    
    /**
     * @param array
     */
	public static void bubbleSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = array.length - 2; j >= i; j--) {
				if (array[j + 1] < array[j]) {
					int tmp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = tmp;
				}
			}
		}
	}
	
	/**
	 * rotate matrix clockwise
	 * 
	 * @param matrix
	 * @param n
	 */
	public static void rotateMatrix(int[][]matrix, int n){
		for(int layer=0;layer<n/2;layer++){
			int first=layer;
			int last =n-layer-1;
			for(int i=first;i<last;i++){
				int offset=i-first;
				
				int top=matrix[first][i];
				
				matrix[first][i]=matrix[last-offset][first];
				matrix[last-offset][first]=matrix[last][last-offset];
				matrix[last][last-offset]=matrix[i][last];
				matrix[i][last]=top;
			}
		}
	}
}
