class Test7 {
  public static void main(String[] args) {
    Person dave = new Person("Dave");

    dave.newDVD("Pulp Fiction");
    System.out.println(dave.findDVD("Pulp Fiction").getPossession());
    System.out.println(dave.findDVD("Pulp Fiction").toString());

    System.out.println("New test");

    dave.printDVDs();

    System.out.println(dave.dvdAmount());

  }
}
