import java.util.*;
import java.io.*;

class Sort {
  public static void  main(String[] args) {

      int threads = 0;
      int linesPerThread;
      String[] sortList = null;
      Monitor moni = new Monitor();
      int rest;
      int arrDivider = 0;
      Scanner in = null;
      File inFile = null;

      //crating the scanner for the file
      try {
         inFile = new File(args[1]);
         in = new Scanner(inFile);
         sortList = new String[(int)inFile.length()];
      }
      catch(FileNotFoundException e) {
         e.printStackTrace();
      }

      try {
         threads = Integer.parseInt(in.nextLine());
      }
      catch(NumberFormatException e) {
         e.printStackTrace();
      }

      int counter = 0;

      while(in.hasNextLine()) {
         sortList[counter] = in.nextLine();
         counter++;
      }

      linesPerThread = ((int)inFile.length() / threads);
      rest = threads % linesPerThread;

      for ( int i = 0; i < threads; i++) {

         if(rest > 0) {
            new Thread(new OurThread(Arrays.copyOfRange(sortList, arrDivider,
                       arrDivider + linesPerThread + rest), moni)).start();
            arrDivider += linesPerThread + rest;
         }

         else {
            new Thread(new OurThread(Arrays.copyOfRange(sortList, arrDivider,
                       arrDivider + linesPerThread), moni)).start();
            arrDivider += linesPerThread;
         }

         rest--;
      }
   }
}

class OurThread extends Thread {
   String[] arr;
   String[] arr2;
   String[] finalArr;
   Monitor monitor;

   public OurThread(String[] arr, Monitor mon) {
      this.arr = arr;
      monitor = mon;
   }

   @Override
   public void run() {
      arr = monitor.sortArray(arr);
      monitor.finishedThread(arr);

      while(monitor.oneOrLessArr()) {
         try {
         wait();
         }
         catch(Exception e) {}
      }

      arr = monitor.getArrays();
      arr2 = monitor.getArrays();
      mergeSort();
      monitor.finishedThread(finalArr);
   }

   public void mergeSort() {
      finalArr = new String[arr.length + arr2.length];
      int iCounter = 0;
      int jCounter = 0;

      for (int i = 0; i < finalArr.length; i++) {
         if(iCounter >= arr.length) {
            for (int k = jCounter; k < arr2.length; k++) {
               finalArr[i] = arr2[k];
               i++;
            }
         }
         if(jCounter >= arr2.length) {
            for (int l = iCounter; l < arr.length; l++) {
            finalArr[i] = arr[l];
            i++;
            }
         }
         else {
            if((arr[iCounter].compareTo(arr2[jCounter])) < 0) {
            finalArr[i] = arr[iCounter];
            iCounter++;
            }
            else {
            finalArr[i] = arr2[jCounter];
            jCounter++;
            }
         }
      }
   }
}

class Monitor {

   String[] first;
   String[] second;
   String[] finishedArr;
   int nThreads;

   //is called in main, to show how the process is doing
   public synchronized void waitForThreads() {

   }

   //is called in a thread when it's finished, not sure if it works/is finished
   public synchronized void finishedThread(String[] arr) {
      if(first == null) {
         first = arr;
      }
      else if(second == null) {
         second = arr;

      }

      //These if else doesnt work, have to make sure the third thread doesnt try to get both threads
      if(nThreads > 1) {
         System.out.println("A thread has finished, notifying");
         nThreads = 0;
         notify();
      }
      else {
         nThreads++;
         try {
            wait();
         } catch(Exception e) {
            e.printStackTrace();
         }
      }
   }

   public synchronized String[] getArrays() {
      String[] reArr = null;
      if(first != null) {
         reArr = first;
         first = null;
         return reArr;
      }

      else if(second != null) {
         reArr = second;
         second = null;
         return reArr;
      }
      System.out.println("Something has gone wrong, both shouldn't be empty");
      return null;
   }

   public boolean oneOrLessArr() {
      if(first == null) return true;
      else if(second == null) return true;
      return false;
   }

   //Got to fix merge to work without sortArray
   //because it would nullify the entire thread process
   public String[] merge(String[] fir, String[] sec) {

      String[] mergeArr = new String[(fir.length + sec.length)];

      for (int i = 0; i < fir.length; i++) {
         mergeArr[i] = fir[i];
      }

      for (int j = fir.length; j < sec.length; j++) {
         mergeArr[j] = sec[j - fir.length];
      }

      return sortArray(mergeArr);
   }

   public String[] sortArray(String[] arr) {
      String temp;

      while(!isSorted(arr)) {
          for(int i = 0; i < arr.length - 1; i++) {
             if((arr[i].compareTo(arr[i + 1]) > 0)) {
               temp = arr[i];
               arr[i] = arr[i + 1];
               arr[i + 1] = temp;
             }
          }
      }
      return arr;
   }

   public boolean isSorted(String[] arr) {
      for(int i = 0; i < arr.length - 1; i++) {
          if((arr[i].compareTo(arr[i + 1]) > 0)) {
              return false;
          }
      }
      return true;
   }
}
