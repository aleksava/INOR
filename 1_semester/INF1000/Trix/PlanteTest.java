class PlanteTest {
  public static void main(String[] args) {
    Plante orchid = new Plante(40);
    Plante rose = new Plante(90);

    orchid.vannPlante(30);
    rose.vannPlante(40);

    orchid.nyDag();
    rose.nyDag();

    orchid.vannPlante(30);
    rose.vannPlante(80);

    orchid.nyDag();
    rose.nyDag();

    if(orchid.erLevende() == 1) {
      System.out.println("The orcid is still alive");
    }
    else {
      System.out.println("The orchid is dead.");
    }

    if(rose.erLevende() == 1) {
      System.out.println("The rose is still alive");
    }
    else {
      System.out.println("The rose is dead.");
    }
  }
}
