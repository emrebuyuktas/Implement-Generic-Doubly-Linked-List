package generics;

public interface List<Type> {
	/**
	 * Adds item <code>t</code> to the end of the list.
	 * @param t Item to be added.
	 */
	void add(Type t);
	
	/**
	 * Adds item <code>t</code> to the list at the specified position.
	 * All items at index >= <code>index</code> will be shifted rightwards. 
	 * @param index Index where item will be added.
	 * @param t Item to be added.
	 */
	int add(int index, Type t);
	
	/**
	 * Adds all items in <code>list</code> to the end of <code>this</code> in order. 
	 * @param list List to be merged with <code>this</code>.
	 */
	void addAll(List<Type> list);
	
	/**
	 * Adds all items in <code>list</code> to <code>this</code> in order.
	 * @param index Starting index for adding the items <code>list</code>
	 * @param list List to be merged with <code>this</code>.
	 */
	int addAll(int index, List<Type> list);
	
	/**
	 * Returns the item at the specified index.
	 * @param index Index of the item to be returned.
	 * @return Item at the specified index or null if index invalid.
	 */
	Type get(int index);
	
	/**
	 * Clears the list to become empty.
	 */
	void clear();
	
	Type remove(int index);
	int size();
	boolean contains(Type t);
	boolean isEmpty();

}
