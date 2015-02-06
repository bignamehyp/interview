package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class LongestConsecutiveSequence {
	
	/**
	 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
	 * @param num  [100, 4, 200, 1, 3, 2],
	 * @return [1, 2, 3, 4]. Return its length: 4.
	 */
	
	public int longestConsecutive(int[] num) {
		if(num == null || num.length == 0)
			return 0;
		HashMap<Integer, HashSet<Integer>> hists = new HashMap<Integer, HashSet<Integer>>();
		HashSet<Integer> visited = new HashSet<Integer>();
		//connect elements
		for(int n : num){
			//repeated element
			if(hists.containsKey(n))
				continue;
			HashSet<Integer> neighbors = new HashSet<Integer>();
			
			if(hists.containsKey(n  - 1)){
				hists.get(n - 1).add(n);
				neighbors.add(n - 1);
			}
			
			if(hists.containsKey(n + 1)){
				hists.get(n + 1).add(n);
				neighbors.add(n + 1);
			}
			hists.put(n, neighbors);			 			
		}
		//compute the longest
		int maxLen = 1;
		
		for(int n : num){
			if(visited.contains(n) || hists.get(n).size() == 0){//visited or isolated elements
				visited.add(n);
				continue;
			}
			int len = 0;
			LinkedList<Integer> queue = new LinkedList<Integer>();
			queue.add(n);
			visited.add(n);
			
			while(queue.size() > 0){
				int parent = queue.pollFirst();
				len++;
				for(int neighbor : hists.get(parent)){
					if(!visited.contains(neighbor)){
						queue.add(neighbor);
						visited.add(neighbor);
					}
				}				
			}
			if(len > maxLen){
				maxLen = len;
			}
			
		}
		return maxLen;
		
	}
}
