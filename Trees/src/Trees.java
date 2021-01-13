import java.util.LinkedList;

/**
 * Class for binary trees
 * @author Precious Jatau
 * @version 2020-05-06
 * 
 * */

/* TODO
 * 1. Node class (completed)
 * 2. add (completed)
 * 3. BFS(in progress)
 * 4. contains (in progress)
 * 5. remove
 * 6. leftRotate
 * 7. rightRotate
 * 8. leftRightRotate
 * 9. rightLeftRotate
 * */

public class Trees<T>{
	
	/* Node class */
	class Node<E>{
		E data;
		Node<E> left, right;
		
		// Default constructor for node
		public Node(E obj)
		{
			data = obj;
			left = right = null;
		}
		
	}
	/* end of Node class */
	
	
	Node<T> root;
	
	// Default constructor for tree
	public Trees() {
		root = null;
	}
	
	/**Adds a new node to the tree
	 * @param obj. data for node to be added to tree
	 * 
	 * */
	public void add(T obj) {
		
		// empty tree
		if (root == null)
			root = new Node<T>(obj);
		else // non-empty tree
			add(obj, root);
	}
	
	/**Helper method that recursive adds node to non-empty trees
	 * @param obj. data for node to be added to tree
	 * @param node. root of tree
	 * 
	 * */
	private void add(T obj, Node<T> node) {
		
		// right subtree
		if (((Comparable<T>)obj).compareTo(node.data) > 0) 
		{
			if (node.right == null) {
				node.right = new Node<T>(obj);
				return;
			}
		
			add(obj, node.right);
		}
		else // left subtree
		{
			if (node.left == null) {
				node.left = new Node<T>(obj);
				return;
			}
			
			add(obj, node.left);
		}
		
	}
	
	
	/** Checks whether tree contains a given node
	 * @param target. target node.
	 * @return true/false indicating if target not was found/not.
	 * */
	public boolean contains(Node<T> target) {
		
		
		return contains(target, root);
	}
	
	
	/** Helper method for contains
	 * @param target. target node.
	 * @param base. root of current tree/subtree.
	 * */
	public boolean contains(Node<T> target, Node<T> base) {
		
		// check if base node is empty
		if (base == null)
			return false;
		
		// check if base node's data match target's data
		if (((Comparable<T>) target.data).compareTo(base.data) == 0) // target found 
		{
			return true;
		}
		
		// check right child
		if (((Comparable<T>) target.data).compareTo(base.data) > 0) // target found 
		{
			return contains(target,base.right);
		}
		
		// check left child
		return contains(target, base.left);
		
	}
	
	
	/**Performs Breadth First Search (BFS) on the tree.
	 * @param start. Node from which to start BFS
	 * @param target. Node to be found.
	 * @return node list for path traversed from start to target or null is target node is not found.
	 * */
	public void BFS(Node<T> node) {
		
		LinkedList<Node<T>> queue = new LinkedList<Node<T>>();
		
				
			
	}
	
	/*
	public void BFSHelper(Node<T> node, LinkedList<Node<T>> queue) {
		
		// base case
		if (node == null)
			return;
		
		queue.add(node);
				
		while (!queue.isEmpty()) {
			// remove, print current data
			node = queue.poll();
			System.out.print(node.data);
					
			// add all neighbors
			queue.add(node.left);
			queue.add(node.right);
			}
	}
	*/
	
	public static void main(String[] args) 
	{
		LinkedList<Integer> a = new LinkedList<Integer> ();
		a.addFirst(1);
		a.addLast(3);
		a.addFirst(6);
		// 6,1,3		
		
		
		System.out.println("Testing main.");
		
		for (int i:a) 
		{
			System.out.println(i);
		}
		
	}


}
