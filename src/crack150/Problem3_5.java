package crack150;

public class Problem3_5 <E> {
	
	Stack<E> forwardStack = new Stack<E>();
	Stack<E> backwardStack = new Stack<E>();
	
	public void push(E data){
 		forwardStack.push(data);		 
	}
	
	public E pop() {
		moveBackward(); 		
		return backwardStack.pop();		
	}
	
	public E peek() {
		moveBackward();
		return backwardStack.peek();
	}
	
	void moveBackward(){
		if(!backwardStack.isEmpty())
			return;
		while(!forwardStack.isEmpty()){
			backwardStack.push(forwardStack.pop());
		}
	}
	
	public boolean isEmpty(){
		return backwardStack.isEmpty() && forwardStack.isEmpty();
	}
	
	public static void main(String [] args){
		Problem3_5<String> myQueue = new Problem3_5<String>();
		myQueue.push("a");
		myQueue.push("b");
		myQueue.push("c");
		myQueue.push("d");
		while(!myQueue.isEmpty()){
			System.out.println(myQueue.pop());
		}
	}
	
	
}
