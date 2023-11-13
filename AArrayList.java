package folder;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class AArrayList<T> implements ListInterface<T> {
   protected T[] elements;
   protected int numOfElements;

   public AArrayList() {
      super();
      this.numOfElements = 0;
      elements = alloc(4);
   }
   
   
   protected T[] alloc(int size) {
      T[] newArray = (T[]) new Object[size];
      return newArray;
   }

   @Override
   public void add(T element) {
      if(element == null)
         return;
   
      if (numOfElements >= elements.length)
         expand();

      elements[numOfElements] = element;
      numOfElements++;
   }

   /**
    * double the capacity of the array.
    */ 
   protected void expand() {
      T[] newArray = alloc(elements.length * 2);

      for (int i = 0; i < elements.length; i++)
         newArray[i] = elements[i];

      elements = newArray;
   }

   @Override
   public T remove(T element) {
      int index = findIndex(element);
      T res = null;
      
      if (index >= 0) {
         res = elements[index];
         for (int i = index; i < numOfElements - 1; i++) {
            elements[i] = elements[i + 1];
         }
         
     
         numOfElements--;
         elements[numOfElements] = null;
      }

      return res;
   }

   /**
    * Find the index of the first occurence of element in the list.
    */ 
   protected int findIndex(T element) {
      for (int i = 0; i < numOfElements; i++) {
         if (element.equals(elements[i]))
            return i;
      }

      return -1;
   }

   @Override
   public boolean contains(T element) {
      return findIndex(element) >= 0;
   }

   @Override
   public T find(T element) {
      int index = findIndex(element);
      return index >= 0 ? elements[index] : null;
   }

   @Override
   public boolean isEmpty() {
      return numOfElements == 0;
   }

   @Override
   public int size() {
      return numOfElements;
   }

   /**
    * Altered to be a bounded implementation
    */ 
   @Override
   public boolean isFull() {
      if(numOfElements > 99){
         return true;
      }
      return false;
   }


   public class ArrayListIterator implements Iterator<T> {
         private int pos = -1;

         @Override
         public boolean hasNext() {
            return pos < size() - 1;
         }

         @Override
         public T next() {
            if (hasNext()) {
               pos++;
               return elements[pos];
            } else
               throw new NoSuchElementException();
         }

         @Override
         public void remove() {
            for (int i = pos; i < numOfElements - 1; i++)
               elements[i] = elements[i + 1];

            numOfElements--;
            pos--;
            elements[numOfElements] = null;

         }
   }


   @Override
   public Iterator<T> iterator() {
      return new ArrayListIterator();
   }
}


