package au.edu.uq.itee.comp3506.part1;

import au.edu.uq.itee.comp3506.adt.EmptyStackException;
import au.edu.uq.itee.comp3506.adt.FullStackException;
import junit.framework.*;

public class TestArrayStack extends TestCase {

	/*
	 * Test the constructor
	 */
	public void testArrayStack() {
		new ArrayStack<String>();
	}

	/*
	 * Test that the size of a newly created ArrayStack is 0.
	 */
	public void testGetSize1() {
		ArrayStack<String> stack = new ArrayStack<String>();
		assertEquals("Incorrect stack size", 0, stack.size());
	}

	/*
	 * Test that a newly created ArrayStack is empty.
	 */
	public void testIsEmpty1() {
		ArrayStack<String> stack = new ArrayStack<String>();
		assertEquals("List incorrectly thinks it is not empty", true,
				stack.isEmpty());
	}

	/*
	 * Tests that attempting to access the top element of an empty stack will
	 * throw an EmptyStackException.
	 */
	public void testTop1() {
		ArrayStack<Object> stack = new ArrayStack<Object>();
		try {
			stack.top();
			fail("EmptyStackException expected");
		} catch (EmptyStackException ex) {
			;
		} catch (Exception ex) {
			fail("EmptyStackException expected");
		}
	}

	/*
	 * Tests that attempting to pop the top element of an empty stack will throw
	 * an EmptyStackException.
	 */
	public void testPop1() {
		ArrayStack<Object> stack = new ArrayStack<Object>();
		try {
			stack.pop();
			fail("EmptyStackException expected");
		} catch (EmptyStackException ex) {
			;
		} catch (Exception ex) {
			fail("EmptyStackException expected");
		}
	}

	/*
	 * Tests the push method to make sure it increments the size of the stack
	 * appropriately.
	 */
	public void testPush1() {
		ArrayStack<String> stack = new ArrayStack<String>();

		assertEquals("Incorrect stack size", 0, stack.size());
		stack.push("1");
		assertEquals("Incorrect stack size", 1, stack.size());
		stack.push("2");
		assertEquals("Incorrect stack size", 2, stack.size());
	}

	/*
	 * Tests that we can access the last object pushed onto the stack.
	 */
	public void testPush2() {
		ArrayStack<String> stack = new ArrayStack<String>();
		stack.push("other");
		stack.push("other");
		stack.push("expected");

		String str = stack.top();
		assertEquals("Incorrect object retrieved", "expected", str);
	}

	/*
	 * Tests that serial additions to the stack are correctly retrieved.
	 */
	public void testTop2() {
		String str;
		ArrayStack<String> stack = new ArrayStack<String>();
		stack.push("other");
		str = stack.top();
		assertEquals("Incorrect object retrieved", "other", str);
		stack.push("expected");
		str = stack.top();
		assertEquals("Incorrect object retrieved", "expected", str);
	}

	/*
	 * Tests that the size of the stack reduces appropriately as elements are
	 * removed.
	 */
	public void testPop2() {
		ArrayStack<String> stack = new ArrayStack<String>();

		assertEquals("Incorrect stack size", 0, stack.size());
		stack.push("1");
		assertEquals("Incorrect stack size", 1, stack.size());
		stack.push("2");
		assertEquals("Incorrect stack size", 2, stack.size());

		stack.pop();
		assertEquals("Incorrect stack size", 1, stack.size());

		stack.pop();
		assertEquals("Incorrect stack size", 0, stack.size());
	}

	/*
	 * Tests that elements added to the stack are removed properly.
	 */
	public void testPop3() {
		ArrayStack<String> stack = new ArrayStack<String>();

		stack.push("1");
		stack.push("2");

		String two = stack.pop();
		assertEquals("Incorrect number retrieved", "2", two);

		String one = stack.pop();
		assertEquals("Incorrect number retrieved", "1", one);
	}

	/*
	 * Tests that a series of push/pop operations work.
	 */
	public void testPushPop1() {
		ArrayStack<String> stack = new ArrayStack<String>();

		stack.push("1");
		stack.push("2");

		String two = stack.pop();
		assertEquals("Incorrect number retrieved", "2", two);
		assertEquals("Incorrect stack size", 1, stack.size());

		stack.push("2");
		assertEquals("Incorrect stack size", 2, stack.size());
		stack.push("3");
		assertEquals("Incorrect stack size", 3, stack.size());

		String three = stack.pop();
		assertEquals("Incorrect number retrieved", "3", three);
		assertEquals("Incorrect stack size", 2, stack.size());
	}

	/*
	 * Tests that the size of the array stack is as expected, and that a
	 * FullStackException is thrown when the size is exceeded.
	 */
	public void testStackLimit1() {
		ArrayStack<String> stack = new ArrayStack<String>(3);

		stack.push("1");
		stack.push("2");
		stack.push("3");

		try {
			stack.push("4");
			fail("FullStackException expected");
		} catch (FullStackException ex) {
			;
		} catch (Exception ex) {
			fail("FullStackException expected");
		}
	}
}
