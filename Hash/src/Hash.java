import java.util.LinkedList;

/**
 * Class for hash with collisions handled by chaining.
 * Each element with be of a HashElement class
 * 
 * @author Precious Jatau
 * @version 2020-03-08
 */

/*TODO
 * 1. resize()
 * 
 */



public class Hash<K,V>{
	
	class HashElement<K,V> implements Comparable<HashElement<K,V>>
	{
		// data
		K key;
		V value;
		
		/**Default constructor for HashElement
		 * @param key
		 * @param value
		 * */
		public HashElement(K key, V value) 
		{
			this.key = key;
			this.value = value;
		}
		
		
		/**Compares this HashElement to another
		 * @param o, the HashElement object to be compared to.
		 * @return 0 if equal, negative if this is less and positive if this is greater.
		 * */
		public int compareTo(HashElement<K,V> o) 
		{
			return ((Comparable<K>)this.key).compareTo(o.key);
		}
		
	}
	// HashElement class ends here
	
	// data fields
	int numElements;
	int tableSize;
	double maxLoadFactor;
	LinkedList<HashElement<K,V>>[] hArray;
	
	/** Non default constructor for Hash class
	 * @param tableSize
	 */
	public Hash(int tableSize) 
	{
		// set size of hash array
		this.tableSize = tableSize;
		
		// initialize hash array
		int [] a = new int[20];
		hArray = (LinkedList<HashElement<K,V>>[]) new LinkedList[tableSize];
		
		// fill array with empty linked lists
		for (int i = 0; i < hArray.length; ++i)
			hArray[i] = new LinkedList<HashElement<K,V>>();
		
		// initialize other fields
		maxLoadFactor = 0.75;	// java api default
		numElements = 0;
		
	}
	
	/** Add new element to hash
	 * @param key, value
	 * @return boolean (if element was added)
	 */
	public boolean add(K key, V value) 
	{
		// resize if at maxLoadFactor
		if (loadFactor() > maxLoadFactor) 
		{
			resize();
		}
		
		// create HashElement
		HashElement he = new HashElement(key, value);
		
		// add to hash array
		int hashVal = key.hashCode() & 0x7FFFFFFF % tableSize;
		hArray[hashVal].add(he);
		
		// increment numElements
		++numElements;
	}
	
	/** Calculate load factor
	 * @return load factor
	 * */
	public double loadFactor() 
	{
		return (numElements/tableSize);
	}

}
