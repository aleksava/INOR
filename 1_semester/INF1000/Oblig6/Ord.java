class Ord {
  //Declaring variables
  private String word;
  private int amount;

  //Constructor
  Ord (String tekst) {
    word = tekst;
  }

  //Returning the word that was read, e.g.
  //new Ord("skog"). toString() returns "skog"
  public String toString() {
    return word;
  }

  //Collects the amount of times the word has shown up
  public int getAmount() {
    return amount;
  }

  //Notices that a word has shown up previously
  public void incAmount() {
    amount ++;
  }
}
