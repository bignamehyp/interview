package leetcode;

public class LinkedListCycle {
	
	public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)
        	return null;
        ListNode nodeIdx = head.next;
        ListNode nodeIdxFast = head.next.next;
        while(  nodeIdx != nodeIdxFast){
            if(nodeIdx == null)
                return null;
        	nodeIdx = nodeIdx.next;
        	if(nodeIdxFast == null || nodeIdxFast.next == null)
        	    return null;
        	nodeIdxFast = nodeIdxFast.next.next;
        }
        
    
        
        nodeIdxFast = head;
        while(nodeIdxFast != nodeIdx){
        	nodeIdx = nodeIdx.next;
        	nodeIdxFast = nodeIdxFast.next;
        }
        return nodeIdx;
    }
}


 class ListNode {
	     int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
}