import java.util.Iterator;
import java.util.LinkedList;

/**
 * Class for hash with collisions handled by chaining.
 * Each element with be of a HashElement class
 * 
 * @author Precious Jatau
 * @version 2020-03-08
 */

/*TODO
 * add() - completed
 * remove() - completed
 * keyIterator() - completed
 * keyIterator Test
 * ConstructorTest() -completed
 * resize() - in progress
 * getValue()
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


	// Getters and setters
	public int getNumElements() {
		return numElements;
	}

	public void setNumElements(int numElements) {
		this.numElements = numElements;
	}

	public int getTableSize() {
		return tableSize;
	}

	public void setTableSize(int tableSize) {
		this.tableSize = tableSize;
	}

	public double getMaxLoadFactor() {
		return maxLoadFactor;
	}

	public void setMaxLoadFactor(double maxLoadFactor) {
		this.maxLoadFactor = maxLoadFactor;
	}

	public LinkedList<HashElement<K, V>>[] gethArray() {
		return hArray;
	}

	public void sethArray(LinkedList<HashElement<K, V>>[] hArray) {
		this.hArray = hArray;
	}

	/** Non default constructor for Hash class
	 * @param tableSize
	 */
	public Hash(int tableSize) 
	{
		// set size of hash array
		this.tableSize = tableSize;

		// initialize hash array
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
		numElements++;
		
		return true;
	}
	
	/**Removes given HashElement from Hash 
	 * @ boolean (if element was removed)
	 */
	public boolean remove(K key, V value) 
	{
		// create HashElement
		HashElement<K,V> he = new HashElement(key, value);
		
		// find index of element
		int hashVal = key.hashCode() & 0x7FFFFFFF % tableSize;
		hArray[hashVal].remove(he);
		
		return true;
	}

	/**Resizes hash array and rehashed elements
	 * @param tableSize
	 * */
	public void resize(int newSize) 
	{	
		// create new hash array
		LinkedList<HashElement<K,V>>[] newArray = (LinkedList<HashElement<K,V>>[])new LinkedList[newSize];

		for (int i = 0; i < newSize; ++i) 
		{
			// initialize empty linked lists
			newArray[i] = new LinkedList();
		}
		
		// rehash elements
		
		
		// iterate through keys
		// find position in newArray
		// insert in newArray



		// update hArray

		// update tableSize
	}

	/** Hash Iterator
	 * @return IteratorHelper object
	 */
	public Iterator<K> Iterator()
	{
		return new IteratorHelper();
	}
	
	
	/**Iterates through hash and store keys in array
	 * 
	 */
	public class IteratorHelper<T> implements Iterator<T> 
	{
		T[] keys;
		int position;

		public IteratorHelper() 
		{
			keys = (T[]) new Object[numElements];
			int p = 0;
					
			// iterate through hash array
			for (int i = 0; i < tableSize; ++i) 
			{
				LinkedList<HashElement<K,V>> list = hArray[i];

				// iterate through linked lists
				for (HashElement<K,V> he : list) 
				{
					// copy key to key array
					keys[p++] = (T)he.key;
				}
			}
			position = 0;
		}

		// hasNext
		public boolean hasNext() 
		{
			return position < keys.length;
		}

		// next 
		public T next() 
		{
			return keys[position++];
		}
	}


	/** Calculate load factor
	 * @return load factor
	 * */
	public double loadFactor() 
	{
		return (numElements/tableSize);
	}
	
	public static void main(String[] args) 
	{
		Integer x = new Integer(6);
		System.out.println(x.hashCode());
		// Integer objects hashCode() is it's int value.
	}


}


