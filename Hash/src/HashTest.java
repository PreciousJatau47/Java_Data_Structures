import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class HashTest {
	
	@Test
	void testHashElement() 
	{
		int key = 25;
		int val = 50;
		int keyn = 35;
		int valn = 50;
		
		Hash<Integer, Integer> tmpHash = new Hash(3);
		Hash<Integer, Integer>.HashElement<Integer,Integer> he = tmpHash.new HashElement<Integer,Integer>(key, val);
		Hash<Integer, Integer>.HashElement<Integer,Integer> he2 = tmpHash.new HashElement<Integer,Integer>(key, val);
		Hash<Integer, Integer>.HashElement<Integer,Integer> he3 = tmpHash.new HashElement<Integer,Integer>(keyn, valn);	
	
		Assert.assertTrue("Error! Hash Elements should be equal",he.compareTo(he2) == 0);
		Assert.assertTrue("Error! Hash Elements should not be equal",he.compareTo(he3) != 0);
	
	}

	@Test
	void testHashConstructor() {
		
		// create new Hash
		int inTableSize = 55;
		Hash<Integer, Integer> tmpHash = new Hash(inTableSize);
		
		//check table size
		Assert.assertEquals("Error! Wrong table size assigned in constructor",inTableSize, tmpHash.getTableSize());
		
		// hArray elements
		LinkedList<Hash<Integer,Integer>.HashElement<Integer,Integer>>[] h = tmpHash.gethArray();
		
		for (int i = 0; i < h.length; ++i) 
		{
			Assert.assertEquals("Non-empty linkedlist found in hash array", 0, h[i].size());
		}
		
		
		// maxLoadFactor
		Assert.assertEquals("Max load factor is not equal to 0.75", 0.75 ,tmpHash.getMaxLoadFactor(), 0.001);
		
		
		// numElements
		Assert.assertEquals("numElements is not equal to 0", 0 ,tmpHash.getNumElements());
		
	}
	
	@Test
	void testResize() 
	{
		// create Hash
		int startTableSize = 10;
		Hash<Integer, Integer> tmpHash = new Hash(startTableSize);
		
		// add Objects
		for (int i = 0; i < 7; ++i) 
		{
			tmpHash.add(i, i^2);
		}
		System.out.println(tmpHash.getTableSize());
		
		// resize
		tmpHash.resize(20);
		
		// check for objects
		for (int i = 0; i < 7; ++i) 
		{
			Assert.assertTrue("Error! element not found in resized array", tmpHash.getValue(i) != null);
		}
		Assert.assertNull("Error! new element found in resized array", tmpHash.getValue(startTableSize + 1));
		
		// check tableSize
		Assert.assertTrue("Error! wrong size set in resize()", tmpHash.getTableSize() == 20);
		
	}

	@Test
	void testAdd() {
		
		int startTableSize = 10;
		Hash<Integer, Integer> tmpHash = new Hash(startTableSize);
		
		// add within maxLoadFactor
		// add Objects
		for (int i = 0; i < 7; ++i) 
		{
			tmpHash.add(i, i^2);
		}
		
		// check elements
		for (int i = 0; i < 7; ++i) 
		{
			Assert.assertTrue("Error! element not found in resized array", tmpHash.getValue(i) != null);
		}
		Assert.assertNull("Error! new element found in resized array", tmpHash.getValue(startTableSize + 1));
		
		// check size
		Assert.assertTrue("Error! wrong size set in resize()", tmpHash.getTableSize() == startTableSize);
		
		// exceed maxLoadFactor
		tmpHash.add(7, 7^2);
		tmpHash.add(8, 8^2);
		
		// check elements
		for (int i = 0; i < 9; ++i) 
		{
			Assert.assertTrue("Error! element not found in resized array", tmpHash.getValue(i) != null);
		}
		Assert.assertNull("Error! new element found in resized array", tmpHash.getValue(startTableSize + 1));
		
		// check size
		Assert.assertTrue("Error! wrong size set in resize()", tmpHash.getTableSize() == startTableSize*2);		
	}
	
	@Test
	void testRemove() 
	{
		int startTableSize = 10;
		Hash<Integer, Integer> tmpHash = new Hash(startTableSize);
		
		// add within maxLoadFactor
		// add Objects
		for (int i = 0; i < 7; ++i) 
		{
			tmpHash.add(i, i*i);
		}
		
		tmpHash.remove(2, 2*2);
		
		for (Integer key: tmpHash) 
		{
			System.out.println("->" + key);
		}
		
	}

	@Test
	void testLoadFactor() {
		fail("Not yet implemented");
	}
	
	@Test
	void testgetValue() 
	{
		// create Hash with two elements
		Integer key1 = 2;
		Integer key2 = 4;
		String value1 = "two";
		String value2 = "four";
		
		Hash<Integer, String> myHash = new Hash(2);
		myHash.add(key1, value1);
		myHash.add(key2, value2);
		
		// check values
		Assert.assertEquals("Error! Expected value not found in hash", value1, myHash.getValue(key1));
		Assert.assertEquals("Error! Expected value not found in hash", value2, myHash.getValue(key2));
		Assert.assertNull("Error! null not returned for getValue() given non-existent key", myHash.getValue(99));
	}
	
	@Test
	void iteratorTest() 
	{
		// create Hash 
		int myTableSize = 10;
		Hash<Integer, Integer> myHash = new Hash(myTableSize);
		
		// add Elements
		for (int i = 0; i < myTableSize; ++i) 
		{
			myHash.add(i, i^2);
		}
		
		// Iterate through Hash, cross check elements
		for (int x : myHash) 
		{
			Assert.assertTrue("Wrong key returned by iterator", x%1 == 0);// no fractions
			Assert.assertTrue("Wrong key returned by iterator", x < myTableSize);
		}
	}
	
	

}
