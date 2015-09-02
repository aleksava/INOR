import java.util.Scanner;
public class Metoder {
  //Method created to take name and origin of user and print this
  static void nameAndOrigin() {
    Scanner input = new Scanner(System.in);
    System.out.println("\nType in your name:");
    String name = input.nextLine();
    System.out.println("Type in your place of origin:");
    String home = input.nextLine();
    System.out.println("Hi, " + name + "! You're from " + home);
  }
  public static void main(String[] args) {

    nameAndOrigin();
    nameAndOrigin();
    nameAndOrigin();
    //Formatting in the terminal
    System.out.println("\n");
  }
}
