package checkpoints;

import java.util.ArrayList;

/*
 * 
 * Print concentric rectangular pattern in a 2d matrix. 
Let us show you some examples to clarify what we mean.

Example 1:

Input: A = 4.
Output:

4 4 4 4 4 4 4 
4 3 3 3 3 3 4 
4 3 2 2 2 3 4 
4 3 2 1 2 3 4 
4 3 2 2 2 3 4 
4 3 3 3 3 3 4 
4 4 4 4 4 4 4 
Example 2:

Input: A = 3.
Output:

3 3 3 3 3 
3 2 2 2 3 
3 2 1 2 3 
3 2 2 2 3 
3 3 3 3 3 
The outermost rectangle is formed by A, then the next outermost is formed by A-1 and so on.

You will be given A as an argument to the function you need to implement, and you need to return a 2D array.
 */

public class PrettyPrint {

	public static void main(String[] args) {
		PrettyPrint pp = new PrettyPrint();
		pp.print(pp.prettyPrint(5));
	}
	
	public void print(ArrayList<ArrayList<Integer>> matrix){
		for(ArrayList<Integer> row: matrix){
			for(int element: row){
				System.out.print(element+" ");
			}
			System.out.println();
		}
	}
	
	public ArrayList<ArrayList<Integer>> prettyPrint(int a) {
	    ArrayList<ArrayList<Integer>> cr = new ArrayList<ArrayList<Integer>>();
	    
	    for(int i=0; i<2*a-1; i++){
	        ArrayList<Integer> inner = new ArrayList<Integer>();
	        for(int j=0; j<2*a-1; j++){
	            inner.add(new Integer(0));
	        }
	        cr.add(inner);
	    }
	    
	    for(int i=a; i>0; i--){
	        int n = 2*i-1;
	        for(int j=a-i; j<a-i+n; j++){
	            cr.get(a-i).set(j, new Integer(i));
	        }
	        
	        for(int j=a-i+1; j<a-i+n; j++){
	            cr.get(j).set(n+a-i-1, new Integer(i));
	        }
	        
	        for(int j=a-i; j<a-i+n; j++){
	            cr.get(a-i+n-1).set(j, new Integer(i));
	        }
	        
	        for(int j=a-i+1; j<a-i+n; j++){
	            cr.get(j).set(a-i, new Integer(i));
	        }
	    }
	    
	    return cr;
	    
	}

}
