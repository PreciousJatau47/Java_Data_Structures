import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/* TODO
 * 1. keyIteratorTest
 * 
 * */

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
		System.out.println(tmpHash.getMaxLoadFactor());
		Assert.assertEquals("Max load factor is not equal to 0.75", 0.75 ,tmpHash.getMaxLoadFactor(), 0.001);
		
		
		// numElements
		Assert.assertEquals("numElements is not equal to 0", 0 ,tmpHash.getNumElements());
		
	}

	@Test
	void testAdd() {
		fail("Not yet implemented");
	}

	@Test
	void testLoadFactor() {
		fail("Not yet implemented");
	}

}
