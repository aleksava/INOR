class Ord {
  //Declaring variables
  private String word;
  private int amount = 1;

  //Constructor
  Ord (String tekst) {
    word = tekst;
  }

  //Returning the word that was read, e.g.
  //new Ord("skog").toString() returns "skog"
  public String toString() {
    return word;
  }

  //Collects the amount of times the word has shown up
  public int hentAntall() {
    return amount;
  }

  //Notices that a word has shown up previously
  public void oekAntall() {
    amount ++;
  }
}
