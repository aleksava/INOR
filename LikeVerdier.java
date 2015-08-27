import java.util.Scanner;
public class LikeVerdier {
  public static void main(String[] args) {
    //Deklarerer variabler
    int c = 29;
    int d = 29;
    //Skjekker om c og d er like og skriver ut ved if/else
    if (c == d) {
      System.out.println("c og d er like");
    }
    else {
      System.out.println("c og d er ikke like");
    }

    //Endrer slik at c og d leses inn fra terminalen
    //Deklarerer variabler
    Scanner innleser;
    innleser = new Scanner(System.in);
    System.out.println("Skriv inn tall c:");
    int a = innleser.nextInt();
    System.out.println("Skriv inn tall d:");
    int b = innleser.nextInt();
    //skjekker om a og b er like og skriver ut ved if/else
    //Skriver ut c i stedet for a og d i stedet for b, slik at jeg
    //følger oppgaveteksten mest mulig
    if (a == b) {
      System.out.println("c og d er like");
    }
    else {
      System.out.println("c og d er ikke like");
    }
  }
}
