package au.edu.uq.itee.comp3506.adt;

/**
 * An Abstract Factory Class provides a mechanism to return concrete
 * implementations of Abstract Data Types (ADTs).
 * 
 * NOTE: The following is a description of potential functionality. You are
 * *not* expected to implement reflection-based methods.
 * 
 * If an implementation is stored in a Java Jar-file on the Java Classpath, an
 * instance of the implementation can be retrieved by using the Class.forName
 * static method and the Class.newInstance instance method.
 * 
 * Class<?> cls = Class.forName( "studentyourstudentnumber.ADTFactory" );
 * IADTFactory<?> adt_factory = (IADTFactory<?>) cls.newInstance();
 * IVector<String> vect = (IVector<String>) adt_factory.createVector( "" );
 * 
 * Thus the use of an ADTFactory class allows later ADTs to be used by existing,
 * pre-compiled software.
 */
public interface IADTFactory<E> {

	/**
	 * Return an implementation of the Queue ADT.
	 * 
	 * If type is an empty string return a default implementation. If an
	 * unsupported type is requested throw a NoSuchElementException.
	 */
	public IQueue<E> createQueue(String type) throws NoSuchElementException;

	/**
	 * Return an implementation of the Stack ADT.
	 * 
	 * If type is an empty string return a default implementation. If an
	 * unsupported type is requested throw a NoSuchElementException.
	 */
	public IStack<E> createStack(String type) throws NoSuchElementException;

	/**
	 * Return an implementation of the PriorityQueue ADT.
	 * 
	 * If type is an empty string return a default implementation. If an
	 * unsupported type is requested throw a NoSuchElementException.
	 */
	public IPriorityQueue<E> createPriorityQueue(String type)
			throws NoSuchElementException;
}
