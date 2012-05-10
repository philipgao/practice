package com.ssparrow.algorithm.stack;

public class Stack {
	private int[] array;
	private int pointer;
	
	public Stack(){
		array=new int[100];
		pointer=-1;
	}
	
	public void push(int value) throws IndexOutOfStackBoundException{
		if(pointer+1>=array.length){
			throw new IndexOutOfStackBoundException("stack pointer ["+pointer+"] is out of limit");
		}
		
		pointer++;
		array[pointer]=value;
	}
	
	public int pop(){
		if(pointer<0){
			return -1;
		}
		
		return array[pointer--];
	}

	public int peek(){
		if(pointer<0){
			return -1;
		}
		
		return array[pointer];
	}
	
	public boolean isEmpty(){
		return pointer==-1;
	}
	
	public static class IndexOutOfStackBoundException extends Exception{
		private static final long serialVersionUID = 1L;

		public IndexOutOfStackBoundException(String message) {
			super(message);
		}
		
	}
}
