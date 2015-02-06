package leetcode;

public class JumpGame {
	/**
	 * 	Given an array of non-negative integers, you are initially positioned at the first index of the array. Each element in the array represents your maximum jump length at that position.
	 * Determine if you are able to reach the last index.
	 * @param A
	 * @return
	 */
	 public boolean canJump(int[] A) {
         int curPos = 0;
         int maxDist = curPos + A[curPos];
         while(curPos <= maxDist){
             if(curPos >= A.length - 1)
                return true;
             if(curPos + A[curPos] > maxDist){
                 maxDist = curPos + A[curPos];
                 if(maxDist >= A.length - 1)
                    return true;
             }
             curPos++;
         }
        return false;
    }
	 
	 
	 /**
	  * Given an array of non-negative integers, you are initially positioned at the first index of the array. Each element in the array represents your maximum jump length at that position.
Your goal is to reach the last index in the minimum number of jumps.
	  * @param A
	  * @return 
	  * dfs can not find the shortest path, only bfs can
	  * greedy algorithm
	  */
	 
	  public int jump(int[] A) {
		  if(A == null || A.length <= 1){
			  return 0;
		  }
	      int jumpFrom = 0;
	      int maxDist = jumpFrom + A[jumpFrom];
	      if(maxDist >= A.length - 1)
	            return 1;
	      int numJumps = 1;
		  int curPos = 1;
 		  
		  
		  int jumpAt = curPos;
		  
	      while(curPos <= jumpFrom + A[jumpFrom]){
	    	  
	    	  if(curPos >= A.length - 1){
	    		  return numJumps;
	    	  }
	    	  
	    	  
	    	  if(curPos + A[curPos] > maxDist){
	    		  maxDist = curPos + A[curPos];
	    		  jumpAt = curPos;
	    		  if(maxDist >= A.length - 1)
	    			  return numJumps + 1;
	    	  }
	    	  
	    	  if(curPos == jumpFrom + A[jumpFrom]){
	    		  numJumps++;
	    		  jumpFrom = jumpAt;
	    	  }
	    	  
 	    	  curPos++;
	      }
	      return -1;
	      
	    }
	  
	  	public static void main(String [] args){
	  		int [] A = new int [5];
	  		A[0] = 2;
	  		A[1] = 3;
	  		A[2] = 1;
	  		A[3] = 1;
	  		A[4] = 4;
	  		JumpGame j = new JumpGame();
	  		j.jump(A);
	  	}
	 
	 
}
