package student42094353Test;

import au.edu.uq.itee.comp3506.adt.NoSuchElementException;
import student42094353.ProtoPriorityQueue;
import junit.framework.TestCase;

public class ProtoPriorityQueueTest extends TestCase {
	/*
	 * Test the constructor
	 */
	public void testProtoPriorityQueue() {
		new ProtoPriorityQueue<String>();
	}

	/*
	 * Test that the size of a newly created ProtoPriorityQueue is 0.
	 */
	public void testInitialSize() {
		ProtoPriorityQueue<String> queue = new ProtoPriorityQueue<String>();

		assertEquals("Incorrect queue size", 0, queue.size());
	}

	/*
	 * Test that the newly created ProtoPriorityQueue is empty
	 */
	public void testInitialIsEmpty() {
		ProtoPriorityQueue<String> queue = new ProtoPriorityQueue<String>();

		assertEquals("Queue incorrectly thinks it is not empty", true,
				queue.isEmpty());
	}

	/*
	 * Tests that attempting to access the minimum element of an empty queue
	 * will throw a NoSuchElementException.
	 */
	public void testInitialMin() {
		ProtoPriorityQueue<Object> queue = new ProtoPriorityQueue<Object>();
		try {
			queue.min();
			fail("NoSuchElementException expected");
		} catch (NoSuchElementException ex) {
			;
		} catch (Exception ex) {
			fail("NoSuchElementException expected");
		}
	}

	/*
	 * Tests that attempting to remove the minimum element of an empty queue
	 * will throw a NoSuchElementException.
	 */
	public void testInitialRemoveMin() {
		ProtoPriorityQueue<Object> queue = new ProtoPriorityQueue<Object>();
		try {
			queue.removeMin();
			fail("NoSuchElementException expected");
		} catch (NoSuchElementException ex) {
			;
		} catch (Exception ex) {
			fail("NoSuchElementException expected");
		}
	}

	/*
	 * Tests the insert method to make sure it increments the size of the queue
	 * appropriately.
	 */
	public void testInsertSize() {
		ProtoPriorityQueue<String> queue = new ProtoPriorityQueue<String>();

		assertEquals("Incorrect queue size", 0, queue.size());
		queue.insert(1, "1");
		assertEquals("Incorrect queue size", 1, queue.size());
		queue.insert(2, "2");
		assertEquals("Incorrect queue size", 2, queue.size());
	}

	/*
	 * Tests that insert properly adds an element to an empty queue.
	 */
	public void testInsertEmpty() {
		ProtoPriorityQueue<String> queue = new ProtoPriorityQueue<String>();
		queue.insert(1, "expected");
		assertEquals("Incorrect object retrieved", "expected", queue.min());
	}

	/*
	 * Tests that we can retrieve an object just added to the queue with higher
	 * priority.
	 */
	public void testInsertHighPriority() {
		ProtoPriorityQueue<String> queue = new ProtoPriorityQueue<String>();
		queue.insert(3, "3");
		assertEquals("Incorrect object retrieved", "3", queue.min());

		queue.insert(2, "2");
		assertEquals("Incorrect object retrieved", "2", queue.min());

		queue.insert(4, "4");
		assertEquals("Incorrect object retrieved", "2", queue.min());

		queue.insert(1, "1");
		assertEquals("Incorrect object retrieved", "1", queue.min());
	}

	/*
	 * Tests that removing elements correctly updates the size of the queue.
	 */
	public void testRemoveSize() {
		ProtoPriorityQueue<String> queue = new ProtoPriorityQueue<String>();
		assertEquals("Incorrect queue size", 0, queue.size());
		queue.insert(1, "1");
		assertEquals("Incorrect queue size", 1, queue.size());
		queue.insert(2, "2");
		assertEquals("Incorrect queue size", 2, queue.size());
		queue.removeMin();
		assertEquals("Incorrect queue size", 1, queue.size());
		queue.removeMin();
		assertEquals("Incorrect queue size", 0, queue.size());
	}

	/*
	 * Tests that elements added to the queue are removed properly.
	 */
	public void testDequeue3() {
		ProtoPriorityQueue<String> queue = new ProtoPriorityQueue<String>();

		queue.insert(3, "3");
		queue.insert(1, "1");
		queue.insert(4, "4");
		queue.insert(2, "2");

		String one = queue.removeMin();
		assertEquals("Incorrect number retrieved", "1", one);
		String two = queue.removeMin();
		assertEquals("Incorrect number retrieved", "2", two);
		String three = queue.removeMin();
		assertEquals("Incorrect number retrieved", "3", three);
		String four = queue.removeMin();
		assertEquals("Incorrect number retrieved", "4", four);
	}

	/*
	 * Tests that a series of insert/remove operations work.
	 */
	public void testEnqueueDequeue1() {
		ProtoPriorityQueue<String> queue = new ProtoPriorityQueue<String>();

		queue.insert(1, "1");
		queue.insert(4, "4");

		String one = queue.removeMin();
		assertEquals("Incorrect number retrieved", "1", one);
		assertEquals("Incorrect queue size", 1, queue.size());

		queue.insert(3, "3");
		assertEquals("Incorrect queue size", 2, queue.size());
		queue.insert(2, "2");
		assertEquals("Incorrect queue size", 3, queue.size());

		String two = queue.removeMin();
		assertEquals("Incorrect number retrieved", "2", two);
		assertEquals("Incorrect queue size", 2, queue.size());
	}
}
