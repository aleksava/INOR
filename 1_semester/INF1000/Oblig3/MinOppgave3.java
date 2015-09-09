//Oppgavetekst:
//Du skal lage en såkalt 'fill in the blanks' historie, den skal inneholde flere
//forskjelige adjektiver, verb, substantiv osv.Du kan finne selve historien på
//internett. Adjektivene o.l. skal taes inn fra bruker.

import java.util.Scanner;
public class MinOppgave3 {
  public static void main(String[] args) {

    //Declaring arrays and variables
    Scanner input = new Scanner(System.in);
    String [] adjectives = new String [2];
    String [] nouns = new String [5];
    String [] numbers = new String [2];
    String [] colours = new String [2];
    String [] animals = new String [2];
    String verb;
    int counter = 0;

    //Taking in a verb
    System.out.println("\nPlease type in a verb: ");
    verb = input.nextLine();

    //Taking in adjectives
    counter = 0;
    System.out.println("\nPlease type in two adjectives: ");
    while (counter < adjectives.length) {
      adjectives[counter] = input.nextLine();
      counter ++;
    }

    //Taking in nouns
    counter = 0;
    System.out.println("\nPlease type in five nouns: ");
    while (counter < nouns.length) {
      nouns[counter] = input.nextLine();
      counter ++;
    }

    //Taking in numbers
    counter = 0;
    System.out.println("\nPlease type in two numbers: ");
    while (counter < numbers.length) {
      numbers[counter] = input.nextLine();
      counter ++;
    }

    //Taking in colours
    counter = 0;
    System.out.println("\nPlease type in two colours: ");
    while (counter < colours.length) {
      colours[counter] = input.nextLine();
      counter ++;
    }

    //Taking in animals
    counter = 0;
    System.out.println("\nPlease type in two animals: ");
    while (counter < animals.length) {
      animals[counter] = input.nextLine();
      counter ++;
    }

    //Writing out the story
    System.out.print("\nMy dog Spark is a very " + adjectives[0] + " dog.");
    System.out.print(" He is " + colours[0] + " and " + colours[1] + " with a very ");
    System.out.print(adjectives[1] + " tail. I have had Spark since I was ");
    System.out.print(numbers[0] + " years old, for almost " + numbers[1] + " years! ");
    System.out.print("We have had a " + animals[0] + " and a " + animals[1] + ", ");
    System.out.print("but he is my favorite pet. Spark loves to " + verb + " ");
    System.out.print("outside and play in the " + nouns[0] + ". He likes to play ");
    System.out.print("fetch with a " + nouns[1] + " and roll around in the ");
    System.out.print(nouns[2] + ". My favorite place to take him is the " + nouns[3]);
    System.out.print(" where he runs around and makes friends with the other dogs. ");
    System.out.print("Everyone in my family loves having a dog; Spark has been a great ");
    System.out.println(nouns[4] + ". I don't think we could ever replace him!\n");
  }
}
