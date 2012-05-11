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
	}
}
