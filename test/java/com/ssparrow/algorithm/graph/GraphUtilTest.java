package com.ssparrow.algorithm.graph;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
	
	@Test
	public void testTopologicalSortGraph(){
		Graph graph=new Graph();
		
		Vertex shirt=new Vertex("shirt");
		Vertex tie=new Vertex("tie");
		Vertex jacket=new Vertex("jacket");
		Vertex belt=new Vertex("belt");
		Vertex watch = new Vertex("watch");
		Vertex underShorts=new Vertex("underShorts");
		Vertex pants=new Vertex("pants");
		Vertex shoes=new Vertex("shoes");
		Vertex socks=new Vertex("socks");
		
		graph.addVertex(shirt);
		graph.addVertex(tie);
		graph.addVertex(jacket);
		graph.addVertex(belt);
		graph.addVertex(watch);
		graph.addVertex(underShorts);
		graph.addVertex(pants);
		graph.addVertex(shoes);
		graph.addVertex(socks);
		
		Edge edge1=new Edge(shirt, tie);
		Edge edge2=new Edge(shirt, belt);
		Edge edge3=new Edge(tie, jacket);
		Edge edge4=new Edge(belt, jacket);
		Edge edge5=new Edge(underShorts, pants);
		Edge edge6=new Edge(underShorts, shoes);
		Edge edge7=new Edge(pants, shoes);
		Edge edge8=new Edge(pants, belt);
		Edge edge9=new Edge(socks, shoes);
		
		graph.addEdge(edge1);
		graph.addEdge(edge2);
		graph.addEdge(edge3);
		graph.addEdge(edge4);
		graph.addEdge(edge5);
		graph.addEdge(edge6);
		graph.addEdge(edge7);
		graph.addEdge(edge8);
		graph.addEdge(edge9);
		
		List<Vertex> topoSortResult = GraphUtil.topologicalSortGraph(graph);
		assertEquals(socks, topoSortResult.get(0));
		assertEquals(underShorts, topoSortResult.get(1));
		assertEquals(pants, topoSortResult.get(2));
		assertEquals(shoes, topoSortResult.get(3));
		assertEquals(watch, topoSortResult.get(4));
		assertEquals(shirt, topoSortResult.get(5));
		assertEquals(belt, topoSortResult.get(6));
		assertEquals(tie, topoSortResult.get(7));
		assertEquals(jacket, topoSortResult.get(8));
	}
	
	@Test
	public void testTopologicalSortFromVertex(){
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
	    

		List<Vertex> topoSortResult = new LinkedList<Vertex>();
		Map<Vertex, Status> statusMap=new HashMap<Vertex, Status>();
		GraphUtil.topologicalSortFromVertex(topoSortResult, statusMap, v1);
		assertEquals(v1, topoSortResult.get(0));
		assertEquals(v5, topoSortResult.get(1));
		assertEquals(v2, topoSortResult.get(2));
		assertEquals(v3, topoSortResult.get(3));
		assertEquals(v4, topoSortResult.get(4));
		assertEquals(v6, topoSortResult.get(5));
	}
	
	@Test
	public void testCreateTranspose(){

		Graph graph=new Graph();
		
		Vertex shirt=new Vertex("shirt");
		Vertex tie=new Vertex("tie");
		Vertex jacket=new Vertex("jacket");
		Vertex belt=new Vertex("belt");
		Vertex watch = new Vertex("watch");
		Vertex underShorts=new Vertex("underShorts");
		Vertex pants=new Vertex("pants");
		Vertex shoes=new Vertex("shoes");
		Vertex socks=new Vertex("socks");
		
		graph.addVertex(shirt);
		graph.addVertex(tie);
		graph.addVertex(jacket);
		graph.addVertex(belt);
		graph.addVertex(watch);
		graph.addVertex(underShorts);
		graph.addVertex(pants);
		graph.addVertex(shoes);
		graph.addVertex(socks);
		
		Edge edge1=new Edge(shirt, tie);
		Edge edge2=new Edge(shirt, belt);
		Edge edge3=new Edge(tie, jacket);
		Edge edge4=new Edge(belt, jacket);
		Edge edge5=new Edge(underShorts, pants);
		Edge edge6=new Edge(underShorts, shoes);
		Edge edge7=new Edge(pants, shoes);
		Edge edge8=new Edge(pants, belt);
		Edge edge9=new Edge(socks, shoes);
		
		graph.addEdge(edge1);
		graph.addEdge(edge2);
		graph.addEdge(edge3);
		graph.addEdge(edge4);
		graph.addEdge(edge5);
		graph.addEdge(edge6);
		graph.addEdge(edge7);
		graph.addEdge(edge8);
		graph.addEdge(edge9);
		
		Graph transpose=GraphUtil.createTranspose(graph);
		Set<Vertex> transposeVertextes = transpose.getAllVertextes();
		
		assertEquals(9, transposeVertextes.size());
		
		List<Vertex> transposeList = new ArrayList<Vertex>(transposeVertextes);
		
		assertEquals("shirt_t", transposeList.get(0).getId());
		assertEquals("tie_t", transposeList.get(1).getId());
		assertEquals("jacket_t", transposeList.get(2).getId());
		assertEquals("belt_t", transposeList.get(3).getId());
		assertEquals("watch_t", transposeList.get(4).getId());
		assertEquals("underShorts_t", transposeList.get(5).getId());
		assertEquals("pants_t", transposeList.get(6).getId());
		assertEquals("shoes_t", transposeList.get(7).getId());
		assertEquals("socks_t", transposeList.get(8).getId());
		

		assertEquals(0, transposeList.get(0).getAdjacentVertexes().size());
		assertEquals(1, transposeList.get(1).getAdjacentVertexes().size());
		assertEquals(2, transposeList.get(2).getAdjacentVertexes().size());
		assertEquals(2, transposeList.get(3).getAdjacentVertexes().size());
		assertEquals(0, transposeList.get(4).getAdjacentVertexes().size());
		assertEquals(0, transposeList.get(5).getAdjacentVertexes().size());
		assertEquals(1, transposeList.get(6).getAdjacentVertexes().size());
		assertEquals(3, transposeList.get(7).getAdjacentVertexes().size());
		assertEquals(0, transposeList.get(8).getAdjacentVertexes().size());
	}
	
	@Test
	public void testDindStronglyConnectedComponents(){
		Graph graph=new Graph();
		
		Vertex a=new Vertex("a");
		Vertex b=new Vertex("b");
		Vertex c=new Vertex("c");
		Vertex d=new Vertex("d");
		Vertex e = new Vertex("e");
		Vertex f=new Vertex("f");
		Vertex g=new Vertex("g");
		Vertex h=new Vertex("h");
		
		graph.addVertex(c);
		graph.addVertex(g);
		graph.addVertex(d);
		graph.addVertex(f);
		graph.addVertex(h);
		graph.addVertex(b);
		graph.addVertex(e);
		graph.addVertex(a);
		
		Edge edge1=new Edge(a,b);
		Edge edge2=new Edge(b, e);
		Edge edge3=new Edge(e, a);
		Edge edge4=new Edge(b, c);
		Edge edge5=new Edge(b, f);
		Edge edge6=new Edge(e, f);
		Edge edge9=new Edge(c, g);
		Edge edge7=new Edge(c, d);
		Edge edge8=new Edge(d, c);
		Edge edge10=new Edge(f, g);
		Edge edge11=new Edge(g, f);
		Edge edge12=new Edge(g, h);
		Edge edge13=new Edge(h, h);
		
		graph.addEdge(edge1);
		graph.addEdge(edge2);
		graph.addEdge(edge3);
		graph.addEdge(edge4);
		graph.addEdge(edge5);
		graph.addEdge(edge6);
		graph.addEdge(edge7);
		graph.addEdge(edge8);
		graph.addEdge(edge9);
		graph.addEdge(edge10);
		graph.addEdge(edge11);
		graph.addEdge(edge12);
		graph.addEdge(edge13);
		
		List<List<Vertex>> scc = GraphUtil.findStronglyConnectedComponents(graph);
		assertEquals(4, scc.size());
		assertEquals(3, scc.get(0).size());
		assertEquals(2, scc.get(1).size());
		assertEquals(2, scc.get(2).size());
		assertEquals(1, scc.get(3).size());
	}

	@Test
	public void testGetConnectedRegions(){
		int [][] matrix=new int[][]{{1,0,1}};
		
		assertEquals(2, GraphUtil.getConnectedRegionsByRecursion(matrix));
		

		assertEquals(2, GraphUtil.getConnectedRegionsByLabeling(matrix));
		
		matrix=new int[][]{
		{1,0,1,0,0,1},
		{1,1,0,1,1,0},
		{1,1,1,0,0,0},
		{0,0,0,0,1,0}
		};		

		assertEquals(5, GraphUtil.getConnectedRegionsByRecursion(matrix));
		

		assertEquals(5, GraphUtil.getConnectedRegionsByLabeling(matrix));
	}
}
