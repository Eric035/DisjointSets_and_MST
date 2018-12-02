import java.util.*;

public class Kruskal{

    public static WGraph kruskal(WGraph g)
    { 
    		WGraph minST = new WGraph(); // MST to return 
    		ArrayList<Edge> sortedEdges = g.listOfEdgesSorted(); // Sort the edges of input graph g first.
    		DisjointSets setOfG = new DisjointSets(g.getNbNodes());   // Create a DisjointSets object based on the nodes of the input graph g.
    		
    		for (Edge e : sortedEdges)  // Loop through the ArrayList sortedEdges to pick the suitable edges to add into our MST. 
    		{
    			if (IsSafe (setOfG, e) == true)   // Check if the edge is safe to add via isSafe method. 
    			{
    				setOfG.union(e.nodes[0], e.nodes[1]); // union node[0] and node[1] into the same set.
    				minST.addEdge(e);  // Add the edge into our MST
    			}
    		}
        return minST;
    }

    public static Boolean IsSafe(DisjointSets p, Edge e)
    {    		
    	if (p.find(e.nodes[0]) != p.find(e.nodes[1]))  // Make sure i and j are not in the same set, or else there will be a cycle occurs. 
    	{
   			return true;
    	}
        return false;
    }

    public static void main(String[] args){

    	String file = args[0];
        WGraph g = new WGraph(file);
        WGraph t = kruskal(g);
        System.out.println(t);

   } 
}
