package com.ssparrow.algorithm.stack;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ssparrow.algorithm.stack.Stack.IndexOutOfStackBoundException;

public class StackTest {

	@Test
	public void test() throws IndexOutOfStackBoundException {
		Stack stack=new Stack();
		
		assertNull(stack.pop());
		
		stack.push("test");
		assertEquals("test", stack.pop());
		
		stack.push("philip");
		stack.push("jamie");
		assertEquals("jamie", stack.pop());
		assertEquals("philip", stack.pop());
		assertNull(stack.pop());
	}

}
