class Ord {
  //Declaring variables
  private String word;
  private int amount = 1;

  //Oppretter et Ord-objekt av den gitte teksten
  Ord (String tekst) {
    word = tekst;
  }

  //Returnerer ordet
  public String toString() {
    return word;
  }

  //Henter data om hvor mange ganger ordet forekommer
  public int hentAntall() {
    return amount;
  }

  //Registrerer at ordet har forekommet en gang til
  public void oekAntall() {
    amount ++;
  }
}
