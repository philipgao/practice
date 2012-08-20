package com.ssparrow.algorithm.graph;

import java.util.ArrayList;
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
	
	/**
	 * @param statusMap
	 * @param graph
	 * @return
	 */
	public static List<Vertex> topologicalSortGraph(Graph graph){
		List<Vertex> result =  new LinkedList<Vertex>();
		Map<Vertex, Status> statusMap=new HashMap<Vertex, Status>();
		
		for(Vertex vertex:graph.getAllVertextes()){
			if(statusMap.get(vertex)==null || statusMap.get(vertex).equals(Status.Unvisited)){
				topologicalSortFromVertex(result, statusMap, vertex);
			}
		}
		
		return result;
	}
	
	
	/**
	 * @param result
	 * @param statusMap
	 * @param vertex
	 */
	public static void topologicalSortFromVertex(List<Vertex> result, Map<Vertex, Status> statusMap,Vertex vertex){
		statusMap.put(vertex, Status.Queued);
		
		Set<Vertex> adjacentVertexes = vertex.getAdjacentVertexes();
		
		for (Iterator iterator = adjacentVertexes.iterator(); iterator.hasNext();) {
			Vertex adjacent = (Vertex) iterator.next();
			
			if(statusMap.get(adjacent)==null || statusMap.get(adjacent).equals(Status.Unvisited)){
			    topologicalSortFromVertex(result, statusMap, adjacent);
			}
			
		}
		
		statusMap.put(vertex, Status.Visited);

		result.add(0, vertex);
	}
	
	
	public static List<List<Vertex>> findStronglyConnectedComponents(Graph graph){
		List<Vertex> topoSortVertexs=topologicalSortGraph(graph);
		
		Graph transpose = createTranspose(graph);
		
		List<List<Vertex>>  scc=new LinkedList<List<Vertex>>();
		Map<Vertex, Status> statusMap=new HashMap<Vertex, Status>();
		
		for(Vertex vertex:topoSortVertexs){
			Vertex transposeVertex=transpose.getVertex(vertex.getId()+"_t");
			
			if(statusMap.get(transposeVertex)==null || statusMap.get(transposeVertex).equals(Status.Unvisited)){
				
				List<Vertex> components=new LinkedList<Vertex>();
				findStronglyConnectedComponents(statusMap, components, transposeVertex);
				
				scc.add(components);
			}
		}
		
		return scc;
	}
	
	private static void findStronglyConnectedComponents(Map<Vertex, Status> statusMap, List<Vertex> components, Vertex vertex){ 
		statusMap.put(vertex, Status.Queued);
		components.add(vertex);
		
		Set<Vertex> adjacentVertexes = vertex.getAdjacentVertexes();
		
		for(Vertex adjacentVertex:adjacentVertexes){
			if(statusMap.get(adjacentVertex)==null || statusMap.get(adjacentVertex).equals(Status.Unvisited)){
				findStronglyConnectedComponents(statusMap, components, adjacentVertex);
			}
		}

		statusMap.put(vertex, Status.Visited);
	}
	
	public static Graph createTranspose(Graph graph){
		Graph transpose = new Graph();
		
		for(Vertex vertex:graph.getAllVertextes()){
			String transposeId = vertex.getId()+"_t";
			Vertex transposeVertex=new Vertex(transposeId);
			
			transpose.addVertex(transposeVertex);
		}
		
		for(Edge edge:graph.getAllEdges()){
			Vertex source=edge.getSource();
			Vertex target = edge.getTarget();
			
			String transposeSourceId = source.getId()+"_t";
			Vertex transposeSource=transpose.getVertex(transposeSourceId);
			
			String transposeTargetId = target.getId()+"_t";
			Vertex transposeTarget=transpose.getVertex(transposeTargetId);
			
			transpose.addEdge(new Edge(transposeTarget, transposeSource));
		}
		
		return transpose;
	}
}
