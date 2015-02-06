package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author huangyp
 *
 */
public class PathSum {

	/**
	 * Given a binary tree, find the maximum path sum.The path may start and end at any node in the tree.
	 * Tricky 
	 * 
	 * @param root
	 * @return
	 */
	public int maxPathSum(TreeNode root) {
		if(root == null)
			return 0;		 

		if(root.left == null && root.right == null){
			return root.val;
		}

		if(root.left == null){
			if(root.val > 0)
				return root.val + maxPathSum(root.right);
			else
				return maxPathSum(root.right);
		}
		if(root.right == null){
			if(root.val > 0)
				return root.val +  maxPathSum(root.left);
			else
				return maxPathSum(root.left);
		}
		int leftSum = 	 maxPathSum(root.left), rightSum = maxPathSum(root.right);
		return Math.max(root.val + leftSum + rightSum, Math.max(leftSum, rightSum)  );
	}

	/**Triangle tricky
	 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
	 * DP approach
	 * @param triangle
	 * @return
	 */
public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        
        if(triangle == null || triangle.size() == 0)
            return 0;
            
        int [] dp = new int [triangle.size()];
        
        for(int level = triangle.size() - 1; level >= 0; level --){
            for(int i = 0; i < level + 1; i++){
                if(level == triangle.size() - 1){
                    dp[i] = triangle.get(level).get(i);
                }else{
                    dp[i] = triangle.get(level).get(i) + Math.min(dp[i],  dp[i+1] );
                }
                
            }
        }
        
        return dp[0];
        
    }

	/**
	 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
	 * @param grid
	 * @return
	 */
	public int minPathSum(int[][] grid) {
		if(grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;
		int N_X = grid.length;
		int N_Y = grid[0].length;
		int [][] dist = new int [N_X][N_Y];
		dist[0][0] = grid[0][0];
		for(int x = 1; x < N_X; x++){
			dist[x][0] = dist[x-1][0] + grid[x][0];	        	
		}

		for(int y = 1; y < N_Y; y++){
			dist[0][y] = dist[0][y - 1] + grid[0][y];
		}

		for(int x = 1; x < N_X; x++){
			for(int y = 1; y < N_Y; y++){
				dist[x][y] = Math.min(dist[x-1][y], dist[x][y-1]) + grid[x][y];
			}
		}

		return dist[N_X - 1][N_Y - 1];
	}


	/**
	 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
	 * @param root
	 * @param sum
	 * @return
	 */
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root == null){
			return false;
		}

		if(root.left == null && root.right == null && root.val == sum)
			return true;

		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum -root.val);

	}

	/**
	 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
	 * @param root
	 * @param sum
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		if(root == null)
			return ans;
		findPathSum(new LinkedList<Integer>(), sum, root, ans);
		return ans;
	}
	void findPathSum(LinkedList<Integer> path, int sum, TreeNode root, ArrayList<ArrayList<Integer>> ans){
		if(root == null)
			return;

		path.add(root.val);

		if(root.left == null && root.right == null){
			if(root.val == sum){
				ans.add(new ArrayList<Integer>(path));
			}
			path.removeLast();
			return;
		}

		if(root.left != null){
			findPathSum(path, sum- root.val, root.left, ans);			  
		}
		if(root.right != null){
			findPathSum(path, sum- root.val, root.right, ans);			  
		}
		path.removeLast();

	}
	/** Sum Root to Leaf Numbers 
	 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number
	 * @param root
	 * @return
	 */
	int sum = 0;
	public int sumNumbers(TreeNode root) {
		getSumToLeafNumber(root, 0);
		return sum;
	}


	void getSumToLeafNumber(TreeNode root, int parSum){
		if(root == null)
			return;

		if(root.left == null && root.right == null){
			sum +=  parSum * 10 + root.val;
		}

		if(root.left != null){
			getSumToLeafNumber(root.left, parSum * 10 + root.val);
		}

		if(root.right != null){
			getSumToLeafNumber(root.right, parSum * 10 + root.val);
		}

	}

	
	//How many possible unique paths are there?
	 public int uniquePaths(int m, int n) {
	        //use equations C(m+n-2, m-1)
		 int small = n - 1;
		 if( n > m){
			 small = m - 1;
 		 }
		 int ans = 1;
		 
		 for(int i = 1; i <= small; i++){
			 ans = (int)(1.0 * ans * (m + n - 2 - i + 1) / i+ 0.5);
		 }
		 
		 return ans;
	 }
	
	 /**
	  * Now consider if some obstacles are added to the grids. How many unique paths would there be?
	  * @param obstacleGrid
	  * @return
	  */
	 public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		 if(obstacleGrid == null || obstacleGrid.length ==0 || obstacleGrid[0].length == 0)
			 return 0;
		 if(obstacleGrid[0][0] == 1)
	    	 return 0;
		 
		 int rows = obstacleGrid.length;
	     int cols = obstacleGrid[0].length;
	     
	     int [][] dp = new int [rows][cols];
	     
	     
	     dp[0][0] = 1;
	     for(int i = 1; i < rows; i++){
	    	 if(obstacleGrid[i][0] == 1)
	    		 dp[i][0] = 0;
	    	 else
	    		 dp[i][0] = dp[i-1][0];
	     }
	     for(int j = 1; j < cols; j++){
	    	 if(obstacleGrid[0][j] == 1)
	    		 dp[0][j] = 0;
	    	 else
	    		 dp[0][j] = dp[0][j-1];
	     }
	     
	     
	     for(int i = 1; i < rows; i++){
		     for(int j = 1; j < cols; j++){
		    	 if(obstacleGrid[i][j] == 1)
		    		 dp[i][j] = 0;
		    	 else{
		    		 dp[i][j] = dp[i - 1][j] + dp[i][j-1];
		    	 }
		     }
	     }
	     
	     return dp[rows-1][cols-1];
	     
	 }
	 
	
	
	
	
	
	
	public static void main(String[] args){
		PathSum p = new PathSum();

		TreeNode n = new TreeNode(0);
		n.left = new TreeNode(1);
		System.out.println(p.sumNumbers(n));
	}

}
