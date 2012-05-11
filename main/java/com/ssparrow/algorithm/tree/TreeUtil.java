package com.ssparrow.algorithm.tree;

public class TreeUtil {
	/**
	 * @param root
	 * @return
	 */
	public static int getTreeHeight(TreeNode root){
		if(root==null){
			return 0;
		}
		
		return Math.max(getTreeHeight(root.getLeftNode()), getTreeHeight(root.getRightNode()))+1;
	}
	
	/**
	 * @param root
	 * @return
	 */
	public static boolean isBalanced(TreeNode root){
		if(root==null){
			return true;
		}
		
		int diff=Math.abs(getTreeHeight(root.getLeftNode())-getTreeHeight(root.getRightNode()));
		if(diff>1){
			return false;
		}else{
			return isBalanced(root.getLeftNode()) && isBalanced(root.getRightNode());
		}
	}
	
	public static int checkHeightAndBalance(TreeNode root){
		if(root==null){
			return 0;
		}
		
		int leftHeight=checkHeightAndBalance(root.getLeftNode());
		if(leftHeight==-1){
			return -1;
		}
		
		int rightHeight=checkHeightAndBalance(root.getRightNode());
		if(rightHeight==-1){
			return -1;
		}
		
		int diff=Math.abs(leftHeight-rightHeight);
		if(diff>1){
			return -1;
		}else{
			return Math.max(leftHeight, rightHeight)+1;
		}
	}
}
