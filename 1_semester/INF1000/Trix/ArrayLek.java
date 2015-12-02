import java.util.Scanner;

class ArrayLek {

  public static int storsteTall(int[] arr) {
    int largest = 0;

    for(int i = 0; i < arr.length; i++) {
      if(arr[i] > largest) {
        largest = arr[i];
      }
    }

    return largest;
  }

  public static int[] reverserArray(int[] arr) {
    int[] revArr = new int[arr.length];

    for(int i = 0; i < arr.length; i++) {
      revArr[arr.length - i - 1] = arr[i];
    }

    return revArr;
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int[] heltall = new int [5];
    int[] reverseHeltall;
    int largest = 0;

    System.out.println();

    for(int i = 0; i < heltall.length; i++) {
      System.out.print("Please type in a number: ");
      heltall[i] = Integer.parseInt(input.nextLine());
    }

    largest = storsteTall(heltall);
    System.out.println("\nThe largest number you put in is " + largest + "\n");

    reverseHeltall = reverserArray(heltall);
    System.out.println("The reverse array is: ");
    for(int i = 0; i < reverseHeltall.length; i++) {
      System.out.print(reverseHeltall[i] + " ");
    }
    System.out.println("\n");
  }
}
