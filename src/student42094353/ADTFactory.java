package student42094353;

import au.edu.uq.itee.comp3506.adt.IADTFactory;
import au.edu.uq.itee.comp3506.adt.IPriorityQueue;
import au.edu.uq.itee.comp3506.adt.IQueue;
import au.edu.uq.itee.comp3506.adt.IStack;
import au.edu.uq.itee.comp3506.adt.NoSuchElementException;
import au.edu.uq.itee.comp3506.part1.ArrayQueue;
import au.edu.uq.itee.comp3506.part1.ArrayStack;

public class ADTFactory<E> implements IADTFactory<E> {
	/**
	 * Return an implementation of the Queue ADT.
	 * 
	 * If type is an empty string return a default implementation. If an
	 * unsupported type is requested throw a NoSuchElementException.
	 */
	public IQueue<E> createQueue(String type) throws NoSuchElementException {
		if (type.equals("ArrayQueue"))
			return new ArrayQueue<E>();
		else if (type.equals("ListQueue"))
			return new ListQueue<E>();
		else if (type.equals(""))
			return new ListQueue<E>();
		else
			throw new NoSuchElementException();
	}

	/**
	 * Return an implementation of the Stack ADT.
	 * 
	 * If type is an empty string return a default implementation. If an
	 * unsupported type is requested throw a NoSuchElementException.
	 */
	public IStack<E> createStack(String type) throws NoSuchElementException {
		if (type.equals("ArrayStack"))
			return new ArrayStack<E>();
		else if (type.equals("ListStack"))
			return new ListStack<E>();
		else if (type.equals(""))
			return new ListStack<E>();
		else
			throw new NoSuchElementException();
	}

	/**
	 * Return an implementation of the PriorityQueue ADT.
	 * 
	 * If type is an empty string return a default implementation. If an
	 * unsupported type is requested throw a NoSuchElementException.
	 */
	public IPriorityQueue<E> createPriorityQueue(String type)
			throws NoSuchElementException {
		if (type.equals("ProtoPriorityQueue"))
			return new ProtoPriorityQueue<E>();
		else if (type.equals(""))
			return new ProtoPriorityQueue<E>();
		else
			throw new NoSuchElementException();

	}

}
