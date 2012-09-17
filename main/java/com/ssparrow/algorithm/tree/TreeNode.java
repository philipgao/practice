package com.ssparrow.algorithm.tree;

public class TreeNode {
	private TreeNode parent;
	private TreeNode leftNode;
	private TreeNode rightNode;
	private TreeNode previousNode;
	private TreeNode nextNode;
	
	/**
	 * @return the previousNode
	 */
	public TreeNode getPreviousNode() {
		return previousNode;
	}

	/**
	 * @param previousNode the previousNode to set
	 */
	public void setPreviousNode(TreeNode previousNode) {
		this.previousNode = previousNode;
	}

	/**
	 * @param nextNode the nextNode to set
	 */
	public void setNextNode(TreeNode nextNode) {
		this.nextNode = nextNode;
	}

	private Object value;
	
	public TreeNode(Object value) {
		this.value = value;
	}
	
	public TreeNode(TreeNode parent, Object value) {
		this.parent=parent;
		this.value = value;
	}
	
	public TreeNode getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(TreeNode leftNode) {
		this.leftNode = leftNode;
	}
	public void addLeft(Object leftValue){
		TreeNode left=new TreeNode(this, leftValue);
		this.setLeftNode(left);
	}
	public TreeNode getRightNode() {
		return rightNode;
	}
	public void setRightNode(TreeNode rightNode) {
		this.rightNode = rightNode;
	}
	public void addRight(Object rightValue){
		TreeNode right=new TreeNode(this, rightValue);
		this.setRightNode(right);
	}
	public Object getValue() {
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[" + value + "]";
	}
	
}
