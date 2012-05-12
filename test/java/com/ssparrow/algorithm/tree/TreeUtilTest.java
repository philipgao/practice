package com.ssparrow.algorithm.tree;

import static org.junit.Assert.*;

import org.junit.Test;

public class TreeUtilTest {

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
}
