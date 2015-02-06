package crack150;

public class Problem4_7 {
	
	
	public static <E> BTreeNode<E> lowestCommonAncestor(BTreeNode<E> root, BTreeNode<E> node1,  BTreeNode<E> node2){
		
		if(!BTreeNode.contains(root, node1) || !BTreeNode.contains(root, node2)){
			return null;
		}
		
		return commonAncestor(root, node1,node2);
	}
	
	public static <E> BTreeNode<E> commonAncestor(BTreeNode<E> root, BTreeNode<E> node1,  BTreeNode<E> node2){
		if(root == null)
			return null;			 
		
		if(root.leftNode != null && !BTreeNode.contains(root.leftNode, node1) && !BTreeNode.contains(root.leftNode, node2)){
			return commonAncestor(root.leftNode, node1, node2);
		}

		if(root.rightNode != null && !BTreeNode.contains(root.rightNode, node1) && !BTreeNode.contains(root.rightNode, node2)){
			return commonAncestor(root.rightNode, node1, node2);
		}
		
		return root;
	}
	
	
}
