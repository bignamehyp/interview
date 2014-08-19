package crack150;

public class Problem4_3 {
	public static BTreeNode<Double> buildTreeFromSortedArray(double [] sortedArray){
		return buildTreeFromSortedArray(sortedArray, 0, sortedArray.length - 1);
	}
	
	static BTreeNode<Double> buildTreeFromSortedArray(double [] sortedArray, int begin, int end){
		
		if(sortedArray == null || end < begin)
			return null;
		
		int middle = begin + (end-begin)/2;
		
		BTreeNode<Double> node = new BTreeNode<Double>(sortedArray[middle]);
		
		if(middle - 1 >= 0)
			node.leftNode = buildTreeFromSortedArray(sortedArray,begin,middle-1);
		
		if(middle + 1 <= end)
			node.rightNode = buildTreeFromSortedArray(sortedArray, middle+1, end);
		
		return node;
		
	}
	
	
	public static void main(String [] args){
		double [] a = new double[14];
		for(int i = 0; i < a.length; i++){
			a[i]  = i * 0.1;
		}
		
		
		
		BTreeNode<Double> root = buildTreeFromSortedArray(a);
		 
		
		
		BTreeNode.inOrderPrint(root);
		System.out.println();

		System.out.println(Problem4_1.isBalanced(root));
		
	}
}
