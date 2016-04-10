import java.util.*;
import java.io.*;

class Oblig7 {

  static String filnavn = "dataset.txt";
  Tabell<Pasient> patientTable = new Tabell<>(100);
  Tabell<Legemiddel> drugTable = new Tabell<>(100);
  SortertEnkelListe<Lege> docList = new SortertEnkelListe<>();
  NyEldsteForstReseptListe perscriptionList = new NyEldsteForstReseptListe();

  public static void main(String[] args) throws IOException {
    System.out.println("Starting program");
    Oblig7 system = new Oblig7(filnavn);
    system.menu();
    system.printFile(filnavn);
    System.out.println("Ending program");
  }

  public Oblig7(String filename) {
    try {
      this.read(filename);
    }
    catch(IOException e) {
      System.out.println("Something went wrong during the reading of the file");
    }

  }

  private void menu() {
    String input;
    Scanner key = new Scanner(System.in);
    while(true) {
      System.out.println("\n"+
                  "1 : Print all patients.\n"+
                  "2 : Print all doctors.\n"+
                  "3 : Print all perscriptions.\n"+
                  "4 : Print all drugs.\n"+
                  "5 : Create and add a new drug.\n"+
                  "6 : Create and add a new doctor.\n"+
                  "7 : Create and add a new patient.\n"+
                  "8 : Create and add a new perscription.\n"+
                  "9 : Get the drug of a perscription.\n"+
                  "S : Statistics\n"+
                  "E : Save and exit.\n");

      input = key.nextLine();

      switch (input.toLowerCase().substring(0,1)) {
                  case "1" :
                      printPatients();
                      break;
                  case "2" :
                      printDoctors();
                      break;
                  case "3" :
                      printPerscriptions();
                      break;
                  case "4" :
                      printDrugs();
                      break;
                  case  "5" :
                      addDrug();
                      break;
                  case "6" :
                      addDoctor();
                      break;
                  case "7" :
                      addPatient();
                      break;
                  case "8" :
                      addPerscription();
                      break;
                  case "9" :
                      getDrugAtPerscription();
                      break;
      			      case "s" :
      				        statistics();
      				        break;
                  case "e" :

                      return;
      }
    }
  }

  private void read(String filename) throws IOException {
    String type = "";
    File file = new File(filename);
    if(!file.exists()) return;
    Scanner scan = new Scanner(file);

    //Troubleshooting
    //System.out.println("Before the while loop");

    while(scan.hasNextLine()) {

      //Troubleshooting
      //System.out.println("Just inside the while loop");

      String[] line = scan.nextLine().split(", ");

      if(line[0].length() == 0) {
        type = "";
      }

      else if(line[0].substring(0,1).equals("#")) {
        String[] typeLine = line[0].split(" ");
        type = typeLine[1];
      }

      else {

        //Troubleshooting
        /*System.out.println("Inside the else, where it finds which kind of method it should use");
        System.out.println(type);
        for(int i = 0; i < line.length; i++) {
          System.out.println(line[i]);
        }*/

        switch(type) {
          case "Personer" :
            //System.out.println("Personer");
            addPatient(line);
            break;
          case "Leger" :
            //System.out.println("Leger");
            addDoctor(line);
            break;
          case "Legemidler" :
            //System.out.println("Legemidler");
            addDrug(line);
            break;
          case "Resepter" :
            //System.out.println("Resepter");
            addPerscription(line);
            break;
        }
      }
    }
  }

  private void printFile(String filename) {
    try {
      PrintWriter printer = new PrintWriter(new File("test.txt"));
      printer.println("# Personer (nr, navn, fnr, adresse, postnr)");
      for(Pasient p: patientTable) {
        if(p != null) {
          printer.println(p.print());
        }
      }

      printer.println("");
      printer.println("# Legemidler (nr, navn, form, type, pris, antall/mengde, virkestoff, stryke)");
      for(Legemiddel d: drugTable) {
        if(d != null) {
          printer.println(d.print());
        }
      }

      printer.println("");
      printer.println("# Leger (navn, avtalenr / 0 hvis ingen avtale)");
      for(Lege doc: docList) {
        printer.println(doc.print());
      }

      printer.println("");
      printer.println("# Resepter (nr, hvit/blaa, persNummer, legeNavn, legemiddelNummer, reit)");
      for(Resept per: perscriptionList) {
        printer.println(per.print());
      }

      printer.println("\n\n# Slutt");
      printer.close();

    }
    catch(FileNotFoundException e) {
      System.out.println("Couldn't create the file");
    }
  }

  private void printPatients() {
    for(Pasient pas: patientTable) {
      if(pas != null) {
        System.out.println(pas);
      }
    }
  }

  private void printDoctors() {
    docList.printAll();
  }

  private void printPerscriptions() {
    for(Resept res: perscriptionList) {
      if(res != null) {
        System.out.println("Patient: " + res.getPatID() + "\nDrug: " + res.getDrug() + "\n");
      }
    }
  }

  private void printDrugs() {
    for(Legemiddel drug: drugTable) {
      if(drug != null) {
        System.out.println(drug);
      }
    }
  }

  //Method that adds a drug with the allready proper info in an array
  private Legemiddel addDrug(String[] line) {
    Legemiddel drug = null;

    //Checks for which type of drug it should add
    switch(line[3]) {
      case "a" : //Narcotic
        if(line[2].equals("pille")) {
          //# Legemidler (nr, navn, form, type, pris, antall/mengde, virkestoff [, styrke])
          drug = new LegemiddelA(line[1], //Name
                                Integer.parseInt(line[4]), //Price
                                Integer.parseInt(line[0]), //serialNumber
                                Integer.parseInt(line[5]), //Number of pills
                                -1, //mikstur stuff
                                Double.parseDouble(line[6]), //Active substance
                                Integer.parseInt(line[7]) //Narcotic strength
                                );


        }

        else if(line[2].equals("mikstur")) {
          drug = new LegemiddelA(line[1], //Name
                                Integer.parseInt(line[4]), //Price
                                Integer.parseInt(line[0]), //serialNumber
                                -1, //pill stuff
                                Double.parseDouble(line[5]), //Volume
                                Double.parseDouble(line[6]), //Active substance
                                Integer.parseInt(line[7]) //Narcotic strength
                                );
        }
        break;

      case "b" : //Addictive
        if(line[2].equals("pille")) {
          //# Legemidler (nr, navn, form, type, pris, antall/mengde, virkestoff [, styrke])
          drug = new LegemiddelB(line[1], //Name
                                Integer.parseInt(line[4]), //Price
                                Integer.parseInt(line[0]), //serialNumber
                                Integer.parseInt(line[5]), //Number of pills
                                -1, //mikstur stuff
                                Double.parseDouble(line[6]), //Active substance
                                Integer.parseInt(line[7]) //Addictive strength
                                );


        }

        else if(line[2].equals("mikstur")) {
          drug = new LegemiddelB(line[1], //Name
                                Integer.parseInt(line[4]), //Price
                                Integer.parseInt(line[0]), //serialNumber
                                -1, //pill stuff
                                Double.parseDouble(line[5]), //Volume
                                Double.parseDouble(line[6]), //Active substance
                                Integer.parseInt(line[7]) //Addictive strength
                                );
        }
        break;

      case "c" : //Regular
        if(line[2].equals("pille")) {
          //# Legemidler (nr, navn, form, type, pris, antall/mengde, virkestoff [, styrke])
          drug = new LegemiddelC(line[1], //Name
                                Integer.parseInt(line[4]), //Price
                                Integer.parseInt(line[0]), //serialNumber
                                Integer.parseInt(line[5]), //Number of pills
                                0, //mikstur stuff
                                Double.parseDouble(line[6]) //Active substance
                                );
        }

        else if(line[2].equals("mikstur")) {
          drug = new LegemiddelC(line[1], //Name
                                Integer.parseInt(line[4]), //Price
                                Integer.parseInt(line[0]), //serialNumber
                                0, //pill stuff
                                Double.parseDouble(line[5]), //Volume
                                Double.parseDouble(line[6]) //Active substance
                                );
        }
        break;

      default : System.out.println("Couldn't add this drug");
        break;
    }

    drugTable.addAt(drug, drug.getSerial());
    return drug;
  }

  private Lege addDoctor(String[] line) {
    Lege doc = null;
    if(Integer.parseInt(line[1]) != 0) {
      doc = new Lege(line[0], Integer.parseInt(line[1]));
    }

    else {
      doc = new Lege(line[0], -1);
    }

    docList.add(doc);
    return doc;
  }

  private Resept addPerscription(String[] line) {
    //# Resepter (nr, hvit/blÃ¥, persNummer, legeNavn, legemiddelNummer, reit)
    boolean blue = line[1].equals("blaa");
    Resept per = new Resept(drugTable.getAt(Integer.parseInt(line[4])), //Drug
                            line[3], //Name of the doctor
                            Integer.parseInt(line[2]), //ID of the patient
                            blue, //Whether or not it's blue
                            Integer.parseInt(line[0]), //Serial number
                            Integer.parseInt(line[5]) //Reit
                            );

    perscriptionList.add(per);
    return per;
  }

  private Pasient addPatient(String[] line) {
    Pasient p = new Pasient(line[1], //Name
                            Long.parseLong(line[2]), //ID
                            line[3], //Adress
                            Integer.parseInt(line[4]), //Area code
                            Integer.parseInt(line[0])  //Patient number
                            );

    boolean add = patientTable.addAt(p, p.getPatient());
    if(!add) {
      System.out.println("Couldn't add patient");
    }

    return p;
  }

  private void addDrug() {
    //# Legemidler (nr, navn, form, type, pris, antall/mengde, virkestoff [, styrke])
    String[] info = new String[8];
    boolean valid = true;

    if(drugTable.firstFreeSpot() == -1) {
      System.out.println("The drug table is full");
      return;
    }

    info[0] = Integer.toString(drugTable.firstFreeSpot());

    info[1] = typeInput("Please type in the name of the drug");

    valid = true;
    while(valid) {
      info[2] = typeInput("Is the drug a pille or mikstur? " +
      "\nPlease type in 'pille' or 'mikstur'");
      if(info[2].equals("pille") || info[2].equals("mikstur")) {
        valid = false;
      }
    }

    valid = true;
    while(valid) {
      info[3] = typeInput("Is the drug: A - narcotic, B - addictive, or C - Regular? " +
      "\nPlease type in A, B or C");
      if(info[3].equals("a") || info[3].equals("b") || info[3].equals("c")) {
        valid = false;
      }
    }

    info[4] = typeNumber("Please type in the price of the drug");
    info[5] = typeNumber("Please type in the amount of the drug, volume or number");
    info[6] = typeNumber("Please type in the amount of active substance");
    if(info[3].equals("c")) {
      addDrug(info);
      return;
    }
    info[7] = typeNumber("Please type in the strength");
    addDrug(info);
}

  private void addDoctor() {
    Scanner key = new Scanner(System.in);
    String[] info = new String[2];
    boolean valid = true;
    int contract = -1;

    System.out.println("\nPlease type in the name of the doctor: ");
    info[0] = key.nextLine();

    info[1] = typeNumber("Please type the contract number, 0 for no contract");

    addDoctor(info);
  }

  private void addPerscription() {
    //# Resepter (nr, hvit/blÃ¥, persNummer, legeNavn, legemiddelNummer, reit)
    String[] info = new String[6];

    info[0] = Integer.toString(perscriptionList.size());
    info[1] = typeInput("Is the perscription hvit or blaa?");
    info[2] = typeNumber("Please type in your birth number (Social security)");
    info[3] = typeInput("Please type in the name of the doctor");
    info[4] = typeNumber("Please type in the ID of the drug");
    info[5] = typeInput("Please type in the reit of the perscription");

    addPerscription(info);
  }

  private void addPatient() {
    //# Personer (nr, navn, fnr, adresse, postnr)
    String[] info = new String[5];

    if(patientTable.firstFreeSpot() == -1) {
      System.out.println("The patient table is full");
      return;
    }

    info[0] = Integer.toString(patientTable.firstFreeSpot());
    info[1] = typeInput("Please type in the name of the patient");
    info[2] = typeNumber("Please type in the ID number of the patient");
    info[3] = typeInput("Please type in the patient's adress");
    info[4] = typeInput("Please type in the patient's area code");

    addPatient(info);
  }

  private void getDrugAtPerscription() {
    String pID = typeNumber("Type in the patients ID or social security");
    Pasient pas = null;

    try {
      pas = getPatient(pID);
    }
    catch(NoSuchElementException e) {
      System.out.println(e.getMessage());
    }

    Resept per = perscriptionList.get(typeNumber("Serial number please"));

    if(pas.getPatient() != per.getPatID()) {
      System.out.println("This patient has nothing to do with this perscription");
      return;
    }

    if(per.getReit() > 0) {
      per.use();
      System.out.println("Price: " + per.getDrug().getPrice());
      System.out.println("Doctor: " + per.getDoc());
      System.out.println("PatientID: " + per.getPatID());
    }

    else {
      System.out.println("This perscription has expired, please contact " +
                          per.getDoc());
    }

  }

  private void statistics() {

  }

  private String typeInput(String message) {
    Scanner key = new Scanner(System.in);
    String out = "";
    boolean valid = true;

    while(valid) {
      System.out.println("\n" + message + ": ");
      out = key.nextLine().toLowerCase();
      valid = false;
      if(out.contains(", ")) {
        System.out.println("The input can't contain ', ' please try again");
        valid = true;
      }
    }

    return out;
  }

  private String typeNumber(String message) {
    Scanner key = new Scanner(System.in);
    String out = "";
    boolean valid = true;
    long number = 0;

    while(valid) {
      System.out.print("\n" + message + ": ");
      out = key.nextLine();
      valid = false;
      try {
        number = Long.parseLong(out);
      }
      catch(NumberFormatException e) {
        System.out.println("Your input has to be a number, please try again");
        valid = true;
      }
    }

    return out;
  }

  private Pasient getPatient(String pID) {
    for(Pasient p: patientTable) {
      if(p != null && p.getID() == Long.parseLong(pID)) {
        return p;
      }
    }
    throw new NoSuchElementException("Couldn't find the patient, sorry 'bout that");
  }
}
