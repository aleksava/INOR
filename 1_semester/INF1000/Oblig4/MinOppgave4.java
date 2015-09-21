//Create a program, where you would use the infinite improbability drive from the heart of Gold
//You may choose yourself what the improbability factor will produce.

import java.util.Scanner;
import java.io.File;

public class MinOppgave4 {

  public static String improbability(Scanner text, String song) {

    while(text.hasNextLine()){
      song += text.nextLine() + " ";
    }
    return song;
  }

  public static void main(String[] args) throws Exception {

    //Declaring variables
    Scanner text = new Scanner(new File("rickAstley.txt"));
    Scanner input = new Scanner(System.in);
    String bootUp;
    String song = "";

    //Startup interface
    System.out.println("\nWelcome to the Heart of Gold!");
    System.out.println("I'm Eddie, I'll be your computer for this program.");

    while(true) {
      System.out.println("\nWould you like to boot up the infinite improbability drive?");
      bootUp = input.nextLine();
      System.out.println();
      if (bootUp.equals("Yes") || bootUp.equals("y") || bootUp.equals ("yes")) {
        song = improbability(text, song);
        System.out.println(song);
        System.out.println();
      }
      else {
        System.out.println("Very well, I'll go ahead and shut down then, if that's allright. Goodnight :) \n");
        break;
      }
    }
  }
}
