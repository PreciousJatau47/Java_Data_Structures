
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
 * 
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
	
	public void BFS(Node<T> node) {
		
			
		
		
	}
	
	

}
