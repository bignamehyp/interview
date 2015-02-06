package leetcode;
/*
Given an input string, reverse the string word by word.
For example,
Given s = "the sky is blue",
return "blue is sky the".
*/

public class ReverseWords {
	public String reverseWords(String s) {
    	
    	String [] words = s.split("\\s+");
    	StringBuilder sb = new StringBuilder();
    	for(int i = words.length - 1; i >=0; i--){
    		sb.append(words[i]);
    		sb.append(" ");
    	}
    	return sb.toString().trim();
 }

	
	
}
