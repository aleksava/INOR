public abstract class Legemiddel implements PilleMikstur {

  protected double activeSubstanceTot;
  protected double volume;
  protected String name;
  protected int serialNumber;
  protected int price;
  protected int pills;

  public double getSubstance() {
    if(pills != -1) {
      return activeSubstanceTot/pills;
    }

    return activeSubstanceTot/volume;
  }

  public double getVolume() {
    return volume;
  }

  public String toString() {
    return name;
  }

  public int getSerial() {
    return serialNumber;
  }

  public int getPrice() {
    return price;
  }

  public int getPills() {
    return pills;
  }
}
