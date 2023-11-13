package cs325;

import java.util.NoSuchElementException;

/**
 * Represents a First-in-first-out (FIFO) queue of objects.
 *
 */
public interface QueueInterface<T> {
	void enqueue(T element) throws QueueOverflowException;
	
	  /**
    * Removes the head element and returns it if the queue is not empty. 
    * @return the head if the queue is not empty.
    * @throws NoSuchElementException when the queue is empty.
    */
	T dequeue() throws NoSuchElementException;
	
	/**
    * Optional
    * @return true if the quueue is full, false otherwise.
    */
	default boolean isFull() {
	   return false;
	}
	
   /**
    * @return true if the queue is empty, false otherwise.
    */	
	boolean isEmpty();
	
	/**
    * @return the number of elements in the queue.
    */
	int size();
	
}
