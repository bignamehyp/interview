package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class Permutations {

	/**
	 * Given a set of distinct integers, S, return all possible subsets.
	 * @param S
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		Arrays.sort(S);
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		subsets(ans, new LinkedList<Integer>(), 0, S);
		return ans;
	}
	void subsets(ArrayList<ArrayList<Integer>> ans, LinkedList<Integer> path, int pos,  int [] S){

		ans.add(new ArrayList<Integer>(path));

		for(int i = pos; i < S.length; i++){
			path.add(S[i]);
			subsets(ans, path, i+1, S);
			path.pollLast();
		}
	}

	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		Arrays.sort(num);
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		subsetsWithDup(ans, new LinkedList<Integer>(), 0, num);
		return ans;   
	}
	
	
	void subsetsWithDup(ArrayList<ArrayList<Integer>> ans, LinkedList<Integer> path, int pos,  int [] S){

		ans.add(new ArrayList<Integer>(path));

		for(int i = pos; i < S.length; i++){
			path.add(S[i]);
			subsetsWithDup(ans, path, i+1, S);
			path.pollLast();
			while(i + 1 < S.length && S[i] == S[i+1]){
				i++;
			}
		}
	}
	


	/**
	 * The set [1,2,3,n] contains a total of n! unique permutations.
 		 By listing and labeling all of the permutations in order,
	 * @param n will be between 1 and 9 inclusive.
	 * @param k
	 * @return the kth permutation sequence.
	 */
	public String getPermutation(int n, int k) {
		if(n == 0)
			return "";
		if(n == 1)
			return "1";

		char [] c_array = new char [n];

		int [] fact = new int [n];
		fact[0] = 1;
		for(int i = 1; i < n; i++){
			fact[i] = i * fact[i-1];
		}

		boolean [] candidates = new boolean [n];

		for(int pos = 0; pos < n; pos++){
			int cur = (k - 1) / fact[n - pos - 1];
			k = k - cur * fact[n - pos - 1];
			int i = 0;
			for(; i < n; i++){
				if(candidates[i] == false){
					if(cur == 0){
						candidates[i] = true;
						c_array[pos] = (char) (i + '1');
						break;
					}else{
						cur--;
					}
				}
			}
		}
		return new String(c_array);
	}

	/**
	 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
	 * @param num
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		ArrayList<ArrayList<Integer>> solns = new ArrayList<ArrayList<Integer>>();
		permuteUnique(num, 0, solns);
		return solns;
	}

	void permuteUnique(int [] num, int idx, ArrayList<ArrayList<Integer>> solns){
		if(idx == num.length - 1){
			ArrayList<Integer> soln = new ArrayList<Integer>();
			for(int n : num){
				soln.add(n);
			}
			solns.add(soln);
			return;
		}
		HashSet<Integer> uniques=  new HashSet<Integer>();

		permuteUnique(num, idx + 1, solns);
		int tmp = num[idx];
		uniques.add(num[idx]);

		for(int i = idx + 1; i < num.length; i++){
			num[idx] = num[i];
			num[i] = tmp;
			if(!uniques.contains(num[idx])){
				permuteUnique(num, idx + 1, solns);
				uniques.add(num[idx]);
			}
			num[i] = num[idx];
			num[idx] = tmp;
		}

	}

	/**
	 * Given a collection of numbers, return all possible permutations.
	 * @param num
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> permute(int[] num) {

		ArrayList<ArrayList<Integer>> solns = new ArrayList<ArrayList<Integer>>();
		permute(num, 0, solns);	
		return solns;
	}

	void permute(int [] num, int idx, ArrayList<ArrayList<Integer>> solns){
		if(idx == num.length - 1){
			ArrayList<Integer> soln = new ArrayList<Integer>();
			for(int n : num){
				soln.add(n);
			}
			solns.add(soln);
			return;
		}

		permute(num, idx+1, solns);
		int tmp = num[idx];
		for(int i = idx + 1; i < num.length ; i++){
			num[idx] = num[i];
			num[i] = tmp;
			permute(num, idx + 1 , solns);
			num[i] = num[idx];
			num[idx] = tmp;
		}

	}

	/**
	 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
	 * @param num
	 */
	public void nextPermutation(int[] num) {
		if(num == null || num.length <= 1)
			return;
		int n = num.length;
		int highestFromRight = n - 1;

		//ensure num[highestFromRight-1] < num[highestFromRight]
		while(highestFromRight > 0 && num[highestFromRight-1] >= num[highestFromRight]){
			highestFromRight--;
		}

		if(highestFromRight == 0){
			reverse(num, 0, n -1);
			return;
		}

		//ensure num[toBeSwap] > num[highestFromRight -1]
		int toBeSwap = n - 1;
		while(toBeSwap > highestFromRight && num[toBeSwap] <= num[highestFromRight -1]){
			toBeSwap--;
		}
		int tmp = num[toBeSwap];
		num[toBeSwap] = num[highestFromRight-1];
		num[highestFromRight-1] = tmp;
		reverse(num, highestFromRight, n-1);

	}

	public void reverse(int [] num, int begin, int end){
		if(end == begin)
			return;
		while(begin < end){
			int tmp = num[begin];
			num[begin] = num[end];
			num[end] = tmp;
			begin++;
			end--;
		}
	}
}
