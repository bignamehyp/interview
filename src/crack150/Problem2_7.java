package crack150;

public class Problem2_7 {
	
	public static <E>  SinglyLinkedListNode<E> reverse( SinglyLinkedListNode<E> headNode){
		if(headNode == null)
			return null;
		if(headNode.next == null)
			return headNode;
		SinglyLinkedListNode<E> prevNode = null;
		SinglyLinkedListNode<E> curNode = headNode;
		
		while(curNode.next != null){
			
			SinglyLinkedListNode<E> nextNode = curNode.next;
			curNode.next = prevNode;
			prevNode = curNode;
			curNode = nextNode;
		}
		
		curNode.next = prevNode;
		return curNode;		
	}
	
	public static void main(String [] args){
		
		String [] inputs = new String [] {"abc","dvsd", "ddb", "cds"};
		
 		
		SinglyLinkedListNode<String> node = new SinglyLinkedListNode<String>(inputs);
  		node.printList();
  		node = reverse(node);
		node.printList();
	 
		
	}
}
