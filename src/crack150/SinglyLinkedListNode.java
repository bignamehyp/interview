package crack150;

public class SinglyLinkedListNode <E> {
	
	public SinglyLinkedListNode<E> next = null;
	public E data;
	
	public SinglyLinkedListNode(E data){
		this.data = data;		
	}
	
	public void appendToTail(E data){
		if(this.data == null){
			this.data = data;
			return;
		}
		
		SinglyLinkedListNode<E> newNode = new SinglyLinkedListNode<E>(data);
		SinglyLinkedListNode<E> curNode = this;
		while(curNode.next != null){
			curNode = curNode.next;
		}
		curNode.next = newNode;
	}
	
	
	public SinglyLinkedListNode( E [] inputs){
		if(inputs == null || inputs.length == 0)
			this.data = null;
 		
		this.data = inputs[0];
		
		for(int i = 1; i < inputs.length; i++)
			this.appendToTail(inputs[i]);
				
	}
	
	public void printList(){
		
		if(this.data == null){
			System.out.println();
			return;
		}
 		
		SinglyLinkedListNode<E> curNode = this;
		if(curNode.data != null)
			System.out.print( this.data);
		
		while(curNode.next != null){			
			if(curNode.next.data != null)
				System.out.print( " -> " + curNode.next.data) ;
			curNode = curNode.next;						
		}
		
		System.out.println();
		
	}
	
}
