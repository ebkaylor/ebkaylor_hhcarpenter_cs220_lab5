package junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;

import org.junit.Test;

import graph.impl.*;
//import graph.sol.*;

public class TestGraphBasic
{
    @Test
    public void testNodeConstructor()
    {
        Node n=new Node("A");
        assertEquals("A", n.getName());
        assertEquals(0, n.getNeighbors().size());
    }
    
    @Test
    public void testAddUndirectedEdges()
    {
        Node n1=new Node("A");
        Node n2=new Node("B");
        n1.addUndirectedEdgeToNode(n2, 5);
        assertEquals(5, n1.getWeight(n2));
        assertEquals(5, n2.getWeight(n1));
    }
    
    
    @Test
    public void testAddDirectedEdge()
    {
        Node n1=new Node("A");
        Node n2=new Node("B");
        n1.addDirectedEdgeToNode(n2, 6);
        assertEquals(6, n1.getWeight(n2));
        try {
            n2.getWeight(n1);
            fail("Should have throw an exception");
        } catch (Exception e) {
            // do nothing; we are supposed to get an exception
        }
    }
    
    @Test
    public void testNeighbors()
    {
        Node n1=new Node("A");
        Node n2=new Node("B");
        Node n3=new Node("C");
        Node n4=new Node("D");
        Node n5=new Node("E");
        
        n1.addUndirectedEdgeToNode(n2, 1);
        n1.addUndirectedEdgeToNode(n3, 1);
        n2.addUndirectedEdgeToNode(n4, 1);
        n5.addUndirectedEdgeToNode(n1, 2);
        
        
        String[] neighbors=new String[n1.getNeighbors().size()];
        int i=0;
        for (Node n : n1.getNeighbors()) {
            neighbors[i]=n.getName();
            i++;
        }
        // arrays can be sorted
        Arrays.sort(neighbors);
        // this should be the correct result
        String[] correct=new String[] {"B", "C", "E"};
        // make sure we have the same neighbors we are expecting
        for (int j=0; j<correct.length; j++) {
            assertEquals(correct[j], neighbors[j]);
        }
    }
    
    
    @Test
    public void testAddNode() throws Exception
    {
        Graph g=new Graph();
        Node n1=g.getOrCreateNode("A");
        assertTrue(g.containsNode("A"));
        Node n2=g.getOrCreateNode("A");
        // should get back the same instance
        assertTrue(n1==n2);
        assertEquals("A", n2.getName());
        assertEquals(0,n2.getNeighbors().size()); 
    }
    
    @Test
    public void testAddTwoConnectedNode() throws Exception
    {
        Graph g=new Graph();
        Node n1=g.getOrCreateNode("A");
        Node n2=g.getOrCreateNode("B");
        n1.addUndirectedEdgeToNode(n2, 5);
        assertEquals(2, g.getAllNodes().size());
        assertEquals(1, n1.getNeighbors().size()); 
        assertEquals(1, n2.getNeighbors().size()); 
    }
    
    @Test
    public void testEdgesAreUpdated()
    {
        Graph g=new Graph();
        Node n1=g.getOrCreateNode("A");
        Node n2=g.getOrCreateNode("B");
        n1.addUndirectedEdgeToNode(n2, 5);
        assertEquals(5, n1.getWeight(n2));
        n1.addUndirectedEdgeToNode(n2, 8);
        assertEquals(8, n1.getWeight(n2));
    }
}
