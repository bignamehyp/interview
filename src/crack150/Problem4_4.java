package crack150;


 
 
public class Problem4_4 {
	
	//Breath First Search
	public static <E> void printByLevels(BTreeNode<E> root){
		
		//ArrayList<Queue<BTreeNode<E>>> queues = new ArrayList<Queue<BTreeNode<E>>>();
		Queue<BTreeNode<E>> q = new Queue<BTreeNode<E>>();
		Queue<BTreeNode<E>> qAux = new Queue<BTreeNode<E>>();
		q.push(root);
		//queues.add(q);
		
		while(!q.isEmpty()){
			
			BTreeNode<E> node = q.pop();
			System.out.print(node.item + " ");
			
			if(node.leftNode != null)
				qAux.push(node.leftNode);
			if(node.rightNode != null)
				qAux.push(node.rightNode);
			
			
			if(q.isEmpty()){
				System.out.println();
				//Finish current level, move the next level;
				while(qAux.isEmpty() == false){
					q.push(qAux.pop());
				}
				//queues.add(q);
			}
		}		 	
		
	}
	
	
	public static void main(String [] args){
		double [] a = new double[15];
		for(int i = 0; i < a.length; i++){
			a[i]  = i;
		}
		
		
		
		BTreeNode<Double> root = Problem4_3.buildTreeFromSortedArray(a);
		 
		printByLevels(root);
		
	}
}
