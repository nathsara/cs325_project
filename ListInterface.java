package folder;


/**
 * Represents list of objects.
 *
 */
public interface ListInterface<T> extends Iterable<T> {
   /**
    * Add the element to the list.
    * @param element the element to be added into the list.
    */
   public void add(T element);

  /**
   * Removes the first occurence of element and returns it if exists. 
   * @return the element to be removed from the list. If the element
   * is not in the list, return null.
   */
   public T remove(T element);

   /**
    * Determines whether or not target is in the list.
    * @return true if target is in the list, false otherwise.
    */
   public boolean contains(T target);

   /**
    * Get the first occurence of element from the list that is equal to 
    * target.
    * @return the first element in the list that is equal to target. If none 
    * returns null.
    */
   public T find(T target);

   /**
    * @return true if the list is empty, false otherwise.
    */
   boolean isEmpty();

   /**
    * @return the number of elements in the list.
    */
   public int size();

   /**
   * Optional
   * @return true if the list is full, false otherwise.
   */
   default boolean isFull() {
      return false;
   }
}
