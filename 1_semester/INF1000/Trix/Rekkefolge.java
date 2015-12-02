import java.util.Scanner;

class Rekkefolge {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int[] arr = new int[3];
    int prev = 0;

    for(int i = 0; i < arr.length; i++) {
      System.out.print("Please type in a number: ");
      arr[i] = Integer.parseInt(input.nextLine());
    }

    if(arr[0] > arr[1] && arr[1] > arr[2]) {
      System.out.println("Declining");
    }
    else if(arr[0] < arr[1] && arr[1] < arr[2]) {
      System.out.println("Inclining");
    }
    else {
      System.out.println("No order");
    }
  }
}
