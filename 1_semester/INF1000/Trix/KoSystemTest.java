import java.util.Scanner;

class KoSystemTest {

  public static void printMenu() {
    System.out.println("-- Menu for the KoSystem --");
    System.out.println("Press 1 for new queue number");
    System.out.println("Press 2 to serve a customer");
    System.out.println("Press 3 to print the queue");
    System.out.println("Press 4 to exit");
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    KoSystem koSystem = new KoSystem();
    int choice = 0;

    while(choice != 4) {
      printMenu();
      choice = Integer.parseInt(input.nextLine());

      if(choice == 1) {
        koSystem.trekkKoLapp();
      }
      else if(choice == 2) {
        koSystem.betjenKunde();
      }
      else if(choice == 3) {
        koSystem.printKunderIKo();
      }
      else if(choice == 4) {
        System.out.println("Shutting down.");
      }
      else {
        System.out.println("Error: Invalid input");
      }
    }
  }
}
