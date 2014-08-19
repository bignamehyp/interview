package crack150;

public class Problem4_1 {
	
	
	static <E> boolean isBalanced(BTreeNode<E> root){
		
		int height = getHeight(root);
		
		return height >= 0;
		
	}
	
	
	static <E> int getHeight(BTreeNode <E> node){
		if(node == null)
			return 0;
		else{				
			int leftHeight =  getHeight(node.leftNode);
			int rightHeight =  getHeight(node.rightNode);
			
			if(leftHeight < 0 || rightHeight < 0 || Math.abs(leftHeight - rightHeight) > 1 ){
				return -1;
			}
			 
			
			return 1 + Math.max(leftHeight, rightHeight);
				
		}
	}
	
	
	public static void main(String [] args){
		BTreeNode<Integer> root = new BTreeNode<Integer>(5);
		root.leftNode = new BTreeNode<Integer>(3);		
		root.rightNode = new BTreeNode<Integer>(6);
		root.rightNode.leftNode = new  BTreeNode<Integer>(5);
		
		System.out.println(isBalanced(root));

		root.leftNode.leftNode = new BTreeNode<Integer>(2);
		root.leftNode.leftNode.leftNode = new BTreeNode<Integer>(1);
		
		System.out.println(isBalanced(root));
		
	}
}
