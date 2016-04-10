public class Pasient {
  private String address;
  private String name;
  private int patientNumber;
  private int areaCode;
  private long identity;

  public Pasient(String name, long identity, String address, int areaCode,
                  int patientNumber) {
    this.name = name;
    this.identity = identity;
    this.address = address;
    this.areaCode = areaCode;
    this.patientNumber = patientNumber;
  }

  public String getAddress() {
    return address;
  }

  public String toString() {
    return name;
  }

  public int getPatient() {
    return patientNumber;
  }

  public int getArea() {
    return areaCode;
  }

  public long getID() {
    return identity;
  }

  public String print() {
    return (patientNumber + ", " + name + ", " + identity + ", " + address +
            ", " + areaCode);
  }
}
