class Personbil extends FossilBil {
  private int passengers;

  public Personbil(String reg, double co2, int pass) {
    super(reg, co2);
    passengers = pass;
  }

  public int getPass() {
    return passengers;
  }
}
