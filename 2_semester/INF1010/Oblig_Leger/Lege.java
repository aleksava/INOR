public class Lege implements Lik, KommuneAvtale, Comparable<Lege> {
  private String name;
  private int contractNumber;

  public Lege(String name, int contractNumber) {
    this.name = name;
    this.contractNumber = contractNumber;
  }

  public boolean same(String name) {
    if(this.name == name) {
      return true;
    }

    return false;
  }

  public String toString() {
    return name;
  }

  public int getContractNumber() {
    if(contractNumber != -1) {
      return contractNumber;
    }

    System.out.println("This doctor doesn't have any contract with the county");
    return contractNumber;
  }

  public int compareTo(Lege l) {
    return (toString().compareTo(l.toString()));
  }
}
