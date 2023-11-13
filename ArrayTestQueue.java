package cs325;

import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class ArrayTestQueue {
   public static void main(String[] args) {
      int cacheSize = 100;

      // Create an instance of the BoundedArrayQueue with the specified cache size
      BoundedArrayQueue<String> wordCache = new BoundedArrayQueue<>(cacheSize);
      int hits = 0;
      int misses = 0;

      try {   
         File csData = new File("/Users/delaneyflaherty/Downloads/dataset_cs325.txt");
         Scanner scan = new Scanner(csData);
         
         while(scan.hasNext()){
            String[] words = scan.next().split("\\s+");
            for (String word : words) {
               try{
                  if(wordCache.contains(word)) {
                     hits++;
                  }else {
                	  misses++;
                  }
                  wordCache.enqueue(word);
               }catch (QueueOverflowException ex) {
            	   
               }
            }
         }
         scan.close();
      }catch (IOException e) {
    	// Print any IOException that occurs
    	  e.printStackTrace(); 
      }
      // Calculate hit and miss rates
      int total = hits + misses;
      double hitRate = (double) hits / total;
      double missRate = (double) misses / total;

      System.out.println("Hit Rate: " + hitRate);
      System.out.println("Miss Rate: " + missRate);
   }
}