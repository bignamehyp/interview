package leetcode;

public class SortedListToBST {
	 ListNode iter;
	
	 	public TreeNode sortedArrayToBST(int[] num) {
	 		if(num.length == 0)
	 			return null;
	 		return sortedArrayToBST(num, 0, num.length - 1);
	    }
	 
	 	public TreeNode sortedArrayToBST(int[] num, int begin, int end){
	 		if(begin == end){
	 			return new TreeNode(num[begin]);
	 		}
	 		
	 		int middle = (end + begin)/2;
	 		TreeNode node = new TreeNode(num[middle]);
	 		if(begin < middle){
	 			node.left = sortedArrayToBST(num, begin, middle - 1);
	 		}
	 		if(middle  < end){
	 			node.right = sortedArrayToBST(num, middle + 1, end);
	 		}
	 		return node;
	    }
	 	
		public TreeNode sortedListToBST(ListNode head) {
			iter = head;
	        int n = listLength(head);
	        return buildBST(head, n);
	    }
	
		
		public TreeNode buildBST(ListNode head, int n){
			
			if(head == null || iter == null || n <= 0)
				return null;
		    int half = n/2;
			TreeNode leftNode = buildBST(head, half);
			TreeNode parent = new TreeNode(iter.val);
			parent.left = leftNode;
			iter = iter.next;
			parent.right = buildBST(iter, n-1 - half);
			return parent;
		}
		
		public int listLength(ListNode head){
 			
			int n = 0;
			while(head != null){
				n++;
				head = head.next;
			}
			return n;
		}
}

class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
}