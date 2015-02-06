package crack150;

import java.util.HashSet;

public class Problem2_1 {
	
	
	public static <E> void removeDup(SinglyLinkedListNode<E> node){
		
		HashSet<E> objSet = new HashSet<E>();
		
		SinglyLinkedListNode<E> curNode = node;
		
		objSet.add(curNode.data);
		
		
		while(curNode.next != null){
			
			if(objSet.contains(curNode.next.data)){
				curNode.next = curNode.next.next;
			}else{
				objSet.add(curNode.next.data);
			}
			
			curNode = curNode.next;			
		}
		
		
	}
	
	public static void main(String [] args){
		
		String [] inputs = new String [] {"abc","abc", "ddb", "cds"};
		
		Integer[] inputs2 = new Integer[]{1,2,2,3};
		
		SinglyLinkedListNode<String> node = new SinglyLinkedListNode<String>(inputs);
  		node.printList();
		removeDup(node);
		node.printList();
		
		SinglyLinkedListNode<Integer> node2 = new SinglyLinkedListNode<Integer>(inputs2);
		node2.printList();
		removeDup(node2);
		node2.printList();
		
	}

}
