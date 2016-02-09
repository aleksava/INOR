class Bok implements TilUtlaan {

  //Declaring a boolean variable to decide whether or not the book is borrowed
  //away, and a few Strings to show title, author and an eventual borrower.
  private boolean borrowedAway = false;
  private String title, author, borrower;

  //Basic constructor to create a book with a title and author.
  public Bok(String title, String author) {
    this.title = title;
    this.author = author;
  }

  //Borrows a way the book to a borrower by name, checks that the book is not
  //allready borrowed away.
  public void borrowAway(String name) {
    if(!borrowedAway) {
      borrower = name;
      borrowedAway = true;
    }
    else System.out.println("This book is allready borrowed away.");
  }

  //Resets the borrowedAway variable to false, that the book is not borrowed
  //away.
  public void returnObject() {
    borrowedAway = false;
  }

  //toString() method to return the name.
  public String toString() {
    return title;
  }

  //Methord to return the author of the book.
  public String getAuthor() {
    return author;
  }
}
