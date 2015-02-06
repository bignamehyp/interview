package crack150;

public class Problem2_3 {
	public static <E> boolean removeNodeMiddle( SinglyLinkedListNode<E> node ){
			if(node == null || node.next == null)
				return false;
			
			node.data = node.next.data;
			node.next = node.next.next;
			
			return true;
		
	}
	
	public static void main(String [] args){
		
		String [] inputs = new String [] {"aaa", "abc", "ddb", "cds"};
		
 		
		SinglyLinkedListNode<String> node = new SinglyLinkedListNode<String>(inputs);
		SinglyLinkedListNode<String> curNode = node;
		curNode = node.next;
		removeNodeMiddle(curNode);
		
  		node.printList();
  		 
		
	}
	
}
