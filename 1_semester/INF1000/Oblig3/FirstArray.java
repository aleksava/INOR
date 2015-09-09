import java.util.Scanner;
public class FirstArray {
  public static void main(String[] args) {

    //Declaring variables and array
    int array []  = new int [4];
    int counter = 0;
    array[0] = 1337;
    array[1] = 1;
    array[2] = 2;
    array[3] = 1337;

    //Declaring String array
    Scanner input = new Scanner(System.in);
    String nameArray [] = new String [5];
    System.out.println("\nPlease type in five names: ");
    nameArray[0] = input.nextLine();
    nameArray[1] = input.nextLine();
    nameArray[2] = input.nextLine();
    nameArray[3] = input.nextLine();
    nameArray[4] = input.nextLine();

    //Printing out int array
    int lengthArray = array.length;
    System.out.println("\nContent of int array: ");
    while (counter < lengthArray) {
      System.out.println(array[counter]);
      counter ++;
    }

    //Printing out String array
    counter = 0;
    int lengthStringArray = nameArray.length;
    System.out.println("\nContent of String array: ");
    while (counter < lengthStringArray) {
      System.out.println(nameArray[counter]);
      counter ++;
    }
    System.out.println();
  }
}
