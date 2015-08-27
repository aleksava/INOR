//Oppgavetekst:
//Lag et program som tester brukerens filmkunnskaper
//i form av en quiz

import java.util.Scanner;
public class MinOppgave1 {
  public static void main(String[] args) {
    //SPOERSMAAL 1
    System.out.println("Spoersmaal 1: What is the answer to life, the universe and everything?");
    System.out.print("Svar: ");
    //Deklarerer variabler og gjør muligheter for input
    Scanner innleser = new Scanner(System.in);
    int svar1 = innleser.nextInt();
    int poengOppg1 = 0;
    int poengOppg2 = 0;
    int poengOppg3 = 0;
    int poengSum = poengOppg1 + poengOppg2 + poengOppg3;
    //Bruker if/else for å bestemme om svaret er korrekt
    if (svar1 == 42) {
      System.out.println("Korrekt!");
      poengOppg1 = 1;
    }
    else {
      System.out.println("Det var dessverre feil, riktig svar var 42");
      poengOppg1 = 0;
    }
    //SPOERSMAAL 2
    System.out.println();
    System.out.println("Spoersmaal 2: Hvor mange millioner aar tok det aa finne svaret på spoersmaal 1?");
    System.out.print("Svar: ");
    //Derklarerer variabler
    Scanner innleser2 = new Scanner(System.in);
    double svar2 = innleser2.nextDouble();
    //Bruker if/else for å bestemme om svaret er korrekt
    if (svar2 == 7.5) {
      System.out.println("Korrekt!");
      poengOppg2 = 1;
    }
    else {
      System.out.println("Det var dessverre feil, ritkig svar var: 7.5");
      poengOppg2 = 0;
    }
    //SPOERSMAAL 3
    System.out.println();
    System.out.println("Spoersmaal 3: Hvem var forfatteren til bokserien The Hitchhiker's Guide to the Galaxy?");
    //Svaralternativer
    System.out.println("Alternativ 1: J.R.R. Tolkien");
    System.out.println("Alternativ 2: Andy Weir");
    System.out.println("Alternativ 3: Douglas Adams");
    System.out.print("Svar: Alternativ ");
    //Deklarerer variabler
    Scanner innleser3 = new Scanner(System.in);
    int svar3 = innleser3.nextInt();
    //Bruker if/else for å bestemme om svaret er korrekt
    if (svar3 == 3) {
      System.out.println("Korrekt!");
      poengOppg3 = 1;
    }
    else {
      System.out.println("Det var dessverre feil, riktig svar var: Alternativ 3: Douglas Adams");
    }
    //POENGSUM
    //Deklrarer varablene
    poengSum = poengOppg1 + poengOppg2 + poengOppg3;
    System.out.println();
    System.out.println("Din totale poengsum ble: " + poengSum + ". Gratulerer!");
  }
}
