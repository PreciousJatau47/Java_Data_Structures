import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;

import org.junit.jupiter.api.Test;

/* TODO
 * 1. testcontains() - completed
 * 2. testNode()
 * 3. testTrees()
 * */


class TreesTest {

	@Test
	void testTrees() {
		fail("Not yet implemented");
	}

	@Test
	void testAdd() {
		fail("Not yet implemented");
	}

	@Test
	void testContainsNodeOfT() {
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
		Assert.assertTrue("Added node not found in tree!", myTree.contains(two));
		
		myTree.add(three.data);
		Assert.assertTrue("Added node not found in tree!", myTree.contains(three));
		
		myTree.add(one.data);
		Assert.assertTrue("Added node not found in tree!", myTree.contains(three));
		

	}

}
