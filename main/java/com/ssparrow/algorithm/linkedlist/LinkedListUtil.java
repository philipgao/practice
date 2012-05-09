package com.ssparrow.algorithm.linkedlist;

public class LinkedListUtil {
	/**
	 * @param head
	 * @param k
	 * @return
	 */
	public static LinkedListNode findkthToEndNode(LinkedListNode head, int k){
		LinkedListNode forwardNode=head;
		LinkedListNode followingNode=null;
		
		int count=0;
		while(forwardNode.getNext()!=null){
			count++;
			forwardNode=forwardNode.getNext();
			
			if(count==k){
				followingNode=head;
			}else if(count>k){
				followingNode=followingNode.getNext();
			}
		}
		return followingNode;
	}
}
