package au.edu.uq.itee.comp3506.adt;

/** Interface for the priority queue ADT
 *
 * - taken and adapted from Goodrich and Tamassia (5th Ed)
 */
public interface IPriorityQueue<E> {
	/**
	 * Returns the number of items in the priority queue. 
	 */
	public int size();

	/**
	 * Returns whether the priority queue is empty.
	 * 
	 */
	public boolean isEmpty();

	/**
	 * Returns but does not remove an entry with minimum key.
	 */
	public E min() throws NoSuchElementException;

	/**
	 * Inserts a key-value pair and return the entry created.
	 */
	public E insert(int key, E value);

	/**
	 * Removes and returns an entry with minimum key.
	 */
	public E removeMin() throws NoSuchElementException;
}