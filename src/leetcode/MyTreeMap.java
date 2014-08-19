package leetcode;

import java.util.ArrayList;
import java.util.Iterator;

public class MyTreeMap<E extends Comparable<E>,V> implements Iterable<E> {
 	MyTreeNode<E,V> root;
 	
	int size;
	public MyTreeMap(){
		root = null;
		size = 0;
 	}
	
	public ArrayList<E> inorderKeys(){
		ArrayList<E> solns = new ArrayList<E>();
		if(root == null)
			return solns;
		else{
			root.inorderKeys(solns);
		}
		return solns;
	}
	
	public void put(E key,V value){
		if ( key == null )
			throw new IllegalArgumentException();
		
		if(root == null){
			root = new MyTreeNode<E,V>(key, value);
			size++;
		}else{
			if (root.put(key, value)){
				size++;
			}
		}
	}
	
	public V get(E key){
		
		if (key == null){
			throw new IllegalArgumentException();
		}
		
		if(root == null){
			return null;
		}else
			return root.get(key);
	}
	
	public int getSize(){
		return this.size;
	}
	public static void main(String[] args){
		MyTreeMap<Integer, String> map = new MyTreeMap<Integer,String>();
		map.put(2, "2");
		map.put(1, "1");
		map.put(4, "4");
		map.put(4, "7");

		System.out.println(map.get(1));
		System.out.println(map.get(2));
		map.put(1, "3");
		System.out.println(map.get(1));
		System.out.println("size = " + map.getSize());
		map.put(2, "6");
		map.put(-1, "-1");

		for (int key : map){
			System.out.println(key + " " + map.get(key));
		}
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new MyIterator();
	}
	
	class MyIterator implements Iterator<E>{
	 	ArrayList<E> list;
	 	int pos = 0;
	 	public MyIterator(){
	 		list = inorderKeys();
	 		pos = 0;
	 	}
	 	
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub			
			return pos < list.size();
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			if (hasNext() == false)
				return null;
			else{
				E key = list.get(pos);
				pos++;
				return key;
			}
			
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}




class MyTreeNode <E extends Comparable<E>, V>{
	E key;
	V value;
	MyTreeNode<E,V> left,right;
	
	public MyTreeNode(E k, V v){
		this.key = k;
		this.value = v;
		left = null;
		right = null;
	}
	

	
	/**
	 * 
	 * @param key
	 * @param value
	 * @return 
	 */
	public boolean put(E key, V value){
		if (this.key.compareTo(key) == 0){
			this.value = value;
			return false;
		}else if (this.key.compareTo(key) > 0){
			if (left == null){
				left = new MyTreeNode<E, V>(key, value);
				return true;
			}else{
				return left.put(key, value);
			}			
		}else{
			if(right == null){
				right = new MyTreeNode<E,V>(key, value);		
				return true;
			}else{
				return right.put(key, value);
			}
		}
	}
	
	public V get(E key){
		if (this.key.compareTo(key) == 0){
			return this.value;
		}else if(this.key.compareTo(key) > 0){
			if (left != null){
				return left.get(key);
			}else{
				return null;
			}
		}else{
			if(right != null){
				return right.get(key);
			}else{
				return null;
			}			
			
		}
	}
	public void inorderKeys(ArrayList<E> solns){
		if(left != null){
			left.inorderKeys(solns);
		}
		solns.add(key);
		if(right != null){
			right.inorderKeys(solns);
		}
	}
	
	
	
	
	
}
