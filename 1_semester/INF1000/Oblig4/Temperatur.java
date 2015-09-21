import java.util.Scanner;
import java.io.File;

public class Temperatur {

  public static int averageTemp(int temperature []) {
    int sum = 0;
    for(int i = 0; i < temperature.length; i++) {
      sum += temperature[i];
    }
    int average = sum/temperature.length;
    return average;
  }

  public static void main(String[] args) throws Exception {

    //User interface
    System.out.println("\nBefore we start, make sure you have the file 'temperatur.txt' downloaded :)");

    //Declaring array, file and scanner. Also formatting
    System.out.println();
    int temperature [] = new int [12];
    int i = 0;
    int average;
    Scanner tempScan = new Scanner(new File ("temperatur.txt"));

    //Putting the data into an array
    while(tempScan.hasNextLine()) {
      temperature[i] = Integer.parseInt(tempScan.nextLine());
      i ++;
    }

    //Printing the array, just for good measure
    System.out.println("The average temperatures each month last year were, respectively: ");
    for(i = 0; i < temperature.length; i++) {
      System.out.print(temperature[i] + " ");
    }

    //Formatting
    System.out.println("\n");

    //Calling method
    average = averageTemp(temperature);
    System.out.println("The average temperature last year was " + average + " degrees\n");
  }
}
