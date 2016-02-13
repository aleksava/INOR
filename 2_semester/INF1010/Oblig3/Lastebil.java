class Lastebil extends FossilBil {
  private double payload;

  public Lastebil(String reg, double co2, double load) {
    super(reg, co2);
    payload = load;
  }
}
