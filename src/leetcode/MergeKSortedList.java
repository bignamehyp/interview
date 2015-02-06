package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList {
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		if(lists == null || lists.size() == 0)
            return null;
		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>(){
			public int compare(ListNode lhs, ListNode rhs) {
		        if (lhs.val > rhs.val) return +1;
		        if (lhs.val == rhs.val) return 0;
		        return -1;
		    }
		});
		
		ListNode node = null, head = null;
		for(ListNode list : lists){
			if(list!= null)
				heap.add(list);
		}
		
		while(heap.size() > 0){
			ListNode minList = heap.poll();
			if(head == null){
				head = minList;
				node = minList;
			}else{
				node.next = minList;
				node = node.next;
			}
			
			minList = minList.next;
			if(minList!= null)
				heap.add(minList);
 		}
		
		return head;
     }
}
