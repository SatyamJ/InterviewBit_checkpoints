package checkpoints;

import java.util.HashSet;
import java.util.List;

/*
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Example: 
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
 */

public class LongestConsecutiveSequence {
	public int longestConsecutive(final List<Integer> a) {
	    int n = a.size();
	    if(n == 0) return 0;
	    if(n == 1) return 1;
	    
	    HashSet<Integer> set = new HashSet<Integer>();
	    for(int item:  a){
	        set.add(item);
	    }
	    
	    int[] unique = new int[set.size()];
	    int i=0;
	    for(int item: set){
	        unique[i++] = item;
	    }
	    
	    int longest = 0;
	    for(int item:  unique){
	        if(set.contains(item)){
	            int currentLength = getConsecutiveLength(item, set);
	            if(currentLength > longest) longest = currentLength;
	        }
	        
	        if(set.size() == 0) break;
	    }
	    return longest;
	}
	
	public int getConsecutiveLength(int element, HashSet<Integer> set){
	    if(! set.contains(element)) return 0;
	    set.remove(element);
	    
	    int left=0 , right=0;
	    
	    int leftElement = element-1;
	    while(set.contains(leftElement)){
	        left++;
	        set.remove(leftElement);
	        leftElement -= 1;
	    }
	    
	    int rightElement = element+1;
	    while(set.contains(rightElement)){
	        right++;
	        set.remove(rightElement);
	        rightElement += 1;
	    }
	    
	    return 1 + left + right;
	}
}

