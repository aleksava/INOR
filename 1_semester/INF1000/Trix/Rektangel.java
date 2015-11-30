class Rektangel {

  private double length;
  private double width;

  public Rektangel(double length, double width) {
    this.length = length;
    this.width = width;
  }

  public void oekLengde(int okning) {
    length += okning;
  }

  public void oekBredde(int okning) {
    width += okning;
  }

  public double areal() {
    return (length*width);
  }

  public double omkrets() {
    return (2*length + 2*width);
  }
}
