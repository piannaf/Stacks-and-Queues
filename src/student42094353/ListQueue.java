/**
 * 
 */
package student42094353;

import au.edu.uq.itee.comp3506.adt.EmptyQueueException;
import au.edu.uq.itee.comp3506.adt.IQueue;

/**
 * Implementation of the queue ADT using a double linked list.
 */
public class ListQueue<E> implements IQueue<E> {
	private ListNode<E> header;
	private ListNode<E> trailer;
	private int size;

	/**
	 * Initializes an empty queue
	 */
	public ListQueue() {
		header = trailer = null;
		size = 0;
	}

	/**
	 * Inserts an element at the rear of the queue.
	 * 
	 * @param element
	 *            new element to be inserted.
	 */
	public void enqueue(E element) {
		/* Create a new node */
		ListNode<E> newNode = new ListNode<E>(element);

		if (!isEmpty()) {
			/* Set current trailer to point to the newNode */
			trailer.next = newNode;

			/* Set current trailer to be the newNode */
			trailer = newNode;
		} else {
			/* newNode will be the only node so it is both first and last */
			header = trailer = newNode;
		}

		/* There is another element in the queue */
		size++;
	}

	/**
	 * Removes and returns the element at the front of the queue.
	 * 
	 * @return element removed.
	 * @throws EmptyQueueException
	 *             if the queue is empty.
	 */
	public E dequeue() throws EmptyQueueException {
		if (isEmpty())
			throw new EmptyQueueException();
		else {
			/* Take note of the front element */
			E frontElement = header.element;

			/* Set header to next node */
			header = header.next;

			/* There is one less element in the queue */
			size--;

			/* Return the expected front element */
			return frontElement;
		}
	}

	/**
	 * Inspects the element at the front of the queue.
	 * 
	 * @return element at the front of the queue.
	 * @throws EmptyQueueException
	 *             if the queue is empty.
	 */
	public E front() throws EmptyQueueException {
		if (isEmpty())
			throw new EmptyQueueException();
		else
			return header.element;
	}

	/**
	 * Returns the number of elements in the queue.
	 * 
	 * @return number of elements in the queue.
	 */
	public int size() {
		return size;
	}

	/**
	 * Returns whether the queue is empty.
	 * 
	 * @return true if the queue is empty; false otherwise.
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * This implements a node for a singly linked list which is perfect for a
	 * queue if we keep track of the trailing node.
	 * 
	 * @param <T>
	 *            the type of element stored in the node
	 */
	private class ListNode<T> {
		ListNode<T> next;
		T element;

		ListNode(T element) {
			this.element = element;
		}
	}

}
