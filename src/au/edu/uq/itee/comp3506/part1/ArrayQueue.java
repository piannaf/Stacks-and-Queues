package au.edu.uq.itee.comp3506.part1;

import au.edu.uq.itee.comp3506.adt.EmptyQueueException;
import au.edu.uq.itee.comp3506.adt.FullQueueException;
import au.edu.uq.itee.comp3506.adt.IQueue;

/**
 * Implementation of the queue ADT using a fixed-length array. An exception is
 * thrown if a push operation is attempted when the size of the queue is equal
 * to the length of the array.
 * 
 * - taken and adapted from Goodrich and Tamassia (4th Ed)
 */

public class ArrayQueue<E> implements IQueue<E> {

	/**
	 * Length of the array used to implement the queue.
	 */
	protected int capacity;

	/**
	 * Default array capacity.
	 */
	public static final int CAPACITY = 1000;

	/**
	 * Array used to implement the queue.
	 */
	protected E S[];

	/**
	 * Index of the top element of the queue in the array.
	 */
	protected int end = -1;

	/**
	 * Initializes the queue to use an array of default length.
	 */
	public ArrayQueue() {
		this(CAPACITY);
	}

	/**
	 * Initializes the queue to hold a certain number of elements.
	 * 
	 * @param cap
	 *            capacity of the queue.
	 */
	@SuppressWarnings("unchecked")
	public ArrayQueue(int cap) {
		capacity = cap;
		S = (E[]) new Object[capacity];
	}

	/**
	 * Returns the number of elements in the queue.
	 * 
	 * @return number of elements in the queue.
	 */
	public int size() {
		/*
		 * Existing code: "return end;"
		 * 
		 * Reason for change: The initial state is an empty queue and is
		 * indicated as end = -1 thus 1 must be added to end in order to
		 * indicate the size of the queue.
		 */
		return end + 1;
	}

	/**
	 * Tests whether the queue is empty.
	 * 
	 * @return true if the queue is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return (end < 0);
	}

	/**
	 * Inserts an element at the end of the queue.
	 * 
	 * @return element inserted.
	 * @param element
	 *            element to be inserted.
	 * @exception FullQueueException
	 *                if the array storing the elements is full.
	 */
	public void enqueue(E element) throws FullQueueException {
		if (size() == capacity)
			throw new FullQueueException();
		S[++end] = element;
	}

	/**
	 * Inspects the element at the front of the queue.
	 * 
	 * @return front element in the queue.
	 * @exception EmptyQueueException
	 *                if the queue is empty.
	 */
	public E front() throws EmptyQueueException {
		if (isEmpty())
			/*
			 * Existing code: "throw new FullQueueException();"
			 * 
			 * Reason for change: inspecting the front of the queue should only
			 * fail if there is nothing at the front. This would be an
			 * EmptyQueueException rather than a FullQueueException as was
			 * originally written.
			 */
			throw new EmptyQueueException();
		return S[0];
	}

	/**
	 * Removes the front element from the queue.
	 * 
	 * @return element removed.
	 * @exception EmptyQueueException
	 *                if the queue is empty.
	 */
	public E dequeue() throws EmptyQueueException {
		if (isEmpty())
			throw new EmptyQueueException();
		E element = S[0];
		/*
		 * Existing code: "i < end"
		 * 
		 * Reason for change: This algorithm works by taking an element from the
		 * front of the queue (S[0]) and then moving all of the following
		 * elements forward one place (S[i - 1] = S[i]). The problem with the
		 * code as it had existed is that the last element of the queue is given
		 * by S[end] but the original code had an off-by-one error where i never
		 * reached end and so the final element was never repositioned.
		 * Modifying the conditional to "i <= end" solves this problem.
		 */
		for (int i = 1; i <= end; i++) {
			S[i - 1] = S[i];
		}
		S[end--] = null;
		return element;
	}
}
