package crack150;

public class Problem2_4 {
	
		public static SinglyLinkedListNode<Integer> partitition(SinglyLinkedListNode<Integer> node, int pivot){
			
			if(node == null)
				return null;
			
			SinglyLinkedListNode<Integer> smallerList = null;
			SinglyLinkedListNode<Integer> largerList = null;
			SinglyLinkedListNode<Integer> smallerHead = null;			
			SinglyLinkedListNode<Integer> largerHead = null;
			
			while(node != null){
				SinglyLinkedListNode<Integer> newNode = new SinglyLinkedListNode<Integer>(node.data);
				if(node.data < pivot){
					if(smallerHead == null){
						smallerHead = newNode;
						smallerList = smallerHead;
					}else{
						smallerList.next = newNode;
						smallerList = smallerList.next;
					}
				}else{
					if(largerHead == null){
						largerHead = newNode;
						largerList = largerHead;
					}else{
						largerList.next = newNode;
						largerList = largerList.next;
					}

				}
				node = node.next;
			}
			
			if(smallerHead == null)
				return largerHead;
			
			smallerList.next = largerHead;
			return smallerHead;
		}
		
		
		public static void main(String [] args){
			
 			
			Integer[] inputs2 = new Integer[]{1,4,9,6,3,8};
			 
			
			SinglyLinkedListNode<Integer> node2 = new SinglyLinkedListNode<Integer>(inputs2);
			node2.printList();
			node2 = partitition(node2, 5);
			node2.printList();
			
		}

	
	
}
