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
}
