public class Resept {
  private Legemiddel drug;
  private String patient;
  private String doctor;
  private boolean blue;
  private int serialNumber;
  private int reit;

  public Resept(Legemiddel drug, String doc, boolean blue, int ser, int reit) {
    this.drug = drug;
    this.blue = blue;
    this.reit = reit;
    serialNumber = ser;
    doctor = doc;
  }

  public Legemiddel getDrug() {
    return drug;
  }

  public String toString() {
    return patient;
  }

  public String getDoc() {
    return doctor;
  }

  public boolean getType() {
    return blue;
  }

  public int getSerial() {
    return serialNumber;
  }

  public int getReit() {
    return reit;
  }

}
