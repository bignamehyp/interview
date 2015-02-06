package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class WordLadder {
	
	
	public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
		ArrayList<ArrayList<String>>  solns = new ArrayList<ArrayList<String>>();
		HashMap<String, HashSet<String>> prev = new HashMap<String, HashSet<String>>();
		
		
		LinkedList<String> queue = new LinkedList<String>();
        HashMap<String, Integer> dists = new HashMap<String, Integer>();
        queue.add(end);
        dists.put(end, 1);
        prev.put(end, new HashSet<String>());
        
        while(queue.size() > 0){
        	String parent = queue.removeFirst();
        	ArrayList<String> childen = getChildrenWords(parent, dict);
         	int dist = dists.get(parent);
        	for(String child : childen){        		
        		if(!dists.containsKey(child)){
        			dists.put(child, dist + 1);
        			queue.add(child);
        			HashSet<String> parents = new HashSet<String>();
        			parents.add(parent);
        			prev.put(child, parents);
        		}else{
        			if(dist - dists.get(child) == 1){
        				prev.get(parent).add(child);
        			}
        		}
        	}
        }
        
        ArrayList<String> curSoln = new ArrayList<String>();
        curSoln.add(start);
        
        buildSolns(solns, curSoln, end, dict, prev);
		return solns;
	}
	void buildSolns(ArrayList<ArrayList<String>> solns, ArrayList<String> curSoln, String desn, HashSet<String> dict, HashMap<String, HashSet<String>> prev ){
			String curString = curSoln.get(curSoln.size()-1);
			if(!prev.containsKey(curString))
				return;
			for(String s : prev.get(curString)){
				 ArrayList<String> newSoln = new ArrayList<String>(curSoln);
				 newSoln.add(s);
				 if(s.equals(desn)){
					 solns.add(newSoln);
				 }else{
					 buildSolns(solns, newSoln, desn, dict, prev); 
				 }
				 
			}
	}
	 
	//breath first search
	public int ladderLength(String start, String end, HashSet<String> dict) {
    	
		LinkedList<String> queue = new LinkedList<String>();
        HashMap<String, Integer> dists = new HashMap<String, Integer>();
        queue.add(start);
        dists.put(start, 1);
        
        while(queue.size() > 0){
        	String parent = queue.removeFirst();
        	ArrayList<String> childen = getChildrenWords(parent, dict);
        	int dist = dists.get(parent);
        	for(String child : childen){
        		if(child.equals(end)){
        			return dist + 1;
        		}
        		
        		if(!dists.containsKey(child)){
        			dists.put(child, dist + 1);
        			queue.add(child);
        		}
        	}
        }
        return 0;	
    }
	
	
	ArrayList<String> getChildrenWords(String parent, HashSet<String> dict){
		ArrayList<String> ans = new ArrayList<String>();
		
		for(int i = 0; i < parent.length(); i++){
			char [] charArray = parent.toCharArray();
			for(char c = 'a'; c <= 'z'; c++){
				if(c != parent.charAt(i)){
					charArray[i] = c;
					String newWord = new String(charArray);
					if(dict.contains(newWord))
						ans.add(newWord);
				}
			}
			for(char c = '0'; c <= '9'; c++){
				if(c != parent.charAt(i)){
					charArray[i] = c;
					String newWord = new String(charArray);
					if(dict.contains(newWord))
						ans.add(newWord);
				}
			}
		}
		
		return ans;
	}
	
	public static void main(String [] args){
		WordLadder wl = new WordLadder();
		HashSet<String> dict =  new HashSet<String>();
		dict.add("hot"); 
		dict.add("dog");
		wl.findLadders("hot", "dog", dict);
	}
}
