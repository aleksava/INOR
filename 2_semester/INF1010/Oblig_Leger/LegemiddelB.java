public class LegemiddelB extends Legemiddel {
  private int addictive;

  public LegemiddelB(String name, int price, int serialNumber, int pills,
                      double volume, double activeSubstance, int addictive) {
    this.name = name;
    this.price = price;
    this.serialNumber = serialNumber;
    this.pills = pills;
    this.volume = volume;
    this.activeSubstanceTot = activeSubstance;
    this.addictive = addictive;
  }

  public int getAdd() {
    return addictive;
  }
}
