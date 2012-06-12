package com.ssparrow.algorithm.array;

import com.ssparrow.algorithm.misc.Pair;

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
	  
	/**
	 * @param array
	 * @param column
	 */
	public static int[][] convertArrayToMatrix(int[] array, int column) {
		int[][] result;
		
		int surplus = array.length % column;
		int deficit = column * (array.length / column + 1) - array.length;

		if (surplus <= deficit) {
			int row = array.length / column;
			result=new int[row+surplus][column];

			for (int i = 0; i < row+surplus; i++) {
				for (int j = 0; j < column; j++) {
					if(i<row){
						int index = (j == 0) ? i : j * row + surplus + i;
						result[i][j]=array[index];
					}else if(j==0){
						result[i][j] = array[i];
					}else{
						result[i][j]=0;
					}
				}
			}
		} else {
			int row = array.length / column + 1;
			result=new int[row][column];

			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column; j++) {
					if (j == 0 && i >= row - deficit) {
						result[i][j]=0;
					}else{
						int index = (j == 0) ? i : j * row - deficit + i;
						result[i][j]=array[index];
					}
				}
			}
		}
		
		return result;
	}
	
	/**
	 * @param array
	 * @param value
	 * @return
	 */
	public static int searchInRtatedArray(int [] array, int value){
		int start=0;
		for(int index=0;index<array.length-1;index++){
			if(array[index]>array[index+1]){
				start=index+1;
				break;
			}
		}
		
		return binarySearchInRtatedArray(array, value, start, array.length+start-1);
	}
	
	private static int binarySearchInRtatedArray(int [] array, int value, int start, int end){
		if(start>end){
			return -1;
		}
			
		int mid=start+(end-start)/2;
		int midIndex = (mid<array.length)? mid: (mid-1)%(array.length-1);
		if(array[midIndex]==value){
			return midIndex;
		}else if(array[midIndex]>value){
			return binarySearchInRtatedArray(array, value, start, mid-1);
		}else{
			return binarySearchInRtatedArray(array, value, mid+1, end);
		}
	}
	
	/**
	 * @param matrix
	 * @param value
	 * @param rowStart
	 * @param rowEnd
	 * @param columnStart
	 * @param columnEnd
	 * @return
	 */
	public static Pair searchInSortedMatrix(int[][] matrix, int value, int rowStart, int rowEnd, int columnStart, int columnEnd){
		if(rowStart>rowEnd || columnStart>columnEnd
				||rowStart<0||rowEnd<0
				||rowStart>=matrix.length||rowEnd>=matrix.length
				||columnStart<0||columnEnd<0
				||columnStart>=matrix[0].length||columnEnd>=matrix[0].length){
			return null;
		}
		
		int rowSpan=rowEnd-rowStart+1;
		int columnSpan=columnEnd-columnStart+1;
		
		if(rowSpan<columnSpan){
			searchInSortedMatrix(matrix, value, rowStart, rowEnd, columnStart+rowSpan, columnEnd);
			columnEnd=columnStart+rowSpan-1;
		}else if(rowSpan>columnSpan){
			searchInSortedMatrix(matrix, value, rowStart+columnSpan, rowEnd, columnStart, columnEnd);
			rowEnd=rowStart+rowSpan-1;
		}
		
		
		int rowMid=rowStart+(rowEnd-rowStart)/2;
		int columnMid=columnStart+(columnEnd-columnStart)/2;
		
		if(matrix[rowMid][columnMid]==value){
			return new Pair(rowMid, columnMid);
		}
		
		
		int row=rowMid;
		int column=columnMid;
		
		if(matrix[rowMid][columnMid]>value){
			while(row>=0 && column>=0 && matrix[row][column]>value){
				row--;
				column--;
			}
		}else{
			while( row<matrix.length && column<matrix[0].length && matrix[row][column]<value){
				row++;
				column++;
			}
			row=row-1;
			column=column-1;
		}
		
		Pair result = searchInSortedMatrix(matrix, value, row+1, rowEnd, columnStart, column);
		if(result==null){
			result=searchInSortedMatrix(matrix, value, rowStart, row, column+1, columnEnd);
		}
		
		return result;
	}
	
	
	public static int findLongestDistance(int[] array){
	        
	        int [] candidates=new int[array.length];
	        int [] oriIndex=new int[array.length];
	        
	        int index=0;
	        int minimum=Integer.MAX_VALUE;
	        for(int i=0;i<array.length;i++){
	            if(array[i]<minimum){
	                minimum=array[i];
	                candidates[index]=array[i];
	                oriIndex[index++]=i;
//	                System.out.println(array[i]);
	            }
	        }
	        
	        for(int i=1;i<index;i++){
	            int tmp=candidates[i];
	            int tmpIndex=oriIndex[i];
	            int j=i-1;
	            while(j>=0&&candidates[j]>tmp){
	        	candidates[j+1]=candidates[j];
	        	oriIndex[j+1]=oriIndex[j];
	        	j--;
	            }
	            candidates[j+1]=tmp;
	            oriIndex[j+1]=tmpIndex;
	        }
	        
	        int k=0;
	        int max=Integer.MIN_VALUE;
	        for(int i=array.length-1;i>=0&&k<index;i--){
	            while(k<index && array[i]>candidates[k]){
	        	int span=i-oriIndex[k];
	        	if(span>max){
	        	    max=span;
	        	}
	        	
	        	k++;
	            }
	        }
	        
	        return max;
	}
	
	/**
	 * find subarray in a given array that has the max sum
	 * the input array has both position number and negative number
	 * @param array
	 * @return
	 */
	public static Pair findMaxSum(int [] array){
		int start=0;
		int end=0;
		int max=0;
		
		int runningStart=0;
		int runningSum=0;
		
		for (int index = 0; index < array.length; index++) {
			runningSum=runningSum+array[index];
			if(runningSum<=0){
				if(runningStart<array.length-1){
					runningStart=index+1;
				}
				runningSum=0;
				continue;
			}
			
			if(runningSum>max){
				max=runningSum;
				
				start=runningStart;
				end=index;
			}
		}
				
		return new Pair(start, end);
	}
	
	
	/**
	 * There is an array A[N] of N numbers. 
	 * You have to compose an array Output[N] such that Output[i] will be equal to multiplication of all the elements of A[N] except A[i]. 
	 * For example Output[0] will be multiplication of A[1] to A[N-1] and Output[1] will be multiplication of A[0] and from A[2] to A[N-1]
	 * 
	 * this solution use O(n) space and O(n) time
	 * @param array
	 * @return
	 */
	public static int[] multiplyNumbersInArray(int [] array){
		int [] left=new int[array.length];
		int [] right=new int[array.length];
		
		left[0]=1;
		for(int index=1;index<array.length;index++){
			left[index]=left[index-1]*array[index-1];
		}
		
		right[array.length-1]=1;
		for(int index=array.length-2;index>=0;index--){
			right[index]=right[index+1]*array[index+1];
		}
		
		int [] result=new int[array.length];
		for(int index=0;index<array.length;index++){
			result[index]=left[index]*right[index];
		}
		
		return result;
	}
	
	/**
	 * this solution only O(1) space and O(n) time
	 * 
	 * @param array
	 * @return
	 */
	public static int [] multiplyNumbersInArrayWIthNoExtraSpace(int [] array){
		int left=1;
		int right=1;
		
		int [] result=new int[array.length];
		for(int index=0;index<array.length;index++){
			result[index]=1;
		}
		
		for(int index=0; index<array.length; index++){
			result[index]*=left;
			result[array.length-index-1]*=right;
			
			left*=array[index];
			right*=array[array.length-index-1];
		}
		
		return result;
	}
	
}
