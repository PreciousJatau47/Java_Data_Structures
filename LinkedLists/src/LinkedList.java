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
		outString += "size: " + currentSize + "\n";

		return outString;
	}


	public static void main(String[] args) 
	{
		LinkedList<Integer> ll = new LinkedList<Integer>();

		for (int i = 0; i < 5; ++i) 
		{
			ll.addLast(i);
		}

		System.out.print(ll.toString());
		System.out.println("head " + ll.getHead().getData());
		System.out.println("tail " + ll.getTail().getData());
	}
}
