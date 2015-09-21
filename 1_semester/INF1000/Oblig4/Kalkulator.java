import java.util.Scanner;
public class Kalkulator {

  //Method for adding
  static int addition(int num1, int num2) {
    return (num1 + num2);
  }

  //Method for finding the difference
  static int subtraction(int num1, int num2) {
    return (Math.abs(num1 - num2));
  }

  //Method for dividing with decimals
  static double divition(double num3, double num4) {
    return (num3/num4);
  }

  //Method for dividing
  static int intDivition(int num1, int num2) {
    return (num1/num2);
  }

  public static void main(String[] args) {
    int addAns = addition(3,4);
    System.out.println(addAns);

    int subAns = subtraction(5,2);
    System.out.println(subAns);

    int subIntDiv = intDivition(10,3);
    System.out.println(subIntDiv);

    double subDiv = divition(10,3);
    System.out.println(subDiv);
  }
}
