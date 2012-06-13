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
	
	@Test
	public void testAddNumbers(){
		LinkedListNode head1=new LinkedListNode("9");
		head1.addToTail("7");
		head1.addToTail("8");
		
		LinkedListNode head2=new LinkedListNode("6");
		head2.addToTail("5");
		head2.addToTail("3");
		
		LinkedListNode head=new LinkedListNode("5");
		head.addToTail("3");
		head.addToTail("2");
		head.addToTail("1");
		
		LinkedListNode node=head;
		LinkedListNode result = LinkedListUtil.addNumbers(head1, head2);
		while(result.getNext()!=null){
			assertEquals(node.getNext().getData(), result.getNext().getData());
			node=node.getNext();
			result=result.getNext();
			
		}
	}
	
	@Test
	public void testReverseLinkedList(){
		LinkedListNode head=new LinkedListNode("1");
		head.addToTail("2");
		head.addToTail("3");
		head.addToTail("4");
		head.addToTail("5");
		
		LinkedListNode reverseHead = LinkedListUtil.reverseLinkedList(head);
		assertEquals("5", reverseHead.getData());
		reverseHead=reverseHead.getNext();
		assertEquals("4", reverseHead.getData());
		reverseHead=reverseHead.getNext();
		assertEquals("3", reverseHead.getData());
		reverseHead=reverseHead.getNext();
		assertEquals("2", reverseHead.getData());
		reverseHead=reverseHead.getNext();
		assertEquals("1", reverseHead.getData());
		reverseHead=reverseHead.getNext();
		assertNull(reverseHead);
		
		
	}
	
	@Test
	public void testRemoveDuplicatesFromLinkedList(){
		LinkedListNode head=new LinkedListNode("1");
		head.addToTail("1");
		head.addToTail("2");
		head.addToTail("2");
		head.addToTail("2");
		head.addToTail("3");
		head.addToTail("3");
		head.addToTail("4");
		head.addToTail("4");
		head.addToTail("1");
		head.addToTail("5");
		head.addToTail("5");
		head.addToTail("3");
		head.addToTail("5");
		head.addToTail("2");
		head.addToTail("5");
		
		head = LinkedListUtil.removeDuplicatesFromLinkedList(head);
		assertEquals("1", head.getData());
		head=head.getNext();
		assertEquals("2", head.getData());
		head=head.getNext();
		assertEquals("3", head.getData());
		head=head.getNext();
		assertEquals("4", head.getData());
		head=head.getNext();
		assertEquals("5", head.getData());
		head=head.getNext();
		assertNull(head);
		
	}


	
	@Test
	public void testDeleteNodeFromMiddle(){
		LinkedListNode head=new LinkedListNode("1");
		LinkedListNode node2 = head.addToTail("2");
		head.addToTail("3");
		head.addToTail("4");
		head.addToTail("5");
		
		LinkedListUtil.deleteNodeFromMiddle(node2);
		assertEquals("1", head.getData());
		head=head.getNext();
		assertEquals("3", head.getData());
		head=head.getNext();
		assertEquals("4", head.getData());
		head=head.getNext();
		assertEquals("5", head.getData());
		head=head.getNext();
		assertNull(head);
		
		
	}
}
