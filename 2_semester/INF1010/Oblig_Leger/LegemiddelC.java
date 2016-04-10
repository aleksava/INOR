public class LegemiddelC extends Legemiddel {

  public LegemiddelC(String name, int price, int serialNumber, int pills,
                      double volume, double activeSubstance) {
    this.name = name;
    this.price = price;
    this.serialNumber = serialNumber;
    this.pills = pills;
    this.volume = volume;
    this.activeSubstanceTot = activeSubstance;
  }

  public String print() {
    if(volume == -1) {
      return (super.print() + ", " + name+", pille, c, " + price + ", " +
      pills + ", " + activeSubstanceTot);
    }

    return (super.print() + ", " + name + ", mikstur, c, " + price + ", " +
            volume + ", " + activeSubstanceTot);
  }
}
