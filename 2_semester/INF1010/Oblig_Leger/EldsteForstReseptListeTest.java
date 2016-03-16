import java.util.NoSuchElementException;

class EldsteForstReseptListeTest {
  public static void main(String[] args) {
    EldsteForstReseptListe oldFirst = new EldsteForstReseptListe();
    boolean first = oldFirst.add(new Resept("Arthur", 1));
    boolean second = oldFirst.add(new Resept("Ford", 2));
    boolean third = oldFirst.add(new Resept("DeepThought", 3));

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
    oldFirst.printAll();
    System.out.println();

    System.out.println(oldFirst.getWithString(2).toString());

    try {
      System.out.println(oldFirst.getWithString(6).toString());
    }
    catch(NoSuchElementException exception) {
      System.out.println("Error 001: " + exception.getMessage());
    }

    oldFirst.recursivePrint();
  }
}
