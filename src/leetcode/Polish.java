package leetcode;

import java.util.LinkedList;

public class Polish {
	
	/**
	 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
	 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
	 * @param tokens
	 * @return
	 */
	public int evalRPN(String[] tokens) {
 		LinkedList<Integer> stack = new LinkedList<Integer>();				
		
		for(String token : tokens){
			if(isNumber(token)){
				stack.add(Integer.valueOf(token));
			}else{
				//get two operand;
				int num1 = 0, num2 = 0;
				if(stack.size() > 0){
					num2 = stack.pollLast(); 
				}
				if(stack.size() > 0){
					num1 = stack.pollLast();
				}
				
				stack.add(compute(token, num1, num2));
			}
		}
		return stack.pollLast();
    }
	
	int compute(String token, int num1, int num2){
		if(token.equals("*"))
			return num1 * num2;
		if(token.equals("/"))
			return num1 / num2;
		if(token.equals("+"))
			return num1 + num2;
		if(token.equals("-"))
			return num1 - num2;
		return 0;
	}
	
	boolean isNumber(String token){
		
		
 		if((token.charAt(0) == '-' && token.length() > 1) || (token.charAt(0) >= '0'  && token.charAt(0)  <= '9')){
			return true;
		}else{
			return false;
		}
			
	}
	
	

}
