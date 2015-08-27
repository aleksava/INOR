import java.util.Scanner;
  public class Billettpris{
    public static void main(String[] args){
      //Derklarerer variabler
      int fullpris = 50;
      int rabatt = fullpris/2;
      Scanner innleser;
      innleser = new Scanner(System.in);
      //La til en beskrivelse av hva bruker skal gjøre i terminalen
      System.out.println("Skriv inn din alder:");
      //Fortsetter deklareringen av variablene
      String inAlder = innleser.nextLine();
      //Gjør inAlder om til tall
      int omAlder = Integer.parseInt(inAlder);
      //Skriver ut ved hjelp av if/else
      if (omAlder > 12 && omAlder < 67) {
        if (omAlder == 42) {
          //La til en liten anekdote
          System.out.println("This is the answer to The Ultimate Question of Life, the Universe, and Everything.");
          System.out.println("Og din billettpriser " + fullpris + "kr");
        }
        else {
          System.out.println("Din billettpris er " + fullpris +"kr");
        }
      }
      else {
        System.out.println("Din billettpris er " + rabatt + "kr");
      }
    }
  }
