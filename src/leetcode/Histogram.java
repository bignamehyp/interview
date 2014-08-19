package leetcode;

import java.util.LinkedList;

public class Histogram {

	
	public int largestRectangleArea(int[] height) {
		int [] heights = new int [height.length + 1];
		for(int i = 0; i < height.length; i++)
			heights[i] = height[i];
		heights[height.length] = 0;
		int max = 0;
		LinkedList<Integer> incBars = new LinkedList<Integer>();
		for(int i = 0; i < heights.length; i++){
			if(incBars.size() == 0 || heights[i] > heights[incBars.peekLast()]){
				incBars.add(i);
			}else{
				int h = heights[incBars.pollLast()];
				int area = h * ((incBars.size() == 0) ? i : (i - incBars.peekLast() - 1));
				if(area > max)
					max = area;
				i--;
			}
		}
		return max;
    }
	
	/**
	 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
	 * @param height
	 * @return
	 */
	public int maxArea(int [] height){
		if(height== null || height.length <= 1 ){
			return 0;
		}
		int max = 0;
		int l = 0, r = height.length - 1;
		
		while(l <= r){
			int area = Math.min(height[l], height[r] ) * (r - l);
			if(height[l] < height[r])
				l++;
			else
				r--;
			if(area > max)
				max = area;
		}
		return max;
	}

	/**
	 * The most boring case!!!
	 * There are N children standing in a line. Each child is assigned a rating value.You are giving candies to these children subjected to the following requirements: Each child must have at least one candy. Children with a higher rating get more candies than their neighbors.
	 * children with same ratings could have different ratings
	 * @param ratings
	 * @return
	 */
	public int candy(int[] ratings) {

		if(ratings == null || ratings.length == 0)
			return 0;
		if(ratings.length == 1){
			return 1;
		}
		int slope = 0;
		int val = 0;
		int peak = 0;

		for(int i = 1; i < ratings.length; i++){
			int diff = ratings[i] - ratings[i-1];

			if(diff > 0){
				slope++;
				val+= slope;
				if(i < ratings.length - 1 && ratings[i] >= ratings[i+1]){//a peak
					peak = slope;
				slope = 0;
				}
			}else if(diff < 0){
				slope--;
				if(i == ratings.length - 1 ||
						(i < ratings.length - 1 && ratings[i] <= ratings[i+1])	){//a valey
					val += -slope * (-slope + 1) /2 - Math.min(peak, -slope);
					slope = 0;
				}
			}else{
				peak = 0;
			}

		}
		return val + ratings.length;
	}

	/**
	 *Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining. 
	 * @param A [0, 1,0, 2, 1,0,1, 3, 2,1, 2,1]
	 * @return
	 * diff     [1 -1 2 -1 -1 1 2 -1 -1 1 -1]
	 */
	public int trap(int[] A) {

		if(A==null || A.length <= 1)
			return 0;

		int ans = 0;
		
		int l = 0, r = A.length - 1;
		
		int maxH = 0;
		
		while( l <= r){
			int h = Math.min(A[l], A[r]);
			if(h > maxH){
				ans += (h - maxH ) * (r - l + 1);
				maxH = h;
			}
			if(A[l] < A[r]){
				ans -= Math.min(maxH, A[l]);
				l++;
			}else{
				ans -= Math.min(maxH, A[r]);
				r--;
			}
 		}
		
		return ans;

	}
	/**
	 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
	 * 
	 * -99 100 - 1 2 -1 
	 * -99 1    0  2  1
	 * left bound of the longest positive sq
 	 */
	 public int canCompleteCircuit(int[] gas, int[] cost) {
		    int left = 0, cumSum = 0;
		    for(int i = 0; i < gas.length; i++){
		    	int diff = gas[i] - cost[i];
		    	cumSum += diff;
		    	if(cumSum < 0){
		    		left = i + 1;
		    	}
		    }
		    if( left >= gas.length)
		    	return -1;
		    return left;
		    
	    }
}
