package com.ssparrow.algorithm.stack;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ssparrow.algorithm.stack.Stack.IndexOutOfStackBoundException;

public class StackUtilTest {

	@Test
	public void testSortStack() throws IndexOutOfStackBoundException {
		Stack stack=new Stack();
		stack.push(7);
		stack.push(9);
		stack.push(8);
		stack.push(12);
		stack.push(1);
		stack.push(15);
		
		Stack result = StackUtil.sortStack(stack);
		assertEquals(15, result.pop());
		assertEquals(12, result.pop());
		assertEquals(9, result.pop());
		assertEquals(8, result.pop());
		assertEquals(7, result.pop());
		assertEquals(1, result.pop());
	}

}
