package student42094353Test;

import au.edu.uq.itee.comp3506.adt.EmptyQueueException;
import student42094353.*;
import junit.framework.TestCase;

public class ListQueueTest extends TestCase {

	/*
	 * Test the constructor
	 */
	public void testListQueue() {
		new ListQueue<String>();
	}

	/*
	 * Test that the size of a newly created ListQueue is 0.
	 */
	public void testGetSize1() {
		ListQueue<String> queue = new ListQueue<String>();
		assertEquals("Incorrect queue size", 0, queue.size());
	}

	/*
	 * Test that a newly created ListQueue is empty.
	 */
	public void testIsEmpty1() {
		ListQueue<String> queue = new ListQueue<String>();
		assertEquals("Queue incorrectly thinks it is not empty", true,
				queue.isEmpty());
	}

	/*
	 * Tests that attempting to access the first element of an empty queue will
	 * throw a EmptyQueueException.
	 */
	public void testFront1() {
		ListQueue<Object> queue = new ListQueue<Object>();
		try {
			queue.front();
			fail("EmptyQueueException expected");
		} catch (EmptyQueueException ex) {
			;
		} catch (Exception ex) {
			fail("EmptyStackException expected");
		}
	}

	/*
	 * Tests that attempting to dequeue the last element of an empty queue will
	 * throw a EmptyQueueException.
	 */
	public void testDequeue1() {
		ListQueue<Object> queue = new ListQueue<Object>();
		try {
			queue.dequeue();
			fail("EmptyQueueException expected");
		} catch (EmptyQueueException ex) {
			;
		} catch (Exception ex) {
			fail("EmptyStackException expected");
		}
	}

	/*
	 * Tests the enqueue method to make sure it increments the size of the queue
	 * appropriately.
	 */
	public void testEnqueue1() {
		ListQueue<String> queue = new ListQueue<String>();

		assertEquals("Incorrect queue size", 0, queue.size());
		queue.enqueue("1");
		assertEquals("Incorrect queue size", 1, queue.size());
		queue.enqueue("2");
		assertEquals("Incorrect queue size", 2, queue.size());
	}

	/*
	 * Tests that enqueue properly adds an element to the queue.
	 */
	public void testEnqueue2() {
		ListQueue<String> queue = new ListQueue<String>();
		queue.enqueue("expected");
		String str = queue.front();
		assertEquals("Incorrect object retrieved", "expected", str);
	}

	/*
	 * Tests that we can retrieve an object just added to the queue.
	 */
	public void testFront2() {
		String str;
		ListQueue<String> queue = new ListQueue<String>();
		queue.enqueue("expected");
		str = queue.front();
		assertEquals("Incorrect object retrieved", "expected", str);
		queue.enqueue("other");
		str = queue.front();
		assertEquals("Incorrect object retrieved", "expected", str);
		queue.enqueue("other");
		str = queue.front();
		assertEquals("Incorrect object retrieved", "expected", str);
	}

	/*
	 * Tests that removing elements correctly updates the size of the queue.
	 */
	public void testDequeue2() {
		ListQueue<String> queue = new ListQueue<String>();
		assertEquals("Incorrect queue size", 0, queue.size());
		queue.enqueue("1");
		assertEquals("Incorrect queue size", 1, queue.size());
		queue.enqueue("2");
		assertEquals("Incorrect queue size", 2, queue.size());
		queue.dequeue();
		assertEquals("Incorrect queue size", 1, queue.size());
		queue.dequeue();
		assertEquals("Incorrect queue size", 0, queue.size());
	}

	/*
	 * Tests that elements added to the queue are removed properly.
	 */
	public void testDequeue3() {
		ListQueue<String> queue = new ListQueue<String>();

		queue.enqueue("1");
		queue.enqueue("2");
		queue.enqueue("3");

		String one = queue.dequeue();
		assertEquals("Incorrect number retrieved", "1", one);
		String two = queue.dequeue();
		assertEquals("Incorrect number retrieved", "2", two);
		String three = queue.dequeue();
		assertEquals("Incorrect number retrieved", "3", three);
	}

	/*
	 * Tests that a series of en/dequeue operations work.
	 */
	public void testEnqueueDequeue1() {
		ListQueue<String> queue = new ListQueue<String>();

		queue.enqueue("1");
		queue.enqueue("2");

		String one = queue.dequeue();
		assertEquals("Incorrect number retrieved", "1", one);
		assertEquals("Incorrect queue size", 1, queue.size());

		queue.enqueue("3");
		assertEquals("Incorrect queue size", 2, queue.size());
		queue.enqueue("4");
		assertEquals("Incorrect queue size", 3, queue.size());

		String two = queue.dequeue();
		assertEquals("Incorrect number retrieved", "2", two);
		assertEquals("Incorrect queue size", 2, queue.size());
	}
}
