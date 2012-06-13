package com.ssparrow.algorithm.linkedlist;

import com.ssparrow.algorithm.stack.Stack;
import com.ssparrow.algorithm.stack.Stack.IndexOutOfStackBoundException;

public class MyQueue {
	Stack stack1=new Stack();
	Stack stack2=new Stack();
	

	public void offer(int value) throws IndexOutOfStackBoundException{
		stack1.push(value);

		stack2=new Stack();
		while(stack1.peek()>=0){
			stack2.push(stack1.pop());
		}
	}
	
	public int poll(){
		return stack2.pop();
	}
}
