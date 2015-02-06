package leetcode;

public class ReorderList {
	/**
	 * Given a list, rotate the list to the right by k places, where k is non-negative.
	 * @param head
	 * @param n
	 * @return
	 */
	 public ListNode rotateRight(ListNode head, int n) {
	       
	        if(head == null || head.next == null){
	        	return head;
	        }
	        
	        ListNode fast = head, slow = head;
	        int len = 0;
	        while(slow!=null){
	            slow = slow.next;
	            len++;
	        }
	        n = n % len;
	        if(n == 0)return head;
	        
	        slow = head;
	        
	        int steps = 0;
	        while(steps < n){
	            fast = fast.next;
	             
	            steps++;
	        }
	        while(fast.next != null){
	            slow = slow.next;
	            fast = fast.next;
	        }
	        ListNode newHead = slow.next;
	        slow.next = null;
	        fast.next = head;
	        return newHead;
	        
	    }

	public void reorderList(ListNode head) {
		if(head == null || head.next == null){
			return;
		}
		
		ListNode half = divideList(head);
		
		half = reverseList(half);
		
		head = merge(head, half);
		
	}
	
	ListNode merge(ListNode l1, ListNode l2){
		
		ListNode node = null, head = null;
		
		while(l1 != null && l2 != null){
			if(head == null){
				node = l1;
				head = node;				
			}else{
				node.next = l1;
				node = node.next;
			}
			l1 = l1.next;
			node.next = l2;
			node = node.next;
			l2 = l2.next;			
		}
		if(l1 != null)
			node.next = l1;
		
		if(l2 == null)
			node.next = l2;
		return head;
	}
	
	ListNode reverseList(ListNode head){
		if(head == null || head.next == null)
			return head;
		
 		ListNode prev = head;
		ListNode cur = head.next;
		prev.next  = null;
		
		while(cur!=null){
			ListNode next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}		
		head = prev;
		return head;
	}
	
	ListNode divideList(ListNode head){
		
		ListNode slow = head, fast = head;
		
		while(fast != null && fast.next != null){
			if(fast.next != null)
				fast = fast.next.next;
			 
			if(fast == null || fast.next == null){//reach the end
				ListNode next = slow.next;
				slow.next = null;
				slow = next;
				break;
			}			
			slow = slow.next;
		}
		
		
		return slow;
	}

	/**
	 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
	 * @param head
	 * @param m
	 * @param n
	 * @return
	 */
	 public ListNode reverseBetween(ListNode head, int m, int n) {
		 if(head == null || head.next == null || m ==n )
			 return head;
		 
		 ListNode leftEnd, tail;		 
		 ListNode prev = null, cur = head;
		 for(int i = 1; i < m; i++){
			 if(prev==null){
				 prev = head;
			 }else{
				 prev = prev.next;
			 }
			 cur = cur.next;
		 }
		 
		 leftEnd = prev;
		 tail = cur;
 		 
		 for(int i = m; i <= n; i++){
			 ListNode next = cur.next;
			 cur.next = prev;
			 prev = cur;
			 cur = next;
		 }
		 if(leftEnd!=null){
			 tail.next = cur;
			 leftEnd.next = prev;
			 return head;
		 }else{
			 tail.next = cur;
			 return prev;
		 }
		 
 	  }
	 
	 public ListNode removeNthFromEnd(ListNode head, int n) {
	        if(head == null)
	            return head;
	        
	        ListNode prev = null, cur = head, tail = head;
	        
	        for(int i = 1; i < n; i++){
	            tail = tail.next;
	        }
	        
	        if(tail.next == null){//remove the first one.
	            return head.next;
	        }
	        
	        while(tail.next!=null){
	            tail = tail.next;
	            cur = cur.next;
	            if(prev==null){
	                prev = head;
	            }else{
	                prev = prev.next;
	            }
	        }
	        
	        prev.next = cur.next;
	        cur.next = null;
	        return head;
	        
	        
	    }
	 
	 public ListNode swapPairs(ListNode head) {
	        if(head == null || head.next == null)
	            return head;
	            
	        ListNode prev = null, first = head;
	        ListNode newHead = null;
	        while(first!=null){//a->b->c->d  b->a->d->c
	            ListNode second = first.next;
	            ListNode next = null;
	            if(second!=null){
	                next = second.next;
	                second.next = first;
	            }
	            first.next = null;
	            if(prev == null){
	                newHead = second;
	             }else{
	                if(second !=null)
	                    prev.next = second;
	                else
	                    prev.next = first;
	            }
	            prev = first;
	            first = next;
	        }
	        return newHead;
	 }
	 
	 public ListNode reverseKGroup(ListNode head, int k) {
		 if(head == null || head.next == null || k < 2)
 	        return head;
 	     ListNode first = head;
 	     ListNode prev = null;
 	     ListNode newHead = head;
 	     while(first!= null){
 	         //advance k steps 
 	         ListNode last = first;
 	         int i = 0;
 	         while(i < k){
 	             if(last == null)
 	                break;
 	             last = last.next;
 	             i++;
 	         }
 	         if(i != k){
 	             if(prev!=null){
 	                prev.next = first;
 	                return newHead;
 	             }
 	              else
 	                return first;
 	         }
 	        last = first;  
 	        ListNode next = first.next;
 	        i = 1;
 	        while(i < k){
 	            ListNode localPrev = last;
                last = next;
                next = last.next;
                last.next = localPrev;
 	            i++;
 	        }
 	        first.next = null;
 	        if(prev == null){
 	            newHead = last;
  	        }else{
 	            prev.next = last;
 	        } 
 	        prev = first;
 	        first = next;
 	     }
    	        
	        
	        return newHead;
	   }
	 
} 
