import java.util.LinkedList;

import org.junit.Assert;


/**
 * Class for binary trees
 * @author Precious Jatau
 * @version 2020-05-06
 * 
 * */

/* TODO
 * 1. Node class (completed)
 * 2. add (completed)
 * 3. contains (completed)
 * 4. BFS(in progress)
 * 5. remove. update numNodes
 * 6. leftRotate
 * 7. rightRotate
 * 8. leftRightRotate
 * 9. rightLeftRotate
 * 10. need size.
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
	int numNodes;
	
	// Default constructor for tree
	public Trees() {
		root = null;
		numNodes = 0;
	}
	
	/**Adds a new node to the tree
	 * @param obj. data for node to be added to tree
	 * 
	 * */
	public void add(T obj) {
		
		// empty tree
		if (root == null) 
		{
			root = new Node<T>(obj);
			++numNodes;
			}
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
				++numNodes;
				return;
			}
		
			add(obj, node.right);
		}
		else // left subtree
		{
			if (node.left == null) {
				node.left = new Node<T>(obj);
				++numNodes;
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
		
		// Initialize variables
		LinkedList<Node<T>> queue = new LinkedList<Node<T>>();
		boolean visited[] = new boolean[getSize()]; 
		Node<T> prev[] = (Node<T>[]) new Object[getSize()];
		
		// BFSHelper
		BFSHelper(node, queue, visited, prev);
		
		// iterate through neighbours, enqueue if not visited, update visited/prev status
		
		// reconstruct path
		
				
			
	}
	
	/** enqueue current node and its neighbors.
	 * @param node
	 * @param queue
	 * @param visited. boolean array indicating which nodes have been visited.
	 * @param prev. Node array indicating previous node for each visited node.
	 * */
	public void BFSHelper(Node<T> node, LinkedList<Node<T>> queue, boolean[] visited, Trees<T>.Node<T>[] prev) {
		
		// base case
		if (node == null)
			return;
		
		queue.add(node);
		visited[(int)node.data] = true;
				
		while (!queue.isEmpty()) {
			// remove, print current data
			node = queue.poll();
			System.out.print(node.data);
					
			// add all neighbors
			queue.add(node.left);
			queue.add(node.right);
			}
	}
	
	/**Returns number of nodes in tree.
	 * @ return numNodes.
	 * */
	public int  getSize() 
	{
		return numNodes;
	}
	
	public static void main(String[] args) 
	{
		// Initialize tree
		Trees<Integer> myTree = new Trees(); 

		// Assert that tree is empty
		Assert.assertNull("Tree is not empty!", myTree.root);		

		// Create nodes
		Trees<Integer>.Node<Integer> two = myTree.new Node<Integer>(2);		// would be root
		Trees<Integer>.Node<Integer> three = myTree.new Node<Integer>(3);	// would be right child
		Trees<Integer>.Node<Integer> one = myTree.new Node<Integer>(1);		// would be left child

		// Add nodes, check if tree contains added node.
		myTree.add(two.data);
		myTree.add(three.data);
		myTree.add(one.data);
		System.out.println(myTree.getSize());
	}


}
