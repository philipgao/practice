package com.ssparrow.algorithm.graph;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Vertex {
	private String id;
	
	private Set<Vertex> adjacentVertexes=new LinkedHashSet<Vertex>();
	private Set<Edge> edges=new LinkedHashSet<Edge>();
	private Map<Vertex, Edge> vertexEdgeMap=new HashMap<Vertex, Edge>();
	
	public Vertex(String id) {
		this.id = id;
	}

	public Set<Vertex> getAdjacentVertexes() {
		return adjacentVertexes;
	}

	public Set<Edge> getEdges() {
		return edges;
	}
	
	public void addEdge(Edge edge){
		if(edge.getSource().equals(this)){
			adjacentVertexes.add(edge.getTarget());
			edges.add(edge);
			vertexEdgeMap.put(edge.getTarget(), edge);
		}
	}
	
	public Edge getEdge(Vertex target){
		return vertexEdgeMap.get(target);
	}

	@Override
	public String toString() {
		return "Vertex [id=" + id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
