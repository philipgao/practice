package com.ssparrow.algorithm.linkedlist;

public class LinkedListNode {
	private LinkedListNode next=null;
	private Object data;
	
	public LinkedListNode(Object data) {
		this.data = data;
	}

	public LinkedListNode getNext() {
		return next;
	}

	public void setNext(LinkedListNode next) {
		this.next = next;
	}
	
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public LinkedListNode addToTail(Object data){
		LinkedListNode next=new LinkedListNode(data);
		
		LinkedListNode node=this;
		while(node.getNext()!=null){
			node=node.getNext();
		}
		
		node.setNext(next);
		
		return next;
	}

}
