import java.util.*;
import java.io.*;

class Sort {
  public static void  main(String[] args) {

      int lines = 0;
      int linesPerThread;
      String[] sortList = null;
      Monitor moni = new Monitor();
      int rest;
      int arrDivider = 0;
      Scanner in = null;
      File inFile = null;
      int threadCounter = Integer.parseInt(args[0]);

      //crating the scanner for the file
      try {
        inFile = new File(args[1]);
        in = new Scanner(inFile);
      }
      catch(FileNotFoundException e) {
        e.printStackTrace();
      }

      try {
        lines = Integer.parseInt(in.nextLine());
      }
      catch(NumberFormatException e) {
        e.printStackTrace();
      }

      sortList = new String[lines];

      int counter = 0;

      while(in.hasNextLine()) {
         sortList[counter] = in.nextLine();
         counter++;
      }

      linesPerThread = (lines / threadCounter);
      rest = lines % threadCounter;

      String[] threadArr;

      for ( int i = 0; i < threadCounter; i++) {

        if((i == threadCounter -1) && (i != 0)){
          arrDivider--;
        }
        //System.out.println(rest + " rest");
         if(rest > 0) {
            threadArr = Arrays.copyOfRange(sortList, arrDivider, arrDivider + linesPerThread + 1);
            new Thread(new OurThread(threadArr, moni)).start();
            //System.out.println("Fra " + arrDivider + " Til: " + (arrDivider + linesPerThread + 1));
            //System.out.println("linesPerThread: " + linesPerThread);
            arrDivider += linesPerThread + 1;
            rest--;
         }

         else {
           //System.out.println("Fra " + arrDivider + " Til: " + (arrDivider + linesPerThread ));
            new Thread(new OurThread(Arrays.copyOfRange(sortList, arrDivider,
                       arrDivider + linesPerThread), moni)).start();
            arrDivider += linesPerThread;
         }
      }

      moni.waitForThreads(threadCounter);
      String[] q = moni.getFinalArr();
      //System.out.println(q + "her er q!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        for(String e : q) {
       System.out.println(e);
   }
      System.out.println(q.length);
      System.out.println("Ferdig");
      System.exit(0);
   }
}

class OurThread extends Thread {
   String[] unMerged;
   String[] unMerged2;
   String[] finalArr;
   Monitor monitor;

   public OurThread(String[] arr, Monitor mon) {
      this.unMerged = arr;
      monitor = mon;
   }

   @Override
   public void run() {
     //System.out.println("Thread id: " + Thread.currentThread().getId());
      unMerged = monitor.sortArray(unMerged);
      //System.out.println(unMerged);
      monitor.finishedThread(unMerged);

      while(monitor.oneOrLessArr()) {
        try {
          wait();
        }
        catch(Exception e) {}
      }

      //System.out.println("woken!!");
      unMerged = monitor.getArrays();
      unMerged2 = monitor.getArrays();

      if(unMerged != null && unMerged2 != null) {
        mergeSort(unMerged, unMerged2);
        monitor.finishedThread(finalArr);
        monitor.countThread();
      }

   }

   public void mergeSort(String[] arr, String[] arr2) {

     //System.out.println("arr " + arr.length);
     //System.out.println("arr2 " + arr.length);
     finalArr = new String[arr.length + arr2.length];

     int i = 0, j = 0, k = 0;

     while(i < arr.length && j < arr2.length) {
       if(arr[i].compareTo(arr2[j]) < 0) {
         finalArr[k] = arr[i];
         k++;
         i++;
       }
       else {
         finalArr[k] = arr2[j];
         k++;
         j++;
       }
     }

     while(i < arr.length) {
       finalArr[k] = arr[i];
       k++;
       i++;
     }

     while(j < arr2.length) {
       finalArr[k] = arr2[j];
       k++;
       j++;
     }

     //System.out.println("ferdig sort!!!: " + Thread.currentThread().getId());
  }
}

class Monitor {

   String[] first;
   String[] second;
   String[] finishedArr;
   int nThreads;

   //is called in main, to show how the process is doing
   synchronized void waitForThreads(int counter) {
     if(counter == 1){
       counter = 2;
     }
      while(nThreads != counter -1 ) {
         try {
            //System.out.println("Waiting for " + nThreads + " threads");
            wait();
         }
         catch(Exception e) {}
      }
   }

   public void countThread() {
     nThreads++;
     //notifyAll();
   }

   //is called in a thread when it's finished, not sure if it works/is finished
   synchronized void finishedThread(String[] arr) {
      if(first == null) {
          //System.out.println("firstArr verdi satt");
         first = arr;
         notifyAll();
      }
      else if(second == null) {
        //System.out.println("secondArr verdi satt");
         second = arr;
         notifyAll();
      }

      /*These if else doesnt work, have to make sure the third thread doesnt try to get both threads
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
      }*/
   }

   synchronized String[] getArrays() {
      String[] reArr = null;
      if(first != null && second != null) {
         reArr = first;
         first = null;
         //System.out.println("got firstArr");
         return reArr;
      }

      else if(second != null) {
         reArr = second;
         second = null;
         //System.out.println("got secondArr");
         return reArr;
      }
      //System.out.println("Something has gone wrong, both shouldn't be empty");
      return null;
   }

   public boolean oneOrLessArr() {
      if(first == null) return true;
      else if(second == null) return true;
      return false;
   }

   public String[] sortArray(String[] arr) {
      String temp;

      while(!isSorted(arr)) {
          for(int i = 0; i < arr.length - 1; i++) {
             if((arr[i
             ].compareTo(arr[i + 1]) > 0)) {
               temp = arr[i];
               arr[i] = arr[i + 1];
               arr[i + 1] = temp;
             }
          }
      }
      for (String s : arr) {
        //System.out.println(s + "\n");
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

   public String[] getFinalArr(){
     if(first != null) {
       return first;
     }
     if(second != null) {
       return second;
     }
     else {
       //System.out.println("noe gikk galt, ingena arrayer her");
       return null;
     }
   }
}
