/**
 * Class that implements a LinkedList data structure.
 * 
 * @author Precious Jatau
 * @version 2019-02-09
 */

/*TODO
 * 1. Unit test LinkedList class
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

		/**
		 Getters and setters for node class
		 */
		public E getData() {
			return data;
		}

		public void setData(E data) {
			this.data = data;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}	

	}
	// end of Node class

	// head points to first element in list 
	private Node<E> head;

	// tail points to last element in list
	private Node<E> tail;

	// currentSize stores current size of LinkedList
	// allows O(1) time access to LinkedList size
	private int currentSize;

	/**
	 * Default constructor for LinkedList
	 */
	public LinkedList() 
	{
		head = null;
		tail = null;
		currentSize = 0;
	}

	/**
	 * Getter and setters for LinkedList class
	 */
	public Node<E> getHead() {
		return head;
	}

	public void setHead(Node<E> head) {
		this.head = head;
	}

	public Node<E> getTail() {
		return tail;
	}

	public void setTail(Node<E> tail) {
		this.tail = tail;
	}

	public int getCurrentSize() {
		return currentSize;
	}

	public void setCurrentSize(int currentSize) {
		this.currentSize = currentSize;
	}


	/**
	 * Adds node to the beginning of LinkedList. Insertion is O(1) time.
	 * @param obj: new item to be inserted at beginning of list.
	 */
	public void addFirst(E obj) 
	{
		// create new node
		Node<E> node = new Node<E>(obj);

		// Check for empty list.
		if (head == null) 
		{
			head = tail = node;
			++currentSize;
			return;
		}


		// insert node at head
		node.next = head;
		head = node;
		++currentSize;
	}


	/**
	 * Adds node to the end of LinkedList. Insertion is O(1) time.
	 * @param obj: new item to be added at the end of list
	 */
	public void addLast(E obj) 
	{
		// create new node
		Node<E> node = new Node<E>(obj);

		// Check for empty list.
		if (head == null) 
		{
			head = tail = node;
			++currentSize;
			return;
		}
		
		tail.next = node;
		tail = node;
		++currentSize;

	}


	/**
	 * Adds node to the end of LinkedList. Insertion is O(n) time.
	 * @param obj: new item to be added at the end of list
	 */
	public void addLastSlow(E obj) 
	{	
		// create new node
		Node<E> node = new Node<E>(obj);
		// point tail to new node
		tail = node;

		// Check for empty list.
		if (head == null) 
		{
			head = node;
			++currentSize;
			return;
		}

		// find last node
		Node<E> temp = head;
		while(temp.next != null)
			temp = temp.next;

		// insert new node at the end
		temp.next = node;
		++currentSize;
		temp = null;
	}
	
	/**
	 * Removes first element of LinkedList and returns its data. Works in O(1) time.
	 */
	public E removeFirst() 
	{
		// Empty list
		if (head == null)
			return null;
		
		// Single element list
		E temp = head.data;
		if (head == tail) 
		{
			head = tail = null;
		}
		else // More than 2 elements 
		{
			head = head.next;			
		}
		--currentSize;
		return temp;
	}
	
	/**
	 * Removes last element of LinkedList and returns its data. Works in O(n) time.
	 */
	public E removeLast() 
	{
		// empty list
		if (head == null)
			return null;
		
		// single element
		if (head == tail)
			return removeFirst();
		
		// more than 2 elements
		Node<E> curr = head;
		Node<E> prev = null;
		while(curr != tail) 
		{
			prev = curr;
			curr = curr.next;
		}
		
		prev.next = null;
		tail = prev;
		--currentSize;
		return curr.data;		
	}
	
	/**
	 * Removes node in LinkedList with thesame data as obj. Worst case is O(n)
	 * @param obj to be used as search key
	 */
	public E remove(E obj) 
	{
		Node<E> curr = head;
		Node<E> prev = null;
				
		while (curr != null) 
		{
			if (((Comparable<E>)obj).compareTo(curr.data) == 0) 
			{	
				// obj found at beginning
				if (curr == head)	
					return removeFirst();
				
				// obj found at end
				if (curr == tail)
					return removeLast();
				
				// obj found in the middle
				prev.next = curr.next;
				--currentSize;
				return curr.data;	
			}
			
			prev = curr;
			curr = curr.next;
		}
		
		return null;
	}
	
	/**
	 * Checks if obj is contained in Linked List. Worst case is O(n)
	 * @param obj to be used as search key
	 *  
	 */
	public boolean contains(E obj) 
	{
		Node<E> curr = head;
				
		while (curr != null) 
		{
			if (((Comparable<E>)obj).compareTo(curr.data) == 0) 
			{	
				return true;
			}
			
			curr = curr.next;
		}

		return false;
	}


	// FIXME modify my toString method
	public String toString() 
	{
		String outString = "";
		Node node = head;

		while (node != null) 
		{
			outString = outString + "==> " + node.data + "\n";
			node = node.next;			
		}
		outString += "size: " + currentSize + "\nhead: " + head.data + "\ntail: " + tail.data;

		return outString;
	}


		
	public static void main(String[] args) 
	{
		LinkedList<Integer> ll = new LinkedList<Integer>();

		for (int i = 0; i < 7; ++i) 
		{
			ll.addLast(i);
		}

		System.out.println(ll.toString());
		
		Integer rm = ll.removeFirst();
		System.out.println();
		System.out.println("Removing first element.");
		System.out.println(ll.toString());
		
		Integer rml = ll.removeLast();
		System.out.println();
		System.out.println("Removing last element.");
		System.out.println(ll.toString());
				
		
	}
}
