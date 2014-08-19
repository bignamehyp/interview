package crack150;


public class Stack <E>{
	
	SinglyLinkedListNode<E> top;

	public void push(E data){
		SinglyLinkedListNode<E> node = new SinglyLinkedListNode<E>(data);
		node.next = top;
		top = node;
	}
	
	public E peek(){
		if(top == null)
			return null;
		
		return top.data;
	}
	
	public boolean isEmpty(){
		return peek() == null;
	}
	
	public E pop(){
		if(top != null){
			E data = top.data;
			top = top.next;
			return data;
		}
		return null;
	}

}
