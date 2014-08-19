package dataStructure;

import java.util.ArrayList;

public class stackArray<E>{
	protected ArrayList<E> data;
	int tail; //The first unused element
	public stackArray(int N){
		data = new ArrayList<E>(N);
		tail = 0;
	}
	
	public E pop() {
		return data.get(--tail);
	}

	public void push(E x) {
		data.set(tail++,x);
	}

	public E top() {
		return data.get(tail-1);
	}

	public boolean isEmpty() {
		return tail == 0;
	}


}
