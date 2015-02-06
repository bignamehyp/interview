package dataStructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DList<E> implements List<E>{
	protected ListNode<E> sentinel;
	protected int length;
	


	public DList(){
		sentinel = new ListNode<E>(null);
		sentinel.next = sentinel;
		sentinel.prev = sentinel;
		length = 0;
	}

	protected ListNode<E> nodeAt(int idx){
		ListNode<E> current = sentinel;
		 
		if (idx < length / 2) {
            for (int i = 0; i < idx + 1; i++) {
                current = current.next;
            }
        } else {
            for (int i = length; i >= idx + 1; i--) {
                current = current.prev;
            }
        }
		return current;
	}

	public void AddAt(int idx, E x) {
        checkIndex(idx);
		ListNode<E> current = nodeAt(idx -1);
		ListNode<E> n  = new ListNode<E>(x, current, current.next);
		current.next.prev = n;
		current.next = n;
		length++;
	}

	public void append(E x) {
		ListNode<E> n = new ListNode<E>(x, sentinel.prev, sentinel);
		sentinel.prev.next = n;
		sentinel.prev = n;
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
		ListNode<E> current = sentinel.next;
		while(current!=sentinel){
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
	
	 private void checkIndex(int index) {
	        if (index < 0 || index >= length) {
	            throw new IndexOutOfBoundsException("index: " + index);
	        }
	    }
	 
	public int length() {
		return length;
	}

	public void push(E x) {
		AddAt(-1, x);	
	}

	public E remove(int idx) {
        checkIndex(idx);
		ListNode<E> c = nodeAt(idx-1);
		E x = c.next.item;
		c.next = c.next.next;
		c.next.prev = c;
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
            ListNode<E> current = sentinel.next;
            while (current != sentinel) {
                result.append(", " + current.item);
                current = current.next;
            }
            result.append("]");
            return result.toString();
        }
    }
	public Iterator<E> iterator() {
		return new SListIterator();
	}


	protected static class ListNode<E>{
		public E item;
		public ListNode<E> next;
		public ListNode<E> prev;
		public ListNode(E data){
			this(data, null, null);    		 
		}

		public ListNode(E x, ListNode<E> prev, ListNode<E> next){
			this.item = x;
			this.prev = prev;
			this.next = next;
		}
	}

	protected class SListIterator implements Iterator<E> {
		private ListNode<E> current;  // location of next value to return
        private boolean removeOK;  // whether it's okay to remove now

		// post: constructs an iterator for the given list
		public SListIterator() {
			current = sentinel.next;
            removeOK = false;
		}

		// post: returns true if there are more elements left, false otherwise
		public boolean hasNext() {
			return current != sentinel;
		}

		// post: returns the next element in the iteration
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			E result = current.item;
			current = current.next;
            removeOK = true;
			return result;
		}

		// Not OK to remove
		public void remove() {
		     if (!removeOK) {
	                throw new IllegalStateException();
	            }
	            ListNode<E> prev2 = current.prev.prev;
	            prev2.next = current;
	            current.prev = prev2;
	            length--;
	            removeOK = false;
		}
	}

	 
		
}
