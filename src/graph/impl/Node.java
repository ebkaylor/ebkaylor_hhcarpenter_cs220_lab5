


package graph.impl;

import java.util.Collection;

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
    public Node(String name) {
        throw new UnsupportedOperationException("Implement this method");
    }

    /**
     * Return the name of the node, which is a String.
     * 
     * @return
     */
    public String getName() {
        throw new UnsupportedOperationException("Implement this method");
    }

    /**
     * Return a collection of nodes that the current node is connected to by an edge.
     * 
     * @return
     */
    public Collection<Node> getNeighbors() {
        throw new UnsupportedOperationException("Implement this method");
    }

    /**
     * Add a directed edge to the given node using the given weight.
     * 
     * @param n
     * @param weight
     */
    public void addDirectedEdgeToNode(Node n, int weight) {
        throw new UnsupportedOperationException("Implement this method");
    }

    /**
     * Add an undirected edge to the given node using the given weight.
     * Remember than an undirected edge can be implemented using two directed edges.
     * 
     * @param n
     * @param weight
     */
    public void addUndirectedEdgeToNode(Node n, int weight) {
        throw new UnsupportedOperationException("Implement this method");
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
        throw new UnsupportedOperationException("Implement this method");
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
        throw new UnsupportedOperationException("Implement this method");
    }

    /**
     * Return true if there is an edge to the given node from this node,
     * and false otherwise.
     * 
     * @param other
     * @return
     */
    public boolean hasEdge(Node other) {
        throw new UnsupportedOperationException("Implement this method");
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
        throw new UnsupportedOperationException("Implement this method");
    }

    @Override
    public int compareTo(Node o) {
        // Nodes should be sorted alphabetically by their name
        // just delegate to the compareTo() method for String
        throw new UnsupportedOperationException("Implement this method");
    }

    @Override
    public String toString() {
        // Just return the Node's name
        // toString() really helps you use the debugger
        throw new UnsupportedOperationException("Implement this method");
    }
}
