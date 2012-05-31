package com.ssparrow.algorithm.graph;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class GraphUtilTest {

	@Test
	public void testBreadFirstSearch() {
		Graph graph=new Graph();
		
		Vertex v1=new Vertex("v1");
		Vertex v2=new Vertex("v2");
		Vertex v3=new Vertex("v3");
		Vertex v4=new Vertex("v4");
		Vertex v5=new Vertex("v5");
		Vertex v6=new Vertex("v6");
		
		Edge edge12 = new Edge(v1, v2);
		Edge edge15 = new Edge(v1, v5);
		Edge edge23 = new Edge(v2, v3);
		Edge edge34 = new Edge(v3, v4);
		Edge edge54 = new Edge(v5, v4);
		Edge edge46 = new Edge(v4, v6);
		
		graph.addVertex(v1);
		graph.addVertex(v2);
		graph.addVertex(v3);
		graph.addVertex(v4);
		graph.addVertex(v5);
		graph.addVertex(v6);
		
		List<Edge> bfsRresult = GraphUtil.breadthFirstSearch(v1);
		assertEquals(edge12, bfsRresult.get(0));
		assertEquals(edge15, bfsRresult.get(1));
		assertEquals(edge23, bfsRresult.get(2));
		assertEquals(edge54, bfsRresult.get(3));
		assertEquals(edge46, bfsRresult.get(4));
	}
	
	@Test
	public void testDepthFirstSearch(){
		Graph graph=new Graph();
		
		Vertex v1=new Vertex("v1");
		Vertex v2=new Vertex("v2");
		Vertex v3=new Vertex("v3");
		Vertex v4=new Vertex("v4");
		Vertex v5=new Vertex("v5");
		Vertex v6=new Vertex("v6");
		
		Edge edge12 = new Edge(v1, v2);
		Edge edge15 = new Edge(v1, v5);
		Edge edge23 = new Edge(v2, v3);
		Edge edge34 = new Edge(v3, v4);
		Edge edge54 = new Edge(v5, v4);
		Edge edge46 = new Edge(v4, v6);
		
		graph.addVertex(v1);
		graph.addVertex(v2);
		graph.addVertex(v3);
		graph.addVertex(v4);
		graph.addVertex(v5);
		graph.addVertex(v6);
		
		
		List<Edge> dfsRresult = new LinkedList<Edge>();
		Map<Vertex, Status> statusMap=new HashMap<Vertex, Status>();
		GraphUtil.depthFirstSearch(dfsRresult,statusMap, v1);
		assertEquals(edge12, dfsRresult.get(0));
		assertEquals(edge23, dfsRresult.get(1));
		assertEquals(edge34, dfsRresult.get(2));
		assertEquals(edge46, dfsRresult.get(3));
		assertEquals(edge15, dfsRresult.get(4));
	}
	
	@Test
	public void testCheckCircleInGraph(){
		Graph graph=new Graph();
		
		Vertex v1=new Vertex("v1");
		Vertex v2=new Vertex("v2");
		Vertex v3=new Vertex("v3");
		Vertex v4=new Vertex("v4");
		Vertex v5=new Vertex("v5");
		Vertex v6=new Vertex("v6");
		
		Edge edge12 = new Edge(v1, v2);
		Edge edge15 = new Edge(v1, v5);
		Edge edge25 = new Edge(v2, v5);
		Edge edge23 = new Edge(v2, v3);
		Edge edge34 = new Edge(v3, v4);
		Edge edge54 = new Edge(v5, v4);
		Edge edge46 = new Edge(v4, v6);
		
		graph.addVertex(v1);
		graph.addVertex(v2);
		graph.addVertex(v3);
		graph.addVertex(v4);
		graph.addVertex(v5);
		graph.addVertex(v6);
		
		assertTrue(GraphUtil.checkCircleInGraph(v1));
		
	}

}
