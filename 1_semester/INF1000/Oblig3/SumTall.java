import java.util.Scanner;
public class SumTall {
  public static void main(String[] args) {

    //Declaring variables
    Scanner input = new Scanner(System.in);
    boolean run = true;
    double num1;
    double num2 = 0;

    //Created a loop
    while (run) {
      System.out.print("\nPlease type in a number: ");
      num1 = Double.parseDouble(input.nextLine());
      if (num1 == 0) {
        run = false;
      }
      else {
        num2 = num1 + num2;
        System.out.println("The sum of the numbers is: " + num2);
      }
    }
  }
}
