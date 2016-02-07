class Bok implements TilUtlaan {

  private boolean borrowedAway = false;
  private String title, author, borrower;

  public Bok(String title, String author) {
    this.title = title;
    this.author = author;
  }

  public void borrowAway(String name) {
    if(!borrowedAway) {
      borrower = name;
      borrowedAway = true;
    }
    else System.out.println("This book is allready borrowed away.");
  }

  public void returnObject() {
    borrowedAway = false;
  }

  public String toString() {
    return title;
  }

  public String getAuthor() {
    return author;
  }
}
