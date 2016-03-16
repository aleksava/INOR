public class Resept implements Comparable<Resept>, Lik{
  private Legemiddel drug;
  private String patient;
  private String doctor;
  private boolean blue;
  private int serialNumber;
  private int reit;

  //Special resept in order to test easier
  public Resept(String patient, int i) {
    this.patient = patient;
    serialNumber = i;
  }

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

  public int compareTo(Resept r) {
    return (getSerial() - r.getSerial());
  }

  public boolean same(String s) {
    return s.equalsIgnoreCase(Integer.toString(serialNumber));
  }
}
