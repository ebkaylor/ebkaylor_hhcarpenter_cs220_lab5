package graph.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

/**
 * A basic representation of a graph that can perform BFS, DFS, Dijkstra,
 * and Prim-Jarnik's algorithm for a minimum spanning tree.
 * 
 * @author jspacco
 *
 */
public class Graph {
	Map<String,Node> nameToNode=new HashMap<String,Node>();
	Set<Node> vertices= new HashSet<Node>();
	Set<String> nodes= new HashSet<String>();
    /**
     * Return the {@link Node} with the given name.
     * 
     * If no {@link Node} with the given name exists, create
     * a new node with the given name and return it. Subsequent
     * calls to this method with the same name should
     * then return the node just created.
     * 
     * @param name
     * @return
     */
    public Node getOrCreateNode(String name) {
    	if (!nameToNode.containsKey(name))
    	{
    		 nameToNode.put(name, new Node(name));
    	}
    
		 return nameToNode.get(name);

    	
    	
    }

    /**
     * Return true if the graph contains a node with the given name,
     * and false otherwise.
     * 
     * @param name
     * @return
     */
    public boolean containsNode(String name) {
        return(nameToNode.containsKey(name));
    }

    /**
     * Return a collection of all of the nodes in the graph.
     * 
     * @return
     */
    public Collection<Node> getAllNodes() {
        Set <Node> collection = new HashSet <Node>();
    	for (Node n: nameToNode.values()) {
    		collection.add(n);
    	}
    	return collection;
    }

    /**
     * Return the sum of the weights of all edges in the graph.
     * 
     * This method should definitely work on undirected, weighted graphs.
     * We are also assuming that undirected edges are symmetric; i.e. that
     * and edge from A to B with a weight of 10 means there's an edge from B to A
     * with a weight of 10.
     * 
     * We are <b>not</b> going to test this method on directed, weighted graphs. 
     * So you don't have to worry about this situation; you can just ignore this
     * possibility.
     * 
     * @return
     */
    public int getSumOfAllEdgeWeights() {
        int sum = 0;    	
    	ArrayList<Integer> edgeWeights = new ArrayList<Integer>();
    	for (Node n : nameToNode.values())
    	{
    		Set<Node> foo = new HashSet<Node>();
    		foo.addAll(getAllNodes());
    		for (Node fooNode: foo)
    		{
    		edgeWeights.add(n.getWeight(fooNode));
    		}
    	}
    	for (int i : edgeWeights)
    	{
    		sum+=i;
    	}
    	return sum/2;
    	
    }

    /**
     * Perform a breadth-first search on the graph, starting at the node
     * with the given name. The visit method of the {@link NodeVisitor} should
     * be called on each node the first time we visit the node.
     * 
     * <b>NOTE:</b> This method visit nodes in alphabetical order, using the name of the
     * node to sort alphabetically.
     * 
     * @param startNodeName
     * @param v
     */
    public void breadthFirstSearch(String startNodeName, NodeVisitor v) {
    	v.visit(nameToNode.get(startNodeName));
    	Set <Node> setVisited = new HashSet <Node>();
    	Queue <Node> queueToVisit = new PriorityQueue<Node>();

    	while (setVisited.size() < nameToNode.size()) {
    		queueToVisit.add(nameToNode.get(startNodeName));
    		for (Node n : queueToVisit)
    		{
    			setVisited.add(n);
    			v.visit(n);
    			queueToVisit.addAll(n.getNeighbors());
    		}
    		
    	}
    	
    	
    	
    	
    }

    /**
     * Perform a depth-first search on the graph, starting at the node
     * with the given name. The visit method of the {@link NodeVisitor} should
     * be called on each node the first time we visit the node.
     * 
     * <b>NOTE:</b> This method visit nodes in alphabetical order, using the name of the
     * node to sort alphabetically.
     * 
     * @param startNodeName
     * @param v
     */
    public void depthFirstSearch(String startNodeName, NodeVisitor v) {
    	v.visit(nameToNode.get(startNodeName));
    	Set <Node> setVisited = new HashSet <Node>();
    	Set <Node> setToVisit = new HashSet <Node>();

    	while (setVisited.size() < nameToNode.size()) {
    		setToVisit.addAll(nameToNode.values());
    		for (Node n : setToVisit)
    		{
    			setVisited.add(n);
    			v.visit(n);
    		}
    	}
    	
    }

    /**
     * Perform Dijkstra's algorithm for computing the cost of the shortest path
     * to every node in the graph starting at the node with the given name.
     * Return a mapping from every node in the graph to the total minimum cost of reaching
     * that node from the given start node.
     * 
     * <b>Hint:</b> Creating a helper class called Path, which stores a destination
     * (String) and a cost (Integer), and making it implement Comparable, can be
     * helpful. Well, either that or repeated linear scans.
     * 
     * @param startName
     * @return
     */
    public Map<Node, Integer> dijkstra(String startName) {
    Queue <Integer> line = new PriorityQueue <Integer>();
    Map <Node, Integer> nodeToInteger = new TreeMap <Node, Integer>();
    for (Node s :nameToNode.get(startName).getNeighbors())
    line.add(nameToNode.get(startName).neighbors.get(s));	
    nodeToInteger.put(getOrCreateNode(startName),0);
    while (nodeToInteger.size()<getAllNodes().size())
      {
    	
    	  
    	  
      }
    	
    	
    }

    /**
     * Perform Prim-Jarnik's algorithm to compute a Minimum Spanning Tree (MST).
     * 
     * The MST is itself a graph containing the same nodes and a subset of the edges 
     * from the original graph.
     * 
     * <b>Hint:</b> This method is easier if you create a class for Edge that is
     * Comparable, and use that to find the smallest edge to a node on the frontier.
     * Prim-Jarnik is a greedy algorithm that constantly chooses the lowest-weight
     * edge to a node that is not yet part of the spanning tree (i.e. is still on
     * the "frontier" of nodes that have not been added).
     * 
     * @return
     */
    public Graph primJarnik() {
        
    	
    	
    	
    	
    	
    }

    /**
     * Static factory method for creating a graph from a list of connections
     * between nodes. The given InputStream will contain lines in the following format:
     * <pre>
     * A B
     * A C
     * B C
     * C D
     * </pre>
     * 
     * This would mean that there are edges from A to B, A to C, B to C, and C to D.
     * The graph is undirected and also unweighted, so the edge weights are not relevant.
     * 
     * @param in
     * @return
     * @throws IOException
     */
    public static Graph createUndirectedUnweightedGraphFromEdgeList(InputStream in) throws IOException {
        throw new UnsupportedOperationException("Implement this method");
    }

    /**
     * Static factory that creates and returns a weighted, undirected
     * graph from list of edges and weights in the given InputStream.
     * The format will be one edge on each line:
     * <pre>
     * A B 3
     * B C 7
     * A D 8
     * </pre>
     * This means that there are edges between A and B with a cost of 3,
     * B and C with a cost of 7, and A and D with a cost of 8. All of these
     * edges are undirected, or directed in both directions.
     * 
     * @param in
     * @return
     * @throws IOException
     */
    public static Graph createUndirectedWeightedGraphFromEdgeList(InputStream in) throws IOException {
        throw new UnsupportedOperationException("Implement this method");
    }

    /**
     * Static factory that creates and returns a weighted, directed
     * graph from list of edges and weights in the given InputStream.
     * The format will be one edge on each line:
     * <pre>
     * A B 3
     * B C 7
     * A D 8
     * </pre>
     * This means that there is an edge from A to B with a weight of 3
     * (but no edge from B back to A), an edge from B to C with weight 7
     * (but again no edge from C back to B), and an edge from A to D with weight 8
     * (again, no return edge from D to A). 
     * 
     * @param in
     * @return
     * @throws IOException
     */
    public static Graph createDirectedWeightedGraphFromEdgeList(InputStream in) throws IOException {
        throw new UnsupportedOperationException("Implement this method");
    }

    /**
     * Static factory that creates and returns a weighted, directed
     * graph from list of edges and weights in the given InputStream.
     * The format will be one edge on each line:
     * <pre>
     * A B
     * B C
     * A D
     * </pre>
     * This means that there is an edge from A to B 
     * (but no edge from B back to A), an edge from B to C,
     * (but again no edge from C back to B), and an edge from A to D
     * (again, no return edge from D to A). 
     * 
     * @param in
     * @return
     * @throws IOException
     */
    public static Graph createDirectedUnweightedGraphFromEdgeList(InputStream in) throws IOException {
        throw new UnsupportedOperationException("Implement this method");
    }

    /**
     * Create a String representing the given graph in DOT format, suitable
     * for display with GraphViz. The graph is assumed to be
     * an <b>unweighted</b>, <b>undirected</b> graph, so the edges will not be labeled.  
     * The graph and its file will be named
     * according to the given graphname.
     * 
     * You can visualize DOT files on http://www.webgraphviz.com/
     * 
     * For example, this is a graph in DOT format:
     * <pre>
     * graph G {
     * A -- B
     * A -- C
     * B -- C
     * C -- D 
     * }
     * </pre>
     * 
     * Try this graph out at 
     * 
     * Note that edges should be listed only once, and should be given 
     * in alphabetical order (i.e. A -- B, not B -- A).
     * 
     * @param g
     * @param graphname 
     */
    public String toUndirectedUnweightedDotFile(String graphname) {
        throw new UnsupportedOperationException("Implement this method");
    }

    /**
     * Return a String containing the given graph in DOT format, suitable
     * for display with GraphViz. The graph is assumed to be
     * a <b>weighted</b>, <b>undirected</b> graph, so each edge will be labeled with
     * its weight. The graph and its file will be named
     * according to the given graphname.
     * 
     * You can visualize DOT files on http://www.webgraphviz.com/
     * <pre>
     * graph G {
     * A -- B [label=10];
     * A -- C [label=6];
     * B -- C [label=7];
     * C -- D [label=3];
     * }
     * </pre>
     * 
     * This would create a weighted undirected graph where there are edges
     * between A and B with weight 10, A and C with weight 6, B and C with weight 7,
     * and C and D with weight 3.
     * 
     * @param g the graph
     * @param graphname the name of the graph
     */
    public String toUndirectedWeightedDotFile(String graphname) {
        throw new UnsupportedOperationException("Implement this method");
    }

    /**
     * Return a String containing the given graph in DOT format, suitable
     * for display with GraphViz. The graph is assumed to be
     * a weighted, directed graph, so each edge will be labeled with
     * its weight, as well as a direction. The graph and its file will be named
     * according to the given graphname.
     * 
     * You can visualize DOT files on http://www.webgraphviz.com/
     * <pre>
     * digraph G {
     * A -> B [label=10];
     * A -> C [label=6];
     * B -> C [label=7];
     * C -> D [label=3];
     * }
     * </pre>
     * 
     * This would create a weighted directed graph where there are edges
     * from A to B with weight 10, A to C with weight 6, B to C with weight 7,
     * and C to D with weight 3.
     * 
     * @param g the graph
     * @param graphname the name of the graph
     */
    public String toDirectedWeightedDotFile(String graphname) {
        throw new UnsupportedOperationException("Implement this method");
    }

    /**
     * Return a String containing the given graph in DOT format, suitable
     * for display with GraphViz. The graph is assumed to be
     * a <b>unweighted</b>, <b>directed</b> graph, so each edge will be labeled with
     * its weight, as well as a direction. The graph and its file will be named
     * according to the given graphname.
     * 
     * You can visualize DOT files on http://www.webgraphviz.com/
     * <pre>
     * digraph G {
     * A -> B;
     * A -> C;
     * B -> C;
     * C -> D;
     * }
     * </pre>
     * 
     * This would create an unweighted directed graph where there are edges
     * from A to B, A to C, B to C, and C to D.
     * 
     * @param g the graph
     * @param graphname the name of the graph
     */
    public String toDirectedUnWeightedDotFile(String graphname) {
        throw new UnsupportedOperationException("Implement this method");
    }
}
