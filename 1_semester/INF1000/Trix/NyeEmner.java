import java.util.ArrayList;
import java.util.Scanner;

class NyeEmner {
  public static void main(String[] args) {
    ArrayList<String> emnekoder = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    String emnekode;

    emnekoder.add("INF1000");
    emnekoder.add("INF1400");
    emnekoder.add("MAT1100");

    System.out.print("Please type in an 'emnekode': ");
    emnekode = input.nextLine();
    if(emnekoder.contains(emnekode)) {
      emnekoder.remove(emnekode);
    }
    else {
      emnekoder.add(emnekode);
    }

    for(int i = 0; i < emnekoder.size(); i++) {
      System.out.println(emnekoder.get(i));
    }
  }
}
