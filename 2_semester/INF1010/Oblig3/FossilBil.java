class FossilBil extends Bil {
  protected double co2;

  public FossilBil(String reg, double co2) {
    super(reg);
    this.co2 = co2;
  }

  public double getEmi() {
    return co2;
  }
}
