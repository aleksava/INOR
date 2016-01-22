class Oblig1 {
  public static void main(String[] args) {

    Rotte twitch = new Rotte("Twitch");
    Mus minnie = new Mus("Minnie Mouse");
    Mus mickey = new Mus("Mickey Mouse");
    Katt gengar = new Katt("Rengar");

    Bol<Mus> musebol = new Bol<Mus>();
    Bol<Rotte> rottebol = new Bol<Rotte>();

    System.out.println();

    gengar.onTheHunt(musebol, rottebol);

    rottebol.enterBol(twitch);

    gengar.onTheHunt(musebol, rottebol);

    musebol.enterBol(mickey);

    musebol.enterBol(minnie);

    gengar.onTheHunt(musebol, rottebol);
  }
}
