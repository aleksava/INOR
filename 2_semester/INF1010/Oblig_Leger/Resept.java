public class Resept implements Comparable<Resept>, Lik{
  private Legemiddel drug;
  private long patientID;
  private String doctor;
  private boolean blue;
  private int serialNumber;
  private int reit;

  public Resept(String name, int i) {
    doctor = name;
    serialNumber = i;
  }

  public Resept(Legemiddel drug, String doc, long id, boolean blue, int ser, int reit) {
    this.drug = drug;
    this.blue = blue;
    this.reit = reit;
    serialNumber = ser;
    doctor = doc;
    patientID = id;
  }

  public Legemiddel getDrug() {
    return drug;
  }

  public long getPatID() {
    return patientID;
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

  public void use() {
    reit --;
  }

  public int compareTo(Resept r) {
    return (getSerial() - r.getSerial());
  }

  public boolean same(String s) {
    return s.equalsIgnoreCase(Integer.toString(serialNumber));
  }

  public String print() {
    if(blue) {
      return (serialNumber + ", blaa, " + patientID + ", " + doctor + ", " +
              drug.getSerial() + ", " + reit);
    }

    return (serialNumber + ", hvit, " + patientID + ", " + doctor + ", " +
            drug.getSerial() + ", " + reit);
  }
}
