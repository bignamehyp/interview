package crack150;

public class BTreeNode <E>{
	public E item;
	public BTreeNode<E> leftNode;
	public BTreeNode<E> rightNode;
	
 
	
	public BTreeNode(E item){
		this.item = item;
	}
	public BTreeNode(E item, BTreeNode<E> leftNode, BTreeNode<E> rightNode){
		this.item = item;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}
	
	
	public static <E> boolean contains(BTreeNode<E> node, BTreeNode<E> nodeToFind){
		
		if(node == null)
			return false;
		
		if(node == nodeToFind)
			return true;
		
 		
		 
		return contains(node.leftNode, nodeToFind) && contains(node.rightNode, nodeToFind);
	}
	
	
	public static <E> boolean contains(BTreeNode<E> node, E  item){
		
		if(node == null)
			return false;
		
		if(node.item.equals(item))
			return true;
		
 		
		 
		return contains(node.leftNode, item) && contains(node.rightNode, item);
	}
	 
	
	
	public static <E> void preOrderPrint(BTreeNode<E> node){
		if(node == null)
			return;
		
		if(node.item != null){
			System.out.println( node.item + " ");
		}
		
		if(node.leftNode!=null){
			inOrderPrint(node.leftNode);				
		}
		
		if(node.rightNode != null){
			inOrderPrint(node.rightNode);
		}
	}
	
	public static <E> void inOrderPrint(BTreeNode<E> node){
		if(node == null)
			return;
		
		if(node.leftNode!=null){
			inOrderPrint(node.leftNode);
		}
	
		if(node.item != null){
			System.out.println( node.item + " ");
		}
		
		if(node.rightNode != null){
			inOrderPrint(node.rightNode);
		}
	}
	
	public static <E> void postOrderPrint(BTreeNode<E> node){
		if(node == null)
			return;
		
		if(node.leftNode!=null){
			inOrderPrint(node.leftNode);
		}
		
		if(node.rightNode != null){
			inOrderPrint(node.rightNode);
		}
		
		if(node.item != null){
			System.out.println( node.item + " ");
		}
	}

}
