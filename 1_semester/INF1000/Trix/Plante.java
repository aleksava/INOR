class Plante {

  private int vannBeholder;
  private int maxGrenseVann;
  private boolean alive;


  public Plante(int maxGrenseVann) {
    this.maxGrenseVann = maxGrenseVann;
    alive = true;
  }

  //Oker vannBeholder med clVann. Om vannBeholder blir storre enn
  //maxGrenseVann, dor planten.
  public void vannPlante(int clVann) {
    vannBeholder += clVann;
    if(vannBeholder > maxGrenseVann) {
      System.out.println("\nThe plant is now dead, thanks to you.");
      System.out.println("It died from drowning.\n");
      alive = false;
    }
  }

  //For hver nye dag minker vannBeholder med 20(siden planten drikker vannet).
  //Om vannBeholder blir mindre enn 0, dor planten.
  public void nyDag() {
    vannBeholder -= 20;
    if(vannBeholder < 0) {
      System.out.println("\nThe plant is now dead, thanks to you.");
      System.out.println("It died from dehydration.\n");
      alive = false;
    }
  }

  //Om planten er levende skal det returnes 1, om ikke planten er levende skal
  // det returneres -1.
  public int erLevende() {
    if(alive) {
      return 1;
    }
    return -1;
  }
}
