package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
	/*	Given an array of integers, find two numbers such that they add up to a specific target number. 
	 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
	 * You may assume that each input would have exactly one solution.
	 * Input: numbers={2, 7, 11, 15}, target=9
	 * Output: index1=1, index2=2
	 */	
	public int[] twoSum(int[] numbers, int target) {
		HashMap<Integer,Integer> remains = new HashMap<Integer, Integer>();
		int [] ans = new int [2];
		Arrays.fill(ans, -1);
		for(int idx = 0; idx < numbers.length; idx++){
			int n = numbers[idx];
			if(remains.containsKey(n)){
				ans[0] = remains.get(n) + 1;
				ans[1] = idx + 1;
				return ans;
			}
			remains.put(target - n, idx);
		}
		return ans;
	}

	/**
	 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
	 * @param num
	 * @param target
	 * @return
	 */
	public int threeSumClosest(int[] num, int target) {
		Arrays.sort(num);
		int minDiff = Integer.MAX_VALUE;
		int minSum = Integer.MAX_VALUE;
		for(int idx1st = 0; idx1st < num.length - 2; idx1st++){			 
 			int idx2nd = idx1st + 1;
			int idx3rd = num.length - 1;
			while( idx2nd < idx3rd){
				int tmp = Math.abs(num[idx1st] + num[idx2nd] + num[idx3rd] - target);
				
				if(tmp < minDiff){
					minDiff = tmp;
					minSum = num[idx1st] + num[idx2nd] + num[idx3rd];
				}
				
				if(num[idx1st] + num[idx2nd] + num[idx3rd] == target){
					break;
				}else if (num[idx1st] + num[idx2nd] + num[idx3rd] < target ){
					idx2nd++;
				}else{
					idx3rd--;
				}	        		
			}
		}
		return minSum;
    }

	/**
	 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
	 * @param num
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		Arrays.sort(num);
		ArrayList<ArrayList<Integer>> solns = new ArrayList<ArrayList<Integer>>();
		for(int idx1st = 0; idx1st < num.length - 2; idx1st++){
			if(idx1st > 0 && num[idx1st] == num[idx1st - 1])
				continue;
			int target = -num[idx1st];
			int idx2nd = idx1st + 1;
			int idx3rd = num.length - 1;
			while( idx2nd < idx3rd){
				if(num[idx2nd] + num[idx3rd] == target){
					ArrayList<Integer> soln = new ArrayList<Integer>();
					soln.add(num[idx1st]); soln.add(num[idx2nd]); soln.add( num[idx3rd]);
					solns.add(soln);
					if(num[idx2nd] == num[idx3rd])
						break;
					while(idx2nd < idx3rd && num[idx2nd] == num[idx2nd+1])
						idx2nd++;
					while(idx2nd < idx3rd && num[idx3rd] == num[idx3rd-1])
						idx3rd--;
					idx2nd++;
					idx3rd--;
				}else if (num[idx2nd] + num[idx3rd] < target ){
					idx2nd++;
				}else{
					idx3rd--;
				}	        		
			}
		}
		return solns;
	}
	/**
	 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
		Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a <= b <= c <= d)
		The solution set must not contain duplicate quadruplets.
	 * @param num
	 * @param target
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		Arrays.sort(num);
		ArrayList<ArrayList<Integer>> solns = new ArrayList<ArrayList<Integer>>();
		for(int idx0 = 0; idx0 < num.length - 3; idx0++){
			if(idx0 > 0 && num[idx0] == num[idx0 - 1])
				continue;
			for(int idx1st = idx0 + 1; idx1st < num.length - 2; idx1st++){
				if(idx1st > idx0 + 1 && num[idx1st] == num[idx1st - 1])
					continue;
				int sum = target - num[idx0] -num[idx1st];
				int idx2nd = idx1st + 1;
				int idx3rd = num.length - 1;
				while( idx2nd < idx3rd){
					if(num[idx2nd] + num[idx3rd] == sum){
						ArrayList<Integer> soln = new ArrayList<Integer>();
						soln.add(num[idx0]); soln.add(num[idx1st]); soln.add(num[idx2nd]); soln.add( num[idx3rd]);
						solns.add(soln);
						if(num[idx2nd] == num[idx3rd])
							break;
						while(idx2nd < idx3rd && num[idx2nd] == num[idx2nd+1])
							idx2nd++;
						while(idx2nd < idx3rd && num[idx3rd] == num[idx3rd-1])
							idx3rd--;
						idx2nd++;
						idx3rd--;
					}else if (num[idx2nd] + num[idx3rd] < sum ){
						idx2nd++;
					}else{
						idx3rd--;
					}	        		
				}
			}
		}
		return solns;
	}

}
