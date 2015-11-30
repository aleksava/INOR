class BilTest {
  public static void main(String[] args) {
    Bil i3 = new Bil("Christian", "BMW");
    Bil xc60 = new Bil("Anett", "Volvo");

    System.out.println("Who owns the XC60? \n" + xc60.getOwner());
    System.out.println("What brand is the i3?\n" + i3.getBrand());
  }
}
