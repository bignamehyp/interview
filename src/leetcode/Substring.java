package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

 
 
public class Substring {
	/**
	 * Very Classic!!
	 * @param S
	 * @param T
	 * @return
	 */
	public String minWindow(String S, String T) {
        if(S == null || S.length() == 0 || T == null || T.length() == 0)
        	return "";
		
		HashMap<Character, Integer> needToFind = new HashMap<Character, Integer>();
		HashMap<Character, Integer> found = new HashMap<Character, Integer>();
		int numFound = 0;
		int minLen = Integer.MAX_VALUE;
		int minStart = 0, minEnd = 0;
		int winStart = 0;
		
		for(char c : T.toCharArray()){
			if(needToFind.containsKey(c)){
				needToFind.put(c, needToFind.get(c) + 1);
			}else{
				needToFind.put(c, 1);
			}
		}
		char [] s_char = S.toCharArray();
		for(int pos = 0; pos < S.length(); pos++){
			char c = s_char[pos];
			if(!needToFind.containsKey(c))
				continue;
			
			if(!found.containsKey(c)){
				found.put(c, 1);
 			}else{
				found.put(c, found.get(c) + 1);
 			}
			
			if(found.get(c) <= needToFind.get(c)){
					numFound++;
			} 
			
			if(numFound == T.length()){
				//advance start pointer
				while( !needToFind.containsKey(s_char[winStart]) || found.get(s_char[winStart]) > needToFind.get(s_char[winStart])){
					if(needToFind.containsKey(s_char[winStart]) && found.get(s_char[winStart]) > needToFind.get(s_char[winStart])){
						found.put(s_char[winStart], found.get(s_char[winStart]) - 1);
					}					
					winStart++;
				}
				if(pos - winStart + 1 < minLen){
					minLen = pos - winStart + 1;
					minStart = winStart;
					minEnd = pos;
				}
			}
		}
		
		if(numFound < T.length()){
			return "";
		}else{
			return S.substring(minStart, minEnd + 1);
		}
		
    }
	
	
	
	/**
	 * You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.
	 * @param S "barfoothefoobarman"
	 * @param L ["foo", "bar"]
	 * @return  indices: [0,9]. (order does not matter).
	 */
	 public ArrayList<Integer> findSubstring(String S, String[] L) {
	        if(S == null || S.length() == 0 || L.length == 0)
	            return new ArrayList<Integer>();
	        int numL = L.length;
	        int unitLen = L[0].length();
	        if(S.length() < numL * unitLen)
	            return new ArrayList<Integer>();
	        
	        ArrayList<Integer> ans = new ArrayList<Integer>();
	        HashMap<String, Integer> needToFind = new HashMap<String, Integer>();
	         
	        for(String str : L){
	            if(!needToFind.containsKey(str)){
	                needToFind.put(str, 1);
	            }
	           else{
	               needToFind.put(str, needToFind.get(str) + 1);
	           }
	        }
	        
	        for(int begin = 0; begin  < S.length() - numL * unitLen + 1; begin++){
	            int numFound = 0;
		        HashMap<String, Integer> found = new HashMap<String, Integer>();
	            for(int i = 0; i < numL; i++){
	                String subStr = S.substring(begin + i * unitLen, begin + (i + 1) * unitLen );
	                if(!needToFind.containsKey(subStr))
	                    break;
	                    
	                if(!found.containsKey(subStr)){
	                    found.put(subStr, 1);
	                }else{
	                    found.put(subStr, found.get(subStr) + 1);
	                }
	                
	                if(found.get(subStr) <= needToFind.get(subStr)){
	                    numFound++;
	                }else{
	                    break;
	                }
	            }
	            if(numFound == L.length){
	                ans.add(begin);
 	            }
	        }
	        
	        return ans;
	    }
	 
	 
	 /**
	  * Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
	  * @param s
	  * @return
	  */
	 public int lengthOfLongestSubstring(String s) {
	        if(s == null || s.length() == 0 ){
	            return 0;
	        }
	        if(s.length() == 1){
	            return 1;
	        }
	        
	        HashSet<Character> uniqueSet = new HashSet<Character>();
	        int maxLen = 0;
	        int begin = 0;
	        
	        char [] s_char = s.toCharArray();
	        for(int pos = 0;  pos < s.length(); pos++ ){
	            char c = s_char[pos];
	            if(!uniqueSet.contains(c) ){
	                uniqueSet.add(c);
	                int len = pos - begin + 1;
	                if(len > maxLen){
	                    maxLen = len;
	                }
	            }else{//advance begin to remove c
	                while(s_char[begin] != c){
	                if(uniqueSet.contains(s_char[begin]))
	                	uniqueSet.remove(s_char[begin]);
	                    begin++;
	                }
	                //s_char[begin] == c;
	                begin++;
	            }
	        }
	        return maxLen;    
	    }
	 
}
