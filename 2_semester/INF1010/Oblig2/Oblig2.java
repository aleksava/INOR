class Oblig2 {

  //Method that attempts to place a book, added because it was pointed out to
  //me that the tests had to be in a static method for the assignment ._.
  //Literally only adds 3 useless lines (6 with comments now, 7 with spaces)
  static void testPlaceBook(Bok book, Hylle<Bok> shelf, int spot) {
    shelf.place(book, spot);
  }

  //Method that tries to remove a book from the shelf, prints out "Huzza!" if
  //it's successfull. Prints the appropriate error message otherwise.
  static void testRemoveBook(Hylle<Bok> shelf, int spot) {
    Bok test = shelf.take(spot);
    if(test != null) {
      System.out.println("Huzza!");
    }
    else {
      System.out.println("As the error message said, it was a failed attempt");
    }
  }

  //Method that tests that the shelf actually contains books, and not just
  //random stuff. Calls the author and toString method on the book. Makes sure
  //that it managed to grab a book. Error message is in Hylle.java
  static void testReadTitleAndAuthor(Hylle<Bok> shelf, int spot) {
    Bok temp = shelf.take(spot);
    if(temp != null) {
      System.out.println("The title of the book is "+ temp +". The author is "+
                          temp.getAuthor() + ".");
      testPlaceBook(temp, shelf, spot);
    }
  }

  //Method that makes sure that the parameter sent with the constructor to the
  //class Hylle, matches the size of the shelf. Error messages are appropriate.
  static void testSizeOfShelf(int param, Hylle<Bok> shelf) {
    if(param == shelf.size()) {
      System.out.println("The size of the shelf is correct! \nSize: " +
                          param + "\n");
    }

    else {
      System.out.println("The size of the shelf is incorrect, there must be " +
                          "some kind of mistake.\n");
    }
  }

  public static void main(String[] args) {

    //Declaring various test variables.
    int testNum1 = 5;
    int testNum2 = 107;
    int sizeOfShelf = 100;
    Hylle<Bok> billy = new Hylle<Bok>(sizeOfShelf);
    Bok nation = new Bok("Nation", "Terry Pratchett");
    Bok bigJava = new Bok("Late Objects", "Horstmann");

    //FIRST TEST
    //Placing a book, removing this same book, and then checking that this spot
    //is now empty
    System.out.println("\nFirst test");
    testPlaceBook(nation, billy, testNum1);
    testRemoveBook(billy, testNum1);
    System.out.print("Is spot number " + testNum1 + " on the shelf free? ");
    System.out.println(billy.vacant(testNum1));
    testPlaceBook(bigJava, billy, testNum1);

    //SECOND TEST
    //Placing a book outside of the shelf, it should not fit
    System.out.println("\nSecond test");
    testPlaceBook(bigJava, billy, testNum2);

    //THIRD TEST
    //Taking out a book, reading its title and author, and then putting it back
    //to its original position
    System.out.println("\nThird test");
    testReadTitleAndAuthor(billy, testNum1);

    //FOURTH TEST
    //Checking that the size of the shelf is the same as the parameter
    System.out.println("\nFourth test");
    testSizeOfShelf(sizeOfShelf, billy);

    /*
    A flawless run should look like this: (SPOILER: It does.)

    First test
    Huzza!
    Is spot number 5 on the shelf free? true

    Second test
    The shelf is to short for this spot, therefore the book fell off.

    Third test
    The title of the book is Late Objects. The author is Horstmann.

    Fourth test
    The size of the shelf is correct!
    Size: 100

    */
  }
}
