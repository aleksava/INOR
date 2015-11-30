import java.util.Scanner;

class RunEspressoMaskin {

  private static void printMenu() {
    System.out.println("\nWhat would you like to do, sir?");
    System.out.println("For an espresso, press 1");
    System.out.println("For a lungo, press 2");
    System.out.println("In order to check the water level, press 3");
    System.out.println("In order to fill the container, press 4");
    System.out.println("If you want me to shut down sir, press 5");
    System.out.print("Your command, sir? ");
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int choice;
    EspressoMaskin nespresso = new EspressoMaskin(500);

    while(true) {
      printMenu();
      choice = Integer.parseInt(input.nextLine());
      System.out.println();

      if(choice == 1) {
        nespresso.lagEspresso();
      }

      else if(choice == 2) {
        nespresso.lagLungo();
      }

      else if(choice == 3) {
        System.out.println("The water level is at: " +
                            nespresso.hentVannmengde() + "ml, sir");
      }

      else if(choice == 4) {
        System.out.println("How much water are you filling me up with, sir?");
        choice = Integer.parseInt(input.nextLine());
        nespresso.fyllVann(choice);
      }

      else if(choice == 5) {
        System.out.println("Alright sir, I will now shut down. Good day!\n");
        break;
      }
    }
  }
}
