package crack150;

public class Problem4_6 <E> extends BTreeNode<E>{
	

	Problem4_6<E> parent;
	Problem4_6<E> leftNode;
	Problem4_6<E> rightNode;
	
	public Problem4_6(E item) {
		super(item);
		// TODO Auto-generated constructor stub
	}
	
	public void setParent(Problem4_6<E> parent){
		this.parent = parent;
	}
	
	
	
	public Problem4_6<E> next(){
		
		if(this.rightNode != null){
			return leftMost(this.rightNode);
			 		
		}else{
			Problem4_6<E> current = this;
			Problem4_6<E> parent = this.parent;

			while( parent!= null && !current.equals(parent.leftNode) ){
				current = parent;
				parent = parent.parent;				
			}
			 
			return parent;
		}
	}
	
	public static <E> Problem4_6<E> leftMost(Problem4_6<E>  node){
		if(node == null)
			return null;
		
		while(node.leftNode != null){
			node = node.leftNode;
		}
		return node;
	}
	
 	
	
	 
	
	public static Problem4_6<Double> buildTreeFromSortedArray(double [] sortedArray){
		return buildTreeFromSortedArray(sortedArray, 0, sortedArray.length - 1, null);
	}
	
	static Problem4_6<Double> buildTreeFromSortedArray(double [] sortedArray, int begin, int end, Problem4_6<Double> parent){
		
		if(sortedArray == null || end < begin)
			return null;
		
		int middle = begin + (end-begin)/2;
		
		Problem4_6<Double> node = new Problem4_6<Double>(sortedArray[middle]);
		node.parent = parent;
		
		if(middle - 1 >= 0)
			node.leftNode = buildTreeFromSortedArray(sortedArray,begin,middle-1,node);
		
		if(middle + 1 <= end)
			node.rightNode = buildTreeFromSortedArray(sortedArray, middle+1, end,node);
		
		return node;
		
	}
	
	
	public static void main(String [] args){
		
		double [] a = new double[14];
		for(int i = 0; i < a.length; i++){
			a[i]  = i;
		}
		
		
		
		Problem4_6<Double> root = buildTreeFromSortedArray(a);
		Problem4_6<Double> node = leftMost(root);
		
		System.out.println(node.item);

		while(node.next() != null){
			node = node.next();
			System.out.println(node.item);

		}

 
		
	}

}
