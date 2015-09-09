public class NegativeTall {
  public static void main(String[] args) {

    //Declaring array
    int [] numbers = {1, 4, 5, -2, -4, 6, 10, 3, -2};
    int counter = 0;
    int negativeNum = 0;
    int lengthNumbers = numbers.length;

    //Finding the negative numbers and printing them out
    System.out.println("\nThe negative numbers in the array are: ");
    while (counter < lengthNumbers) {
      if (numbers[counter] < 0) {
        negativeNum ++;
        System.out.println(numbers[counter]);
      }
        counter ++;
    }
    System.out.println("\nThere are " + negativeNum + " negative numbers in the array\n");

    //Replacing the numbers in the array
    counter = 0;
    while (counter < lengthNumbers) {
      if (numbers[counter] < 0) {
        numbers[counter] = counter;
      }
        counter ++;
    }

    //Printing out the changed array
    counter = 0;
    System.out.println("The negative numbers in the array \nhave now been replaced with their number in the array.\n"); 
    System.out.print("The new array is now: ");
    while (counter < lengthNumbers) {
      System.out.print(numbers[counter] + " ");
      counter ++;
    }
    System.out.println("\n");
  }
}
