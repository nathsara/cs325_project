package cs325;

import java.util.NoSuchElementException;

public class BoundedArrayQueue<T> implements QueueInterface<T> {
   protected final static int DEFAULT_CAPACITY = 100;

   protected T[] elements;
   protected int rear, front;
   protected int numOfElements;

   public BoundedArrayQueue(int size) {
      super();
      if (size < DEFAULT_CAPACITY)
         size = DEFAULT_CAPACITY;

      numOfElements = 0;
      this.elements = (T[]) new Object[size];
      rear = elements.length - 1;
      front = 0;
   }

   public BoundedArrayQueue() {
      this(DEFAULT_CAPACITY);
   }

   /**
    * Put the element at the rear of the queue if it is not full.
    * Throws QueueOverflowException if the queue is full.
    */
   @Override
   public void enqueue(T element) throws QueueOverflowException {
      if (!isFull()) {
         rear = (rear + 1) % elements.length;
         elements[rear] = element;
         numOfElements++;
      } else {
         throw new QueueOverflowException("full");
      }
   }

   /**
    * Returns the element at front if exists.
    * Throws NoSuchElementException otherwise.
    */
   @Override
   public T dequeue() throws NoSuchElementException {
      if (!isEmpty()) {
         T res = elements[front];
         elements[front] = null;
         front = (front + 1) % elements.length;
         numOfElements--;
         return res;
      } else
         throw new NoSuchElementException();

   }

   @Override
   public boolean isFull() {
      return numOfElements == elements.length;
   }

   @Override
   public boolean isEmpty() {
      return numOfElements == 0;
   }

   @Override
   public int size() {
      return numOfElements;
   }
   public boolean contains(T element) {
        for (int i = 0; i < numOfElements; i++) {
            if (elements[(front + i) % elements.length].equals(element)) {
                return true;
            }
        }
        return false;
    }

   public void addToCache(String word) {
      // Remove the oldest word when the cache is full
      if (numOfElements == elements.length) {
         dequeue();
      }
      // Add the new word to the end of the queue
      enqueue((T) word);
   }
}
