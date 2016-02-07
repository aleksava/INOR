class Oblig2 {

  static void testPlaceBook(Bok book, Hylle<Bok> shelf, int spot) {
    shelf.place(book, spot);
  }

  static void testRemoveBook(Hylle<Bok> shelf, int spot) {
    Bok test = shelf.take(spot);
    if(test != null) {
      System.out.println("Huzza!");
    }
    else {
      System.out.println("As the error message said, it was a failed attempt");
    }
  }

  static void testReadTitleAndAuthor(Hylle<Bok> shelf, int spot) {
    Bok temp = shelf.take(spot);
    System.out.println("The title of the book is " + temp + ". The author is "+
                        temp.getAuthor() + ".");
    testPlaceBook(temp, shelf, spot);
  }

  public static void main(String[] args) {
    Bok bigJava = new Bok("Late Objects", "Horstmann");
    Bok nation = new Bok("Nation", "Terry Pratchett");
    Hylle<Bok> billy = new Hylle<Bok>(100);
    int testNum2 = 107;
    int testNum1 = 5;
    System.out.println(billy.size());

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
  }
}
