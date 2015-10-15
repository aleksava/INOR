class TestOrd {
  public static void main(String[] args) throws Exception{
    String tekst = "";
    Ord test = new Ord("apekatt");
    Ord jungle = new Ord("panther");
    test.oekAntall();
    System.out.println("First word: " + test.toString() + " " +
                        test.hentAntall() + "\nSecond word: " +
                        jungle.toString() + " " + jungle .hentAntall());

    Ordliste list = new Ordliste();
    list.lesBok("scarlet.text");
    System.out.println("bok");
    System.out.println(list.finnOrd("of") + "of");
    list.leggTilOrd("test");
  }
}
