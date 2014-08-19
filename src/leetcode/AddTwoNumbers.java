package leetcode;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
        if(l1 == null)
        	return l2;
        if(l2 == null)
        	return l1;
        
        int carry = 0;
        
        
        ListNode ans = null;
        ListNode root = null;
        
        while(l1 != null || l2 != null){
        	
        	int val = carry;
        	
        	if(l1 != null)
        		val += l1.val;
        	if(l2 != null)
        		val += l2.val;
        	
            if(val >= 10){
            	carry = 1;
            	val -= 10;
            } else{
            	carry = 0;
            }
            
            if(ans == null){
            	ans = new ListNode(val);
            	root = ans;
            }else{
            	ans.next = new ListNode(val);
            	ans = ans.next;
            }
            if(l1 != null)
            	l1 = l1.next;
            if(l2 != null)
            	l2 = l2.next;
        }
        
        if(carry != 0){
        	ans.next = new ListNode(carry);
        }
        
        return root;
    }
}


