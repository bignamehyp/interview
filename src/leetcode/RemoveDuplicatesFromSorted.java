package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class RemoveDuplicatesFromSorted {
	
	
	/**
	 * Given a sorted linked list, delete all duplicates such that each element appear only once.

	 * @param head
	 * @return
	 */
	public ListNode deleteDuplicatesList1(ListNode head) {
		if(head == null)
			return null;
        HashSet<Integer> values = new HashSet<Integer>();
        ListNode cur = head;
		values.add(cur.val);

        while(cur.next != null){
        	if(values.contains(cur.next.val)){        		
        		cur.next = cur.next.next;
        	}else{
        		values.add(cur.next.val);
           		cur = cur.next;
        	}
        }
        return head;
    }

	//Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

	public ListNode deleteDuplicatesList2(ListNode head) {
		if(head == null)return null;
		HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();
		//get the requencies;
		ListNode cur = head;
		while(cur!=null){
			if(freq.containsKey(cur.val)){
				int f = freq.get(cur.val);
				freq.put(cur.val, f + 1);
			}else{
				freq.put(cur.val, 1);
			}
			cur = cur.next;
		}
		
		//Get the first unique element
		while(head.next!= null && freq.get(head.val) != 1){
 				head.val = head.next.val;
				head.next = head.next.next;
		}
		//the last element is head
		if(head.next == null && freq.get(head.val) != 1){
			return null;
		}
		
		cur = head;
		while(cur.next != null){
			if(freq.get(cur.next.val) != 1){
				cur.next = cur.next.next;
			}else
				cur = cur.next;
		}
		return head;
    }
	
	//Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
	public int removeDuplicatesArray1(int[] A) {
		if(A == null || A.length == 0)
			return 0;
		 
		int good = 0;
		for( int i = 1; i < A.length; i++){
			if(A[i] != A[i-1]){
				good++;
				A[good] = A[i];
 			}
		}
		
		return good + 1;   
	}
	/**
	 * What if duplicates are allowed at most twice?
	 * @param A
	 * @return
	 */
	public int removeDuplicates(int[] A) {
        if(A == null || A.length == 0)return 0;
  		int kept = 0;
  		int rep = 1;   
		for(int i = 1; i < A.length; i++){ //111111222
		    if(A[i] == A[i - 1]){
		        rep++;
		    }else{
		        rep = 1;
 		    }
 		    
		    if(rep <= 2){
		        A[kept+1] = A[i];
		        kept++;
		    }
		}
		return kept+1;
     }
}
