package au.edu.uq.itee.comp3506.part1;

import au.edu.uq.itee.comp3506.adt.EmptyStackException;
import au.edu.uq.itee.comp3506.adt.FullStackException;
import au.edu.uq.itee.comp3506.adt.IStack;

/**
 * Implementation of the stack ADT using a fixed-length array. An exception is
 * thrown if a push operation is attempted when the size of the stack is equal
 * to the length of the array.
 * 
 * - taken and adapted from Goodrich and Tamassia (4th Ed)
 */

public class ArrayStack<E> implements IStack<E> {

	/**
	 * Length of the array used to implement the stack.
	 */
	protected int capacity;

	/**
	 * Default array capacity.
	 */
	public static final int CAPACITY = 1000;

	/**
	 * Array used to implement the stack.
	 */
	protected E S[];

	/**
	 * Index of the top element of the stack in the array.
	 */
	protected int top = -1;

	/**
	 * Initializes the stack to use an array of default length.
	 */
	public ArrayStack() {
		this(CAPACITY);
	}

	/**
	 * Initializes the stack to hold a certain number of elements.
	 * 
	 * @param cap
	 *            capacity of the stack.
	 */
	@SuppressWarnings("unchecked")
	public ArrayStack(int cap) {
		capacity = cap;
		S = (E[]) new Object[capacity];
	}

	/**
	 * Returns the number of elements in the stack.
	 * 
	 * @return number of elements in the stack.
	 */
	public int size() {
		return (top + 1);
	}

	/**
	 * Tests whether the stack is empty.
	 * 
	 * @return true if the stack is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return (top < 0);
	}

	/**
	 * Inserts an element at the top of the stack.
	 * 
	 * @return element inserted.
	 * @param element
	 *            element to be inserted.
	 * @exception FullStackException
	 *                if the array storing the elements is full.
	 */
	public void push(E element) throws FullStackException {
		if (size() == capacity)
			throw new FullStackException();
		/*
		 * Existing code: "S[top] = element;"
		 * 
		 * Reason for change: For an empty stack, top is defined as -1. It
		 * follows that to add an element to the stack, we must place it at the
		 * position defined by top + 1. For the stack invariant to hold, top
		 * must also be incremented. Both can be accomplished with ++top.
		 */
		S[++top] = element;
	}

	/**
	 * Inspects the element at the top of the stack.
	 * 
	 * @return top element in the stack.
	 * @exception EmptyStackException
	 *                if the stack is empty.
	 */
	public E top() throws EmptyStackException {
		if (isEmpty())
			throw new EmptyStackException();
		return S[top];
	}

	/**
	 * Removes the top element from the stack.
	 * 
	 * @return element removed.
	 * @exception EmptyStackException
	 *                if the stack is empty.
	 */
	public E pop() throws EmptyStackException {
		if (isEmpty())
			throw new EmptyStackException();
		/*
		 * Existing code: "S[top--] = null; E element = S[top];"
		 * 
		 * Reason for change: It is true that we must set S[top] to null and
		 * then decrement top which is accomplished by " S[top--] = null;" but
		 * by doing this step first, the original code returns the element below
		 * top rather than the top element. Swapping the lines fixes this
		 * problem.
		 */
		E element = S[top];
		S[top--] = null;
		return element;
	}
}
