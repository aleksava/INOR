class DelB {
  public static void main(String[] args) {

    //Creating a test book
    Bok test = new Bok("Big Java", "Horstmann");

    //Formatting and testing the toString() and getAuthor() method
    System.out.println("\n" + test);
    System.out.println(test.getAuthor());

    //Testing the borrowAway method twice to check the failsafe.
    test.borrowAway("Aleksander");
    test.borrowAway("Vebjorn");

    //Returning the book from "Aleksander", and then borrowes it away to
    //"Vebjørn".
    test.returnObject();
    test.borrowAway("Vebjorn");

    //Formatting
    System.out.println();
  }
}
