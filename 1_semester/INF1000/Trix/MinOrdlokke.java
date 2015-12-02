import java.util.Scanner;

class MinOrdlokke {

  public static double printSum(int a, int b) {
    return (a+b);
  }

  public static void printHei(String name) {
    System.out.println("Hei, " + name);
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String name;
    int in = 3;

    while(in != 0) {
      System.out.print("Type in a number: ");
      in = Integer.parseInt(input.nextLine());
      if(in == 1) {
        System.out.println(printSum(27, 15));
      }
      else if(in == 2) {
        System.out.print("Give me your name nigga: ");
        name = input.nextLine();
        printHei(name);
      }
      else if (in != 0){
        System.out.println("Error: Invalid input");
      }
    }
  }
}
