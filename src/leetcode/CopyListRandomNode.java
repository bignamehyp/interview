package leetcode;

public class CopyListRandomNode {
	//A linked list is given such that each node contains an additional 
	//random pointer which could point to any node in the list or null. Return a deep copy of the list.
	public RandomListNode copyRandomList(RandomListNode head) {
		  if(head == null)
	        	return null;
	        
	        RandomListNode rootHead = head;
	        
	        while(head!=null){
	        	RandomListNode copy = new RandomListNode(head.label);
	         	copy.next = head.next;
	         	copy.random = null;
	         	head.next = copy;         		
	        	head = copy.next;
	         }
	         
	        head = rootHead;
	        
	        while(head!=null){
	            if(head.random!=null)
	                head.next.random = head.random.next;
	            else
	                head.next.random = null;
	            head = head.next.next;
	         }
	              
	        RandomListNode copiedHead = rootHead.next;
	        head = rootHead;

	        while(head!=null){
	            RandomListNode copy = head.next;
	            head.next = head.next.next;
	            if(head.next!=null){
	                copy.next = head.next.next;
	            }else{
	                copy.next = null;
	            }
	            head = head.next;
	         }
	       
	        return copiedHead;
	}
}

class RandomListNode {
     int label;
     RandomListNode next, random;
     RandomListNode(int x) { 
    	 this.label = x; 
     }
  
};
