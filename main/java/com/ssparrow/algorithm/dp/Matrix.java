package com.ssparrow.algorithm.dp;

public class Matrix {
	private int[][] data;

	public Matrix(int[][] data) {
		this.data = data;
	}
	
	public int getRowSize(){
		return data.length;
	}
	
	public int getColumnSize(){
		return data[0].length;
	}
}
