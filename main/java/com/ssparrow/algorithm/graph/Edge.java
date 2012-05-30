package com.ssparrow.algorithm.graph;

public class Edge {
	private boolean isDirected=false;
	private int weight;
	
	private Vertex source;
	private Vertex target;
	
	public Edge(Vertex source, Vertex target) {
		this.source = source;
		this.target = target;
		
		source.addEdge(this);
		target.addEdge(this);
	}

	public Edge(boolean isDirected, Vertex source, Vertex target) {
		this.source = source;
		this.target = target;
		
		this.isDirected = isDirected;
		
		if(isDirected){
			source.addEdge(this);
		}else{
			source.addEdge(this);
			target.addEdge(this);
		}
	}

	public boolean isDirected() {
		return isDirected;
	}

	public void setDirected(boolean isDirected) {
		this.isDirected = isDirected;
	}

	public Vertex getSource() {
		return source;
	}

	public void setSource(Vertex source) {
		this.source = source;
	}

	public Vertex getTarget() {
		return target;
	}

	public void setTarget(Vertex target) {
		this.target = target;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isDirected ? 1231 : 1237);
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + ((target == null) ? 0 : target.hashCode());
		result = prime * result + weight;
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
		Edge other = (Edge) obj;
		if (isDirected != other.isDirected)
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		if (target == null) {
			if (other.target != null)
				return false;
		} else if (!target.equals(other.target))
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Edge [isDirected=" + isDirected + ", weight=" + weight
				+ ", source=" + source + ", target=" + target + "]";
	}
	
	
}
