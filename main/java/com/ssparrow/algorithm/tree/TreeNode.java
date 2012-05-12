package com.ssparrow.algorithm.tree;

public class TreeNode {
	private TreeNode parent;
	private TreeNode leftNode;
	private TreeNode rightNode;
	
	private int value;
	
	public TreeNode(int value) {
		this.value = value;
	}
	
	public TreeNode(TreeNode parent, int value) {
		this.parent=parent;
		this.value = value;
	}
	
	public TreeNode getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(TreeNode leftNode) {
		this.leftNode = leftNode;
	}
	public void addLeft(int leftValue){
		TreeNode left=new TreeNode(this, leftValue);
		this.setLeftNode(left);
	}
	public TreeNode getRightNode() {
		return rightNode;
	}
	public void setRightNode(TreeNode rightNode) {
		this.rightNode = rightNode;
	}
	public void addRight(int rightValue){
		TreeNode right=new TreeNode(this, rightValue);
		this.setRightNode(right);
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	public TreeNode getParent() {
		return parent;
	}

	public void setParent(TreeNode parent) {
		this.parent = parent;
	}

	public int getSize(){
		int size=0;
		
		size++;
		
		if(this.getLeftNode()!=null){
			size+=this.getLeftNode().getSize();
		}
		
		if(this.getRightNode()!=null){
			size+=this.getRightNode().getSize();
		}
		
		return size;
	}
	
	public TreeNode getNextNode(){
		if(this.getRightNode()!=null){
			TreeNode node=this.getRightNode();
			while(node.getLeftNode()!=null){
				node=node.getLeftNode();
			}
			return node;
		}else if(this.getParent()!=null){
			TreeNode node=this;
			while(node==node.getParent().getRightNode()){
				node=node.getParent();
			}
			return node.getParent();
		}
		return null;
	}
}
