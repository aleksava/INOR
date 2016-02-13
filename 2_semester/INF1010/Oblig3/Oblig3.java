import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

class Oblig4 {

  static ArrayList<Bil> readFile(String fileText) throws Exception {
    Scanner file = new Scanner(new File(fileText));
    ArrayList<Bil> parkinglot = new ArrayList<>();
    String[] parts;
    String text;

    while(file.hasNextLine()) {
      text = file.nextLine();
      parts = text.split(" ");

      /*if(parts[0].equalsIgnoreCase("Bil")) {
        parkinglot.add(new Bil(parts[1]));
      }

      else if(parts[0].equalsIgnoreCase("El")) {
        parkinglot.add(new ElBil(parts[1], Integer.parseInt(parts[2])));
      }

      else if(parts[0].equalsIgnoreCase("Fossil")) {
        parkinglot.add(new FossilBil(parts[1], Double.parseDouble(parts[2])));
      }

      else if(parts[0].equalsIgnoreCase("Lastebil")) {
        parkinglot.add(new Lastebil(parts[1], Double.parseDouble(parts[2]),
                        Double.parseDouble(parts[3])));
      }

      else if(parts[0].equalsIgnoreCase("Personfossilbil")) {
        parkinglot.add(new Personbil(parts[1], Double.parseDouble(parts[2]),
                        Integer.parseInt(parts[3])));
      }*/

      switch(parts[0].toUpperCase()) {
        case "BIL" : parkinglot.add(new Bil(parts[1]));
            break;

        case "EL" : parkinglot.add(new ElBil(parts[1],
                                    Integer.parseInt(parts[2])));
            break;

        case "FOSSIL" : parkinglot.add(new FossilBil(parts[1],
                                        Double.parseDouble(parts[2])));
            break;

        case "LASTEBIL" : parkinglot.add(new Lastebil(parts[1],
                                          Double.parseDouble(parts[2]),
                                          Double.parseDouble(parts[3])));
            break;

        case "PERSONFOSSILBIL" : parkinglot.add(new Personbil(parts[1],
                                                Double.parseDouble(parts[2]),
                                                Integer.parseInt(parts[3])));
      }
    }

    return parkinglot;
  }

  static void printInfo(ArrayList<Bil> parkinglot) {
    Personbil pCar;
    for(Bil car : parkinglot) {
      if(car instanceof Personbil) {
        pCar = (Personbil) car;
        System.out.println("\nThe passenger car with the registration " +
                            pCar.getPlate() + " has CO2 emissions at " +
                            pCar.getEmi() + ", and has room for " +
                            pCar.getPass() + " passengers.");
      }
    }

    //Formatting
    System.out.println();
  }

  static void printAllRegNr(ArrayList<Bil> parkinglot) {
    System.out.println("\nHere are the licenseplates of all the cars in the " +
                        "entire parkinglot: ");
    for(Bil car : parkinglot) {
      System.out.println(car.getPlate());
    }
    System.out.println();
  }

  public static void main(String[] args) throws Exception {
    printAllRegNr(readFile("carsheet.txt"));
    printInfo(readFile("carsheet.txt"));
  }
}
