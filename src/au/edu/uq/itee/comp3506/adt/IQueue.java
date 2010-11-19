package au.edu.uq.itee.comp3506.adt;

/**
 * Interface for a queue: a collection of elements that are inserted and removed
 * according to the first-in first-out principle.
 * 
 * - taken and adapted from Goodrich and Tamassia (5th Ed)
 * 
 * @param <E>, the type of the objects to be stored on the stack.
 */

public interface IQueue<E> {
	/**
	 * Inserts an element at the rear of the queue.
	 * 
	 * @param element
	 *            new element to be inserted.
	 */
	public void enqueue(E element);

	/**
	 * Removes and returns the element at the front of the queue.
	 * 
	 * @return element removed.
	 * @throws EmptyQueueException
	 *             if the queue is empty.
	 */
	public E dequeue() throws EmptyQueueException;

	/**
	 * Inspects the element at the front of the queue.
	 * 
	 * @return element at the front of the queue.
	 * @throws EmptyQueueException
	 *             if the queue is empty.
	 */
	public E front() throws EmptyQueueException;

	/**
	 * Returns the number of elements in the queue.
	 * 
	 * @return number of elements in the queue.
	 */
	public int size();

	/**
	 * Returns whether the queue is empty.
	 * 
	 * @return true if the queue is empty; false otherwise.
	 */
	public boolean isEmpty();
}