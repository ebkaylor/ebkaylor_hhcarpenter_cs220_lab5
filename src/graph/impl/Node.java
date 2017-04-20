


package graph.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Class to represent a single node (or vertex) of a graph.
 * 
 * Node can be used for either directed or undirected graphs, as well as
 * for weighted or unweighted graphs. For unweighted graphs, use something like 1 for all 
 * of the weights. For undirected graphs, add a directed edge in both directions.
 * 
 * You want to make as many operations O(1) as possible, which means you will
 * probably use a lot of Maps.
 * 
 * Side note: You can tell that I come from a networking background and not a mathematical
 * background because I almost always use the term "node" instead of "vertex".
 * 
 * @author jspacco
 *
 */
public class Node implements Comparable<Node> {

    /**
     * Create a new node with the given name. The newly created node should
     * have no edges.
     * @param name
     */
	Node node;
	String myName;
	Map <Node, Integer> neighbors;
    public Node(String name) {
        node = new Node(name);
        myName = name;
        neighbors = new HashMap <Node, Integer>();
    }

    /**
     * Return the name of the node, which is a String.
     * 
     * @return
     */
    public String getName() {
       return myName;
    }

    /**
     * Return a collection of nodes that the current node is connected to by an edge.
     * 
     * @return
     */
    public Collection<Node> getNeighbors() {
    	Set<Node> collection = new HashSet<Node>();
        for (Node s : neighbors.keySet())
        {
        	collection.add(s);
        }
    	return collection;
    }

    /**
     * Add a directed edge to the given node using the given weight.
     * 
     * @param n
     * @param weight
     */
    public void addDirectedEdgeToNode(Node n, int weight) {
        neighbors.put(n, weight);
    	
     }

    /**
     * Add an undirected edge to the given node using the given weight.
     * Remember than an undirected edge can be implemented using two directed edges.
     * 
     * @param n
     * @param weight
     */
    public void addUndirectedEdgeToNode(Node n, int weight) {
        neighbors.put(n, weight);
        n.neighbors.put(this, weight);
    }

    /**
     * Remove the directed edge to the given node.
     * 
     * If there is no edge to the given node, throw
     * IllegalStateException (which is a type of runtime exception).
     * 
     * @param n
     * @throws IllegalStateException
     */
    public void removeDirectedEdgeToNode(Node n) {
        if (neighbors.containsKey(n)) {
        	neighbors.remove(n);
        }
        else {
        	throw new IllegalStateException();
        }
    }

    /**
     * Remove an undirected edge to the given node. This means removing
     * the edge to the given node, but also any edge from the given
     * node back to this node.
     * 
     * Throw a IllegalStateException if there is no edge to the given node.
     * 
     * @param n
     * @throws IllegalStateException
     */
    public void removeUndirectedEdgeToNode(Node n) {
    	if (neighbors.containsKey(n) && n.neighbors.containsKey(this)) {
    		neighbors.remove(n);
    		n.neighbors.remove(this);
    	}
    	else {
    		throw new IllegalStateException();
    	}
    	
    }

    /**
     * Return true if there is an edge to the given node from this node,
     * and false otherwise.
     * 
     * @param other
     * @return
     */
    public boolean hasEdge(Node other) {
        if (neighbors.containsKey(other))
        {
        	return true;
        }
        else {
        	return false;
        }
    	
    }

    /**
     * Get the weight of the edge to the given node.
     * 
     * If no such edge exists, throw {@link IllegalStateException}
     * 
     * @param n
     * @return
     * @throws IllegalStateException
     */
    public int getWeight(Node n) {
    	if (hasEdge(n))
    	{
    		return neighbors.get(n);
    	}
    	else
    	{
    		throw new IllegalStateException();
    	}
    }

    @Override
    public int compareTo(Node o) {
        // Nodes should be sorted alphabetically by their name
        // just delegate to the compareTo() method for String
    	return myName.compareTo(o.getName());
    	
    	
    	
    }

    @Override
    public String toString() {
        return myName;
    }
}
