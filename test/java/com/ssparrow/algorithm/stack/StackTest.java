package com.ssparrow.algorithm.stack;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ssparrow.algorithm.stack.Stack.IndexOutOfStackBoundException;

public class StackTest {

	@Test
	public void test() throws IndexOutOfStackBoundException {
		Stack stack=new Stack();
		
		assertEquals(-1,stack.pop());
		
		stack.push(1);
		assertEquals(1, stack.pop());
		
		stack.push(5);
		stack.push(9);
		assertEquals(9, stack.pop());
		assertEquals(5, stack.peek());
		assertEquals(5, stack.pop());
		assertEquals(-1,stack.pop());
		
		assertTrue(stack.isEmpty());
	}

}
