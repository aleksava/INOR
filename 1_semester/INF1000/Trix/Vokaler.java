import java.util.Scanner;

class Vokaler {
  public static void main(String[] args) {
    char[] arr = new char[] {'a', 'e', 'i', 'o', 'u', 'y'};
    Scanner input = new Scanner(System.in);
    String word;
    int vowels = 0;

    System.out.print("\nPlease type in a word: ");
    word = input.nextLine().toLowerCase();

    for(int i = 0; i < word.length(); i++) {
      for (int j = 0; j < arr.length; j++) {
        if(arr[j] == word.charAt(i)) {
          vowels ++;
        }
      }
    }

    System.out.println("There are " + vowels + " vowels in " + word + "\n");

  }
}
