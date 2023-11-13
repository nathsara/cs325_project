package folder;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class LastInFirstOut {

//Simulation of the "Last In, First Out" replacement policy under the Lazy Caching (or Cache Aside) system.
//Cache Aside means that new data will be inserted into the cache if it is encountered and not already in the cache.
//Last-In-First-Out means that the most recently added data entry will be removed to make room for the next entry if the cache is full.


   public static void main(String[] args) throws FileNotFoundException {
      //to simulate a user accessing random data, we feed the program a large text file
      Scanner input = new Scanner(new File("C:\\Users\\rally\\.vscode\\CODESTUFF\\folder\\dataset_cs325.txt"));
      //                                   ^replace this file destination with text file of choice^
      
      
      AArrayList<String> cache = new AArrayList<String>();
      //cache maxes out at 100

      int hitCount = 0;
      int missCount = 0;
      String recent = "";//last item added into the cache

      while(input.hasNext()) {//reads next item from dataset
         String current = input.next();//the next item in dataset

         if(cache.contains(current)){//if the cache has the item, cache hit is recorded and program continues reading
            hitCount++;
            System.out.println("Cache Hit --- Element found in cache");
         }else{
            if(cache.isFull()){//if cache does not have item and is full, latest cache item is replaced by it
               cache.remove(recent);
               cache.add(current);
               recent = current;
               System.out.println("Cache Miss --- Element not in cache");
               System.out.println("Cache Full --- Replacing latest entry");
               missCount++;

            }else{//if cache does not have item and is not full, item is added
               cache.add(current);
               recent = current;
               System.out.println("Cache Miss --- Element not in cache");
               missCount++;
            }
         }
      }
      int cacheAccess = hitCount + missCount; //total checks in cache

      float hitRate = 100*((float)hitCount / cacheAccess); //percentage of instances where the cache had the item

      //End result printout
      System.out.println("Caching simulation finished");
      System.out.println("");
      System.out.println("Total cache checks: ");
      System.out.print(cacheAccess);
      System.out.println("");
      System.out.println("Total cache hits: ");
      System.out.print(hitCount);
      System.out.println("");
      System.out.println("Total cache misses: ");
      System.out.print(missCount);
      System.out.println("");
      System.out.println("");
      System.out.println("Simulated cache hitrate for Last-In-First-Out: ");
      System.out.printf("%.2f", hitRate);
      System.out.print("%");
      System.out.println("");
      



      
   }
}
