package dataStructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SList<E> implements List<E>{
	protected ListNode<E> head;
	protected ListNode<E> tail;
	protected int length;

	public SList(){
		head = new ListNode<E>(null);
		tail = null;
		length = 0;
	}

	protected ListNode<E> nodeAt(int idx){
		ListNode<E> current = head;

		for(int i = 0; i <= idx; i++)
			current = current.next;
		return current;
	}

	public void AddAt(int idx, E x) {
		if (idx < 0 || idx > length) {
            throw new IndexOutOfBoundsException("index: " + idx);
        }
 		ListNode<E> current = nodeAt(idx -1);
		current.next = new ListNode<E>(x, current.next);
		if(idx == length - 1)
			tail = current.next;
		length++;
	}

	public void append(E x) {
		if(head.next == null){
			tail = new ListNode<E>(x, null);
			head.next = tail;
		}
		else{
			tail.next = new ListNode<E>(x,null);
			tail = tail.next;
		}
		length++;
	}

	public E at(int idx) {
        checkIndex(idx);
		ListNode<E> n = nodeAt(idx);
		return n.item;
	}

	public boolean contains(E x) {
		return find(x) < length();
	}

	public int find(E x) {
		int idx = 0;
		ListNode<E> current = head.next;
		while(current!=null){
			if(current.item.equals(x))
				break;
			idx++;
			current = current.next;
		}
		return idx;
	}

	public boolean isEmpty() {
		return length == 0;
	}

	public int length() {
		return length;
	}

	public void push(E x) {
		AddAt(0, x);	
	}

	public E remove(int idx) {
        checkIndex(idx);
		ListNode<E> c = nodeAt(idx-1);
		E x = c.next.item;
		c.next = c.next.next;
		if(idx == length - 1)
			tail = c;
		length--;
		return x;
	}

	public void set(int idx, E x) {
        checkIndex(idx);
		ListNode<E> n = nodeAt(idx);
		n.item = x;
	}
	
    public String toString() {
        if (length == 0) {
            return "[]";
        } else {
            StringBuffer result = new StringBuffer();
            result.append("[");
            ListNode<E> current = head.next;
            while (current != null) {
                result.append(", " + current.item);
                current = current.next;
            }
            result.append("]");
            return result.toString();
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
    }
	public Iterator<E> iterator() {
		return new SListIterator();
	}

	protected static class ListNode<E>{
		public E item;
		public ListNode<E> next;

		public ListNode(E data){
			this(data, null);    		 
		}

		public ListNode(E x, ListNode<E> next){
			this.item = x;
			this.next = next;
		}
	}

	protected class SListIterator implements Iterator<E> {
		private ListNode<E> current;  // location of next value to return
		// post: constructs an iterator for the given list
		public SListIterator() {
			current = head.next;
		}

		// post: returns true if there are more elements left, false otherwise
		public boolean hasNext() {
			return current != null;
		}

		// post: returns the next element in the iteration
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			E result = current.item;
			current = current.next;
			return result;
		}

		// Not OK to remove
		public void remove() {

		}
	}

}


