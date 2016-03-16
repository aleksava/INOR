class TabellTest {
  public static void main(String[] args) {

    @SuppressWarnings("unchecked")
    Tabell<Lege> table = new Tabell(10);
    boolean first = table.addAt(new Lege("Vebjorn", -1), 1);
    boolean second = table.addAt(new Lege("Thomas", 1), 9);
    boolean third = table.addAt(new Lege("Lloyd", 2), 3);

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
      System.out.println("Success!\n");
    }
    else {
      System.out.println("Failure!");
    }


    System.out.println(table.getAt(1));
    System.out.println(table.getAt(3));
    System.out.println(table.getAt(9));

    System.out.println();
  }
}
