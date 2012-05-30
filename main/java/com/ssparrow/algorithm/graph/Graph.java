package com.ssparrow.algorithm.graph;

import java.util.LinkedHashSet;
import java.util.Set;

public class Graph {
	private Set<Vertex> allVertextes;
	private Set<Edge> allEdges;
	
	public Graph() {
		allVertextes=new LinkedHashSet<Vertex>();
		allEdges=new LinkedHashSet<Edge>();
	}

	public Graph(Set<Vertex> allVertextes, Set<Edge> allEdges) {
		this.allVertextes = allVertextes;
		this.allEdges = allEdges;
	}
	
	public void addVertex(Vertex vertex){
		allVertextes.add(vertex);
		allEdges.addAll(vertex.getEdges());
	}
	
	public void addEdge(Edge edge){
		allVertextes.add(edge.getSource());
		allVertextes.add(edge.getTarget());
		allEdges.add(edge);
	}
}
