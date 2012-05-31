package com.ssparrow.algorithm.graph;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingDeque;


public class GraphUtil {
	
	/**
	 * @param start
	 * @return
	 */
	public static List<Edge> breadthFirstSearch(Vertex start){
		List<Edge> result=new LinkedList<Edge>();

		Map<Vertex, Status> statusMap=new HashMap<Vertex, Status>();
		Queue<Vertex> bfsQueue=new LinkedBlockingDeque<Vertex>();
		
		bfsQueue.offer(start);
		statusMap.put(start, Status.Queued);
		
		while(bfsQueue.peek()!=null){
			Vertex vertex = bfsQueue.poll();
			Set<Vertex> adjacentVertexes = vertex.getAdjacentVertexes();
			
			for (Iterator iterator = adjacentVertexes.iterator(); iterator.hasNext();) {
				Vertex adjacent = (Vertex) iterator.next();
				if(statusMap.get(adjacent)==null ||statusMap.get(adjacent).equals(Status.Unvisited)){
					statusMap.put(adjacent, Status.Queued);
					bfsQueue.offer(adjacent);
					
					result.add(vertex.getEdge(adjacent));
				}
			}
			
			statusMap.put(vertex, Status.Visited);
		}
		
		return result;
	}
	
	/**
	 * @param result
	 * @param vertex
	 */
	public static void depthFirstSearch(List<Edge> result,Map<Vertex, Status> statusMap,  Vertex vertex){
		
		Set<Vertex> adjacentVertexes = vertex.getAdjacentVertexes();
		for (Iterator iterator = adjacentVertexes.iterator(); iterator.hasNext();) {
			Vertex adjacent = (Vertex) iterator.next();
			
			if(statusMap.get(adjacent)==null ||statusMap.get(adjacent).equals(Status.Unvisited)){
				statusMap.put(adjacent, Status.Queued);
				result.add(vertex.getEdge(adjacent));
				
				depthFirstSearch(result, statusMap, adjacent);
			}
		}
		
		statusMap.put(vertex, Status.Visited);
	}
	

	/**
	 * @param vertex
	 * @return
	 */
	public static boolean checkCircleInGraph(Vertex vertex){
		List<Vertex> result =new LinkedList<Vertex>();
		Map<Vertex, Status> statusMap=new LinkedHashMap<Vertex, Status>();
		
		checkCircleInGraph(result, statusMap, vertex, null);
		
		return result.size()>0;
	}
	
	private static void checkCircleInGraph(List<Vertex> result, Map<Vertex, Status> statusMap, Vertex vertex, Vertex predecessor){
		Set<Vertex> adjacentVertexes = vertex.getAdjacentVertexes();
		
		for (Iterator iterator = adjacentVertexes.iterator(); iterator.hasNext();) {
			Vertex adjacent = (Vertex) iterator.next();
			
			if(statusMap.get(adjacent)==null || statusMap.get(adjacent).equals(Status.Unvisited)){
				statusMap.put(adjacent, Status.Queued);
				checkCircleInGraph(result, statusMap, adjacent, vertex);
			}else if(statusMap.get(adjacent).equals(Status.Queued) && !adjacent.equals(predecessor)){
				result.add(vertex);
			}
		}
		
	}
}
