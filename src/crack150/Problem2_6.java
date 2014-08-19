package crack150;

public class Problem2_6 {
	
	public static <E>  SinglyLinkedListNode<E> loopHead( SinglyLinkedListNode<E> headNode){
		if(headNode == null)
			return null;
		 SinglyLinkedListNode<E> singlePaceNode = headNode;
		 SinglyLinkedListNode<E> doublePaceNode = headNode;
		 SinglyLinkedListNode<E> catchupNode = headNode;
		 
		 singlePaceNode = singlePaceNode.next;
		 doublePaceNode = doublePaceNode.next.next;
		 while(singlePaceNode != doublePaceNode){
			 singlePaceNode = singlePaceNode.next;
			 doublePaceNode = doublePaceNode.next.next;
		 }
		
		 while(singlePaceNode != catchupNode){
			 singlePaceNode = singlePaceNode.next;
			 catchupNode = catchupNode.next;
		 }
		 return singlePaceNode;
	}
	
	
public static void main(String [] args){
		
		String [] inputs = new String [] {"abc","def", "ddb", "cds"};
		
 		
		SinglyLinkedListNode<String> node = new SinglyLinkedListNode<String>(inputs);
		SinglyLinkedListNode<String> tailNode = node.next.next.next;
  		tailNode.next = node.next;
  		
  		SinglyLinkedListNode<String> loopHead = loopHead(node);
  		System.out.println(loopHead.data);
		
	}
	
	
}
