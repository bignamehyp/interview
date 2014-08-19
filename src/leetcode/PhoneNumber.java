package leetcode;

import java.util.ArrayList;

public class PhoneNumber {
	
	
	 public ArrayList<String> letterCombinations(String digits) {
		 
		 ArrayList<String> ans = new ArrayList<String>();
		 
		 letterCombinations(ans, new char[digits.length()], 0, digits);
		 return ans;
	 }
	 
	 void letterCombinations( ArrayList<String> ans, char [] path, int pos, String digits){
 		 
		 if(pos == digits.length()){
			 ans.add(new String(path));
			 return;
		 }
		 
		 String candidates = getChar(digits.charAt(pos) - '0');
		 
		 for(char c : candidates.toCharArray()){
			 path[pos] = c;
			 letterCombinations(ans, path, pos + 1, digits);
		 }		 
		 
	 }
	 
	 String getChar(int i ){
		 if(i == 0)
			 return " ";
		 if(i == 1)
			 return "1";
		 
		 if(i == 9)
			 return "wxyz";
		 if(i == 7)
			 return "pqrs";
		 if( i== 8 )
			 return "tuv";
		 
		 if( i == 2){
			 return "abc";
		 }
		 
		 if( i == 3){
			 return "def";
		 }
		 if( i == 4){
			 return "ghi";
		 }
		 if( i == 5){
			 return "jkl";
		 }
		 if( i == 6){
			 return "mno";
		 }
		 return "";
	 }
	 
}
