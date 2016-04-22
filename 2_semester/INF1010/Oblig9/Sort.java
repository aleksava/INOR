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

    //Creating the file and the scanner
    try {
      inFile = new File(args[1]);
      in = new Scanner(inFile);
    }
    catch(FileNotFoundException e) {
      e.printStackTrace();
    }

    //Figuring out how many words there are in the file
    try {
      lines = Integer.parseInt(in.nextLine());
    }
    catch(NumberFormatException e) {
      e.printStackTrace();
    }

    sortList = new String[lines];

    int counter = 0;

    //Reading the file and adding the words to an array while making sure the
    //amount of words doesn't exceed the stated amount of words
    while(in.hasNextLine()) {
      try {
        sortList[counter] = in.nextLine();
        counter++;
      }
      catch(ArrayIndexOutOfBoundsException e) {
        System.out.println("The amount of words in the file doesn't match what the file says");
        e.printStackTrace();
        System.exit(1);
      }
    }

    //Dividing all the words in even groups +-1 based on the amount of threads
    linesPerThread = (lines / threadCounter);
    rest = lines % threadCounter;

    String[] threadArr;

    System.out.println("Starting up all the threads now, please wait");

    for ( int i = 0; i < threadCounter; i++) {
      if((i == threadCounter - 1) && (i != 0)){
        arrDivider--;
      }
      if(rest > 0) {
        threadArr = Arrays.copyOfRange(sortList, arrDivider, arrDivider + linesPerThread + 1);
        new Thread(new OurThread(threadArr, moni)).start();
        arrDivider += linesPerThread + 1;
        rest--;
      }

      else {
        new Thread(new OurThread(Arrays.copyOfRange(sortList, arrDivider,
                    arrDivider + linesPerThread), moni)).start();
        arrDivider += linesPerThread;
      }
    }

    //moni.waitForThreads(threadCounter);
    while(!moni.ready(lines)) {
      //customWait method
    }

    String[] q = moni.getFinalArr();
    /* Printing all the words in sorted order, just before it is added to the new file
    for(String e : q) {
    System.out.println(e);
    }
    System.out.println(q.length);
    */

    //Writing the file with the sorted words
    try {
      PrintWriter outFile = new PrintWriter(new File(args[2]));
      for(String e: q) {
        outFile.println(e);
      }
      outFile.close();
    }
    catch(FileNotFoundException e) {
      e.printStackTrace();
      System.out.println("You need to write the name of the file in the terminal");
    }

    System.out.println("Finished, the words are now sorted in the file named: " + args[2]);
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
    monitor = mon;
  }

  @Override
  public void run() {
    split1 = monitor.sortArray(split1);
    monitor.finishedThread(split1);

    while(!monitor.oneOrLessArr()) {
      twoDArr = monitor.getArrays();
      split1 = twoDArr[0];
      split2 = twoDArr[1];
      try {
        monitor.finishedThread(mergeSort(split1, split2));
        monitor.countThread();
      }
      catch(NullPointerException e) {
        System.out.println("Error: ");
        e.printStackTrace();
        System.exit(1);
      }
    }
  }

  //The method that merges two arrays
  public String[] mergeSort(String[] arr, String[] arr2) {
    String[] finalArr = new String[arr.length + arr2.length];
    int i = 0, j = 0, k = 0;

    while(i < arr.length && j < arr2.length) {
      if(arr[i].compareTo(arr2[j]) < 0) {
        finalArr[k++] = arr[i++];
      }
      else {
        finalArr[k++] = arr2[j++];
      }
    }

    while(i < arr.length) {
      finalArr[k++] = arr[i++];
    }

    while(j < arr2.length) {
      finalArr[k++] = arr2[j++];
    }

    return finalArr;
  }
}

class Monitor {
  String[] first;
  String[] second;
  String[] finishedArr;
  int nThreads;

  //is called in main, to make sure the main thread doesn't finish before all other threads
  //should work, but isn't being used as per 22.04.16
  synchronized void waitForThreads(int counter) {
    while(nThreads < (counter - 1) ) {
      try {
        System.out.println("Waiting for " + (nThreads + 1) + " threads");
        wait();
      }
      catch(InterruptedException e) {
        System.out.println("This thread was interrupted, exiting now...");
        e.printStackTrace();
        System.exit(2);
      }
    }
  }

  //method that keeps count of all the threads that has finished
  public synchronized  void countThread() {
    nThreads++;
    notifyAll();
  }

  //is called in a thread when it's finished sorting an array
  synchronized void finishedThread(String[] arr) {
    boolean yiha = true;
    while(yiha) {
      if(first == null) {
        first = arr;
        notifyAll();
        yiha = false;
      }
      else if(second == null) {
        second = arr;
        notifyAll();
        yiha = false;
      }
      else {
        try {
          wait();
        }
        catch(InterruptedException e) {
          System.out.println("A thread was interrupted, now exiting...");
          e.printStackTrace();
          System.exit(3);
        }
      }
    }
  }

  //Method that returns a 2D array as long as the monitor has two arrays
  synchronized String[][] getArrays() {
    String[][] reArr = new String[2][0];

    if(first != null && second != null) {
      reArr[0] = first;
      reArr[1] = second;
      first = null;
      second = null;
    }
    return reArr;
  }

  //Method that returns whether or not there is one or less arrays in the monitor
  public boolean oneOrLessArr() {
    if(first == null) return true;
    else if(second == null) return true;
    return false;
  }

  //A bubblesort algorithm for sorting the words
  synchronized public String[] sortArray(String[] arr) {
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

  //Checks if the words are in alphabetical order
  public boolean isSorted(String[] arr) {
    for(int i = 0; i < arr.length - 1; i++) {
      if((arr[i].compareTo(arr[i + 1]) > 0)) {
        return false;
      }
    }
    return true;
  }

  //A part of the method to make sure the main method waits
  public synchronized boolean ready(int lines) {
    if(first != null) {
      if(first.length == lines) {
        return true;
      }
    }
    else if(second != null) {
      if(second.length == lines) {
        return true;
      }
    }
    return false;
  }

  //Method that is used to get the final array when all the merging is finished
  public String[] getFinalArr() {
    if(first != null) {
      return first;
    }
    if(second != null) {
      return second;
    }
    else {
      System.out.println("Something went wrong, there aren't any arrays here");
      return null;
    }
  }
}
