package junit;

import static org.junit.Assert.*;

import java.io.FileInputStream;

import org.junit.Test;

import graph.impl.*;

public class TestGraphHelpers
{
    static final String SMALL_WEIGHTED = "tests/small-weighted.txt";
    static final String SMALL_UNWEIGHTED = "tests/small-unweighted.txt";

    @Test
    public void testUndirectedWeighted() throws Exception {
        Graph g = Graph.createUndirectedWeightedGraphFromEdgeList(new FileInputStream(SMALL_WEIGHTED));
        //System.out.println(GraphHelpers.toUndirectedWeightedDotFile(g, "mygraph"));
        assertTrue(g.containsNode("A"));
        assertTrue(g.containsNode("B"));
        assertTrue(g.containsNode("C"));
        assertTrue(g.containsNode("D"));
        assertTrue(g.containsNode("E"));

        Node A = g.getOrCreateNode("A");
        Node B = g.getOrCreateNode("B");
        Node C = g.getOrCreateNode("C");
        Node D = g.getOrCreateNode("D");
        Node E = g.getOrCreateNode("E");

        assertEquals(10, A.getWeight(B));
        assertEquals(10, B.getWeight(A));
        assertEquals(4, A.getWeight(C));
        assertEquals(4, C.getWeight(A));
        assertEquals(99, B.getWeight(D));
        assertEquals(99, D.getWeight(B));
        assertEquals(3, C.getWeight(D));
        assertEquals(3, D.getWeight(C));
        assertEquals(12, D.getWeight(E));
        assertEquals(12, E.getWeight(D));
        assertEquals(20, B.getWeight(E));
        assertEquals(20, E.getWeight(B));
    }

    @Test
    public void testDirectedWeighted() throws Exception {
        Graph g = Graph.createDirectedWeightedGraphFromEdgeList(new FileInputStream(SMALL_WEIGHTED));

        assertTrue(g.containsNode("A"));
        assertTrue(g.containsNode("B"));
        assertTrue(g.containsNode("C"));
        assertTrue(g.containsNode("D"));
        assertTrue(g.containsNode("E"));

        Node A = g.getOrCreateNode("A");
        Node B = g.getOrCreateNode("B");
        Node C = g.getOrCreateNode("C");
        Node D = g.getOrCreateNode("D");
        Node E = g.getOrCreateNode("E");

        assertEquals(10, A.getWeight(B));
        assertEquals(4, A.getWeight(C));
        assertEquals(99, B.getWeight(D));
        assertEquals(3, C.getWeight(D));
        assertEquals(12, D.getWeight(E));
        assertEquals(20, B.getWeight(E));
        
        try {
            B.getWeight(A);
            fail("should have thrown an exception");
        } catch (Exception e) {
            // ignore; should have thrown exception
        }
        
        try {
            C.getWeight(A);
            fail("should have thrown an exception");
        } catch (Exception e){
            // ignore
        }
        
        try {
            D.getWeight(C);
            fail("should have thrown an exception");
        } catch (Exception e){
            // ignore
        }
        
        try {
            D.getWeight(B);
            fail("should have thrown an exception");
        } catch (Exception e){
            // ignore
        }
        
        try {
            E.getWeight(B);
            fail("should have thrown an exception");
        } catch (Exception e){
            // ignore
        }
        
        try {
            E.getWeight(D);
            fail("should have thrown an exception");
        } catch (Exception e){
            // ignore
        }
    }
    
    @Test
    public void testDirectedUnweighted() throws Exception {
        Graph g = Graph.createUndirectedUnweightedGraphFromEdgeList(new FileInputStream(SMALL_UNWEIGHTED));

        assertTrue(g.containsNode("A"));
        assertTrue(g.containsNode("B"));
        assertTrue(g.containsNode("C"));
        assertTrue(g.containsNode("D"));
        assertTrue(g.containsNode("E"));
        
        Node A = g.getOrCreateNode("A");
        Node B = g.getOrCreateNode("B");
        Node C = g.getOrCreateNode("C");
        Node D = g.getOrCreateNode("D");
        Node E = g.getOrCreateNode("E");
        
        assertTrue(A.hasEdge(B));
        assertTrue(B.hasEdge(A));
        assertTrue(A.hasEdge(C));
        assertTrue(C.hasEdge(A));
        assertTrue(B.hasEdge(D));
        assertTrue(D.hasEdge(B));
        assertTrue(D.hasEdge(E));
        assertTrue(E.hasEdge(D));
        assertTrue(B.hasEdge(E));
        assertTrue(E.hasEdge(B));
    }
    
    @Test
    public void testUndirectedUnweighted() throws Exception {
        Graph g = Graph.createDirectedUnweightedGraphFromEdgeList(new FileInputStream(SMALL_UNWEIGHTED));

        assertTrue(g.containsNode("A"));
        assertTrue(g.containsNode("B"));
        assertTrue(g.containsNode("C"));
        assertTrue(g.containsNode("D"));
        assertTrue(g.containsNode("E"));
        
        Node A = g.getOrCreateNode("A");
        Node B = g.getOrCreateNode("B");
        Node C = g.getOrCreateNode("C");
        Node D = g.getOrCreateNode("D");
        Node E = g.getOrCreateNode("E");
        
        assertTrue(A.hasEdge(B));
        assertFalse(B.hasEdge(A));
        assertTrue(A.hasEdge(C));
        assertFalse(C.hasEdge(A));
        assertTrue(B.hasEdge(D));
        assertFalse(D.hasEdge(B));
        assertTrue(D.hasEdge(E));
        assertFalse(E.hasEdge(D));
        assertTrue(B.hasEdge(E));
        assertFalse(E.hasEdge(B));
    }

}
