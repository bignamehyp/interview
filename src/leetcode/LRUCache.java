package leetcode;

import java.util.HashMap;

public class LRUCache {
    HashMap<Integer, CacheNode> cache;
    int capacity;
    CacheNode head, last;
     
    public LRUCache(int capacity) {
        cache = new HashMap<Integer, CacheNode>();
        this.capacity = capacity;
     }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            CacheNode node = cache.get(key);
            int value = node.val;
            if(node!=last){
                remove(node);
                attach(new CacheNode(key, value));
            }
            return value;
        }else{
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if(cache.containsKey(key)){
            get(key);
            last.val = value;
         }else{
            CacheNode node = new CacheNode(key, value);
            attach(node);
        }
        
        if(cache.size() > capacity){
            remove(head);
        }
    }
    
    
    void remove(CacheNode node){
         if(node == head){
             cache.remove(head.key);
             head = head.next;
             return;
         }
         if(node.next != null){
             cache.remove(node.key);
             CacheNode next = node.next;
             node.key = next.key;
             node.val = next.val;
             node.next = next.next;
             if(next == last){
                 last = node;
             }
             cache.put(node.key, node);
         }             
    }
    
    void attach(CacheNode node){
        if(head == null){
            head = node;
            last = node;
        }else{
            last.next = node;
            last = last.next;
        }
        cache.put(node.key, node);
    }
    
 }

class CacheNode{
    int key;
    int val;
    CacheNode next;
    public CacheNode(int key, int val){
        this.key = key;
        this.val = val;
        next = null;
    }
}
