package crack150;

import java.util.ArrayList;
import java.util.List;

public class GraphNode <E>{
	
	public boolean visited = false;
	public E item;
	public List<GraphNode<E>> adjNodes = new ArrayList<GraphNode<E>>();
	
	public GraphNode(E item){
		this.item = item;
	}
	
	public void addLink(GraphNode<E> node){
		adjNodes.add(node);
	}
	
	
}
