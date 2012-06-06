package com.ssparrow.afi.ch04graph;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.List;

import com.ssparrow.algorithm.tree.TreeNode;
import com.ssparrow.algorithm.tree.TreeUtil;

public class Ch04GraphUtilTest {

	@Test
	public void testP402GetTreeNodesByLevel(){
		TreeNode root = TreeUtil.createMinimalBST(null, new int[]{1,2,3,4,5,6,7}, 0, 6);
		
		List<List<TreeNode>> result = Ch04GraphUtil.p402GetTreeNodesByLevel(root);
		
		assertEquals(3, result.size());
		assertEquals(1, result.get(0).size());
		assertEquals(4, result.get(0).get(0).getValue());
		assertEquals(2, result.get(1).size());
		assertEquals(2, result.get(1).get(0).getValue());
		assertEquals(6, result.get(1).get(1).getValue());
		assertEquals(4, result.get(2).size());
		assertEquals(1, result.get(2).get(0).getValue());
		assertEquals(3, result.get(2).get(1).getValue());
		assertEquals(5, result.get(2).get(2).getValue());
		assertEquals(7, result.get(2).get(3).getValue());
		
		//test case for incomplete tree, in which start node of level 2 has no child
		root=new TreeNode(10);
		root.addLeft(5);
		root.addRight(15);
		root.getRightNode().addLeft(11);
		root.getRightNode().addRight(20);
		
		result = Ch04GraphUtil.p402GetTreeNodesByLevel(root);
		
		assertEquals(3, result.size());
		assertEquals(1, result.get(0).size());
		assertEquals(10, result.get(0).get(0).getValue());
		assertEquals(2, result.get(1).size());
		assertEquals(5, result.get(1).get(0).getValue());
		assertEquals(15, result.get(1).get(1).getValue());
		assertEquals(2, result.get(2).size());
		assertEquals(11, result.get(2).get(0).getValue());
		assertEquals(20, result.get(2).get(1).getValue());
		
	}
}
