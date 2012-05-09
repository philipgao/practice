package com.ssparrow.algorithm.linkedlist;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListUtilTest {

	@Test
	public void testFindkthToEndNode() {
		LinkedListNode head=new LinkedListNode("1");
		head.addToTail("2");
		head.addToTail("3");
		head.addToTail("4");
		head.addToTail("5");
		LinkedListNode kthNode = LinkedListUtil.findkthToEndNode(head, 2);
		assertEquals("3", kthNode.getData());
		
		kthNode = LinkedListUtil.findkthToEndNode(head, 6);
		assertNull(kthNode);
	}

}
