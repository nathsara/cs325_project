package cs325;

import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;

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

          //list to store all words from file
         List<String> allWords = new ArrayList<>();
         
         //reads words from file and adds them to list
         while(scan.hasNext()){
            String[] words = scan.next().split("\\s+");
            for (String word : words) {
               allWords.add(word);
            }
         }
         scan.close();
         
         int totalWords = allWords.size();
         
         //iterating for random pattern
         for (int i = 0; i < 750; i++) {
        	   int random = (int)(Math.random() * totalWords);
        	   String word = allWords.get(random);
             //checking if word is already in cache 
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
