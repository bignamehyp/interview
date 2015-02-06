package crack150;

public class Problem4_5 {
	
	public static boolean isBST(BTreeNode<Double> node){
		return isInRange(node, -Double.MAX_VALUE, Double.MAX_VALUE);
	}
	
	static boolean isInRange(BTreeNode<Double> node, double min, double max){
		
		if(node == null)
			return true;
					
		if(node.item >= min && node.item <= max){
			
			return isInRange(node.leftNode, min, node.item) && isInRange(node.rightNode,node.item,max);
			
		} 
		System.out.println(min + " " + node.item + " " + max);
		return false;
	
	}
	
	public static void main(String [] args){
		double [] a = new double[15];
		for(int i = 0; i < a.length; i++){
			a[i]  = i;
		}
		
		
		
		BTreeNode<Double> root = Problem4_3.buildTreeFromSortedArray(a);
		 
		System.out.println(isBST(root));
		
	}
	
	
}
