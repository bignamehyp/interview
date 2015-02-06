package crack150;

public class Problem4_2 {
	
	
	static <E> boolean isConnected(GraphNode<E> n1, GraphNode<E> n2){
		if(n1.equals(n2))
			return true;
		n1.visited = true;
		for(GraphNode<E> n : n1.adjNodes){
			if(!n.visited && isConnected(n,n2)){
				return true;
			}
		}
		return false;
	}
	
	
	
	public static void main(String [] argins){
		GraphNode<Integer> n1 = new GraphNode<Integer>(1);
		GraphNode<Integer> n2 = new GraphNode<Integer>(2);
		GraphNode<Integer> n3 = new GraphNode<Integer>(3);
		GraphNode<Integer> n4 = new GraphNode<Integer>(4);
		GraphNode<Integer> n5 = new GraphNode<Integer>(5);
		GraphNode<Integer> n6 = new GraphNode<Integer>(6);

		n1.addLink(n2);
		n1.addLink(n3);
		
		n2.addLink(n1);
		n2.addLink(n4);
		
		n3.addLink(n1);
		n3.addLink(n5);
		
		n4.addLink(n2);
		n5.addLink(n3);
		
		
		System.out.println(isConnected(n1,n5));
		System.out.println(isConnected(n1,n6));


	}

}
