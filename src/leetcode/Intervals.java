package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Intervals {
	/**
	 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
	 * You may assume that the intervals were initially sorted according to their start times.
	 * @param intervals
	 * @param newInterval
	 * @return
	 */
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		
		LinkedList<Interval> ans = new LinkedList<Interval>();
		
        for(Interval inv : intervals){
        	
        	if(inv.end < newInterval.start || inv.start > newInterval.end ){
        		ans.add(inv);
        		continue;
        	}
        	 
        	if(inv.start < newInterval.start ){
        		newInterval.start = inv.start;
        	}
        	
        	if(inv.end > newInterval.end ){
        		newInterval.end = inv.end;
        	}        	
         }
        
        if(ans.size() == 0)
        	ans.add(newInterval);
        
        for(int pos = 0; pos < ans.size(); pos++){
        	if(ans.get(pos).start >newInterval.start ){
        		ans.add(pos, newInterval);
        		break;
        	}
        }
        if(ans.get(ans.size() - 1).start < newInterval.start){
        	ans.add(newInterval);
        }
        
         return new ArrayList<Interval>(ans);
        		
    }

	/**
	 * Given a collection of intervals, merge all overlapping intervals.
	 * @param intervals
	 * @return
	 */
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
    	if(intervals.size() == 0)
    		return intervals;
    	
    	Collections.sort(intervals, new IntervalComparator());
    	
    	ArrayList<Interval> ans = new ArrayList<Interval>();
  	
    	Interval prev = intervals.get(0);
    	
    	for(int i = 1; i < intervals.size(); i++){
    		if(intervals.get(i).start > prev.end){//no overlapping
    			ans.add(prev);
    			prev = intervals.get(i);
    		}else{ //overlapped
    			if(intervals.get(i).end > prev.end){
    				prev.end = intervals.get(i).end; //grow the previous interval
    			}
    			if(intervals.get(i).start < prev.start){
    			    prev.start = intervals.get(i).start;
    			}
    		}    		
    	}
    	ans.add(prev);
    	
    	return ans;
    	
    }
    
    
    /**
     * Given a sorted array of integers, find the starting and ending position of a given target value.
     * @param A
     * @param target
     * @return
     */
    public int[] searchRange(int[] A, int target) {
    	    	
        int [] ans = new int[2];
        if(A.length == 0 || target < A[0] || target > A[A.length - 1]){
        	ans[0] = -1;
        	ans[1] = -1;
    		return ans;
        }
        ans[0] = -1;
        ans[1] = -1;
        
        int l = 0, r = A.length - 1;
        
        while( l <= r){
        	int mid = l + ( r - l)/2;
        	if(A[mid] < target){
        		l = mid + 1;        		
        	}else if(A[mid] > target){
        		r = mid - 1;
        	}else{//A[mid] == target        		
        		if(mid == 0 || A[mid -1] != target){
        			ans[0] = mid;
        			break;
        		}
        		r = mid - 1;
        	}       	       	
        }
        
        if(l > r)//not found
        	return ans;
        
        l = 0;
        r = A.length - 1;
        
        while( l <= r){
        	int mid = l + ( r - l)/2;
        	if(A[mid] < target){
        		l = mid + 1;        		
        	}else if(A[mid] > target){
        		r = mid - 1;
        	}else{//A[mid] == target        		
        		if(mid == A.length - 1 || A[mid  + 1] != target){
        			ans[1] = mid;
        			break;
        		}
        		l = mid + 1;
        	}       	       	
        }
          
        return ans; 
    }
 
    
}



class IntervalComparator implements Comparator<Interval>{
	@Override
	public int compare(Interval o1,Interval o2) {
		if(o1.start < o2.start)return -1;
		else if(o1.start == o2.start)return 0;
		else return 1;
	}
}



class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}
