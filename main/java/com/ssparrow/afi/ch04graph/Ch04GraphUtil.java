package com.ssparrow.afi.ch04graph;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import com.ssparrow.algorithm.graph.Graph;
import com.ssparrow.algorithm.graph.Status;
import com.ssparrow.algorithm.graph.Vertex;
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
					foundLevelStart=true;
				}else if(node.getRightNode()!=null){
					levelStartNode=node.getRightNode();
					foundLevelStart=true;
				}else{
					//if the start node of current level has no child, 
					//then set flag and let its siblings to find start of next level
					foundLevelStart=false;
				}
			}else if(!foundLevelStart){
				//when the start node has no child, non-start node will try to find start node of next level
				
				if(node.getLeftNode()!=null){
					levelStartNode=node.getLeftNode();
					foundLevelStart=true;
				}else if(node.getRightNode()!=null){
					levelStartNode=node.getRightNode();
					foundLevelStart=true;
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
	
	/**
	 * @param start
	 * @return
	 */
	public static boolean p404IsPCBWiringLayoutPossible(Vertex start){
		Queue<Vertex> queue=new LinkedList<Vertex>();
		Map<Vertex, Status> statusMap=new HashMap<Vertex, Status>();
		Map<Vertex, Integer> distanceMap=new HashMap<Vertex, Integer>();
		
		List<List<Vertex>> distanceLists=new LinkedList<List<Vertex>>();
		
		queue.offer(start);
		statusMap.put(start, Status.Queued);
		distanceMap.put(start, 0);
		
		Vertex node;
		List<Vertex> currentDistanceList = null;
		while((node=queue.poll())!=null){
			Integer currentDistance = distanceMap.get(node);
			Set<Vertex> adjacentVertexes = node.getAdjacentVertexes();
			
			if(distanceLists.size()<=currentDistance || distanceLists.get(currentDistance)==null){
				currentDistanceList=new LinkedList<Vertex>();
				distanceLists.add(currentDistanceList);
			}
			currentDistanceList.add(node);
			
			
			for (Iterator iterator = adjacentVertexes.iterator(); iterator.hasNext();) {
				Vertex adjacent = (Vertex) iterator.next();
				
				if(statusMap.get(adjacent)==null || statusMap.get(adjacent).equals(Status.Unvisited)){
					queue.offer(adjacent);
					
					statusMap.put(adjacent, Status.Queued);
					distanceMap.put(adjacent, currentDistance+1);
				}
			}
			
			statusMap.put(node, Status.Visited);
		}
		
		for(int index=1;index<distanceLists.size();index++){
			List<Vertex> vertexList = distanceLists.get(index);
			
			for (Iterator iterator = vertexList.iterator(); iterator.hasNext();) {
				Vertex vertex = (Vertex) iterator.next();
				
				for (Iterator iterator2 = vertexList.iterator(); iterator2.hasNext();) {
					Vertex vertexOnSameDistance = (Vertex) iterator2.next();
					
					if(!vertexOnSameDistance.equals(vertex) && vertex.getAdjacentVertexes().contains(vertexOnSameDistance)){
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
	
	public static int p413ComputeSortestPathNumber(Vertex start, Vertex end){
	    Queue<Vertex> queue=new LinkedList<Vertex>();
	    Map<Vertex, Status> statusMap=new HashMap<Vertex, Status>();
	    Map<Vertex, Integer> levelMap=new HashMap<Vertex, Integer>();
	    List<List<Vertex>> allLevelList=new LinkedList<List<Vertex>>();
	    
	    queue.offer(start);
	    statusMap.put(start, Status.Queued);
	    levelMap.put(start, 0);
	    
	    Vertex vertex;
	    int lastLevel=-1;
	    List<Vertex> levelList = null;
	    while((vertex=queue.poll())!=null){
		int currentLevel=levelMap.get(vertex);
		
		if(currentLevel!=lastLevel){
		    lastLevel=currentLevel;
		    levelList=new LinkedList<Vertex>();
		    
		    allLevelList.add(levelList);
		}
		
		levelList.add(vertex);
		
		if(vertex.equals(end)){
		    break;
		}
		
		Set<Vertex> adjacentVertexes = vertex.getAdjacentVertexes();
		for (Iterator iterator = adjacentVertexes.iterator(); iterator.hasNext();) {
		    Vertex adjacent = (Vertex) iterator.next();

        		if(statusMap.get(adjacent)==null){
        		    queue.offer(adjacent);
        		    statusMap.put(adjacent, Status.Queued);
        		    levelMap.put(adjacent, currentLevel+1);
        		}
		}
	    }
	    
	    int count=0;
	    int max=Integer.MIN_VALUE;
	    List<Vertex> targetList=new LinkedList<Vertex>();
	    targetList.add(end);
	    for(int index=lastLevel-1;index>0;index--){
		    List<Vertex> lastLevelList = allLevelList.get(lastLevel-1);
		    List<Vertex> tmpList=new LinkedList<Vertex>();
		    
		    for (Iterator iterator = lastLevelList.iterator(); iterator.hasNext();) {
				Vertex lastLevelVertex = (Vertex) iterator.next();
				for (Iterator iterator2 = targetList.iterator(); iterator2.hasNext();) {
					Vertex vertex2 = (Vertex) iterator2.next();
					if(lastLevelVertex.getAdjacentVertexes().contains(vertex2)){
					    count++;
					    tmpList.add(vertex2);
					}
					
				}
		    }
		    
		    targetList=tmpList;
		    
		    if(count>max){
		    	max=count;
		    }
	    }
	    
	    return max;
	}
}
