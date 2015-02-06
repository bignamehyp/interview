package crack150;

public class Problem2_2 {
	
	
	public static <E> E kToLast(SinglyLinkedListNode<E> node, int k){
		
		if(k <= 0)
			return null;
		
		SinglyLinkedListNode<E> nodeLast = node;
		SinglyLinkedListNode<E> nodeFirst = node;
		
		for(int step = 1; step < k; step++){
			nodeLast = nodeLast.next;
			if(nodeLast == null)
				return null;
		}
		
		while(nodeLast.next != null){
			nodeLast = nodeLast.next;
			nodeFirst = nodeFirst.next;
		}
		return nodeFirst.data;
	}
	
	public static void main(String [] args){
		
		String [] inputs = new String [] {"abc","abc", "ddb", "cds"};
		
 		
		SinglyLinkedListNode<String> node = new SinglyLinkedListNode<String>(inputs);
  		node.printList();
		System.out.println(kToLast(node,2)); 
		
	}
	
}
