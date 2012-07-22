package com.ssparrow.algorithm.stack;

import com.ssparrow.algorithm.stack.Stack.IndexOutOfStackBoundException;


public class StackUtil {
	public static Stack sortStack(Stack srcStack) throws IndexOutOfStackBoundException{
		Stack destStack=new Stack();
		
		while(!srcStack.isEmpty()){
			int tmp=srcStack.pop();
			
			while(!destStack.isEmpty() && destStack.peek()>tmp){
				srcStack.push(destStack.pop());
			}
			
			destStack.push(tmp);
		}
		
		return destStack;
	}
	
	
	/**
	 * reverse elements in stack without using other data structure
	 * 
	 * @param stack
	 * @throws IndexOutOfStackBoundException
	 */
	public static void reverseStack(Stack stack) throws IndexOutOfStackBoundException{
		if(stack.isEmpty()){
			return;
		}

		//retrieve and keep the top value
		int value = stack.pop();
		
		//recursively retireve and arrange value from stack
		reverseStack(stack);
		
		//put value at the bottom of stack, then put back items in stack with original order
		reverseItems(stack, value);
	}
	
	
	private static void reverseItems(Stack stack, int value) throws IndexOutOfStackBoundException{
		if(stack.isEmpty()){
			stack.push(value);
			return;
		}
		
		int temp=stack.pop();
		
		reverseItems(stack, value);
		
		stack.push(temp);
	}
}
