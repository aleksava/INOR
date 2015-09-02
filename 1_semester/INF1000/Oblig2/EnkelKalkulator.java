import java.util.Scanner;

public class EnkelKalkulator {
  //Method for adding numbers from the user's input
  static void NumberSum(String inNum1, String inNum2) {
    int num1 = Integer.parseInt(inNum1);
    int num2 = Integer.parseInt(inNum2);
    System.out.println("\nThe sum of the first and second number is: " + (num1 + num2));
  }
  //Method for finding the difference of the user's input
  static void NumberDif(String inNum1, String inNum2) {
    int num1 = Integer.parseInt(inNum1);
    int num2 = Integer.parseInt(inNum2);
    System.out.println("The difference of the first and second number is: " + Math.abs(num1 - num2));
  }
  //Method for multiplying the user's input
  static void NumberProd(String inNum1, String inNum2) {
    int num1 = Integer.parseInt(inNum1);
    int num2 = Integer.parseInt(inNum2);
    System.out.println("The product of the first and second number is: " + (num1 * num2) + "\n");
  }

  public static void main(String[] args) {
    //Taking input from the user + formatting
    Scanner input = new Scanner(System.in);
    System.out.print("\nPlease type in a number: ");
    String inNum1 = input.nextLine();
    System.out.print("Please type in a second number: ");
    String inNum2 = input.nextLine();
    //Using the methods
    NumberSum(inNum1, inNum2);
    NumberDif(inNum1, inNum2);
    NumberProd(inNum1, inNum2);
  }
}
