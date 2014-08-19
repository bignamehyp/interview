package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTree {


	/**
	 * Two elements of a binary search tree (BST) are swapped by mistake.
	 * tricky
	 * @param root
	 */	
	TreeNode prev = null, first = null, second = null;
	public void recoverTree(TreeNode root) {
		inOrder(root);
		int tmp = first.val;
		first.val = second.val;
		second.val = tmp;
	}
	void inOrder(TreeNode node){
		if(node == null)
			return;
		inOrder(node.left);
		if(prev != null){
			if(prev.val > node.val){ // incorrect
				if(first == null){
					first = prev;
				}
				second = node;
			}
		}		  	
		prev = node;
		inOrder(node.right);

	}




	/**
	 * No duplications are allowed
	 * @param root
	 * @return
	 */
	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}


	boolean isValidBST(TreeNode root, int min, int max){
		if(root == null)
			return true;
		if(root.val > max || root.val < min)
			return false;
		return isValidBST(root.left, min, root.val - 1) && isValidBST(root.right, root.val + 1, max);
	}

	public boolean isSymmetric(TreeNode root) {
		TreeNode copy = mirrorTree(root);
		return isSameTree(root, copy);
	}

	public TreeNode mirrorTree(TreeNode root){
		if (root == null)return null;
		TreeNode copy = new TreeNode(root.val);
		copy.left = mirrorTree(root.right);
		copy.right = mirrorTree(root.left);
		return copy;
	}

	public boolean isSameTree(TreeNode root, TreeNode copy){
		if(root == null && copy == null)return true;

		if(root == null || copy == null)return false;


		return (root.val == copy.val) && isSameTree(root.left, copy.left) && isSameTree(root.right, copy.right);

	}

	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> ans = new ArrayList<Integer>(); 
		postorderTraversal(ans, root);
		return ans;
	}
	void postorderTraversal(ArrayList<Integer> ans, TreeNode node){
		if(node == null){
			return;
		}
		postorderTraversal(ans, node.left);
		postorderTraversal(ans, node.right);
		ans.add(node.val);

	}

	public void flatten(TreeNode root) {
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

		TreeNode node = root;
		while(node != null){

			if(node.left != null && node.right != null){
				stack.add(node.right);
				node.right = node.left;
				node.left = null;
			}else if(node.right == null && node.left != null){
				node.right = node.left;
				node.left = null;
			}else if (node.right == null && node.left == null ){
				if(stack.size() == 0)
					break;
				node.right = stack.pollLast();
			}

			node = node.right;
		}

	}
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> ans = new  ArrayList<ArrayList<Integer>> ();
		if(root == null)
			return ans;

		boolean l2r = true;
		ArrayList<Integer> level = new ArrayList<Integer>();
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		queue.add(null);

		while(true){ 			 
			if(queue.size() == 0)
				break;
			TreeNode node = queue.removeFirst();
			if(node != null){
				level.add(node.val);
				if(node.left!=null)queue.add(node.left);
				if(node.right != null)queue.add(node.right);
			}else{
				//finish one level;
				if(l2r){
					ans.add(level);
				}else{
					ArrayList<Integer> tmp = new ArrayList<Integer>();

					for(int i = level.size() - 1; i >=0; i--){
						tmp.add(level.get(i));
					}
					ans.add(tmp);
				}
				level = new ArrayList<Integer>();
				l2r = !l2r;
				if(queue.size() == 0)
					break;
				queue.add(null);
			}
		}
		return ans;
	}

	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		LinkedList<ArrayList<Integer>> ans = new  LinkedList<ArrayList<Integer>> ();
		if(root == null)
			return new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> level = new ArrayList<Integer>();
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		queue.add(null);
		while(true){
			if(queue.size()==0)
				break;
			TreeNode node = queue.removeFirst();
			if(node != null){
				level.add(node.val);
				if(node.left!=null)queue.add(node.left);
				if(node.right!=null)queue.add(node.right);
			}else{
				ans.addFirst(level);
				level = new ArrayList<Integer>();
				if(queue.size()==0)
					break;
				queue.add(null);
			}
		}
		return new ArrayList<ArrayList<Integer>>(ans);
	}

	/**
	 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
	 * @param n
	 * @return
	 */
	public int numTrees(int n) {
		int [] dp = new int [n + 1];
		if( n < 2)
			return 1;

		dp[0] = 1;
		dp[1] = 1;
		for(int i = 2; i <= n; i++){
			dp[i] = 0;
			for(int top = 1; top <= i; top++){
				dp[i] += dp[i - top] * dp[top - 1];
			}
		}
		return dp[n];
	}

	/**
	 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
	 * @param n
	 * @return
	 */
	public ArrayList<TreeNode> generateTrees(int n) {
		return generateTrees( 1, n);
	}

	ArrayList<TreeNode> generateTrees(int m, int n){
		ArrayList<TreeNode> ans = new ArrayList<TreeNode>();
		if( m > n){
			ans.add(null);
			return ans;
		}
		if(m == n){
			ans.add(new TreeNode(m));
			return ans;
		}

		for(int i = m; i <= n; i++){
			ArrayList<TreeNode> lefts = generateTrees(m, i-1);
			ArrayList<TreeNode> rights = generateTrees(i+1, n);
			for(TreeNode left : lefts){
				for(TreeNode right: rights){
					TreeNode node = new TreeNode(i);
					node.left = left;
					node.right = right;
					ans.add(node);
				}
			}
		}
		return ans;
	}

	/**
	 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
	 * @param root
	 */

	public void connect(TreeLinkNode root) {
        while(root!=null){
            TreeLinkNode firstChild = null, prev = null;
            while(root!=null){
                if(firstChild == null){
                    if(root.left!=null)
                        firstChild = root.left;
                    else
                        firstChild = root.right;
                }
                
                if(root.left!=null){
                    if(prev!=null)
                        prev.next = root.left;
                    prev = root.left;
                }
                
                if(root.right!=null){
                    if(prev != null)
                        prev.next = root.right;
                    prev = root.right;
                }
                root = root.next;
            }
            root = firstChild;
        }
    }
}


class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;
	TreeLinkNode(int x) { val = x; }
}
