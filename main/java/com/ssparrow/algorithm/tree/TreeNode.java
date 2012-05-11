package com.ssparrow.algorithm.tree;

public class TreeNode {
	private TreeNode leftNode;
	private TreeNode rightNode;
	
	private int value;
	
	public TreeNode(int value) {
		this.value = value;
	}
	
	public TreeNode getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(TreeNode leftNode) {
		this.leftNode = leftNode;
	}
	public void addLeft(int leftValue){
		TreeNode left=new TreeNode(leftValue);
		this.setLeftNode(left);
	}
	public TreeNode getRightNode() {
		return rightNode;
	}
	public void setRightNode(TreeNode rightNode) {
		this.rightNode = rightNode;
	}
	public void addRight(int rightValue){
		TreeNode right=new TreeNode(rightValue);
		this.setRightNode(right);
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	

}
