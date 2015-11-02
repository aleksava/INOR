import java.util.HashMap;
import java.util.Scanner;
import java.io.*;

class DVDAdministrasjon {

  //Declaring a HashMap and a place to hold the filename of wich file has been
  //read from.
  private HashMap<String, Person> persons = new HashMap<>();
  private String filename = "";

  //Constructor
  public DVDAdministrasjon(String filename) throws Exception {
    loadFile(filename);
    this.filename = filename;
  }

  //Adds a new person to the HashMap persons
  public void addPerson(String name) {
    if(findPerson(name) == null) {
      persons.put(name, new Person(name));
    }
    else {
      System.out.println("This person is allready in our register");
    }
  }

  //Gets a filename through the Constructor for DVDAdministrasjon, reads a file
  //and adds the given persons and gives them their DVDs. Also displays the
  //DVDs that are borrowed away, and tho whom.
  public void loadFile(String filename) throws Exception {
    Scanner fileScan = new Scanner(new File(filename));
    Person owner = null;
    String line = "";


    while(fileScan.hasNextLine()) {
      line = fileScan.nextLine();

      //Huston we have a problem, way to many person objects FIX IT!!
      if(line != "-") {
        System.out.println("Linja er ulik '-'");
        if(findPerson(line) == null){
        persons.put(line, new Person(line));
        }
      }
      else if(line == "-") {
        line = fileScan.nextLine();
        owner = findPerson(line);
        while(line != "-") {
          if(owner == null) {
            System.out.println("There was an error in reading the file. " +
                                "Please check the file, and try again");
            return;
          }
          else {
            System.out.println("REMOVE THIS!!! " + line);
            owner.newDVD(line);
          }
        }
      }
      else if(line.startsWith("*")) {
        String dvdTitle = line.substring(1);
        System.out.println("REMOVE THIS!!! " + dvdTitle);
        line = fileScan.nextLine();
        owner.borrowAwayDVD(findPerson(line), dvdTitle);
      }
    }
    for (String s: persons.keySet()) {
      System.out.println(s);

    }
  }


  //Goes through the HashMap of persons and returns the person with the given
  //name, if that person doesn't exist it returns null
  public Person findPerson(String name) {
    for(String key: persons.keySet()) {
      if(name == key) {
        System.out.println("Fant Aleksander");
        return persons.get(key);
      }
    }
    return null;
  }


  public void addPersonInterace() {
    Scanner input = new Scanner(System.in);
    String newPerson = "";
    System.out.println("What's the name of the person you would like to add?");
    newPerson = input.nextLine();
    addPerson(newPerson);
  }


  //Getting nullPointerException when looking for the dvd search
  public void buyInterface() {
    Scanner input = new Scanner(System.in);
    String buyer = "";
    String dvd = "";

    System.out.println("Who have bought a dvd?");
    buyer = input.nextLine();
    System.out.println("The buyer is " + buyer);
    System.out.println("And which dvd has he/she bought?");
    dvd = input.nextLine();

    /*if(findPerson(buyer) == null) {
      System.out.println(buyer + " is not in our system, please add " +
                          "this person before you buy a dvd");
      return;
    }
    else if(findPerson(buyer).findDVD(dvd) != null) {
      System.out.println(buyer + " allready has this dvd, it is ill " +
                          "advised to own to similar DVDs, please return it");
    }
    else {*/
      findPerson(buyer).newDVD(dvd);
    //}
  }

  //Untestet as I cannot buy add new DVDs
  public void borrowInterface() {
    Scanner input = new Scanner(System.in);
    String dvd = "";
    String borrower = "";
    String owner = "";
    Person borrow = null;
    Person own = null;
    DVD theDVD = null;

    System.out.println("Which person would like to borrow a DVD?");
    borrower = input.nextLine();
    borrow = findPerson(borrower);
    System.out.println("From who is he/she going to borrow from?");
    owner = input.nextLine();
    own = findPerson(owner);
    System.out.println("Which DVD is about to be borrowed?");
    dvd = input.nextLine();
    theDVD = own.findDVD(dvd);

    if(borrow == null) {
      System.out.println(borrower + " is not in our system, please add " +
                          "this person before you buy a dvd");
      return;
    }
    if(own == null) {
      System.out.println(owner + " is not in our system, please add " +
                          "this person before you buy a dvd");
      return;
    }

    if(theDVD != null) {
      theDVD.changePossession(borrow);
      System.out.println(borrower + " has now borrowed " + dvd + " from " +
                          owner);
    }
    else {
      System.out.println(owner + " is not in posession of this DVD");
    }
  }

  //Uses the printDVDs method to print all the DVDs for a spesific person
  public void showPersonInterface() {
    Scanner input = new Scanner(System.in);
    String person = "";
    System.out.println("Who would you like info for? (Press '*' for all)");
    person = input.nextLine();
    if(person == "*") {
      printAll();
    }
    else {
      System.out.println(findPerson(person).printDVDs());
    }
  }

  public void showAllInterface() {
    for (Person temp: persons.values()) {
      System.out.println(temp.toString());
      temp.collection();
    }
  }

  //Used in showPerson in case it wants all the persons
  public void printAll() {
    for (Person temp: persons.values()) {
      System.out.println(temp.toString());
      temp.printDVDs();
    }
  }
}
