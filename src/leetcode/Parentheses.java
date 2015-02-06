package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
 
public class Parentheses {
	
	/**
	 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
	 * @param n
	 * @return
	 */
	public ArrayList<String> generateParenthesis(int n) {
		if(n == 0)
			return new ArrayList<String>();
		
        if(n == 1){
        	String p = "()";
        	ArrayList<String> ans = new ArrayList<String>();
        	ans.add(p);
        	return ans;
        }
         
        ArrayList<String> soln =  new ArrayList<String>();
        completeParent(soln, "(", 0, 1, n);
        return soln;
    }

	void completeParent(ArrayList<String> soln, String partial, int numRight, int numLeft, int n){
		if(numLeft == n){
			char [] c = new char[numLeft-numRight];
			Arrays.fill(c, ')');
			soln.add(partial + new String(c));
			return;
		}
		
		for(int i = 0; i <= numLeft - numRight; i++){
			char [] c = new char[i];
			Arrays.fill(c, ')');
			completeParent(soln, partial + new String(c), numRight + i, numLeft + 1, n);
		}								
	}
	 /**
	  * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
	  * @param s
	  * @return
	  * somewhat tricky use stack to store ( indexes
	  */
	  public int longestValidParentheses(String s) {
		  if(s == null || s.length() == 0)
			  return 0;
		  LinkedList<Integer> stack = new LinkedList<Integer>();		  
		  int lastNeg = -1;
		  int maxDist = 0;
		  char [] c_array = s.toCharArray();
		  for(int pos = 0; pos < s.length(); pos++){
			  char c = c_array[pos];
			  if(c == '('){
				  stack.add(pos);
			  }else{
				  if(stack.size() == 0){
					  lastNeg = pos;
				  }else{
					  stack.removeLast();
					  int dist = 0;
					  if(stack.size() == 0){
						  dist = pos - lastNeg;
					  }else{
						  dist = pos - stack.peekLast();
					  }
					  if(dist > maxDist){
						  maxDist = dist;
					  }
				  }
			  }
		  }
		  return maxDist;
	   }	
	  /**
	   * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
	   * @param s
	   * @return
	   */
	  public boolean isValid(String s) {
		  if(s == null || s.length() == 0)
			  return false;
		  LinkedList<Character> stack = new LinkedList<Character> ();
		  
		  for(int i = 0; i < s.length(); i++){
		      
		      if(s.charAt(i) == '('){
		          stack.add('(');
		      }else if(s.charAt(i) == ')'){
		          if(stack.size() == 0 || stack.peekLast() != '('){
 		              return false;
		          }
		      }else if(s.charAt(i) == '['){
		          stack.add('[');
		      }else if(s.charAt(i) == ']'){
		          if(stack.size() == 0 || stack.removeLast() != '['){
		              return false;
		          }
		      }else if(s.charAt(i) == '{'){
		          stack.add('{');
		      }else if(s.charAt(i) == '}'){
		          if(stack.size() == 0 || stack.removeLast() != '{'){
		              return false;
		          }
		      }else{
		          return false;
		      }
		  }
		  return stack.size() == 0;
		 
	   }
	  
	  public static void main(String[] args){
		  Parentheses p = new Parentheses();
		  p.isValid("()");
		  
	  }
	  
}
