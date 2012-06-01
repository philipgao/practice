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
	
	/**
	 * @param root
	 * @return
	 */
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
	
	/**
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 */
	public static TreeNode createMinimalBST(TreeNode root,int [] array,int start, int end){
		if(array==null){
			return null;
		}
		
		if(start>end){
			return null;
		}
		
		int middle=start+(end-start)/2;
		
		TreeNode node=new TreeNode(root, array[middle]);
		node.setLeftNode(createMinimalBST(node, array, start, middle-1));
		node.setRightNode(createMinimalBST(node, array, middle+1, end));
		
		return node;
	}
	
	/**
	 * @param root
	 * @return
	 */
	public static boolean checkBST(TreeNode root){
		if(root==null){
			return true;
		}
		int[] array=new int[root.getSize()];
		
		index=0;
		copyBST(root, array);
		
		for(int i=0;i<array.length-1;i++){
			if(array[i]>array[i+1]){
				return false;
			}
		}
		
		return true;
	}
	
	public static int index=0;
	private static void copyBST(TreeNode node, int[] array){
		if(node==null){
			return;
		}
		copyBST(node.getLeftNode(), array);
		array[index++]=node.getValue();
		copyBST(node.getRightNode(), array);
	}
	
	
	/**
	 * @param root
	 * @return
	 */
	public static int last_data=Integer.MIN_VALUE;
	public static boolean checkBSTOptimaized(TreeNode root){
		if(root==null){
			return true;
		}
		
		if(!checkBSTOptimaized(root.getLeftNode())){
			return false;
		}
		
		if(root.getValue()<last_data){
			return false;
		}
		last_data=root.getValue();
		
		if(!checkBSTOptimaized(root.getRightNode())){
			return false;
		}
		
		return true;
	}
	
	/**
	 * @param root
	 * @param sum
	 * @return
	 */
	public static String findSum(TreeNode root, int sum){
		int [] path = new int[getTreeHeight(root)];
		StringBuffer sb=new StringBuffer();
		findSum(sb, root, sum, path, 0);
		return sb.toString();
	}
	
	private static void findSum(StringBuffer sb, TreeNode node, int sum, int[] path, int level){
		if(node==null){
			return;
		}
		
		path[level]=node.getValue();
		int result=0;
		for(int i=level;i>=0;i--){
			result+=path[i];
			
			if(result==sum){
				for(int j=i;j<=level;j++){
					sb.append(path[j]).append(' ');
				}
				sb.append('\n');
			}
		}
		
		findSum(sb,node.getLeftNode(), sum, path, level+1);
		findSum(sb, node.getRightNode(), sum, path, level+1);
	}
	
	/**
	 * @param result
	 * @param root
	 * @param currentlevel
	 * @param expectedlevel
	 */
	public static void findByLevel(StringBuffer result, TreeNode root, int currentlevel, int expectedlevel){
		if(root==null){
			return;
		}
		
		if(currentlevel==expectedlevel){
			result.append(root.getValue());
			return;
		}
		
		findByLevel(result, root.getLeftNode(), currentlevel+1, expectedlevel);
		findByLevel(result, root.getRightNode(), currentlevel+1, expectedlevel);
	}
	
	/**
	 * @param str
	 * @return
	 */
	
	public static int findTreeDepth(String str){
		if(str.charAt(0)=='(' && str.charAt(str.length()-1)==')'){
			if(str.length()<4){
				return -1;
			}
			
			return findSubTreeDepth(str);
		}else{
			return -1;
		}
	}
	
	private static int findSubTreeDepth(String str){
		boolean isBranch=true;
		String content = str;
		
		if(str.charAt(0)=='(' && str.charAt(str.length()-1)==')'){
			if(str.length()<4){
				return -1;
			}
			
			isBranch=false;
			content = str.substring(1, str.length()-1);
		}else if(str.charAt(0)!='0'){
			return -1;
		}
		
		if(content.charAt(0)=='('){
			int count=1;
			int index=1;
			for(;index<content.length();index++){
				if(content.charAt(index)=='('){
					count++;
				}else if(content.charAt(index)==')'){
					count --;
				}else if(content.charAt(index)!='0'){
					return -1;
				}
				
				if(count==0){
					break;
				}
			}
			
			if((index==content.length()) || count>0){
				return -1;
			}
			
			String left=content.substring(0, index+1);
			String right=content.substring(index+1);
			
			int leftDepth=findSubTreeDepth(left);
			int rightDepth=findSubTreeDepth(right);
			
			if(leftDepth==-1 || rightDepth==-1){
				return -1;
			}else{
				return Math.max(leftDepth, rightDepth)+1;
			}
		}else{
			int index=1;
			
			while(index<content.length() && content.charAt(index)=='0'){
				index++;
			}
			
			if(index==content.length()){
				int expected=isBranch?1:2;
				
				if(index==expected){
					return 1;
				}else{
					return -1;
				}
			}else{
				
				if(content.charAt(index)!='('){
					return -1;
				}
				
				int leftDepth=0;
				
				String right=content.substring(index);
				int rightDepth=findSubTreeDepth(right);
				
				if(rightDepth==-1){
					return -1;
				}else{
					return Math.max(leftDepth, rightDepth)+1;
				}
			}
			
			
		}
	}
}
