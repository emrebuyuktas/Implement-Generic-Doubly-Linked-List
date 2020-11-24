import generics.List;
import linkedlist.DoublyLinkedList;
/**
 * 
 * @author Emre Büyüktaş
 *
 */

public class Test {

	public static void main(String[] args) {
		//kodların doğru çalıştığını göstermek için DoublyLinkedList içine print ve printreverse adlı iki fonksiyon yazdım.
		DoublyLinkedList<Integer> list=new DoublyLinkedList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		System.out.println("List:");
		list.print();
		List<Integer> list_two=new DoublyLinkedList<>();
		list_two.add(11);
		list_two.add(12);
		list_two.add(13);
		list_two.add(14);
		list.addAll(list_two);
		System.out.println("List after adding a new list:");
		list.print();
		System.out.println("View of the list in reverse:");
		list.printreverse();
		System.out.println("Size of list:" +list.size());
		System.out.println("Data in index 3:");
		int a=list.get(3);//return data of node which is in 3th index
		System.out.println(a);
		System.out.println("If the desired index is larger than the size of the list:");
		System.out.println(list.get(20));//this print data of last node
		System.out.println("If the desired index is smaller than zero:");
		System.out.println(list.get(-1));//this print data of first node
		
		System.out.println("Before adding a new list in specific index");
		list.print();
		List<Integer> list_three=new DoublyLinkedList<>();
		list_three.add(100);
		list_three.add(200);
		list_three.add(300);
		list.addAll(4, list_three);
		System.out.println("After adding a new list in specific index");
		list.print();
		System.out.println("Reverse of list after adding a new list in specific index");
		list.printreverse();
		System.out.println("Is list empty? " + list.isEmpty());
		System.out.println("Is 200 contains in the list? " + list.contains(20) );
		System.out.println("Is -20 contains in the list? " + list.contains(-20) );//-20 is not in the list
		System.out.println("Before removing node which is in the 4. index: "  + list.get(4));
		list.remove(4);
		System.out.println("After removing node which is in the 4. index: "  + list.get(4));
		list.clear();
		System.out.println("After clear the list:");
		list.print();//this will print list is empty
		list.printreverse();//this will print list is empty
		
	}

}
