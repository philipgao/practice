package com.ssparrow.algorithm.stack;

public class Stack {
	private String[] array;
	private int pointer;
	
	public Stack(){
		array=new String[100];
		pointer=-1;
	}
	
	public void push(String value) throws IndexOutOfStackBoundException{
		if(pointer+1>=array.length){
			throw new IndexOutOfStackBoundException("stack pointer ["+pointer+"] is out of limit");
		}
		
		pointer++;
		array[pointer]=value;
	}
	
	public String pop(){
		if(pointer<0){
			return null;
		}
		
		return array[pointer--];
	}

	public static class IndexOutOfStackBoundException extends Exception{
		private static final long serialVersionUID = 1L;

		public IndexOutOfStackBoundException(String message) {
			super(message);
		}
		
	}
}
