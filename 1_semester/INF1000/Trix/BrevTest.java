class BrevTest {
  public static void main(String[] args) {
    Brev langdistanse = new Brev("Aleksander", "Elmedina");

    langdistanse.skrivLinje("Jeg savner deg veldig mye");
    langdistanse.skrivLinje("gleder meg utrolig mye til å se deg igjen <3");
    langdistanse.skrivLinje("Snakkes til jul!");

    langdistanse.lesBrev();
  }
}
