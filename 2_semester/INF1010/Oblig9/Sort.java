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
            //System.out.println("Fra " + arrDivider + " Til: " + (arrDivider + linesPerThread + 1));
            threadArr = Arrays.copyOfRange(sortList, arrDivider, arrDivider + linesPerThread + 1);
            new Thread(new OurThread(threadArr, moni)).start();
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
      //System.out.println(sortList[sortList.length - 1]);

      //moni.waitForThreads(threadCounter);
      while(!moni.ready(lines)) {
        //wait
      }

      String[] q = moni.getFinalArr();

      for(String e : q) {
        System.out.println(e);
      }
      System.out.println(q.length);
      System.out.println("Ferdig");

      try {
        PrintWriter outFile = new PrintWriter(new File(args[2]));
        for(String e: q) {
          outFile.println(e);
        }
        outFile.close();
      }
        catch(FileNotFoundException e) {
          System.out.println("You need to write the name of the file in the terminal");
        }

      System.exit(0);
   }
}

class OurThread extends Thread {
   String[][] twoDArr;
   String[] split1;
   String[] split2;
   Monitor monitor;

   public OurThread(String[] arr, Monitor mon) {
      this.split1 = arr;
      //System.out.println("Split1: " + split1.length);
      monitor = mon;
   }

   @Override
   public void run() {
     System.out.println("Thread id: " + Thread.currentThread().getId());
     //for (String s : split1) {
       //System.out.println("String s: " + s + ", " + Thread.currentThread().getId());
     //}
      split1 = monitor.sortArray(split1);
      //System.out.println(unMerged);
      monitor.finishedThread(split1);
      System.out.println("Ferdig sortert og levert: " + Thread.currentThread().getId());

      /*while(monitor.oneOrLessArr()) {
        try {
          wait();
        }
        catch(Exception e) {}
      }*/

      //System.out.println("woken!!");
      //System.out.println("Hey ho, before any waits()");

      //System.out.println("Final spot in split2: " + split2[split2.length - 1]);
      //System.out.println("Length of split1: " + split1.length);
      //System.out.println("Length of split2: " + split2.length);
      /*if(split1[split1.length - 1] == null) {
        System.out.println("Definatly not in split1 if");
        split1 = Arrays.copyOf(split1, split1.length - 2);
      }
      if(split2[split2.length - 1] == null) {
        System.out.println("Definatly not in split2 if");
        split2 = Arrays.copyOf(split2, split2.length - 2);
      }*/

      //System.out.println("Hey ho, before notifyAll()");
      //notifyAll();

      //if(unMerged != null && unMerged2 != null) {

      while(!monitor.oneOrLessArr()) {
        twoDArr = monitor.getArrays();
        split1 = twoDArr[0];
        split2 = twoDArr[1];
        try {
          //System.out.println("heiho, for kallet av mergeSort()");
          monitor.finishedThread(mergeSort(split1, split2));
          System.out.println("Merged ID: " + Thread.currentThread().getId());
          monitor.countThread();
        }
        catch(NullPointerException e) {
          System.out.println("Error: ");
          e.printStackTrace();
          System.exit(1);
        }
      }
      System.out.println("Nå døyr eg: " + Thread.currentThread().getId());
   }

   public String[] mergeSort(String[] arr, String[] arr2) {

     //System.out.println("arr " + arr.length);
     //System.out.println("arr2 " + arr.length);
     //System.out.println("Index 0 arr2: " + arr2[0]);
     String[] finalArr = new String[arr.length + arr2.length];

     /*for(String s: arr2) {
       System.out.println(s);
     }*/

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

     return finalArr;

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

      while(nThreads < (counter - 1) ) {
         try {
            System.out.println("Waiting for " + (nThreads + 1) + " threads");
            wait();
         }
         catch(Exception e) {}
      }
   }

   public synchronized  void countThread() {
     nThreads++;
     notifyAll();
   }

   //is called in a thread when it's finished, not sure if it works/is finished
   synchronized void finishedThread(String[] arr) {
     while(true) {
       if(first == null) {
         //System.out.println("firstArr verdi satt: " + arr);
         first = arr;
         notifyAll();
         break;
       }
       else if(second == null) {
         //System.out.println("secondArr verdi satt");
         second = arr;
         notifyAll();
         break;
       }
       else {
         try {
           wait();
         } catch(Exception e) {}
       }
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

   synchronized String[][] getArrays() {
      String[][] reArr = new String[2][0];

      /*while(second == null) {
        try {
          //System.out.println("The eternal wait in getArrays()");
          //System.out.println("First: " + first);
          //System.out.println("Second: " + second);
          //wait();
        }
        catch(InterruptedException e) { System.exit(1); }
      }*/
      if(first != null && second != null) {
        reArr[0] = first;
        reArr[1] = second;
        first = null;
        second = null;
      }
      return reArr;
      //System.out.println("Something has gone wrong, both shouldn't be empty");
   }

   public boolean oneOrLessArr() {
      if(first == null) return true;
      else if(second == null) return true;
      return false;
   }

   synchronized public String[] sortArray(String[] arr) {
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

   public synchronized boolean ready(int lines) {
      if(first != null) {
        //System.out.println(first.length + " first lengde");
        if(first.length == lines) {
          System.out.println("first");
          return true;
        }
      }
     else if(second != null) {
       if(second.length == lines) {
         System.out.println("second");
         return true;
       }
     }
     return false;
   }

   public String[] getFinalArr(){
     if(first != null) {
       return first;
     }
     if(second != null) {
       return second;
     }
     else {
       System.out.println("noe gikk galt, ingena arrayer her");
       return null;
     }
   }
}
