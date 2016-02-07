class DelB {

  public static void main(String[] args) {
    Bok test = new Bok("Big Java", "Horstmann");

    System.out.println("\n" + test);
    System.out.println(test.getAuthor());

    test.borrowAway("Aleksander");
    test.borrowAway("Vebjorn");

    test.returnObject();
    test.borrowAway("Vebjorn");

    System.out.println();
  }
}
