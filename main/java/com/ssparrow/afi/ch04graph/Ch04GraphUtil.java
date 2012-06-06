package com.ssparrow.afi.ch04graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.ssparrow.algorithm.tree.TreeNode;

public class Ch04GraphUtil {

	/**
	 * return each level in a tree as a individual linked list
	 * 
	 * @param root
	 * @return
	 */
	public static List<List<TreeNode>> p402GetTreeNodesByLevel(TreeNode root){
		List<List<TreeNode>> result=new LinkedList<List<TreeNode>>();
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		
		queue.offer(root);
		
		TreeNode node;
		boolean foundLevelStart=true;
		TreeNode levelStartNode=root;
		LinkedList<TreeNode> levelList = null;
		while((node=queue.poll())!=null){
			if(node.equals(levelStartNode)){
				levelList=new LinkedList<TreeNode>();
				result.add(levelList);
				
				//since this node is start of this level, its child will be start of next level
				if(node.getLeftNode()!=null){
					levelStartNode=node.getLeftNode();
				}else if(node.getRightNode()!=null){
					levelStartNode=node.getRightNode();
				}else{
					//if the start node of current level has no child, 
					//then set flag and let its siblings to find start of next level
					foundLevelStart=false;
				}
			}else if(!foundLevelStart){
				//when the start node has no child, non-start node will try to find start node of next level
				
				if(node.getLeftNode()!=null){
					levelStartNode=node.getLeftNode();
				}else if(node.getRightNode()!=null){
					levelStartNode=node.getRightNode();
				}
			}
			
			levelList.add(node);
			
			if(node.getLeftNode()!=null){
				queue.offer(node.getLeftNode());
			}
			
			if(node.getRightNode()!=null){
				queue.offer(node.getRightNode());
			}
		}
		
		return result;
		
	}
	
}
