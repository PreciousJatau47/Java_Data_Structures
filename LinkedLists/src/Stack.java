/**
 * Array implementation of stack data structure.
 * 
 * @author - Precious Jatau
 * @version 2020-02-22
 * 
 */

/*TODO
 * 1. Default constructor
 * 2. push (done)
 * 3. pop (done)
 * 4. isEmpty (done)
 * 5. peek (done)
 * 	toString
 * 	
 * 6. Use try-catch
 * 7. Use generic array
 */


public class Stack<E> 
{
	static final int MAX = 1000;	// size of array
	private int top;				// points to last element pushed to stack
	
	int arr[] = new int[MAX];
	
	/**
	 * Default constructor for Stack
	 */
	public Stack() 
	{
		top = -1;
	}
	
	/**
	 * Checks if Stack is empty
	 * @return True(False) if stack is empty(non-empty)
	 */
	public boolean isEmpty() 
	{
		return top < 0;
	}
	
	
	/**
	 * Push new element to top of stack
	 * @return True(False) if successful (fail)
	 */
	
	public boolean push(int x) 
	{
		if (top >= MAX - 1) 
		{
			System.out.println("Stack overflow");
			return false;	
		}
		else 
		{
			++top;
			arr[top] = x;
			return true;
		}
	}
	
	/**
	 * Removes top element that was pushed to stack array
	 * @return element(or INTEGER.MIN_VALUE) if stack is non-empty (empty)
	 */
	public int pop() 
	{
		
		if (top < 0) 
		{
			System.out.println("Stack underflow");
			return Integer.MIN_VALUE;	
		}
		else 
		{
			int tmp = arr[top];
			--top;
			return tmp;
		}
	}
		
	/**
	 * String representation of stack ordered from top to bottom
	 */
	public String toString() 
	{
		String str = "";
		
		for (int i = top; i >= 0; --i) 
		{
			str = str + "=>" + arr[i] + "\n";
		}
		
		
		return str;
	}
	
	/**
	 * Returns top element from stack array
	 */
	public int peek() 
	{
		if (top < 0) 
		{
			System.out.println("Stack underflow");
			return Integer.MIN_VALUE;	
		}
		else 
		{
			int tmp = arr[top];
			return tmp;
		}	
		
	}
	
	
	
	public static void main(String[] args) 
	{
		Stack stk = new Stack();
		
		System.out.println("Pushed 0-4");
		for (int i = 0; i <= 4; ++i) 
		{
			stk.push(i);
			// stk is 8, 7, 6, 5, 4, ...
		}
		
		System.out.println(stk.toString() + "\n");
		
		
		System.out.println("Pop 4");
		System.out.println("Pop 3");
		stk.pop();
		stk.pop();
		
		System.out.println(stk.toString());
		
		
		stk.pop();
		stk.pop();
		stk.pop();
		
		System.out.println("Expected stack underflow");
		stk.pop();
	}
	
	

}
