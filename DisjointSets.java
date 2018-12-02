package A2;
import java.io.*;
import java.util.*;


/****************************
*
* COMP251 template file
*
* Assignment 2, Question 1
*
*****************************/


public class DisjointSets {

    private int[] par;
    private int[] rank;
    
    /* contructor: creates a partition of n elements. */
    /* Each element is in a separate disjoint set */
    DisjointSets(int n) {
        if (n>0) {
            par = new int[n];
            rank = new int[n];
            for (int i=0; i<this.par.length; i++) {
                par[i] = i;
            } 
        }
    }
    
    public String toString(){
        int pari,countsets=0;
        String output = "";
        String[] setstrings = new String[this.par.length];
        /* build string for each set */
        for (int i=0; i<this.par.length; i++) {
            pari = find(i);
            if (setstrings[pari]==null) {
                setstrings[pari] = String.valueOf(i);
                countsets+=1;
            } else {
                setstrings[pari] += "," + i;
            }
        }
        /* print strings */
        output = countsets + " set(s):\n";
        for (int i=0; i<this.par.length; i++) {
            if (setstrings[i] != null) {
                output += i + " : " + setstrings[i] + "\n";
            }
        }
        return output;
    }
    
    /* find representative of element i */
    public int find (int i) {

        /* Fill this method (The statement return 0 is here only to compile) */
        if (this.par[i] == i)   // means i is the root, simply returns i.
        {
        		return i;
        }
        else
        {	
        		this.par[i] = find(this.par[i]);   // Path compression seen in class
        		return this.par[i];
        }
    }	
    
    /* merge sets containing elements i and j */
    public int union(int i, int j) {
    
        /* Fill this method (The statement return 0 is here only to compile) */
    	
    	   if (this.find(i) != this.find(j))    // Determine if i and j are in different sets.
       {
    		   if (this.rank[find(i)] > this.rank[find(j)])   // Case where the size of the tree containing i is larger than the size of the tree containing j, merge j into i. 
    		   {
    			   this.par[find(j)] = find(i);
    			   return find(i);
    		   }
    		   else if (this.rank[find(i)] < this.rank[find(j)])  // Case where the size of the tree that contains i is less than or equals to the size of the tree that contains j, merge i into j. 
    		   {
    			   this.par[find(i)] = find(j);
    			   return find(j);
    		   }
    		   else if (this.rank[find(i)] == this.rank[find(j)])  // When the ranks for i and j are equals than merge i into j.
    		   {
    			   this.par[find(i)] = find(j);
    			   this.rank[find(j)]++;   // We update the rank of the new root which is j.
    			   return find(j);
    		   }
       }
       return find(i);  // for the case where find(i) == find(j), ie. i and j are in the same set.
    }
    
    public static void main(String[] args) {
        
    		
        DisjointSets myset = new DisjointSets(6);
          
        System.out.println(myset);
        System.out.println("-> Union 2 and 3");
        myset.union(2,3);
        System.out.println(myset);
        System.out.println("-> Union 2 and 3");
        myset.union(2,3);
        System.out.println(myset);
        System.out.println("-> Union 2 and 1");
        myset.union(2,1);
        System.out.println(myset);
        System.out.println("-> Union 4 and 5");
        myset.union(4,5);
        System.out.println(myset);
        System.out.println("-> Union 3 and 1");
        myset.union(3,1);
        System.out.println(myset);
        System.out.println("-> Union 2 and 4");
        myset.union(2,4);
        System.out.println(myset);
        
    }

}
