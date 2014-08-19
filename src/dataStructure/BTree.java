package dataStructure;

public class BTree<E>{
	protected E item;
	protected BTree<E> left;
	protected BTree<E> right;
	public BTree(E x){
		this(x, null, null);
	}
	public BTree(E x, BTree<E> l, BTree<E> r){
		item = x;
		left = l;
		right = r;		
	}
	
	public void traverse(BTree<E> b){
		
	}
	
}
