package leetcode;

public class BuildBinaryTree {
	
	/**
	 * Given preorder and inorder traversal of a tree, construct the binary tree. Note: You may assume that duplicates do not exist in the tree.
	 * @param preorder
	 * @param inorder
	 * @return
	 */
	 public TreeNode buildTree(int[] preorder, int[] inorder){
	        return buildTreeFromPreIn(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	   }
	 
	 TreeNode buildTreeFromPreIn(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
		 if(preStart > preEnd || inStart > inEnd)
			 return null;
		  
		 TreeNode node = new TreeNode(preorder[preStart]);
		 int idx = inStart;
		 for(; idx <= inEnd; idx++){
			 if(inorder[idx] == preorder[preStart]){
				 break;
			 }
		 }
		 
		 if(idx > inStart){
			 node.left  = buildTreeFromPreIn(preorder, preStart +  1, preStart + (idx - inStart), inorder, inStart, idx - 1);
		 }
		 
		 if(idx < inEnd){
			 node.right = buildTreeFromPreIn(preorder, preStart + idx - inStart + 1, preEnd, inorder, idx + 1, inEnd);
		 }
		 return node;
	 }
	 
	 TreeNode buildTreeFromInPost(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
		 if(postStart > postEnd || inStart > inEnd)
			 return null;
	 
		 TreeNode node = new TreeNode(postorder[postEnd]);
		 int idx = inStart;
		 for(; idx <= inEnd; idx++){
			 if(inorder[idx] == postorder[postEnd]){
				 break;
			 }
		 }
		 
		 if(idx > inStart){
			 node.left  = buildTreeFromInPost(inorder, inStart, idx - 1, postorder, postStart, postStart + idx - inStart - 1);
		 }
		 
		 if(idx < inEnd){
			 node.right = buildTreeFromInPost(inorder, idx + 1, inEnd, postorder, postStart + idx - inStart, postEnd - 1);
		 }
		 
		 return node;
	 }
}
