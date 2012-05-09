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
	
	/**
	 * @param head1
	 * @param head2
	 * @return
	 */
	public static LinkedListNode addNumbers(LinkedListNode head1, LinkedListNode head2){
		int carry=0;
		LinkedListNode node1=head1;
		LinkedListNode node2=head2;
		
		int sum=Integer.parseInt(node1.getData().toString())+Integer.parseInt(node2.getData().toString());
		LinkedListNode head=new LinkedListNode(String.valueOf(sum%10));
		carry=sum/10;
		
		while(node1.getNext()!=null || node2.getNext()!=null){
			sum=carry;
			
			if(node1.getNext()!=null){
				sum+=Integer.parseInt(node1.getNext().getData().toString());
			}
			
			if(node2.getNext()!=null){
				sum+=Integer.parseInt(node2.getNext().getData().toString());
			}
			
			head.addToTail(String.valueOf(sum%10));
			carry=sum/10;
			
			node1=node1.getNext();
			node2=node2.getNext();
		}
		
		if(carry>0){
			head.addToTail(String.valueOf(carry));
		}
		
		return head;
	}
}
