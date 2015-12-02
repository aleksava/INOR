import java.util.Scanner;
import java.io.File;

class Gruppemoete {
  private String[] navn = new String[14];
  private boolean[] oppmoete = new boolean[14];
  private String svegg;

  public Gruppemoete() {
    svegg = "balle";
  }

  public void readFile(String text) throws Exception {
    Scanner file = new Scanner(new File(text));
    int counter = 0;

    while(file.hasNextLine()) {
      navn[counter] = file.nextLine();
      counter ++;
    }
  }

  public void attendance() {
    Scanner input = new Scanner(System.in);
    String yayNay = "";

    for(int i = 0; i < navn.length; i++) {
      System.out.println("Is " + navn[i] + " present today?");
      yayNay = input.nextLine();

      if(yayNay.equalsIgnoreCase("Yes") || yayNay.equalsIgnoreCase("ja")) {
        oppmoete[i] = true;
      }
      else if(yayNay.equalsIgnoreCase("No") || yayNay.equalsIgnoreCase("Nei")){
        oppmoete[i] = false;
      }
      else {
        System.out.println("Error: Invalid input, please start over\n");
        return;
      }
    }
  }

  public void printAttendance() {
    for (int i = 0; i < navn.length; i++) {
      if(oppmoete[i]) {
        System.out.println(navn[i] + " is present");
      }
      else {
        System.out.println(navn[i] + " isn't present");
      }
    }
  }
}
