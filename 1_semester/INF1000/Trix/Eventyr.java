import java.util.Scanner;

class Eventyr {
  public static void main(String[] args) {
    MagiskSkip theFlyingDutchman = new MagiskSkip();
    Scanner input = new Scanner(System.in);
    String ability;

    for(int i = 0; i < 7; i++) {
      System.out.println("\nWhat ability does this helper have?");
      ability = input.nextLine();
      theFlyingDutchman.pickUpNewHelper(new GodHjelper(ability));
      System.out.println("Done with helper number " + (i + 1));
    }
    System.out.println();
  }
}
