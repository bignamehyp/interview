package leetcode;

public class Sort {
	
	
	/**
	 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
	 * @param A A has enough space (size that is greater or equal to m + n) to hold additional elements from B.
	 * @param m
	 * @param B
	 * @param n
	 */
	public void merge(int A[], int m, int B[], int n) {
        int a = m - 1, b = n - 1;
        
        for(int i = m + n - 1; i >= 0; i--){
        	
        	if(a < 0 || b < 0)
        		break;
        	
        	if(A[a] > B[b]){
        		A[i] = A[a];
        		a--;
        	}else{
        		A[i] = B[b];
        		b--;
        	}
        }
        
        for(int i = b; i >= 0; i--){
        	A[i] = B[i];
        }
        
    }
	
	
	public ListNode sortList(ListNode head) {
        int len = getLen(head);
        return merge_sort(head, len);
    }
	
	int getLen(ListNode head){
		int len = 0;
		while(head!=null){
			len++;
			head = head.next;
		}
		return len;
	}
	
	ListNode merge_sort(ListNode head, int len){
	 
		if(len <= 1){
 			return head;
		}
		
		ListNode slow = head, fast = head;
		int pos = 0;
		while(pos + 1 < len){
			slow = slow.next;
			fast = fast.next.next;
			pos+=2;
		}
		
		 head = merge_sort(head, len/2);
		 slow = merge_sort(slow, len - len/2);
 		 return merge(head, len/2,slow, len - len/2);
	}
	
	ListNode merge(ListNode head1,int len1, ListNode head2, int len2){
		ListNode head, node;
		int pos1=0, pos2=0;
		if(head1.val <= head2.val){
			node = head1;
			head1 = head1.next;
			pos1++;
		}
		else{
			node = head2;
			head2 = head2.next;
			pos2++;
		}
		head = node;
		
		while(pos1 < len1 && pos2 < len2){
 			if(head1.val <= head2.val){
				node.next = head1;
				head1 = head1.next;
				pos1++;
			}
			else{
				node.next = head2;
				head2 = head2.next;
				pos2++;
			}
			node = node.next;
		}
		
		while(pos1< len1){
			node.next = head1;
			head1 = head1.next;
			node = node.next;
			pos1++;
		}
		
		while(pos2 < len2){
			node.next = head2;
			node = node.next;
			head2 = head2.next;
			pos2++;
		}
		node.next = null;
		
		return head;	
	}
	
	public static void main(String [] args){
		ListNode head = new ListNode(3);
		head.next = new ListNode(2);
		head.next.next = new ListNode(1);
		Sort s = new Sort();
		head = s.sortList(head);
		while(head!=null){
			System.out.println(head.val);
			head = head.next;
		}
	}
}
