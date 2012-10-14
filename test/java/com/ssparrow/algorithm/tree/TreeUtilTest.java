package com.ssparrow.algorithm.tree;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class TreeUtilTest {
	
	@Test
	public void testPostorderTraverseTreeWithLoop(){
		TreeNode root = new TreeNode(6);
		
		String result = TreeUtil.postorderTraverseTreeWithLoop(root);
		assertEquals("6", result);
		
		root.addLeft(2);
		root.getLeftNode().addLeft(1);
		root.getLeftNode().addRight(4);
		root.getLeftNode().getRightNode().addLeft(3);
		root.getLeftNode().getRightNode().addRight(5);

		root.addRight(7);
		root.getRightNode().addRight(9);
		root.getRightNode().getRightNode().addLeft(8);
		
		result = TreeUtil.postorderTraverseTreeWithLoop(root);
		assertEquals("135428976", result);
		
	}

	@Test
	public void testTreeHeight() {
		assertEquals(0, TreeUtil.getTreeHeight(null));
		
		TreeNode root=new TreeNode(1);
		assertEquals(1, TreeUtil.getTreeHeight(root));
		
		root.addLeft(2);
		assertEquals(2, TreeUtil.getTreeHeight(root));
		
		root.addRight(3);
		assertEquals(2, TreeUtil.getTreeHeight(root));
		
		root.getLeftNode().addLeft(4);
		root.getLeftNode().getLeftNode().addLeft(5);
		assertEquals(4, TreeUtil.getTreeHeight(root));
	}
	
	@Test
	public void testTreeBalance(){
		assertTrue(TreeUtil.isBalanced(null));
		
		TreeNode root=new TreeNode(1);
		assertTrue(TreeUtil.isBalanced(root));
		
		root.addLeft(2);
		assertTrue(TreeUtil.isBalanced(root));
		
		root.getLeftNode().addLeft(4);
		assertFalse(TreeUtil.isBalanced(root));
		
		root.getLeftNode().addRight(5);
		assertFalse(TreeUtil.isBalanced(root));
		
		root.addRight(3);
		assertTrue(TreeUtil.isBalanced(root));
		
		root.getLeftNode().getRightNode().addRight(6);
		assertFalse(TreeUtil.isBalanced(root));
		
		root.getRightNode().addLeft(7);
		assertTrue(TreeUtil.isBalanced(root));
		
		root.getRightNode().getLeftNode().addRight(8);
		assertFalse(TreeUtil.isBalanced(root));
		assertEquals(8, root.getSize());
	}
	
	@Test
	public void testTreeHeightAndBalance(){
		assertEquals(0, TreeUtil.checkHeightAndBalance(null));
		
		TreeNode root=new TreeNode(1);
		assertEquals(1, TreeUtil.checkHeightAndBalance(root));
		
		root.addLeft(2);
		assertEquals(2, TreeUtil.checkHeightAndBalance(root));
		
		root.getLeftNode().addLeft(4);
		assertEquals(-1, TreeUtil.checkHeightAndBalance(root));
		
		root.getLeftNode().addRight(5);
		assertEquals(-1, TreeUtil.checkHeightAndBalance(root));
		
		root.addRight(3);
		assertEquals(3, TreeUtil.checkHeightAndBalance(root));
		
		root.getLeftNode().getRightNode().addRight(6);
		assertEquals(-1, TreeUtil.checkHeightAndBalance(root));
		
		root.getRightNode().addLeft(7);
		assertEquals(4, TreeUtil.checkHeightAndBalance(root));
		
		root.getRightNode().getLeftNode().addRight(8);
		assertEquals(-1, TreeUtil.checkHeightAndBalance(root));
		assertEquals(8, root.getSize());
	}
	
	@Test
	public void testCreateMinimalBST(){
		assertNull(TreeUtil.createMinimalBST(null, null, 0, 0));
		
		TreeNode root = TreeUtil.createMinimalBST(null, new int[]{1}, 0, 0);
		assertEquals(1, root.getValue());
		
		root = TreeUtil.createMinimalBST(null, new int[]{1,2}, 0, 1);
		assertEquals(1, root.getValue());
		assertEquals(2, root.getRightNode().getValue());
		
		root = TreeUtil.createMinimalBST(null, new int[]{1,2,3}, 0, 2);
		assertEquals(2, root.getValue());
		assertEquals(1, root.getLeftNode().getValue());
		assertEquals(3, root.getRightNode().getValue());
		assertEquals(3, root.getSize());
	}
	
	@Test
	public void testCheckBST(){
		TreeNode root = TreeUtil.createMinimalBST(null, new int[]{1,2,3,4,5,6,7}, 0, 6);
		assertTrue(TreeUtil.checkBST(root));
		assertTrue(TreeUtil.checkBSTOptimaized(root));
		
		root=new TreeNode(20);
		root.addLeft(10);
		root.getLeftNode().addRight(25);
		root.addRight(30);
		assertFalse(TreeUtil.checkBST(root));
		assertFalse(TreeUtil.checkBSTOptimaized(root));
	}
	
	@Test 
	public void testGetNextNode(){
		TreeNode root = TreeUtil.createMinimalBST(null, new int[]{1,2,3,4,5,6,7}, 0, 6);
		assertEquals(4, root.getValue());
		assertEquals(5, root.getNextNode().getValue());
		assertEquals(root, root.getLeftNode().getRightNode().getNextNode());
	}
	
	@Test
	public void testFindSum(){
		TreeNode root = TreeUtil.createMinimalBST(null, new int[]{1,2,3,4,5,6,7}, 0, 6);
		assertEquals("6 5 \n", TreeUtil.findSum(root, 11));
		assertEquals("4 6 5 \n", TreeUtil.findSum(root, 15));
	}
	
	@Test
	public void testFindByLevel(){
		TreeNode root = TreeUtil.createMinimalBST(null, new int[]{1,2,3,4,5,6,7}, 0, 6);
		
		StringBuffer result=new StringBuffer();
		TreeUtil.findByLevel(result, root, 1, 1);
		assertEquals("4", result.toString());
		
		result=new StringBuffer();
		TreeUtil.findByLevel(result, root, 1, 2);
		assertEquals("26", result.toString());
		
		result=new StringBuffer();
		TreeUtil.findByLevel(result, root, 1, 3);
		assertEquals("1357", result.toString());
		
	}
	
	@Test
	public void testFindTreeDepth(){
		assertEquals(1, TreeUtil.findTreeDepth("(00)"));
		assertEquals(2, TreeUtil.findTreeDepth("((00)0)"));
		assertEquals(2, TreeUtil.findTreeDepth("((00)(00))"));
		assertEquals(3, TreeUtil.findTreeDepth("((00)(0(00)))"));
		assertEquals(4, TreeUtil.findTreeDepth("((00)(0(0(00))))"));
		assertEquals(-1, TreeUtil.findTreeDepth("x"));
		assertEquals(-1, TreeUtil.findTreeDepth("0"));
		assertEquals(-1, TreeUtil.findTreeDepth("()"));
		assertEquals(-1, TreeUtil.findTreeDepth("(0)"));
		assertEquals(-1, TreeUtil.findTreeDepth("(00)x"));
		assertEquals(-1, TreeUtil.findTreeDepth("(0p)"));
	}
	
	
	@Test
	public void testFindKthNumberInBST(){
		TreeNode root = TreeUtil.createMinimalBST(null, new int[]{1,2,3,4,5,6,7}, 0, 6);
		
		assertEquals(3, TreeUtil.findKthNumberInBST(root, 3));
	}
	
	@Test
	public void testFindKthMaxNumberInBST(){
		TreeNode root = TreeUtil.createMinimalBST(null, new int[]{1,2,3,4,5,6,7}, 0, 6);
		
		assertEquals(5, TreeUtil.findKthMaxNumberInBST(root, 3));
	}
	
	@Test
	public void testGenerateEquation(){
		int [] numbers = new int[]{2,3,5,1};
		OPERATOR [] operators=new OPERATOR[numbers.length-1];
		
		assertEquals("2+3*5-1", TreeUtil.generateEquation(numbers, operators, 0, 16));
	}
	
	@Test
	public void testConvertTreeToLinkedList(){
		TreeNode root = TreeUtil.createMinimalBST(null, new int[]{1,2,3,4,5,6,7}, 0, 6);
		List<TreeNode> result = TreeUtil.convertTreeToLinkedList(root);
		assertEquals(7, result.size());
	}
	
	@Test
	public void testRebuildTreeFromInorderAndPreOrder(){
		int [] inOrder=new int[]{4,2,5,1,6,3};
		int [] preOrder=new int[]{1,2,4,5,3,6};
		
		TreeNode root = TreeUtil.rebuildTreeFromInorderAndPreOrder(inOrder, preOrder);
		assertEquals("[1][2][4][5][3][6]", root.toString());
	}
}
