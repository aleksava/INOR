import java.util.Scanner;
import java.io.File;

class PrinsessaOgErten {

  public static int sjekkOrd(String word) {
    return word.length();
  }

  public static boolean forsteBokstav(String word, char letter) {
    if(word.charAt(0) == letter) {
      return true;
    }
    return false;
  }

  public static void main(String[] args) throws Exception {
    Scanner file = new Scanner(new File("princessandthepea.txt"));
    String readWord;
    int fourWords = 0;

    while(file.hasNextLine()) {
      readWord = file.nextLine();

      if(sjekkOrd(readWord) == 4) {
        fourWords ++;
      }

      if(forsteBokstav(readWord, 'a')) {
        System.out.print(readWord + " - ");
      }
    }
    System.out.println("\n");
  }
}
