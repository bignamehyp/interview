package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	
	public boolean wordBreak1(String s, Set<String> dict) {
        boolean [] possible = new boolean[s.length()];
        
        for(int iter = 0; iter < s.length(); iter++){
        	possible[iter] = false;
        	 if(dict.contains(s.substring(0, iter+1))){
        		 possible[iter] = true;
        	 } else{
        		 for(int b = 0; b < iter; b++){
        			 if(possible[b] && dict.contains(s.substring(b+1, iter + 1))){
        				 possible[iter] = true;
        				 break;
        			 }
        				 
        		 }
        	 }
        }
        
        return possible[s.length() - 1];
     }
	/*
	 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

	Return all such possible sentences.

	For example, given
	s = "catsanddog",
	dict = ["cat", "cats", "and", "sand", "dog"].

	A solution is ["cats and dog", "cat sand dog"].
	 */
	public ArrayList<String> wordBreak(String s, Set<String> dict) {
		ArrayList<String> solutions = new ArrayList<String>();
		ArrayList<ArrayList<Integer>> lastBreaks = new ArrayList<ArrayList<Integer>>();
        for(int iter = 0; iter < s.length(); iter++){
        	ArrayList<Integer> lastBreak = new ArrayList<Integer>();
        	lastBreaks.add(lastBreak);
        	if(dict.contains(s.substring(0, iter+1))){
        		lastBreak.add(0);
        	}
        	for(int wordBreak = 0; wordBreak < iter; wordBreak++){
        		ArrayList<Integer> breaksBefore = lastBreaks.get(wordBreak);
        		if(breaksBefore.size() > 0 && dict.contains(s.substring(wordBreak+1,iter + 1))){
        			lastBreak.add(wordBreak + 1);
        		}
        	}
        	 
        }
        
        buildSolns(s, s.length() - 1, "", solutions, dict, lastBreaks);
        return solutions;
    }
	
	 void buildSolns(String s, int curIdx, String curSoln, ArrayList<String> solutions, Set<String> dict, ArrayList<ArrayList<Integer>> lastBreaks){
		 for(int lastIdx  : lastBreaks.get(curIdx)){
			String soln;
			if(curSoln.length() > 0) 
				soln = s.substring(lastIdx, curIdx + 1) + " " + curSoln;
			else
				soln = s.substring(lastIdx, curIdx + 1);
			
			if(lastIdx == 0){
				solutions.add(soln);
			}else{
				buildSolns(s, lastIdx -  1, soln, solutions, dict, lastBreaks);
			}
		 }
	}
	
	public static void main(String [] args){
		WordBreak wb = new WordBreak();
		HashSet<String> dict = new HashSet<String>();
		dict.add("cats");
		dict.add("cat");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		ArrayList<String> solns = wb.wordBreak("catsanddog", dict);
		for(String s  : solns){
			System.out.println(s);
		}
	}
}
