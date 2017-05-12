package graph.impl;

import java.awt.Point;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class SYSolver
{
	/**
	 * Read a Scotland Yard graph file from an input stream.
	 * The file contains a header line with the number of locations
	 * on the game board (which is 199) then the number of links
	 * between those locations (469). Locations are always numbered
	 * starting at 1. 
	 * 
	 * Each of the 469 links will contain the two endpoints of the link
	 * followed by the transportation type, which is either T for Taxi,
	 * B for Bus, or U for Underground (subway).
	 * 
	 * See files/scotmap.txt for the full file. The first few lines of the file
	 * look like this:
	 * 
	 * <pre>
	 * 199 469
	 * 1 8 T
	 * 1 9 T
	 * 1 58 B
	 * 1 46 B
	 * 1 46 U
	 * 2 20 T
	 * ...
	 * </pre>
	 * 
	 * Keep in mind that some nodes may be connected by both bus and by taxi.
	 * 
	 * @param in
	 * @return
	 * @throws IOException
	 */
	public static Graph readGraphFromFile(InputStream in) throws IOException
	{
		Scanner scan = new Scanner(in);
		Graph scotYard = new Graph();
		int locs = scan.nextInt();
		int connections=scan.nextInt();
		for (int i=0; i<locs; i++)
			while (scan.hasNext())
			{
				Node n1 =scotYard.getOrCreateNode(scan.next());
				Node n2 = scotYard.getOrCreateNode(scan.next());
				String type = scan.next();
				if (type.equals("T"))
				{
					if (n1.hasEdge(n2))
					{
						n1.addUndirectedEdgeToNode(n2, n1.getWeight(n2)+1);
					}
					else
						n1.addUndirectedEdgeToNode(n2,1);
				}
				else if (type.equals("B"))
				{
					if (n1.hasEdge(n2))
					{
						n1.addUndirectedEdgeToNode(n2, n1.getWeight(n2)+10);
					}
					else
						n1.addUndirectedEdgeToNode(n2,10);
				}
				else if (type.equals("U"))
				{
					if (n1.hasEdge(n2))
					{
						n1.addUndirectedEdgeToNode(n2, n1.getWeight(n2)+100);
					}
					else
						n1.addUndirectedEdgeToNode(n2,100);
				}
			}

		return scotYard;


	}

	/**
	 * 
	 * Read from the given inputstream a mapping of numbered locations on the Scotland
	 * Yard game board to their corresponding x y coordinates, in a format like this:
	 * 
	 * <pre>
	 * 199
	 * 1 143 45
	 * 2 329 49
	 * 3 406 40
	 * 4 504 44
	 * 5 784 46
	 * 6 844 50
	 * 7 941 52
	 * 8 97 79
	 * 9 169 84
	 * 10 350 97
	 * </pre>
	 * 
	 * The first number (i.e. 199) is the number of points, then each line is
	 * the location number (from 1 to 199) then the x and y coordinates.
	 * 
	 * So for example:
	 * 
	 * 3 406 40
	 * 
	 * means that location 3 is at (406, 40). The x, y coordinates are in pixels.
	 * 
	 * The full file is in files/scotpos.txt.
	 * 
	 * 
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public static Map<String,Point> readPositionPoints(String filename) throws IOException {
		Map<String, Point> coordinates = new HashMap<String, Point>();
		Scanner scan = new Scanner(new FileInputStream(filename));
		int numPoints = scan.nextInt();
		for (int i=0; i<numPoints; i++)
		{
			String position = scan.next();
			int x = scan.nextInt();
			int y = scan.nextInt();
			Point point = new Point(x,y);
			coordinates.put(position, point);
		}

		return coordinates;
	}

	/**
	 * Get the next 5 possible moves that Mr X could make starting
	 * at the given start node. 
	 * 
	 * Assume that we don't know or care about
	 * the types of transportation that Mr X is using.
	 * 
	 * @param g
	 * @param start
	 * @return
	 */
	public static Map<Integer, Set<String>> getNextFivePossibleMoves(Graph g, String start)
	{

		Map <Integer, Set<String>> possibleMoves = new HashMap <Integer, Set <String>>(); 
		Set <String> names = new HashSet <String>();
		names.add(start);

		for (int i = 0; i < 5; i++) {
			Set <String> foo = new HashSet<String>();
			for (String bar : names)
			{
				Node n = g.getOrCreateNode(bar);
				for (Node pancake : n.getNeighbors())
				{
					foo.add(pancake.myName);
				}
			}
			names.clear();
			names.addAll(foo);
			possibleMoves.put(i+1, foo);
		}



		return possibleMoves;

	}




	/**
	 * Get the next 5 possible moves that Mr X could make starting
	 * at the given start node. 
	 * 
	 * Assume that that given list of transportation types tells us what
	 * type of transportation Mr X uses for each move.
	 * 
	 * The given list of transportTypes contains 5 strings that are either
	 * "any", "taxi", "bus" or "underground". If a transport type is "any"
	 * then any type of transportation can be used.
	 * 
	 * If the type of transportation makes a move impossible, then the set of
	 * possible locations should be empty
	 * 
	 * 
	 * @param g
	 * @param start
	 * @param transportTypes
	 * @return
	 */
	public static Map<Integer,Set<String>> getNextFivePossibleMoves(Graph g, String start, List<String> transportTypes) {

		Map <Integer, Set<String>> possibleMoves = new HashMap <Integer, Set <String>>(); 
		Set <String> names = new HashSet <String>();
		names.add(start);

		for (int i = 0; i < 5; i++) {
			Set <String> foo = new HashSet<String>();
			for (String bar : names)
			{
				Node n = g.getOrCreateNode(bar);
				for (Node pancake : n.getNeighbors())
				{
					if (transportTypes.get(i).equals("any"))
					{
						foo.add(pancake.myName);
					}
					else if (transportTypes.get(i).equals("taxi"))
					{
						if(n.getWeight(pancake)==1||n.getWeight(pancake)==101||n.getWeight(pancake)==11)
						{
							foo.add(pancake.myName);
						}
					}
					else if (transportTypes.get(i).equals("bus"))
					{
						if(n.getWeight(pancake)==10||n.getWeight(pancake)==11||n.getWeight(pancake)==110)
						{
							foo.add(pancake.myName);
						}
					}
					else if (transportTypes.get(i).equals("underground"))
					{
						if(n.getWeight(pancake)==100||n.getWeight(pancake)==101||n.getWeight(pancake)==110)
						{
							foo.add(pancake.myName);
						}
					}
				}
			}
			names.clear();
			names.addAll(foo);
			possibleMoves.put(i+1, foo);
		}



		return possibleMoves;





	}



	private SYSolver() {
		// private constructor to prevent creating instances
		// this class exists only to hold static methods
	}

}
