package crack150;

public class Problem3_6{
	 static Stack<Integer> sort ( Stack<Integer> stack ){
		 Stack<Integer> auxStack = new Stack<Integer>();
		 
		 while(!stack.isEmpty()){
			 Integer data = stack.pop();
			 
			 int numAuxPop = 0;
			 while(!auxStack.isEmpty() && data > auxStack.peek()){
				 stack.push(auxStack.pop());
				 numAuxPop++;
			}
			
			 auxStack.push(data);
				 
				 
			 for(int iterPush = 0; iterPush < numAuxPop; iterPush++){
				 auxStack.push(stack.pop());
			}							 
		 }
		 
		 return auxStack;
		 
	 }
	 
	 public static void main(String[] argins){
		 Stack<Integer> minStack = new Stack<Integer>();
		 minStack.push(5);
		 minStack.push(8);
		 minStack.push(4);
		 minStack.push(7);
		 minStack.push(2);
		 minStack.push(4);
		 Stack<Integer>sortedStack = sort(minStack);
		 
		 while(!sortedStack.isEmpty()){
			 System.out.println( sortedStack.pop());
		 }
		 
	 }
}
