/**
 * Class that implements a LinkedList data structure.
 * 
 * @author Precious Jatau
 * @version 2019-02-09
 */
public class LinkedList<E>{
	
	// Node class for linked list elements
		class Node<E>
		{
			// data for current node.
			E data;
			
			// pointer to the next node.
			Node<E> next;
			
			/**Non default constructor for node object
			 * @param obj: input data for new node
			 * */
			public Node(E obj)
			{
				data = obj;
				next = null;		
			}	
		}
		// end of Node class
	
	// head points to first element in list 
	private Node<E> head;
	
	// currentSize stores current size of LinkedList
	// allows O(1) time access to LinkedList size
	private int currentSize;
	
	/**
	 * Default constructor for LinkedList
	 */
	public LinkedList() 
	{
		head = null;
		currentSize = 0;
	}
	
	/**
	 * Adds node to the beginning of LinkedList. Operate in O(1) time.
	 * @param obj: new item to be inserted LinkedList.
	 */
	public void addFirst(E obj) 
	{
		// create new node
		Node<E> node = new Node<E>(obj);
		
		// insert node at head
		node.next = head;
		head = node;
		++currentSize;
	}



}
