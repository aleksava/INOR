class PlanteTest {
  public static void main(String[] args) {
    /*Plante orchid = new Plante(40);
    Plante rose = new Plante(90);

    orchid.vannPlante(30);
    rose.vannPlante(40);

    orchid.nyDag();
    rose.nyDag();

    orchid.vannPlante(30);
    rose.vannPlante(80);

    orchid.nyDag();
    rose.nyDag();

    if(orchid.erLevende()) {
      System.out.println("The orcid is still alive");
    }
    else {
      System.out.println("The orchid is dead.");
    }

    if(rose.erLevende()) {
      System.out.println("The rose is still alive");
    }
    else {
      System.out.println("The rose is dead.");
    }
    */

    //Testing for PlanteHage
    System.out.println("\n**PlanteHage**\n");
    PlanteHage haugesund = new PlanteHage();

    haugesund.groPlante(40);
    haugesund.groPlante(60);
    haugesund.groPlante(80);

    haugesund.vannPlanter(25);


    haugesund.renskOppHage();

    System.out.println("Plants still alive: " + haugesund.antPlanter() + "\n");

    haugesund.nyDagTilAlleMinePlanter();
    haugesund.renskOppHage();
    System.out.println("Overlevde dag 1: " + haugesund.antPlanter());
    haugesund.nyDagTilAlleMinePlanter();
    haugesund.renskOppHage();
    System.out.println("Overlevde dag 2: " + haugesund.antPlanter());
    haugesund.nyDagTilAlleMinePlanter();
    haugesund.renskOppHage();
    System.out.println("Overlevde dag 3: " + haugesund.antPlanter());


    System.out.println("Plants still alive: " + haugesund.antPlanter() + "\n");
  }
}
