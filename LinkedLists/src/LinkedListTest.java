import java.util.Collections;
import org.junit.Assert;
import org.junit.Test;

/**
 * Testing class for LinkedList
 * 
 * @author Precious Jatau
 * @version 2019-02-11
 */

/*
 * TODO
 * 1. Node constructor (completed)
 * 2. size (completed)
 * 3. addLast, removeLast (completed)
 * 4. remove
 * 5. contains (completed)
 * 6. peekFirst
 * 7. peekLast 
 * 8. addLastSlow
 * 9. iterator
*/


public class LinkedListTest {
	
	
	/**
	 * Test the node constructor 
	 */
	@Test
	public void nodeConstructor() 
	{
		LinkedList<Integer> ll = new LinkedList<Integer>();
		LinkedList<Integer>.Node<Integer> node = ll.new Node<Integer>(2);
		
		Assert.assertEquals("Node constructor correct", node.getData().intValue(), 2);
	}
	
	
	/**
	 * Test the empty LinkedList constructor 
	 */
	@Test
	public void emptyConstructorTest()
	{
		LinkedList<Integer> ll = new LinkedList();
		Assert.assertEquals("Wrong head returned for LinkedList empty constructor", null, ll.getHead());
		Assert.assertEquals("Wrong tail returned for LinkedList empty constructor", null, ll.getTail());
		Assert.assertEquals("Wrong size returned for LinkedList empty constructors", 0, ll.getCurrentSize());
	}
	
	/**
	 * Test addFirst(), removeFirst() methods
	 */
	@Test
	public void addRemoveFirstTest() 
	{
		int numElements = 100;
		LinkedList<Integer> ll = new LinkedList();
		
		for (int i = 0; i < numElements; ++i) 
		{
			ll.addFirst(i);
			// ll contains 99, 98, 97, ... 0
		}
		Assert.assertEquals("LinkedList has incorrect correct size after addFirst.", numElements, ll.getCurrentSize());
		
		// remove elements and compare
		for (int i = numElements - 1; i >= 0; --i) 
		{
			Assert.assertEquals("Wrong output for removeFirst", i, ll.removeFirst().intValue());
		}
		
		Assert.assertEquals("LinkedList has incorrect size after removeFirst.", 0, ll.getCurrentSize());
	}
	
	/**
	 * Test addLast(), removeLast() methods
	 */
	@Test
	public void addLastFirstLastTest() 
	{
		int numElements = 100;
		LinkedList<Integer> ll = new LinkedList();
		
		
		for (int i = 0; i < numElements; ++i) 
		{
			ll.addLast(i);
			// ll contains 0,1,2,...,99
		}
		Assert.assertEquals("LinkedList has incorrect correct size after addLast.", numElements, ll.getCurrentSize());
		
		// remove last elements and compare
		for (int i = numElements - 1; i >= 0; --i) 
		{
			Assert.assertEquals("Wrong output for removeLast", i, ll.removeLast().intValue());
		}
		
		Assert.assertEquals("LinkedList has incorrect size after removeLast.", 0, ll.getCurrentSize());
	}
	
	/**
	 * Test remove() method
	 */
	
	
	/**
	 * Test contains() method
	 */
	@Test
	public void containsTest() 
	{
		LinkedList<Integer> ll = new LinkedList<Integer>();
		Assert.assertFalse(ll.contains(2));
		
		ll.addLast(3);
		Assert.assertFalse(ll.contains(2));
		
		ll.addLast(2);
		Assert.assertTrue(ll.contains(2));
		
	}
	
	/**
	 * Test LinkedList Iterator
	 */
	@Test
	public void IteratorTest() 
	{
		LinkedList<Integer> ll = new LinkedList<Integer>();

		for (int i = 0; i < 7; ++i) 
		{
			ll.addLast(i);
			// contains 0,1,2,...6
		}
		
		int expected = 0;
		for (int data: ll) 
		{
			Assert.assertEquals("Iterator returns wrong data.", expected, data);
			++expected;
		}
		
	}
	
}
