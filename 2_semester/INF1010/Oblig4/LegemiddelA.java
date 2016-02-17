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
}
