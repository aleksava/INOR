public class KoLapp {

  private int queueNumber;

  //Konstruktor
  public KoLapp(int nummer) {
    queueNumber = nummer;
  }

  //Returnerer et tildelt nummer paa kolappen.
  public int hentNummer() {
    return queueNumber;
  }
}
