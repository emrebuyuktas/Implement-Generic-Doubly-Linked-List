package linkedlist;

import generics.List;

public class DoublyLinkedList<Type> implements List<Type> {
	protected Node<Type>head;
	
	public DoublyLinkedList() {
		head=new Node<Type>(null, null, null);
		
	}

	@Override
	public void add(Type t) {
		    Node<Type> node;
			node=head;
			//if head is empty, next of head will point to the new node's reference,otherwise, it is added to the end of the tail.
			while(node.next!=null)
			{
				node=node.next;
			}
			Node<Type> new_node=new Node<Type>(t, null, node);
			node.next=new_node;
			
		
		
	}

	@Override
	public int add(int index, Type t) {
		Node<Type>curr=find(index);
		Node<Type>new_node=new Node<Type>(t, curr, curr.prev);
		curr.prev.next=new_node;
		curr.prev=new_node;
		return index;
	}

	@Override
	public void addAll(List<Type> list) {
		Node<Type> this_list;
		//we'll go to the last node
		this_list=find(size()-1);
		//Cast the list given as interface into the linked list.
		DoublyLinkedList<Type> new_list=(DoublyLinkedList<Type>)list;
		/*We bilaterally connect the last node of the current list with the first node of the list to be added,
		 * In this way, we combine the two lists.
		 */
		this_list.next=new_list.head.next;
		new_list.head.next.prev=this_list;
	}

	@Override
	public int addAll(int index, List<Type> list) {
		//Find the node which is in wanted index.
		Node<Type> this_list=find(index);
		//Cast the list given as interface into the linked list.
		DoublyLinkedList<Type> new_list=(DoublyLinkedList<Type>)list;
		//We must keep the last item of the list which is parameter to connect with the rest of the first list.
		Node<Type>tail_of_new_list=new_list.find(size()-1);
		this_list.prev.next=new_list.head.next;
		new_list.head.next.prev=this_list.prev;
		//We reconnect the rest of this list with the tail of the list which is given as parameter
		tail_of_new_list.next=this_list;
		this_list.prev=tail_of_new_list;
		
		return index;
	}

	@Override
	public Type get(int index) {
		Node<Type>curr=find(index);
		return curr.data;
	}
		

	@Override
	public void clear() {
		/*If we empty the reference value held by the head, we will empty the list, 
		 * the remaining elements are deleted by Garbage Collector. 
		 */
		head.next=null;
		
	}

	@Override
	public Type remove(int index) {
		Node<Type>curr=find(index);
		/*If the node to be removed is the trailing or index bigger than size of list it will remove last node,
		 * last node does not keep a next referance so we need to do a separate check*/
		if(index>=size()-1) {
			curr.prev.next=null;
			return curr.data;
		}
		curr.prev.next=curr.next;
		curr.next.prev=curr.prev;
		return curr.data;
		
	}

	@Override
	public int size() {
		int count=0;
		Node<Type>curr=head;
		//The counter increases by one for each node from the first to the last node.
		while(curr.next!=null)
		{
			count++;
			curr=curr.next;
			
		}
		return count;
	}

	@Override
	public boolean contains(Type t) {
		Node<Type>curr=head.next;
		while(curr!=null)
		{
			//we check the item starting from the first node to the last node.
			if(curr.data.equals(t)) 
			{
				return true;
			}else {
				curr=curr.next;
			}
			
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		//if next of head is empty, list is empty
		return head.next==null;
	}
	
	/**
	 * Returns the Node at the specified index
	 * @param index Index of the Node to be returned.
	 * @return Node at the specified index or node at the bottom of the list or at the beginning if index out of list.
	 */
	private Node<Type> find(int index){
		Node<Type>curr=head;
		int i=0;
		//If index is negative then we return the first node
		if(index<0) {
			return curr.next;
		}
		/*We also check if we are in the list when we try to find the directory entered using curr.next!=null.
		 * if index is bigger than list,this way we return the last node instead of getting an error*/
		while(i<=index && curr.next!=null) 
		{
			curr=curr.next;
					i++;
		}
		//if index is smaller than zero return the null.
		return curr;
	}

	/**
	 * prints the list from head to tail
	 */
	public void print() {
		String string=" ";
		Node<Type>curr=head;
		if(head.next==null)
		{
			//if list empty this will print list is empty
			System.out.println("List is empty!");
		}
		//The counter increases by one for each node from the first to the last node.
		while(curr.next!=null)
		{
			curr=curr.next;
			string+=curr.data.toString()+" ";
			
			
		}
		System.out.println(string);
		
	}

	/**
	 * prints the list from tail to head
	 */
	public void printreverse() {
		String string=" ";
		Node<Type>curr=head.next;
		//Get the last node.
		curr=find(size()-1);
		if(curr==null)
		{
			//if list empty this will print list is empty and thanks to return method will be over.
			System.out.println("List is empty!");
			return;
		}
		//starts from tail and goes to head but head is not including.
		while(curr!=head)
		{
			string+=curr.data.toString()+" ";
			curr=curr.prev;
		}
		System.out.println(string);
		
		
	}
	


}
