package com.ssparrow.algorithm.graph;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Graph {
	private Set<Vertex> allVertextes;
	private Set<Edge> allEdges;
	
	Map<String, Vertex> vertexMap=new HashMap<String, Vertex>();
	
	public Graph() {
		allVertextes=new LinkedHashSet<Vertex>();
		allEdges=new LinkedHashSet<Edge>();
	}

	public Graph(Set<Vertex> allVertextes, Set<Edge> allEdges) {
		this.allVertextes = allVertextes;
		this.allEdges = allEdges;
		
		for(Vertex vertex:allVertextes){
			vertexMap.put(vertex.getId(), vertex);
		}
	}
	
	public void addVertex(Vertex vertex){
		allVertextes.add(vertex);
		allEdges.addAll(vertex.getEdges());
		
		vertexMap.put(vertex.getId(), vertex);
	}
	
	public void addEdge(Edge edge){
		allVertextes.add(edge.getSource());
		allVertextes.add(edge.getTarget());
		allEdges.add(edge);
		
		vertexMap.put(edge.getSource().getId(), edge.getSource());
		vertexMap.put(edge.getTarget().getId(), edge.getTarget());
	}
	
	public Vertex getVertex(String id){
		return vertexMap.get(id);
	}

	public Set<Vertex> getAllVertextes() {
		return allVertextes;
	}

	public Set<Edge> getAllEdges() {
		return allEdges;
	}
	
}
