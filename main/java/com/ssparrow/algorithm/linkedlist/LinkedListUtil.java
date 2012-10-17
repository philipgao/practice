package com.ssparrow.algorithm.linkedlist;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import com.ssparrow.algorithm.stack.Stack;
import com.ssparrow.algorithm.stack.Stack.IndexOutOfStackBoundException;

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
	
	/**
	 * @param head
	 * @return
	 */
	public static LinkedListNode reverseLinkedList(LinkedListNode head){
		if(head==null || head.getNext()==null){
			return head;
		}
		
		LinkedListNode lastNode=head;		
		LinkedListNode node=head.getNext();
		
		while(node!=null){
			LinkedListNode tmp = node.getNext();
			
			node.setNext(lastNode);
			lastNode=node;
			
			node=tmp;
		}
		
		head.setNext(null);
		return lastNode;
	}
	
	/**
	 * @param head
	 * @return
	 */
	public static LinkedListNode removeDuplicatesFromLinkedList(LinkedListNode head){
		LinkedListNode traverser=head.getNext();
		LinkedListNode nonDuplicateHead=head;
		LinkedListNode nonDuplicateTail=head;
		
		while(traverser!=null){
			LinkedListNode node=nonDuplicateHead;
			
			boolean isDuplicate=false;
			while(true){
				
				if(node.getData().equals(traverser.getData())){
					isDuplicate=true;
				}
				

				if(nonDuplicateTail.equals(node)){
					break;
				}else{
					node=node.getNext();
				}
			}
			
			if(!isDuplicate){
				nonDuplicateTail.setNext(traverser);
				nonDuplicateTail=traverser;
				
				if(nonDuplicateHead.equals(nonDuplicateTail)){
					nonDuplicateHead.setNext(nonDuplicateTail);
				}
			}
			traverser=traverser.getNext();
		}
		nonDuplicateTail.setNext(null);
		
		return nonDuplicateHead;
	}
	
	/**
	 * @param node
	 * @return
	 */
	public static boolean deleteNodeFromMiddle(LinkedListNode node){
		if(node==null || node.getNext()==null){
			return false;
		}
		
		
		LinkedListNode lastNode=node;
		LinkedListNode next = node.getNext();
		node.setData(next.getData());
		node.setNext(next.getNext());
		
		return true;
	}
	
	/**
	 * hanoi tower
	 * 
	 * @param n
	 * @param source
	 * @param destination
	 * @param buffer
	 * @throws IndexOutOfStackBoundException
	 */
	public static void moveDisks(int n, Stack source, Stack destination, Stack buffer) throws IndexOutOfStackBoundException{
		if(n>0){
			moveDisks(n-1, source, buffer, destination);
			destination.push(source.pop());
			moveDisks(n-1, buffer, destination, source);
		}
	}
	
	/**
	 * @param head
	 * @param k
	 * @return
	 */
	public static LinkedListNode reverserEveryKNodesInList(LinkedListNode head, int k){
		LinkedListNode node=head;
		head=null;
		
		LinkedListNode previousLastNode=null;
		while(node!=null){
			LinkedListNode firstNode=node;

			int count=0;
			LinkedListNode previousNode=null;
			while(count<k && node!=null){
				LinkedListNode next=node.getNext();
				
				node.setNext(previousNode);
				previousNode=node;
				
				node=next;
				count++;
			}
			
			if(head==null){
				head=previousNode;
			}
			
			if(previousLastNode!=null){
				previousLastNode.setNext(previousNode);
			}
			
			previousLastNode=firstNode;
		}
		
		return head;
	}
}
