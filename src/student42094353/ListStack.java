package student42094353;

import au.edu.uq.itee.comp3506.adt.EmptyStackException;
import au.edu.uq.itee.comp3506.adt.IStack;

/**
 * Implementation of the stack ADT using a singly linked list.
 */
public class ListStack<E> implements IStack<E> {
	private ListNode<E> header;
	private int size;

	/**
	 * Initializes an empty stack
	 */
	public ListStack() {
		header = null;
		size = 0;
	}

	/**
	 * Places the passed element on the top of the stack.
	 * 
	 * @param element
	 *            element to be inserted.
	 */
	public void push(E element) {
		/* Create a new node */
		ListNode<E> newNode = new ListNode<E>(element);

		if (!isEmpty()) {
			/*
			 * There's already something at the top of the stack so we need our
			 * new node to point to it since the new node will replace it
			 */
			newNode.next = header;
		}

		/* Let the new node be on top */
		header = newNode;

		/* There is another element on the stack */
		size++;
	}

	/**
	 * Removes and returns the top element of the stack.
	 * 
	 * @return the removed element.
	 * @throws EmptyStackException
	 *             if the stack is empty.
	 */
	public E pop() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException();
		} else {
			/* Take note of the top element */
			E topElement = header.element;

			/* Set header to the next node */
			header = header.next;

			/* There is one less element on the stack */
			size--;

			/* Return the expected top element */
			return topElement;
		}
	}

	/**
	 * Inspects the element at the top of the stack.
	 * 
	 * @return the top element of the stack.
	 * @throws EmptyStackException
	 *             if the stack is empty.
	 */
	public E top() throws EmptyStackException {
		if (isEmpty())
			throw new EmptyStackException();
		else
			return header.element;
	}

	/**
	 * Returns the number of elements in the stack
	 * 
	 * @return number of elements in the stack.
	 */
	public int size() {
		return size;
	}

	/**
	 * Returns whether the stack is empty
	 * 
	 * @return true if the stack is empty; false otherwise.
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * This implements a node for a singly linked list which is perfect for a
	 * stack.
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
