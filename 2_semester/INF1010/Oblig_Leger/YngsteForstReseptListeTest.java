import java.util.NoSuchElementException;

class YngsteForstReseptListeTest {
  public static void main(String[] args) {
    YngsteForstReseptListe youngFirst = new YngsteForstReseptListe();
    boolean first = youngFirst.add(new Resept("Arthur", 1));
    boolean second = youngFirst.add(new Resept("Ford", 2));
    boolean third = youngFirst.add(new Resept("DeepThought", 3));

    if(first) {
      System.out.println("\nSuccess!");
    }
    else {
      System.out.println("Failure!");
    }

    if(second) {
      System.out.println("Success!");
    }
    else {
      System.out.println("Failure!");
    }

    if(third) {
      System.out.println("Success!");
    }
    else {
      System.out.println("Failure!");
    }

    System.out.println("\n\nOrder: \n");
    youngFirst.printAll();
    System.out.println();

    System.out.println("\nNew thing\n");
    System.out.println(youngFirst.getWithString(2).toString());

    try {
      System.out.println(youngFirst.getWithString(6).toString());
    }
    catch(NoSuchElementException exception) {
      System.out.println("Error 002: " + exception.getMessage());
    }
  }
}
