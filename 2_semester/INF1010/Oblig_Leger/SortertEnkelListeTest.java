class SortertEnkelListeTest {
  public static void main(String[] args) {
    SortertEnkelListe<Lege> doctors = new SortertEnkelListe<Lege>();

    //Adding three new doctors, prints success or failure
    if(doctors.add(new Lege("Arthur", -1))) {
      System.out.println("Success!");
    }
    else {
      System.out.println("Failure!");
    }

    if(doctors.add(new Lege("Ford", 0152))) {
      System.out.println("Success!");
    }
    else {
      System.out.println("Failure!");
    }

    if(doctors.add(new Lege("Deep Thought", 42))) {
      System.out.println("Success!");
    }
    else {
      System.out.println("Failure!");
    }


    System.out.println(doctors.getWithString("Arthur").getContractNumber());
    System.out.println(doctors.getWithString("Ford").getContractNumber());
    System.out.println(doctors.getWithString("Deep Thought").toString());
    System.out.println(doctors.getWithString("Ikke en Lege").getContractNumber());
  }
}
