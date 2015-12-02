import java.util.ArrayList;

public class KoSystem {

  private ArrayList<KoLapp> koLapper = new ArrayList<>();
  private int customerNumber = 1;


  //Lager et nytt objekt av KoLapp, printer ut informasjon om den og legger
  //den til i listen over koLapper.
  public void trekkKoLapp() {
    koLapper.add(new KoLapp(customerNumber));
    System.out.println("\nYou are customer number: " + customerNumber);
    System.out.println("There are " + (koLapper.size() - 1) + " customers in " +
                        "front of you.\n");
    customerNumber ++;
  }

  //Henter ut, printer ut informasjon og fjerner den forste kolappen i lista.
  //Gir feilmelding dersom ingen kunder staar i ko.
  public void betjenKunde() {
    if(koLapper.isEmpty()) {
      System.out.println("The queue is empty.");
    }
    else {
    KoLapp inService = koLapper.remove(0);
      System.out.print("\nNow serving: " + inService.hentNummer() + "\n\n");
    }
  }

  //Returnerer antall kunder som er i ko.
  public int antKunder() {
    return koLapper.size();
  }

  //Printer alle kunder i ko
  public void printKunderIKo() {
    if(koLapper.isEmpty()) {
      System.out.println("The queue is empty.");
    }
    for(KoLapp kolapp: koLapper) {
      System.out.println("Number: " + kolapp.hentNummer());
    }
  }
}
