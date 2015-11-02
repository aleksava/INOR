class Test7 {
  public static void main(String[] args) throws Exception {
    Person dave = new Person("Dave");

    dave.newDVD("Pulp Fiction");
    System.out.println(dave.findDVD("Pulp Fiction").getPossession());
    System.out.println(dave.findDVD("Pulp Fiction").toString());

    System.out.println("New test");
    dave.printDVDs();
    System.out.println(dave.dvdAmount());


    System.out.println("Testing DVDAdministrasjon");
    DVDAdministrasjon test = new DVDAdministrasjon("dvdarkiv.txt");
    test.addPersonInterace();

    test.showPersonInterface();

    test.menu();
  }
}
