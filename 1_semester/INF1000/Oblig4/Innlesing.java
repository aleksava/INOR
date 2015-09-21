import java.util.Scanner;
import java.io.File;
public class Innlesing {
  public static void main(String[] args) throws Exception {

    //'User interface'
    System.out.println("\nBefore we start, make sure you've got the file winnie.txt downloaded :)\n");

    //Declaring scanner, file and variables
    File winnie = new File("winnie.txt");
    Scanner story = new Scanner(winnie);
    String text = "";
    int countingWords = 0;
    String word = "";

    while(story.hasNextLine()) {
      text += story.nextLine();
    }

    //Have to redeclare file, and scanner in order
    //to read through the file again
    winnie = new File("winnie.txt");
    story = new Scanner(winnie);

    //Created a loop which counts almost all the variations of 'Winnie-the-Pooh'
    while(story.hasNextLine()) {
      word = story.nextLine();
      if(word.equals ("Winnie-the-Pooh") || word.equals ("Winnie-the-Pooh.") || word.equals ("WINNIE-THE-POOH")) {
        countingWords ++;
      }
    }

    //Printing out the amount of times it appears in the text
    System.out.println("'Winnie-the-Pooh' appears " + countingWords + " times in the story\n");

    //Letting the user controll which word to look for
    winnie = new File("winnie.txt");
    story = new Scanner(winnie);
    System.out.println("Which word would you like to look for in the story?");
    Scanner input = new Scanner(System.in);
    String choice = input.nextLine();

    countingWords = 0;
    while(story.hasNextLine()) {
      word = story.nextLine();
      if(word.equals (choice)) {
        countingWords ++;
      }
    }
    System.out.println("'" + choice + "'" + " appears " + " " + countingWords + " times in the story\n");
  }
}
