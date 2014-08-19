package crack150;


public class Queue <E>{
	SinglyLinkedListNode<E> first, last;
	
	public void push(E data){
		if(first == null){
			first = new SinglyLinkedListNode<E>(data);
			last = first;
		}else{
			last.next = new SinglyLinkedListNode<E>(data);
			last = last.next;			
		}
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public E pop() {
		if(first == null)
			return null;
		
		E data = first.data;
		first = first.next;
		return data;		
	}
	
	public E peek() {
		if(first == null)
			return null;
		return first.data;
	}

}
