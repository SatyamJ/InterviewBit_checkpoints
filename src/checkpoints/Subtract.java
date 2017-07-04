package checkpoints;

/*
 * Given a singly linked list, modify the value of first half nodes such that :

1st node’s new value = the last node’s value - first node’s current value
2nd node’s new value = the second last node’s value - 2nd node’s current value,
and so on …

 NOTE : 
* If the length L of linked list is odd, then the first half implies at first floor(L/2) nodes. So, if L = 5, the first half refers to first 2 nodes. 
* If the length L of linked list is even, then the first half implies at first L/2 nodes. So, if L = 4, the first half refers to first 2 nodes. 
Example :

Given linked list 1 -> 2 -> 3 -> 4 -> 5,

You should return 4 -> 2 -> 3 -> 4 -> 5
as

for first node, 5 - 1 = 4
for second node, 4 - 2 = 2
Try to solve the problem using constant extra space.

 */
public class Subtract {

	class ListNode {
		public int val;
		public ListNode next;
		ListNode(int x) { val = x; next = null; }
	}

	public ListNode subtract(ListNode a) {
	    
	    if(a == null || a.next == null) return a;
	    
	    ListNode runner1 = a;
	    ListNode runner2 = a;
	    boolean odd = false;
	    
	    ListNode prev = null;
	    while(runner2.next != null && runner2.next.next != null){
	        prev = runner1;
	        runner1 = runner1.next;
	        runner2 = runner2.next.next;
	    }
	    
	    ListNode secondHalf = runner1.next;
	    if(runner2.next == null) {
	        odd = true;
	        secondHalf = runner1;
	        prev.next = null;
	    }else{
	        runner1.next = null;
	    }
	    
	    
	    ListNode reversed = reverseLinkedList(a);
	    
	    ListNode start1 = reversed;
	    ListNode start2 = odd ? secondHalf.next : secondHalf;
	    
	    
	    while(start1 != null){
	        start1.val = start2.val -  start1.val;
	        start1 = start1.next;
	        start2 = start2.next;
	    }
	    
	    ListNode firstHalf = reverseLinkedList(reversed);
	    connectLinkedList(firstHalf, secondHalf);
	    return firstHalf;
	}
	
	public ListNode reverseLinkedList(ListNode node){
	    ListNode current = node, prev = null;
	    
	    if(current == null) return node;
	   
	    while(current != null){
	        ListNode next = current.next;
	        current.next = prev;
	        prev = current;
	        current = next;
	    }
	    
	    return prev;
	}
	
	public ListNode connectLinkedList(ListNode first, ListNode second){
	    if(first == null) return second;
	    if(second == null) return first;
	    
	    ListNode current = first;
	    while(current.next != null){
	        current = current.next;
	    }
	    current.next = second;
	    return first;
	}
}

