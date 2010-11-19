package student42094353Test;

import au.edu.uq.itee.comp3506.part1.*;
import student42094353.*;
import junit.framework.TestCase;

public class ADTFactoryTest extends TestCase {

	/*
	 * Test the constructor
	 */
	public void testADTFactory() {
		new ADTFactory<String>();
	}

	/*
	 * Test that we can get an ArrayQueue from the factory.
	 */
	public void testCreateArrayQueue() {
		ADTFactory<String> factory = new ADTFactory<String>();
		assertEquals("Could not create ArrayQueue", true,
				factory.createQueue("ArrayQueue") instanceof ArrayQueue);
	}

	/*
	 * Test that we can get an ArrayStack from the factory.
	 */
	public void testCreateArrayStack() {
		ADTFactory<String> factory = new ADTFactory<String>();
		assertEquals("Could not create ArrayStack", true,
				factory.createStack("ArrayStack") instanceof ArrayStack);
	}

	/*
	 * Test that we can get a ListQueue from the factory.
	 */
	public void testCreateListQueue() {
		ADTFactory<String> factory = new ADTFactory<String>();
		assertEquals("Could not create ListQueue", true,
				factory.createQueue("ListQueue") instanceof ListQueue);
	}

	/*
	 * Test that we can get a ListStack from the factory.
	 */
	public void testCreateListStack() {
		ADTFactory<String> factory = new ADTFactory<String>();
		assertEquals("Could not create ListStack", true,
				factory.createStack("ListStack") instanceof ListStack);
	}

	/*
	 * Test that we can get a ProtoPriorityQueue from the factory.
	 */
	public void testCreateProtoPriorityQueue() {
		ADTFactory<String> factory = new ADTFactory<String>();
		assertEquals(
				"Could not create ProtoPriorityQueue",
				true,
				factory.createPriorityQueue("ProtoPriorityQueue") instanceof ProtoPriorityQueue);
	}

}
