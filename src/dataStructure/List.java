package dataStructure;

public interface List<E> extends Iterable<E>{
	
	public int length();
	
	public boolean isEmpty();
	/**
	 * Return the item in the idx-position of the list, idx = 0, .... length() - 1
	 * @param idx
	 * @return
	 */
	public E at(int idx);
	/**
	 * Find the index of the list corresponding the item x, if x is not found, return the length() of the list 
	 * @param x
	 * @return
	 */
 	public int find(E x);
 	/**
 	 * Insert an item at the beginning of a List
 	 * @param Item x
 	 */
 	public void push(E x);
 	/**
 	 * Add an item after the position at idx - 1
 	 * @param idx: the index of x in the list after insertion
 	 * @param x: Item to be inserted;
 	 */
 	public void AddAt(int idx, E x);
 	public E remove(int idx);
 	public void set(int idx, E x);
 	public boolean contains(E x);
 	public void append(E x);
}
