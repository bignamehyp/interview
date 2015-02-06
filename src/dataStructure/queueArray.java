package dataStructure;

import java.util.ArrayList;

 
public class queueArray<E>{
	protected ArrayList<E> data;
	int head, tail, size; //The first unused element
	public queueArray(int N){
		data = new ArrayList<E>(N+1);		
		size = N + 1;
		tail = 0;
		head = size;
	}
	
	public E get() {
		head = head % size;
		return data.get(head++);
	}

	public void put(E x) {
		data.set(tail++,x);
		tail = tail % size;
	}

	public boolean isEmpty() {
		return head%size == tail;
	}

}
