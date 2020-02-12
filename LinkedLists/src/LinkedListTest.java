import java.util.Collections;
import org.junit.Assert;
import org.junit.Test;

/*
 * TODO
 * 1. Need node class in package
*/

/**
 * Testing class for LinkedList
 * 
 * @author Precious Jatau
 * @version 2019-02-11
 */
public class LinkedListTest {
	
	/**
	 * Test the empty LinkedList constructor 
	 */
	@Test
	public void emptyConstructorTest()
	{
		LinkedList<Integer> ll = new LinkedList();
		Assert.assertEquals("LinkedList created correctly", ll.getHead(), null);
		Assert.assertEquals("LinkedList created correctly", ll.getTail(), null);
		Assert.assertEquals("LinkedList created correctly", ll.getCurrentSize(), 0);
	}
	
	/**
	 * Test addFirst
	 */
	@Test
	public void addFirstTest() 
	{
		LinkedList<Integer> ll = new LinkedList();
		
		for (int i = 0; i < 5; ++i) 
		{
			ll.addFirst(i);
			// ll contains 4,3,2,1,0
		}
		// remove elements and compare
		
		//Assert.assertEquals("LinkedList created correctly", ll.getHead(), null);
	}

}
