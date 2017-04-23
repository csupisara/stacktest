package test;

import static org.junit.Assert.*;
import static org.junit.Assume.*;
import org.junit.Before;
import org.junit.Test;

import ku.util.Stack;
import ku.util.StackFactory;

/**
 * JUnit 4 tests for the Stack testing assignment.
 * Testing that all methods in Stack work correctly.
 * @author Supisara Chuthathumpitak
 */
public class StackTest {
	private Stack<String> stack;
	private String obj = "a";
	private String obj2 = "b";
	private String obj3 = "c";
		
	/** "Before" method  is run before each test. */
	@Before
	public void setUp() {
		stack = makeStack( 2 );
	}
	
	/** A method to create stacks, so we can change implementation. */
	private Stack<String> makeStack( int capacity ) {
		StackFactory.setStackType(1);
		return StackFactory.makeStack(capacity);
	}
	
	/** The stack capacity need to be the same as the capacity that we initialize before testing. */
	@Test
	public void testCapacity() {
		assertEquals( 2, stack.capacity() );
		stack.push( obj );
		assertEquals( 2, stack.capacity() );
		stack.push( obj2 );
		assertEquals( 2, stack.capacity() );
		stack.pop();
		assertEquals( 2, stack.capacity() );
		stack.peek();
		stack.peek();
		assertEquals( 2, stack.capacity() );
	}
	
	/** Stack capacity never be negative number. */
	@Test
	public void testNecessaryCapacity() {
		assertFalse(stack.capacity() < 0);
	}
	
	/** Test that IsEmpty method is working correctly. */
	@Test
	public void testIsEmpty(){
		assertTrue( stack.isEmpty() );
		stack.push( obj );
		assertFalse( stack.isEmpty() );
		stack.push( obj2 );
		assertFalse( stack.isEmpty() );
		stack.pop();
		assertFalse( stack.isEmpty() );
		stack.pop();
		assertTrue( stack.isEmpty() );
		assertEquals( 0, stack.size() );
	}

	/** Stack should be full when the size is same as the capacity. */
	@Test
	public void testIsFull() {
		assertFalse( stack.isFull() );
		stack.push( obj );
		stack.push( obj2 );
		assertTrue( stack.isFull() );
		stack.pop();
		stack.peek();
		assertFalse( stack.isFull() );
		stack.push( obj3 );
		assertTrue( stack.isFull() );
	}
	
	/** When push some elements into stack, the peek should return the same element every times and not alter the stack.*/
	@Test
	public void testPeek() {
		assertNull( stack.peek() );
		stack.push( obj );
		assertEquals( obj , stack.peek() );
		assertEquals( stack.peek(), stack.peek() );
		assertEquals( 1, stack.size() ); //not alter the stack
		stack.push( obj2 );
		assertEquals( obj2 , stack.peek() );
		assertEquals( 2, stack.size() );
		assertEquals( stack.peek(), stack.peek() );
		stack.pop();
		assertEquals( obj3 , stack.peek() );
		stack.pop();
		assertNull( stack.peek() );
	}
	
	/** If the stack is Empty and want to pop, it will throw an exception. */
	@Test( expected=java.util.EmptyStackException.class )
	public void testPopEmptyStack() {
		assumeTrue( stack.isEmpty() );
		stack.pop();
	}
	
	/** Remove it from the stack when calling pop. */
	@Test
	public void testPopSize() {
		stack.push( obj );
		stack.push( obj2 );
		assertEquals( 2, stack.size() );
		stack.pop();
		assertEquals( 1, stack.size() );
		stack.pop();
		assertEquals( 0, stack.size() );
	}
	
	/** Return the item on the top of the stack, and remove it from the stack. */
	@Test
	public void testPopReturn() {
		stack.push( obj );
		stack.push( obj2 );
		assertEquals( obj2, stack.pop()) ;
		stack.push( obj3 );
		assertEquals( obj3, stack.pop() );
		assertEquals( obj, stack.pop() );
	}
	
	/** If push null to the stack, it will throws IllegalArgumentException. */
	@Test(expected=IllegalArgumentException.class)
	public void testPushNullThrowsException() {
		stack.push(null);
	}
	
	/** If push is called when stack is full, it will throws IllegalStateException. */
	@Test(expected=IllegalStateException.class)
	public void testOverflow() {
		stack.push( obj );
		stack.push( obj2 );
		stack.push( obj3 );
	}

	/** New stack need to have empty size. (Not full) */
	@Test
	public void testNewStackIsEmpty() {
		assertTrue( stack.isEmpty() );
		assertFalse( stack.isFull() );
		assertEquals( 0, stack.size() );
	}
	
	/** Return the number of items in the stack. */
	@Test
	public void testSize() {
		stack.push( obj );
		assertEquals( 1, stack.size() );
		stack.peek();
		assertEquals( 1, stack.size() );
		stack.pop();
		assertEquals( 0, stack.size() );
		stack.push( obj2 );
		assertEquals( 1, stack.size() );
	}
}
