import java.util.Scanner;
public class Beslutninger {
public static void main(String[] args) {
  //Deklarerer variabel
  int alder = 19;
  //Skriver ut ved hjelp av en if/else
  if (alder >= 18)
    System.out.println("Du er myndig");
  else
    System.out.println("Du er ikke myndig");

  //Endrer slik at alder blir lest inn fra terminalen
  //Skriver inn "import java.util.Scanner" øverst
  //Ber bruker skrive inn alder
  System.out.println("Hvor gammel er du?");
  //Deklarerer variabel og leser inn
  Scanner innleser;
  innleser = new Scanner(System.in);
  String inAlder = innleser.nextLine();
  //Gjør om til tall
  int omAlder = Integer.parseInt(inAlder);
  //Skriver ut ved hjelp av if/else
  if (omAlder >= 18)
    System.out.println("Du er myndig");
  else
    System.out.println("Du er ikke myndig");
  }
}
