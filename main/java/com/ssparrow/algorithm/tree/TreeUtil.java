package com.ssparrow.algorithm.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TreeUtil {
	
	/**
	 * @param head
	 * @return
	 */
	public static String postorderTraverseTreeWithLoop(TreeNode head){
		StringBuffer result=new StringBuffer();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(head);
		
		TreeNode previoudNode = null;
		while(!stack.isEmpty()){
			TreeNode node = stack.peek();
			
			if(node.getLeftNode()==null && node.getRightNode()==null){
				stack.pop();
				result.append(node.getValue());
			} else if (previoudNode == null || (node.getParent()!=null && node.getParent().equals(previoudNode))) {
				if (node.getLeftNode() != null) {
					stack.push(node.getLeftNode());
				}else if(node.getRightNode()!=null){
					stack.push(node.getRightNode());
				}
			} else if(node.equals(previoudNode.getParent())){
				if(previoudNode.equals(node.getLeftNode())){
					if(node.getRightNode()!=null){
						stack.push(node.getRightNode());
					}else{
						stack.pop();
						result.append(node.getValue());
					}
				}else if(previoudNode.equals(node.getRightNode())){
					stack.pop();
					result.append(node.getValue());
				}
			}
			
			previoudNode=node;
		}
		
		return result.toString();
		
	}
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
		array[index++]=((Integer)node.getValue()).intValue();
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
		
		if(((Integer)root.getValue()).intValue()<last_data){
			return false;
		}
		last_data=((Integer)root.getValue()).intValue();
		
		if(!checkBSTOptimaized(root.getRightNode())){
			return false;
		}
		
		return true;
	}
	
	
	/**
	 * @param root
	 * @param value
	 * @return
	 */
	public static BSTCheckResult checkBSTWithoutStaticVariable(TreeNode root, Object value){
		if(root==null){
			return new BSTCheckResult(true,value);
		}
		
		BSTCheckResult leftResult = checkBSTWithoutStaticVariable(root.getLeftNode(), value);
		if(!leftResult.isBST()){
			return new BSTCheckResult(false, null);
		}
		Object leftMaxValue=leftResult.getMaxValue();
		
		if(leftMaxValue!=null && ((Integer)root.getValue()).compareTo((Integer)leftMaxValue)<0){
			return new BSTCheckResult(false, root.getValue());
		}
		
		return checkBSTWithoutStaticVariable(root.getRightNode(), root.getValue());
	}
	
	static class BSTCheckResult{
		private boolean isBST;
		private Object maxValue;
		/**
		 * @param isBST
		 * @param maxValue
		 */
		private BSTCheckResult(boolean isBST, Object maxValue) {
			super();
			this.isBST = isBST;
			this.maxValue = maxValue;
		}
		/**
		 * @return the isBST
		 */
		public boolean isBST() {
			return isBST;
		}
		/**
		 * @return the maxValue
		 */
		public Object getMaxValue() {
			return maxValue;
		}
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
		
		path[level]=((Integer)node.getValue()).intValue();
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
	 * Consider this string representation for binary trees. Each node is of the form (lr), where l represents the left child and r represents the right child. 
	 * If l is the character 0, then there is no left child. Similarly, if r is the character 0, then there is no right child. 
	 * Otherwise, the child can be a node of the form (lr), and the representation continues recursively.
	 * For example: (00) is a tree that consists of one node. ((00)0) is a two-node tree in which the root has a left child, and the left child is a leaf. 
	 * And ((00)(00)) is a three-node tree, with a root, a left and a right child.
	 * 
	 * Write a function that takes as input such a string, and returns -1 if the string is malformed, and the depth of the tree if the string is well-formed.
	 * 
	 * @param str
	 * @return
	 */
	
	public static int findTreeDepth(String str){
		return findTreeDepth(str, true);
	}
	
	public static int findTreeDepth(String str, boolean isWholeStr){
		boolean isBranch=true;
		String content = str;
		
		if(str.charAt(0)=='(' && str.charAt(str.length()-1)==')'){
			if(str.length()<4){
				return -1;
			}
			
			isBranch=false;
			content = str.substring(1, str.length()-1);
		}else if(isWholeStr || str.charAt(0)!='0'){
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
			
			int leftDepth=findTreeDepth(left, false);
			int rightDepth=findTreeDepth(right, false);
			
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
				int rightDepth=findTreeDepth(right, false);
				
				if(rightDepth==-1){
					return -1;
				}else{
					return Math.max(leftDepth, rightDepth)+1;
				}
			}
			
			
		}
	}
	
	/**
	 * @param root
	 * @param k
	 * @return
	 */
	public static int bst_index=1;
	public static int findKthNumberInBST(TreeNode root, int k){
		if(root==null){
			return -1;
		}
		
		if(root.getLeftNode()!=null){
			int leftResult = findKthNumberInBST(root.getLeftNode(), k);
			if(leftResult!=-1){
				return leftResult;
			}
		}
		
		if(bst_index==k){
			return ((Integer)root.getValue()).intValue();
		}
		bst_index++;
		
		if(root.getRightNode()!=null){
			int rightResult = findKthNumberInBST(root.getRightNode(), k);
			if(rightResult!=-1){
				return rightResult;
			}
		}
		
		return -1;
	}
	
	
	/**
	 * find kth max number in BST
	 * @param node
	 * @param k
	 * @return
	 */
	public static int max_index=1;
	public static int findKthMaxNumberInBST(TreeNode node, int k){
		if(node==null){
			return -1;
		}
		
		if(node.getRightNode()!=null){
			int result = findKthMaxNumberInBST(node.getRightNode(), k);
			if(result!=-1){
				return result;
			}
		}
		
		if(max_index==k){
			return ((Integer)node.getValue()).intValue();
		}
		max_index++;
		
		if(node.getLeftNode()!=null){
			int result = findKthMaxNumberInBST(node.getLeftNode(), k);
			if(result!=-1){
				return result;
			}
		}
		
		return -1;
	}
	
	/**
	 * Given a series of numbers as the input, the last one as the result. Use the rest numbers to calculate the result,only +, -, *, / are allowed. 
	 * The order of the input cannot be changed. If there is an equation, print it; or print "no equation". If more than one solution, any working equation is fine.
	 *
	 *example:
	 *input: 2, 3, 5, 1, 4
	 *output: 2+3*5-1 = 4.
	 * @param numbers
	 * @return
	 */
	public static String generateEquation(int [] numbers, OPERATOR [] operators, int position,int target){
		
		if(position==operators.length){
			Object [] equation = new Object[numbers.length+operators.length];
			equation[0]=numbers[0];
			int index=1;
			for(int i=0;i<numbers.length-1;i++){
				equation[index++]=operators[i];
				equation[index++]=numbers[i+1];
			}
			
			TreeNode root= createEquationTree(equation, 0, equation.length-1);
			
			try{
				int value=calculateEquationValue(root);
				
				if(value==target){
					StringBuffer sb=new StringBuffer();
					
					for(int k=0;k<=equation.length-1;k++){
						sb.append(equation[k]);
					}
					return sb.toString();
				}
				return null;
			}catch(InvalidEquationException exception){
				return null;
			}
		}
		
		operators[position]=OPERATOR.ADD;
		String result = generateEquation(numbers, operators, position+1, target);
		if(result!=null){
			return result;
		}
		
		operators[position]=OPERATOR.MINUS;
		result = generateEquation(numbers, operators, position+1, target);
		if(result!=null){
			return result;
		}
		
		operators[position]=OPERATOR.MULTIPLY;
		result = generateEquation(numbers, operators, position+1, target);
		if(result!=null){
			return result;
		}
		
		operators[position]=OPERATOR.DIVIDE;
		result = generateEquation(numbers, operators, position+1, target);
		if(result!=null){
			return result;
		}
		 	
		return null;  
	}
	
	private static int calculateEquationValue(TreeNode node) throws InvalidEquationException{
		if(node.getValue() instanceof Integer){
			return ((Integer)node.getValue()).intValue();
		}else{
			int left=calculateEquationValue(node.getLeftNode());
			int right=calculateEquationValue(node.getRightNode());
			
			OPERATOR operator=(OPERATOR) node.getValue();
			return doOperation(left, right, operator);
		}
	}
	
	private static TreeNode createEquationTree(Object []  equation, int start, int end){
		if(start==end){
			return new TreeNode(equation[start]);
		}
		
		
		int mid=start+(end-start)/2;
		
		int left=mid;
		boolean isFirstLeftOperator=true;
		int leftRoot=-1;
		int leftOperator=-1;
		while(left>=start){
			if(equation[left] instanceof OPERATOR){
				if(isFirstLeftOperator){
					isFirstLeftOperator=false;
					leftOperator=left;
				}
				
				if(equation[left]==OPERATOR.ADD||equation[left]==OPERATOR.MINUS){
					leftRoot=left;
					break;
				}
			}
			left--;
		}
		
		int right=mid+1;
		boolean isFirstRightOperator=true;
		int rightRoot=-1;
		int rightOperator=-1;
		while(right<end){
			if(equation[right] instanceof OPERATOR){
				if(isFirstRightOperator){
					isFirstRightOperator=false;
					rightOperator=right;
				}
				
				if(equation[right]==OPERATOR.ADD||equation[right]==OPERATOR.MINUS){
					rightRoot=right;
					break;
				}
			}
			right++;
		}
		
		int rootIndex=-1;
		if(leftRoot>0 || rightRoot>0){
			int leftDistance=mid-leftRoot;
			int rightDistance=Math.abs(rightRoot-mid);
					
			rootIndex = leftDistance<rightDistance?leftRoot:rightRoot;
		}else if(leftOperator>0 || rightOperator>0){
			int leftDistance=mid-leftOperator;
			int rightDistance=Math.abs(rightOperator-mid);
					
			rootIndex = leftDistance<rightDistance?leftOperator:rightOperator;
		}
		
		if(rootIndex>0){
			TreeNode root=new TreeNode(equation[rootIndex]);
			
			root.setLeftNode(createEquationTree(equation, start, rootIndex-1));
			
			root.setRightNode(createEquationTree(equation, rootIndex+1, end));
			
			return root;
		}else{
			return null;
		}
	}
	
	private static int doOperation(int value1, int value2, OPERATOR operator) throws InvalidEquationException{
		switch (operator) {
		case ADD:
			
			return value1+value2;

		case MINUS:
			
			return value1-value2;
			
		case MULTIPLY:
			
			return value1*value2;

		case DIVIDE:
			
			if(value2==0){
				throw new InvalidEquationException();
			}
			
			return value1/value2;
			
		default:
			return 0;
		}
	}
	
	/**
	 * convert a bst to linked list representation
	 * 
	 * @param root
	 * @return
	 */
	public static List<TreeNode> convertTreeToLinkedList(TreeNode root){
		List<TreeNode> result=new LinkedList<TreeNode>();
		
		TreeNode lastNodeFromLeft = convertTreeToLinkedList(result, root.getLeftNode(), null, true);
		
		result.add(root);
		root.setPreviousNode(lastNodeFromLeft);

		convertTreeToLinkedList(result, root.getRightNode(), root, true);
		
		return result;
	}
	
	private static TreeNode convertTreeToLinkedList(List<TreeNode> list, TreeNode node, TreeNode previousNode, boolean isOnLeft){
		if(node==null){
			return null;
		}
		
		TreeNode leftNode = node.getLeftNode();
		if(leftNode!=null){
			leftNode.setPreviousNode(previousNode);
			convertTreeToLinkedList(list, leftNode, previousNode, isOnLeft);
		}
		
		list.add(node);
		TreeNode previousNodeForCurrent = leftNode==null?previousNode:leftNode;
		node.setPreviousNode(previousNodeForCurrent);
		
		TreeNode rightNode = node.getRightNode();
		if(rightNode!=null){
			rightNode.setPreviousNode(node);
			return convertTreeToLinkedList(list, rightNode, node, isOnLeft);
		}else{
			return node;
		}
	}
	
	/**
	 * Construct Tree from given Inorder and Preorder traversals
	 * Let us consider the below traversals:
	 * 
	 * Inorder sequence: D B E A F C
	 * Preorder sequence: A B D E C F
	 * 
	 * @param inOrder
	 * @param preOrder
	 * @return
	 */
	public static TreeNode rebuildTreeFromInorderAndPreOrder(int [] inOrder, int [] preOrder){
		return buildTreeFromInOrder(inOrder, 0, inOrder.length-1, preOrder, 0);
	}
	
	private static TreeNode buildTreeFromInOrder(int [] inOrder, int start, int end, int [] preOrder, int preOrderIndex){
		if(start>end){
			return null;
		}
		
		if(start==end){
			return new TreeNode(inOrder[start]);
		}
		
		int rootIndex=-1;
		int rootValue = preOrder[preOrderIndex];
		for(int i=start;i<=end;i++){
			if(inOrder[i]==rootValue){
				rootIndex=i;
				break;
			}
		}
		
		TreeNode root=new TreeNode(rootValue);
		
		TreeNode leftRoot=buildTreeFromInOrder(inOrder, start, rootIndex-1, preOrder, preOrderIndex+1);
		root.setLeftNode(leftRoot);
		
		int preOrderRightRootIndex=-1;
		if(rootIndex>start){
			int lastLeftNodeValue=inOrder[rootIndex-1];
			
			for(int i=preOrderIndex+1;i<preOrder.length;i++){
				if(preOrder[i]==lastLeftNodeValue){
					preOrderRightRootIndex=i+1;
					break;
				}
			}
		}else{
			preOrderRightRootIndex=rootIndex+1;
		}
		
		TreeNode rightRoot=buildTreeFromInOrder(inOrder, rootIndex+1, end, preOrder,preOrderRightRootIndex);
		root.setRightNode(rightRoot);
		
		return root;
	}
	
	/**
	 * Two trees can be called isomorphic if they have similar structure and the only difference amongst them can be is, that their child nodes may or may not be swaped..
	 * 
	 * for example
	 * 
	 * ��4
	 * 
	 * �-2�6
	 * 
	 * �1�3�5�7
	 * 
	 * and
	 * 
	 * ��4
	 * 
	 * �-6�2
	 * 
	 * �1�3�7�5
	 * 
	 * are isomorphic .. the trees are similar and a few nodes have their left and right child swapped�
	 * 
	 * Given two trees determine if they are isomorphic�
	 * @param root1
	 * @param root2
	 * @return
	 */
	public static boolean isIsomorphicTree(TreeNode root1, TreeNode root2){
		if(root1==null && root2==null){
			return true;
		}else if(root1==null || root2==null || !root1.getValue().equals(root2.getValue())){
			return false;
		}
			
		if(root1.getLeftNode().getValue().equals(root2.getLeftNode().getValue()) && 
				root1.getRightNode().getValue().equals(root2.getRightNode().getValue())){
			return isIsomorphicSubTree(root1.getLeftNode(), root2.getLeftNode()) &&
					isIsomorphicSubTree(root1.getRightNode(), root2.getRightNode());
		}else if(root1.getLeftNode().getValue().equals(root2.getRightNode().getValue()) && 
				root1.getRightNode().getValue().equals(root2.getLeftNode().getValue())){
			return isIsomorphicSubTree(root1.getLeftNode(), root2.getLeftNode()) &&
					isIsomorphicSubTree(root1.getRightNode(), root2.getRightNode());
		}
		
		return false;
	}
	
	private static boolean isIsomorphicSubTree(TreeNode root1, TreeNode root2){
		if(root1==null && root2==null){
			return true;
		}else if(root1==null || root2==null){
			return false;
		}
	
		if((root1.getLeftNode()==null && root2.getLeftNode()==null || 
				root1.getLeftNode().getValue().equals(root2.getLeftNode().getValue())) && 
				(root1.getRightNode()==null && root2.getRightNode()==null || 
				root1.getRightNode().getValue().equals(root2.getRightNode().getValue())) ){
			return isIsomorphicSubTree(root1.getLeftNode(), root2.getLeftNode()) &&
					isIsomorphicSubTree(root1.getRightNode(), root2.getRightNode());
		}else if((root1.getLeftNode()==null && root2.getRightNode()==null || 
				root1.getLeftNode().getValue().equals(root2.getRightNode().getValue())) && 
				(root1.getRightNode()==null && root2.getLeftNode()==null || 
				root1.getRightNode().getValue().equals(root2.getLeftNode().getValue())) ){
			return isIsomorphicSubTree(root1.getLeftNode(), root2.getLeftNode()) &&
					isIsomorphicSubTree(root1.getRightNode(), root2.getRightNode());
		}
		
		return false;
	}
	
	/**
	 * @param node
	 * @return
	 */
	public static TreeNode getNextNode(TreeNode node){
		if(node.getRightNode()!=null){
			node = node.getRightNode();
			
			while(node.getLeftNode()!=null){
				node=node.getLeftNode();
			}
			
			return node;
		}else if(node.getParent()!=null){
			while(node==node.getParent().getRightNode()){
				node=node.getParent();
			}
			
			return node.getParent();
		}
		
		return null;
	}
}
