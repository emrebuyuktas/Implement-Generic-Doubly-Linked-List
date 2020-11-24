package linkedlist;

public class Node<Type> {
	protected Type data;
	protected Node<Type> next;
	protected Node<Type> prev;
	
	public Node(Type data, Node<Type> next, Node<Type> prev) {
		
		this.data = data;
		this.next = next;
		this.prev = prev;
	}

	public Type getData() {
		return data;
	}

	public Node<Type> getNext() {
		return next;
	}

	public Node<Type> getPrev() {
		return prev;
	}
	
	
	
}
