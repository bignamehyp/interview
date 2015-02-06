package crack150;

import java.util.ArrayList;

public class Problem4_9 {
	public static void pathToSum(BTreeNode<Double> node, double sum){
		pathToSum(node, sum, null);
	}
	
	
	static void pathToSum(BTreeNode<Double> node, double sum,   ArrayList<Double> parts){
		
		if(node == null)
			return;
		
		if(parts == null)
			parts = new ArrayList<Double>();

		System.out.println("Visit Node " + node.item);
		
		 
		 
		
		
 		parts.add(node.item);
 		
 		double partialSum = 0.0;
 		for(int i = parts.size() - 1; i >=0; i--){
 			partialSum += parts.get(i);
 			if( partialSum == sum ){
 				for(int j = parts.size() - 1; j > i; j--){
 					System.out.print(parts.get(j) + " + ");
 				}
 				System.out.println(parts.get(i) + " = " + sum);
 			}
 		}
		
		if(node.leftNode != null){
			pathToSum(node.leftNode, sum,   parts);

 		}
		
		
		if(node.rightNode != null){
			pathToSum(node.rightNode, sum,  parts);

 		}
		
		parts.remove(parts.size() - 1);


		
	}
	
	
	public static void main(String [] args){
		double [] a = new double[10];
		for(int i = 0; i < a.length; i++){
			a[i]  = i + 1;
		}
		
		
		
		BTreeNode<Double> root = Problem4_3.buildTreeFromSortedArray(a);
		Problem4_4.printByLevels(root);
		
		pathToSum(root, 10.0);
	}
	
	
}
