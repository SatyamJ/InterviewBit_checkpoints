package checkpoints;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Find the kth smallest element in an unsorted array of non-negative integers.

Definition of kth smallest element

 kth smallest element is the minimum possible n such that there are at least k elements in the array <= n.
In other words, if the array A was sorted, then A[k - 1] ( k is 1 based, while the arrays are 0 based ) 
NOTE
You are not allowed to modify the array ( The array is read only ). 
Try to do it using constant extra space.

Example:

A : [2 1 4 3 2]
k : 3

answer : 2
 */

public class KthSmallestElement {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(2, 1, 4, 3, 2);
		KthSmallestElement k =  new KthSmallestElement();
		System.out.println(k.kthsmallest(list, 3));
	}
	
	public int kthsmallest(final List<Integer> a, int k) {
	    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new MyComparator());
	    for(int item: a){
	        if(pq.size()<k) pq.add(item);
	        else{
	            if(pq.peek() > item){
	                pq.remove();
	                pq.add(item);
	            }
	        }
	    }
	    
	    return pq.remove().intValue();
	}
	
	class MyComparator implements Comparator<Integer>{
	    public int compare(Integer a, Integer b){
	        if(a < b) return 1;
	        else if(a > b) return -1;
	        else return 0;
	    }
	}

}
