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
