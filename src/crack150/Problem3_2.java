package crack150;

public class Problem3_2 extends Stack<Integer>{
 	 Stack<Integer> minStack = new Stack<Integer>();
	 
	 public void push(Integer data){
		 super.push(data);
		 
		 if(minStack.isEmpty()){
			 minStack.push(data);
		 }else{
			 if (data <= minStack.peek()){
				 minStack.push(data);
			 }
		 }				 
	 }
	 
	 public Integer pop(){		 
		 Integer data = super.pop();
		 if(minStack.peek().equals(data)){
			 minStack.pop();
		 }
		 return data;
	 }
	 
	 public Integer min(){
		 if( minStack.isEmpty())
		 	return null;
		 return minStack.peek();
	 }
	 
	 public static void main(String[] argins){
		 Problem3_2 minStack = new Problem3_2();
		 minStack.push(5);
		 minStack.push(8);
		 minStack.push(3);
		 minStack.push(4);
		 while(!minStack.isEmpty()){
			 System.out.println(minStack.min() + " , " + minStack.pop());
		 }
		 
	 }

}
