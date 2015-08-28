import java.util.Scanner;
public class HeiStudent {
  public static void main(String[] args) {
    //Skriver ut teksten
    System.out.println("Hei Student!");

    //Definerer variabel
    String navn = "Aleksander";
    //Skriver ut tekst + variabelen
    System.out.println("Hei " + navn);

    //Skrev inn "import java.util.Scanner;" øverst, slik at jeg kan
    //ta imot input fra tastaturet
    //Ber bruker skrive inn navnet sitt
    System.out.println("Hva heter du?");
    //Definerer variabel og leser inn
    Scanner innleser;
    innleser = new Scanner(System.in);
    String inNavn = innleser.nextLine();
    //Skriver ut
    System.out.println("Hello " + inNavn);

    //Definerer variabel og leser inn
    int tall1 = 29;
    int tall2 = 13;
    //Skriver ut summen av tall1 og tall2
    System.out.println("Summen av tall1 og tall2 er " + (tall1 + tall2));

    //Ber bruker skrive inn to tall
    System.out.println("Skriv først et heltall, for så å trykke 'return'. Gjenta dette en gang til :)");
    //Definerer vaiabel på nytt og leser inn
    Scanner innlesertall;
    innlesertall = new Scanner(System.in);
    String inTall1 = innlesertall.nextLine();
    String inTall2 = innlesertall.nextLine();
    //"Gjør om" til tall
    int omTall1 = Integer.parseInt(inTall1);
    int omTall2 = Integer.parseInt(inTall2);
    //Skriver ut summen av omTall1 og omTall2
    System.out.println("Summen av de to tallene du skrev inn er: " + (omTall1 + omTall2));
  }
}
