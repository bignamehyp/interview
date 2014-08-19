package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	
    	if(node == null)return null;
    	
    	HashMap<Integer,UndirectedGraphNode> visited = new HashMap<Integer,UndirectedGraphNode>();
    	LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
    	HashSet<Integer> edgeCopied = new HashSet<Integer>();
    	//clone the nodes
    	UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
     	visited.put(node.label, clone);
    	queue.add(node);

    	
    	while(queue.size() > 0){
    		UndirectedGraphNode parent = queue.removeFirst();
    		ArrayList<UndirectedGraphNode> children = parent.neighbors;
    		for(UndirectedGraphNode child : children){
    			if(!visited.containsKey(child.label)){
    				UndirectedGraphNode childNode = new UndirectedGraphNode(child.label);
    				visited.put(child.label, childNode);
    				queue.add(child);
    			}
     		}
    	}
    	//clone the edges
    	queue.add(node);
    	for(UndirectedGraphNode neighbor : node.neighbors){
    		visited.get(node.label).neighbors.add( visited.get(neighbor.label));
    	}
    	edgeCopied.add(node.label);
    	
    	while(queue.size() > 0){
    		UndirectedGraphNode parent = queue.removeFirst();
    		ArrayList<UndirectedGraphNode> children = parent.neighbors;
    		for(UndirectedGraphNode child : children){
    			if(!edgeCopied.contains(child.label)){
    				for(UndirectedGraphNode neighbor : child.neighbors){
    		    		visited.get(child.label).neighbors.add( visited.get(neighbor.label));
    		    	}
    		    	edgeCopied.add(child.label);
    				queue.add(child);
    			}
     		}
    	}
    	
    	return clone;
    }
}


class UndirectedGraphNode {
	     int label;
	      ArrayList<UndirectedGraphNode> neighbors;
	      UndirectedGraphNode(int x) { 
	    	  label = x; 
	    	  neighbors = new ArrayList<UndirectedGraphNode>(); 
	      }
};
