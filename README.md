# DisjointSets_and_MST

  DisjointSets.java has a simple implementation of the disjoint set data structure with union
and find operations. 
  
  It models a partition of n elements with distinct integers ranging from 0 to n − 1 (i.e. each element is 
represented by an integer in [0, · · · , n − 1], and each integer in [0, · · · , n − 1] represents one element). 
Moreoever, the disjoint sets are represented by trees, and to implement the forest of trees with an array named par. 
More precisely, the value stored in par[i] is parent of the element i, and par[i]==i when i is the root of the tree and 
thus the representative of the disjoint set. On the other hand, the rank[i] is an integer associated with each node. 
  
  Initially (i.e. when the set contains one single object) its value is 0.
Union operations link the root of the tree with smaller rank to the root of the tree with larger rank. In case of the rank 
of both trees is the same, the rank of the new root increases by 1. 

- The method find(int i) will return the representative of the disjoint set that contains i.
- The method union(int i, int j) will merge the
set with smaller rank (for instance i) in the disjoint set with larger rank (in that case j). In that case,
the root of the tree containing i will become a child of the root of the tree containing j), and return the
representative (as an integer) of the new merged set. 


As for the kruskal.java file, I implemented the Kruskal algorithm to calculate the minimum spanning tree (MST) of a undirected weighted graph. To execute the kruskal.java file, you will need the classes DisjointSets and WGraph which are also in the repository. 

The file WGraph.java implements two classes WGraph and Edge. An object of Edge stores all informations
about edges (i.e. the two vertices and the weight of the edge), which are used to build graphs.
The class WGraph has two constructors WGraph() and WGraph(String file). The first one
creates an empty graph and the second uses an input file to initialize a graph. Graphs are encoded using the
following format. The first line of this file is a single integer n that indicates the number of nodes in
the graph. Each vertex is labelled with an number in [0, · · · , n − 1], and each integer in [0, · · · , n − 1]
represents one and only one vertex. The following lines respect the syntax “n1 n2 w”, where n1 and n2
are integers representing the nodes connected by an edge, and w the weight of this edge. n1, n2, and w
must be separated by space(s).

An example of such input file is also in the repository (g1.txt). Thus, 
an example of a command line is java Kruskal g1.txt.

The class WGraph also provide a method addEdge(Edge e) that adds an edge to a graph (i.e. an
object of this class). Another method listOfEdgesSorted() allows you to access the list of edges
of a graph in increasing order of their weight.

In kruskal.java, 

- the method isSafe considers a partition of the nodes p and an edge e, and should return True if it is safe to add the edge e to the MST, and False otherwise.
- The method kruskal will take a graph object of the class WGraph as an input, and return another WGraph object which will be the MST of the input graph.

An example of the expected output is available in the file mst1.txt :)

