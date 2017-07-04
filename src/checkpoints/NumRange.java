package checkpoints;

import java.util.ArrayList;

/*
 * Given an array of non negative integers A, and a range (B, C), 
find the number of continuous subsequences in the array which have sum S in the range [B, C] or B <= S <= C

Continuous subsequence is defined as all the numbers A[i], A[i + 1], .... A[j]
where 0 <= i <= j < size(A)

Example :

A : [10, 5, 1, 0, 2]
(B, C) : (6, 8)
ans = 3 
as [5, 1], [5, 1, 0], [5, 1, 0, 2] are the only 3 continuous subsequence with their sum in the range [6, 8]

 NOTE : The answer is guranteed to fit in a 32 bit signed integer. 
 */

public class NumRange {
	
	public int numRange(ArrayList<Integer> a, int b, int c) {
	    if(b>c || c<0) return 0;
	    int n = a.size(), count=0;
	    
	    for(int i=0; i<n; i++){
	        int sum = 0;
	        for(int j=i; j<n; j++){
	            int current = a.get(j);
	            sum += current;
	            if(sum>c) {
	                sum = 0;
	                break;
	            }              
	            if(sum>=b && sum<=c) count++;
	        }
	    }
	    
	    return count;
	}

}
