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
    String dvdTitle = "";
    boolean breakTest = true;

    while(fileScan.hasNextLine() && !(line.equals("-"))) {
      line = fileScan.nextLine();
      if(!(line.equals("-"))) {
        if(findPerson(line) == null){
          addPerson(line);
        }
      }
    }

    while(fileScan.hasNextLine()) {

      if(line.equals("-") && !(line.equals("#"))) {
        breakTest = true;
        line = fileScan.nextLine();
        owner = findPerson(line);
        if(owner == null) {
          System.out.println("There was an error in reading the file. " +
                              "Please check the file, and try again");
          return;
        }
        while(breakTest == true && !(line.equals("#"))) {
          line = fileScan.nextLine();
          if(line.equals("-")) {
            breakTest = false;
          }
          else {
            if(!(line.equals("#"))) {
              dvdTitle = line;
            }
            if(line.startsWith("*")) {
              dvdTitle = line.substring(1);
            }
            owner.newDVD(dvdTitle);
            if(line.startsWith("*") && !(line.equals("#"))) {
              line = fileScan.nextLine();
              owner.borrowAwayDVD(findPerson(line), dvdTitle);
            }
          }
        }
      }
    }
  }


  //Goes through the HashMap of persons and returns the person with the given
  //name, if that person doesn't exist it returns null
  public Person findPerson(String name) {
    for(Person subject: persons.values()) {
      if(name.equals(subject.toString())) {
        return subject;
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

    if(findPerson(buyer) == null) {
      System.out.println(buyer + " is not in our system, please add " +
                          "this person before you buy a dvd");
      return;
    }
    else if(findPerson(buyer).findDVD(dvd) != null) {
      System.out.println(buyer + " allready has this dvd, it is ill " +
                          "advised to own two similar DVDs, please return it");
    }
    else {
      findPerson(buyer).newDVD(dvd);
    }
  }

  //Untestet as I cannot buy add new DVDs
  public void rentInterface() {
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

    if(theDVD != null && (theDVD.getPossession().equals(theDVD.getOwner()))) {
      theDVD.changePossession(borrow);
      System.out.println(borrower + " has now borrowed " + dvd + " from " +
                          owner);
    }
    else {
      System.out.println(owner + " is not in possession of this DVD");
    }
  }

  //Uses the printDVDs method to print all the DVDs for a spesific person
  public void showPersonInterface() {
    Scanner input = new Scanner(System.in);
    String person = "";
    System.out.println("Who would you like info for? (Press '*' for all)");
    person = input.nextLine();
    if(person.equals("*")) {
      for (Person temp: persons.values()) {
        System.out.println("\n" + temp.toString());
        System.out.println(temp.printDVDs());
      }
    }
    else {
      System.out.print(findPerson(person).printDVDs() + "\n");
    }
  }

  public void showAllInterface() {
    for (Person temp: persons.values()) {
      System.out.println(temp.toString());
      System.out.println(temp.collection() + "\n");
    }
  }

  public void returnDVDInterface() {
    Scanner input = new Scanner(System.in);
    String dvdTitle = "";
    String owner = "";
    String borrower = "";

    System.out.println("Who borrowed the DVD?");
    borrower = input.nextLine();
    System.out.println("Whose DVD is it?");
    owner = input.nextLine();
    System.out.println("Which DVD is it?");
    dvdTitle = input.nextLine();

    if(findPerson(owner) != null && findPerson(borrower) != null) {
      if(findPerson(owner).returnDVD(dvdTitle, findPerson(borrower))){
        System.out.println("The movie has been delivered!");
      }
      else {
        System.out.println("This movie doesn't exist, therefore it can't be " +
                            "delivered");
      }
    }
    else {
      System.out.println("One or both of these persons do not exist in this " +
                          "system, therefore the DVD can't be delivered");
    }
  }

  public void menu() {
    Scanner input = new Scanner(System.in);
    int choice = 10;
    while(choice != 0) {
      printMenu();
      choice  = Integer.parseInt(input.nextLine());
      System.out.println();
      if(choice == 1) {
        addPersonInterace();
      }
      if(choice == 2) {
        buyInterface();
      }
      if(choice == 3) {
        rentInterface();
      }
      if(choice == 4) {
        showPersonInterface();
      }
      if(choice == 5) {
        showAllInterface();
      }
      if(choice == 6) {
        returnDVDInterface();
      }
    }
  }

  public void printMenu() {
    System.out.println("\nPress 1 to add a new person");
    System.out.println("Press 2 to add a new DVD");
    System.out.println("Press 3 to rent a DVD");
    System.out.println("Press 4 to show a person");
    System.out.println("Press 5 to show all the persons");
    System.out.println("Press 6 to return a DVD");
    System.out.println("Press 0 to exit\n");
  }
}
