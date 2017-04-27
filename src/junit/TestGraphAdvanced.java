package junit;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.junit.Test;

import graph.impl.*;
//import graph.sol.*;

public class TestGraphAdvanced
{
    static String LARGE_WEIGHTED="tests/graph1.txt";
    static final String SMALL_WEIGHTED = "tests/small-weighted.txt";
    
    @Test
    public void testBFS1() throws Exception
    {
        Graph g=Graph.createUndirectedWeightedGraphFromEdgeList(new FileInputStream(LARGE_WEIGHTED));
        final List<String> nodes = new ArrayList<String>();
        g.breadthFirstSearch("A", new NodeVisitor() {
            @Override
            public void visit(Node n) {
                System.out.println("BFS Visiting node: " + n.getName());
                nodes.add(n.getName());
            }
        });
        int i=0;
        assertEquals("A", nodes.get(i++));
        assertEquals("B", nodes.get(i++));
        assertEquals("F", nodes.get(i++));
        assertEquals("C", nodes.get(i++));
        assertEquals("G", nodes.get(i++));
        assertEquals("K", nodes.get(i++));
        assertEquals("D", nodes.get(i++));
        assertEquals("H", nodes.get(i++));
        assertEquals("L", nodes.get(i++));
        assertEquals("P", nodes.get(i++));
        assertEquals("E", nodes.get(i++));
        assertEquals("I", nodes.get(i++));
        assertEquals("M", nodes.get(i++));
        assertEquals("Q", nodes.get(i++));
        assertEquals("U", nodes.get(i++));
        assertEquals("J", nodes.get(i++));
        assertEquals("N", nodes.get(i++));
        assertEquals("R", nodes.get(i++));
        assertEquals("V", nodes.get(i++));
        assertEquals("O", nodes.get(i++));
        assertEquals("S", nodes.get(i++));
        assertEquals("W", nodes.get(i++));
        assertEquals("T", nodes.get(i++));
        assertEquals("X", nodes.get(i++));
        assertEquals("Y", nodes.get(i++));
    }
    
    @Test
    public void testBFS2() throws Exception
    {
        Graph g=Graph.createUndirectedWeightedGraphFromEdgeList(new FileInputStream(LARGE_WEIGHTED));
        final List<String> nodes = new ArrayList<String>();
        g.breadthFirstSearch("G", new NodeVisitor() {
            @Override
            public void visit(Node n) {
                System.out.println("BFS Visiting node: " + n.getName());
                nodes.add(n.getName());
            }
        });
        int i=0;
        assertEquals("G", nodes.get(i++));
        assertEquals("B", nodes.get(i++));
        assertEquals("F", nodes.get(i++));
        assertEquals("H", nodes.get(i++));
        assertEquals("L", nodes.get(i++));
        assertEquals("A", nodes.get(i++));
        assertEquals("C", nodes.get(i++));
        assertEquals("K", nodes.get(i++));
        assertEquals("I", nodes.get(i++));
        assertEquals("M", nodes.get(i++));
        assertEquals("Q", nodes.get(i++));
        assertEquals("D", nodes.get(i++));
        assertEquals("P", nodes.get(i++));
        assertEquals("J", nodes.get(i++));
        assertEquals("N", nodes.get(i++));
        assertEquals("R", nodes.get(i++));
        assertEquals("V", nodes.get(i++));
        assertEquals("E", nodes.get(i++));
        assertEquals("U", nodes.get(i++));
        assertEquals("O", nodes.get(i++));
        assertEquals("S", nodes.get(i++));
        assertEquals("W", nodes.get(i++));
        assertEquals("T", nodes.get(i++));
        assertEquals("X", nodes.get(i++));
        assertEquals("Y", nodes.get(i++));
    }
    
    @Test
    public void testDFS1() throws Exception
    {
        Graph g=Graph.createUndirectedWeightedGraphFromEdgeList(new FileInputStream(LARGE_WEIGHTED));
        final List<String> nodes = new ArrayList<String>();
        g.depthFirstSearch("A", new NodeVisitor() {
            @Override
            public void visit(Node n) {
                System.out.println("DFS Visiting node: " + n.getName());
                nodes.add(n.getName());
            }
        });
        int i=0;
        assertEquals("A", nodes.get(i++));
        assertEquals("F", nodes.get(i++));
        assertEquals("K", nodes.get(i++));
        assertEquals("P", nodes.get(i++));
        assertEquals("U", nodes.get(i++));
        assertEquals("V", nodes.get(i++));
        assertEquals("W", nodes.get(i++));
        assertEquals("X", nodes.get(i++));
        assertEquals("Y", nodes.get(i++));
        assertEquals("T", nodes.get(i++));
        assertEquals("S", nodes.get(i++));
        assertEquals("R", nodes.get(i++));
        assertEquals("Q", nodes.get(i++));
        assertEquals("L", nodes.get(i++));
        assertEquals("M", nodes.get(i++));
        assertEquals("N", nodes.get(i++));
        assertEquals("O", nodes.get(i++));
        assertEquals("J", nodes.get(i++));
        assertEquals("I", nodes.get(i++));
        assertEquals("H", nodes.get(i++));
        assertEquals("G", nodes.get(i++));
        assertEquals("B", nodes.get(i++));
        assertEquals("C", nodes.get(i++));
        assertEquals("D", nodes.get(i++));
        assertEquals("E", nodes.get(i++));

    }
    
    @Test
    public void testDFS2() throws Exception
    {
        Graph g=Graph.createUndirectedWeightedGraphFromEdgeList(new FileInputStream(LARGE_WEIGHTED));
        final List<String> nodes = new ArrayList<String>();
        g.depthFirstSearch("G", new NodeVisitor() {
            @Override
            public void visit(Node n) {
                System.out.println("DFS Visiting node: " + n.getName());
                nodes.add(n.getName());
            }
        });
        int i=0;
        assertEquals("G", nodes.get(i++));
        assertEquals("L", nodes.get(i++));
        assertEquals("Q", nodes.get(i++));
        assertEquals("V", nodes.get(i++));
        assertEquals("W", nodes.get(i++));
        assertEquals("X", nodes.get(i++));
        assertEquals("Y", nodes.get(i++));
        assertEquals("T", nodes.get(i++));
        assertEquals("S", nodes.get(i++));
        assertEquals("R", nodes.get(i++));
        assertEquals("M", nodes.get(i++));
        assertEquals("N", nodes.get(i++));
        assertEquals("O", nodes.get(i++));
        assertEquals("J", nodes.get(i++));
        assertEquals("I", nodes.get(i++));
        assertEquals("H", nodes.get(i++));
        assertEquals("C", nodes.get(i++));
        assertEquals("D", nodes.get(i++));
        assertEquals("E", nodes.get(i++));
        assertEquals("B", nodes.get(i++));
        assertEquals("A", nodes.get(i++));
        assertEquals("F", nodes.get(i++));
        assertEquals("K", nodes.get(i++));
        assertEquals("P", nodes.get(i++));
        assertEquals("U", nodes.get(i++));
    }
    
    @Test
    public void testTotalEdgeWeights1() throws Exception
    {
        Graph g=Graph.createUndirectedWeightedGraphFromEdgeList(new FileInputStream(SMALL_WEIGHTED));
        assertEquals(148, g.getSumOfAllEdgeWeights());
    }
    
    @Test
    public void testTotalEdgeWeights2() throws Exception
    {
        Graph g=Graph.createUndirectedWeightedGraphFromEdgeList(new FileInputStream(LARGE_WEIGHTED));
        assertEquals(455, g.getSumOfAllEdgeWeights());
    }

    @Test
    public void testSmallDijkstra() throws Exception
    {
        Graph g=Graph.createUndirectedWeightedGraphFromEdgeList(new FileInputStream(SMALL_WEIGHTED));
        Map<Node, Integer> shortPaths=g.dijkstra("A");
        Map<String, Integer> paths=new TreeMap<String, Integer>();
        for (Entry<Node, Integer> entry : shortPaths.entrySet()) {
            paths.put(entry.getKey().getName(), entry.getValue());
        }
        assertEquals(0, (int)paths.get("A"));
        assertEquals(4, (int)paths.get("C"));
        assertEquals(7, (int)paths.get("D"));
        assertEquals(10, (int)paths.get("B"));
        assertEquals(19, (int)paths.get("E"));
    }
    
    @Test
    public void testFullDijkstra() throws Exception
    {
        Graph g=Graph.createUndirectedWeightedGraphFromEdgeList(new FileInputStream(LARGE_WEIGHTED));
        Map<Node, Integer> shortPaths=g.dijkstra("A");
        Map<String, Integer> paths=new TreeMap<String, Integer>();
        for (Entry<Node, Integer> entry : shortPaths.entrySet()) {
            paths.put(entry.getKey().getName(), entry.getValue());
        }
        assertEquals(43, (int)paths.get("N"));
        assertEquals(45, (int)paths.get("U"));
        assertEquals(19, (int)paths.get("K"));
        assertEquals(20, (int)paths.get("G"));
        assertEquals(15, (int)paths.get("C"));
        assertEquals(74, (int)paths.get("Y"));
        assertEquals(0, (int)paths.get("A"));
        assertEquals(30, (int)paths.get("P"));
        assertEquals(22, (int)paths.get("L"));
        assertEquals(6, (int)paths.get("B"));
        assertEquals(62, (int)paths.get("T"));
        assertEquals(37, (int)paths.get("E"));
        assertEquals(37, (int)paths.get("Q"));
        assertEquals(60, (int)paths.get("O"));
        assertEquals(33, (int)paths.get("I"));
        assertEquals(59, (int)paths.get("S"));
        assertEquals(30, (int)paths.get("M"));
        assertEquals(58, (int)paths.get("X"));
        assertEquals(49, (int)paths.get("R"));
        assertEquals(47, (int)paths.get("J"));
        assertEquals(15, (int)paths.get("F"));
        assertEquals(23, (int)paths.get("D"));
        assertEquals(48, (int)paths.get("W"));
        assertEquals(27, (int)paths.get("H"));
        assertEquals(44, (int)paths.get("V"));
    }
    
//    class MyVisitor implements NodeVisitor {
//        private Set<Node> visited=new HashSet<Node>();
//        int totalWeight = 0;
//        @Override
//        public void visit(Node n) {
//            for (Node other : n.getNeighbors()){
//                if (!visited.contains(other)){
//                    visited.add(other);
//                    totalWeight += n.getWeight(other);
//                }
//            }
//        }
//    }

    @Test
    public void testPrimJarnik() throws Exception
    {
        Graph g=Graph.createUndirectedWeightedGraphFromEdgeList(new FileInputStream(LARGE_WEIGHTED));
        Graph primJarnik=g.primJarnik();
        assertEquals(187, primJarnik.getSumOfAllEdgeWeights());
    }
}
