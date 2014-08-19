package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class CombinationSum {




	/**
	 * 	Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
	 * The same repeated number may be chosen from C unlimited number of times
	 * @param candidates positive integers.
	 * @param target positive integers.
	 * @return   in non-descending order The solution set must not contain duplicate combinations.
	 */
	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(candidates);
		combinationSum(ans, new LinkedList<Integer>(), 0, candidates, 0, target);
		return ans;
	}

	void combinationSum ( ArrayList<ArrayList<Integer>> ans, LinkedList<Integer> path, int pos, int[] candidates, int parSum, int target){


		if(parSum == target){ 
			ans.add(new ArrayList<Integer>(path));
			return;
		}

		if(pos >= candidates.length || parSum > target)
			return;

		int sum = parSum;

		while(sum <= target){
			combinationSum(ans, path, pos+1, candidates, sum, target);
			path.add(candidates[pos]);
			sum += candidates[pos];
		}
		while(parSum != sum){
			sum -= path.pollLast();
		}


	}

	/**
	 * Each number in C may only be used once in the combination.

	 * @param num
	 * @param target
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(num);
		combinationSum2(ans, new LinkedList<Integer>(), 0, num,   target);
		return ans;
	}

	void combinationSum2 ( ArrayList<ArrayList<Integer>> ans, LinkedList<Integer> path, int pos, int[] candidates,  int target){

 		if(0 == target){ 
			ans.add(new ArrayList<Integer>(path));
			return;
		}
 
  
		for(int i = pos; i < candidates.length; i++){
			if( candidates[i] > target)
				continue;
			
			path.add(candidates[i]);
			combinationSum2(ans, path, i+1, candidates, target - candidates[i]);
			
			path.pollLast(); 
			while( i + 1  < candidates.length && candidates[i] == candidates[i+1]){
				i++;
			}

		}
		 

	}
	/**
	 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
	 * @param n
	 * @param k
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		combine(ans, new LinkedList<Integer>(), 1, n, k);
		return ans;
    }
	
	void combine(ArrayList<ArrayList<Integer>> ans, LinkedList<Integer> path, int pos, int n, int k){
		if(path.size() == k){
			ans.add(new ArrayList<Integer>(path));
			return;
		}
		
		for(int i = pos; i <= n - k + pos; i++){
			if( i > n)
				break;
			path.add(i);
			combine(ans, path, i+1, n, k);
			path.pollLast();
		}
	}

}
