package checkpoints;

import java.util.ArrayList;

/*
 * Given an array, find the next greater element G[i] for every element A[i] in the array. The Next greater Element for an element A[i] is the first greater element on the right side of A[i] in array. 
More formally,

G[i] for an element A[i] = an element A[j] such that 
    j is minimum possible AND 
    j > i AND
    A[j] > A[i]
Elements for which no greater element exist, consider next greater element as -1.

Example:

Input : A : [4, 5, 2, 10]
Output : [5, 10, 10, -1]

Example 2:

Input : A : [3, 2, 1]
Output : [-1, -1, -1]
 */

public class Nextgreater {

	public ArrayList<Integer> nextGreater(ArrayList<Integer> a) {
	    
	    ArrayList<Integer> g = new ArrayList<Integer>();
	    
	    int n = a.size();
	    if(n == 0) return g;
	    
	    for(int i=0; i<n; i++){
	        int focus = a.get(i), least = Integer.MAX_VALUE;
	        boolean got=false;
	        for(int j=i+1; j<n; j++){
	            int current = a.get(j);
	            
	            if(current == least && !got) {
	                got = true;
	                break;
	            }     
	            
	            if(current>focus && current<least){
	                got = true;
	                least = current;
	                break;
	            }
	        }
	        
	        if(!got) g.add(i, -1);
	        else g.add(i, least);
	    }
	    
	    return g;
	}
}

