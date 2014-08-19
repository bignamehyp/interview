package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;

public class Palindromic {

	/**
	 * Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
	 * @param s
	 * @return
	 * Very tricky! traverse the center of palindrome
	 */
	public String longestPalindrome(String s) {
		if(s == null || s.length() == 0)
			return "";
		if(s.length() == 1)
			return s;


		int maxLen = 1;
		String maxPalindrome = s.substring(0,1);
		char [] s_char = s.toCharArray();
		for(int center = 0; center < s.length() - 1; center++){
			//find the longest palindrome centerred at center
			int left = center - 1, right = center + 1, len = 1;
			while(left >=0 && right  < s.length() && s_char[left] == s_char[right]){
				left--;
				right++;
				len+=2;
			}
			if(len > maxLen){
				maxLen = len;
				maxPalindrome = s.substring(left + 1,  right);
			}
			//find the longest palindrome centerred at center, center + 1
			left = center;
			right = center + 1;
			len = 0;
			while(left >=0 && right  < s.length() && s_char[left] == s_char[right]){
				left--;
				right++;
				len+=2;
			}
			if(len > maxLen){
				maxLen = len;
				maxPalindrome = s.substring(left + 1,  right);
			}
		}

		return maxPalindrome;
	}

	/**
	 * Given a string s, partition s such that every substring of the partition is a palindrome.
	 * @param s
	 * @return
	 * Difficult question,  use dp
	 */
	public int minCut(String s) {
		if(s == null || s.length() <= 1)
			return 0; 
		
		boolean [][] isPal = new boolean [s.length()][s.length()];
 		int [] cuts = new int [s.length()];
		
		for(int i = 0; i < s.length(); i++){
			cuts[i] = i;
			isPal[i][i] = true;
		}
		
		for(int end = 1; end < s.length(); end++){
			for(int start = 0; start <= end; start++){
				if( s.charAt(start) == s.charAt(end) && ( end - start < 2 ||  isPal[start+1][end - 1] == true) ){
					isPal[start][end] = true;
					if(start == 0){
						cuts[end] = 0;
						break;
					}
					else
						cuts[end] = Math.min(cuts[end],  1 + cuts[start - 1]);
				}
			}
		}
		return cuts[s.length() - 1]; 
	}
	
	

	/**
	 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
	 * For the purpose of this problem, we define empty string as valid palindrome.
	 * @param s
	 * @return
	 */
	public boolean isPalindrome(String s) {
		if(s.length() == 0)
			return true;
		s = s.toLowerCase();
		s = s.replaceAll("[^a-z0-9]","");
		char [] s_char = s.toCharArray();
		for(int i = 0; i < s.length()/2; i++){
			if(s_char[i] != s_char[s.length() - i - 1])
				return false;
		}
		return true;
	}

	/**
	 * Given a string s, partition s such that every substring of the partition is a palindrome.
	 * Return all possible palindrome partitioning of s.
	 * @param s 
	 * @return
	 */
	 public ArrayList<ArrayList<String>> partition(String s) {
		 if(s == null || s.length() == 0)
			 return new ArrayList<ArrayList<String>>();
		 
		 
		 ArrayList<ArrayList<String>> solns = new ArrayList<ArrayList<String>>();
		  
		 LinkedList<String> soln = new LinkedList<String>();
		 dfs(solns, soln, s);
		 return solns;
		 
	 }
	 
	 void dfs(ArrayList<ArrayList<String>> solns ,LinkedList<String> soln, String s){
	     if(s.length() == 0){
	         solns.add(new ArrayList<String>(soln) );
	     }
	     
	     for(int i = 0; i < s.length(); i++ ){
	         String sub = s.substring(0, i + 1);
	         if(isP(sub)){
	             soln.add(sub);
	             dfs(solns, soln, s.substring(i+1));
	             soln.removeLast();
	         }
	     }
	 }
	 
	 
	 boolean isP(String s){
	     int l = 0;
	     int r = s.length() - 1;
	     while(l < r){
	         if(s.charAt(l) != s.charAt(r)){
	             return false;
	         }
	         l++;
	         r--;
	     }
	     return true;
	 }
	 

	 public boolean isPalindrome(int x) {
		 if(x < 0)
			 return false;
		 if(x < 10)
			 return true;
		 
	        int y = x;
	        int h = 0;
	        while(y!=0){
	        	y = y / 10;
	        	h++;
	        }
	        
	        for(int l = 1; l <= h/2; l++){
	        	int lowerBit = x / (int)(Math.pow(10, l - 1));
	        	lowerBit = lowerBit % 10;
	        	int upperBit = x / (int)(Math.pow(10, h - l));
	        	upperBit = upperBit % 10;
	        	if(lowerBit != upperBit)
	        		return false;
	        }
	        return true;
	  }
	

	public static void main(String [] args){
		Palindromic p = new Palindromic();
		System.out.println(p.longestPalindrome("bb"));
	}
}
