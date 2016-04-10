public class LegemiddelA extends Legemiddel {
  private int narcotic;

  public LegemiddelA(String name, int price, int serialNumber, int pills,
                      double volume, double activeSubstance, int narcotic) {
    this.name = name;
    this.price = price;
    this.serialNumber = serialNumber;
    this.pills = pills;
    this.volume = volume;
    this.activeSubstanceTot = activeSubstance;
    this.narcotic = narcotic;
  }

  public int getNarc() {
    return narcotic;
  }

  public String print() {
    String form;
    if(volume == -1) {
      return (super.print() + ", " + name+", pille, a, " + price + ", " +
      pills + ", " + activeSubstanceTot + ", " + narcotic);
    }

    return (super.print() + ", " + name + ", mikstur, a, " + price + ", " +
            volume + ", " + activeSubstanceTot + ", " + narcotic);
  }
}
