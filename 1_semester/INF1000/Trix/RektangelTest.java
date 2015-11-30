class RektangelTest {
  public static void main(String[] args) {
    Rektangel pc = new Rektangel(5, 5);
    Rektangel mac = new Rektangel(4, 4);

    System.out.println("PC: " + pc.areal());
    System.out.println("MAC: " + mac.areal());

    mac.oekLengde(2);
    pc.oekBredde(5);

    System.out.println("PC: " + pc.omkrets());
    System.out.println("MAC: " + mac.areal());
  }
}
