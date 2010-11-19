package student42094353;

import au.edu.uq.itee.comp3506.adt.IPriorityQueue;
import au.edu.uq.itee.comp3506.adt.NoSuchElementException;

/**
 * Implementation of the priority queue ADT using a doubly linked list.
 * 
 * Elements are inserted into the queue such that the queue is always in sorted
 * order.
 */
public class ProtoPriorityQueue<E> implements IPriorityQueue<E> {
	private ListNode<E> header;
	private ListNode<E> trailer;
	private int size;

	/**
	 * Initializes an empty queue
	 */
	public ProtoPriorityQueue() {
		header = trailer = null;
		size = 0;
	}

	/**
	 * Returns the number of items in the priority queue.
	 * 
	 * @return number of elements in the queue.
	 */
	public int size() {
		return size;
	}

	/**
	 * Returns whether the priority queue is empty.
	 * 
	 * @return true if the queue is empty; false otherwise.
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Returns but does not remove an entry with minimum key.
	 * 
	 * @return entry associated with minimum key.
	 * @throws NoSuchElementException
	 *             if the queue is empty.
	 */
	public E min() throws NoSuchElementException {
		if (isEmpty())
			throw new NoSuchElementException();
		else
			return header.value;
	}

	/**
	 * Inserts a key-value pair and return the entry created.
	 * 
	 * @return the entry created
	 */
	public E insert(int key, E value) {
		/* Create new node */
		ListNode<E> newNode = new ListNode<E>(key, value);

		if (isEmpty()) {
			/* newNode will be the only node so it is both first and last */
			header = trailer = newNode;
		} else {
			ListNode<E> currentNode = header;

			/* Find where to put newNode in the queue */
			while (currentNode != null && currentNode.key <= newNode.key) {
				/* Traverse the list */
				currentNode = currentNode.next;
			}

			if (currentNode == null) { // newNode will be last
				/* Set newNode to point to last node */
				newNode.previous = trailer;

				/* Set last node to point to newNode */
				trailer.next = newNode;

				/* Set trailer to point to newNode */
				trailer = newNode;
			} else if (currentNode.previous == null) { // newNode will be first

				/* Set newNode to point to first node */
				newNode.next = currentNode;

				/* Set first node to point to newNode */
				currentNode.previous = newNode;

				/* Set header to point to newNode */
				header = newNode;
			} else { // newNode will be in the middle
				/* Set newNode to point to the next node */
				newNode.next = currentNode;

				/* Set newNode to point to the previous node */
				newNode.previous = currentNode.previous;

				/* Set previous node to point to newNode */
				currentNode.previous.next = newNode;

				/* Set next node to point to newNode */
				currentNode.previous = newNode;
			}
		}

		/* There is another element in the queue */
		size++;

		return value;
	}

	/**
	 * Removes and returns an entry with minimum key.
	 * 
	 * @return entry associated with minimum key.
	 * @throws NoSuchElementException
	 *             if the queue is empty.
	 */
	public E removeMin() throws NoSuchElementException {
		if (isEmpty())
			throw new NoSuchElementException();
		else {
			/* Take note of the entry with minimum key */
			E minimumEntry = header.value;

			/* Set header to next node */
			header = header.next;

			/* Enforce header has no previous node */
			if (header != null)
				header.previous = null;

			/* There is one less element in the queue */
			size--;

			/* Return the expected entry with minimum key */
			return minimumEntry;
		}
	}

	/**
	 * This implements a node for a doubly linked list which is well-suited for
	 * a naive priority queue.
	 * 
	 * @param <T>
	 *            the type of element stored in the node
	 */
	private class ListNode<T> {
		ListNode<T> next;
		ListNode<T> previous;
		int key;
		T value;

		ListNode(int key, T value) {
			this.key = key;
			this.value = value;
		}
	}

	@Override
	public String toString() {
		String str = "";

		ListNode<E> currentNode = header;
		while (currentNode != null && currentNode.next != null) {
			str += currentNode.value.toString() + ",";
			currentNode = currentNode.next;
		}
		if (currentNode != null)
			str += currentNode.value.toString();

		return "ProtoPriorityQueue [" + str + "]";
	}

}
