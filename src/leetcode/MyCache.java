package leetcode;

import java.util.HashMap;

public class MyCache {
	MyCacheNode head, last;
	HashMap<String, MyCacheNode> cache;
	
	public MyCache(int size){
 		cache = new HashMap<String, MyCacheNode>();
		head = null;
		last = null;
	}
	
	public Object get(String key){
		if (cache.containsKey(key) == false) {
			return null;
		}else{
			MyCacheNode node = cache.get(key);
			Object result = node.value;
			if(node != last){
 				detach(node);
 				attach(node);
 			}
			return result;
		}
	}
	
	public void set(String key, Object value){
		if (cache.containsKey(key)){
			get(key);
			last.value = value;
		} else{
			MyCacheNode node = new MyCacheNode(key, value);
			attach(node);
		}
	}
	
	public void removeLRU(){
		if(head != null){
			detach(head);
		}
	}
	
	public void detach(MyCacheNode node){
		 cache.remove(node.key);
		 if(head == node){
			 head = node.next;
			 if(node.next != null)
				 node.next.prev = null;
		 }else{
			  MyCacheNode prev = node.prev;
			  MyCacheNode next = node.next;
			  prev.next = next;
			  next.prev = prev;
		 }
	}
	public void attach(MyCacheNode node){
		cache.put(node.key, node);
		if(head == null){
			head = node;
			last = node;
  		}else{
			last.next = node;
			node.prev = last;
			last = last.next;
		}
	}
	public static void main(String[] args){
		MyCache cache = new MyCache(2);
		cache.set("1", 1);
		cache.set("2", 2);
		cache.set("3", 3);
		cache.removeLRU();
		cache.set("2", 4);
		System.out.println(cache.get("2"));
		System.out.println(cache.get("1"));
		cache.set("4",4);
		cache.removeLRU();
		System.out.println(cache.get("3"));

	}
	

}
class MyCacheNode{
	String key;
	Object value;
	MyCacheNode next;
	MyCacheNode prev;
	public MyCacheNode(String key, Object value){
		this.key = key;
		this.value = value;
		this.next = null;
		this.prev = null;
	}
	
}
