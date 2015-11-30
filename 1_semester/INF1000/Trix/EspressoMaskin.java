class EspressoMaskin {

  private int waterLevel = 0;

  public EspressoMaskin(int ml) {
    waterLevel = ml;
  }

  // Lag espresso dersom det er nok vann
  public void lagEspresso() {
    if(waterLevel >= 40) {
      waterLevel -= 40;
      System.out.println("Here's your espresso sir, enjoy.");
    }
    else {
      System.out.println("I'm terribly sorry sir, but I don't seem to have " +
                          "enough water to make this espresso.");
    }
  }

  // Lag lungo dersom det er nok vann
  public void lagLungo() {
    if(waterLevel >= 110) {
      waterLevel -= 110;
      System.out.println("Here's your lungo sir, enjoy.");
    }
    else {
      System.out.println("I'm terribly sorry sir, but I don't seem to have " +
                          "enough water to make this lungo.");
    }
  }

  // Fyll på et gitt antall milliliter vann, dersom det er plass
  public void fyllVann(int ml) {
    if(waterLevel + ml < 1000) {
      waterLevel += ml;
      System.out.println("Thank you, sir. The container has now been filled " +
                          "up to the " + waterLevel + "ml mark.");
    }
    else {
      System.out.println("I'm allready full sir, you can't fill me up anymore");
    }
  }

  // Les av målestrekene på vanntanken og tilgjengelig vann i ml
  public int hentVannmengde() {
    return waterLevel;
  }
}
