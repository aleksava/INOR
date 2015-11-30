import java.util.HashMap;
import java.util.Scanner;
import java.io.*;

class DVDAdministrasjon {

  //Declaring a HashMap and a place to hold the filename of wich file has been
  //read from.
  private HashMap<String, Person> persons = new HashMap<>();
  private String filename = "";

  //Constructor for DVDAdministrasjon, it starts up the loadFile method, and
  //gives it the file it's supposed to load. Also sets the filename for this
  //object. (Which as of this version is not needed, but will be needed later)
  public DVDAdministrasjon(String filename) throws Exception {
    loadFile(filename);
    this.filename = filename;
  }

  //Adds a new person to the HashMap persons, makes sure they don't allready
  //exists in the HashMap
  public void addPerson(String name) {

    //Uses the findPerson method to find a person with the given name
    if(findPerson(name) == null) {
      persons.put(name, new Person(name));
    }
    else {
      System.out.println("This person is allready in our register");
    }
  }

  //Gets a filename through the constructor for DVDAdministrasjon, reads a file
  //and adds the given persons and gives them their DVDs. Also takes car of the
  //DVDs that are borrowed away, and tho whom.
  public void loadFile(String filename) throws Exception {

    //Declaring Scanner, and the different strings, and other pointers to use
    //throughout the method. Could have gotten around the boolean one, but had
    //insufficient time
    Scanner fileScan = new Scanner(new File(filename));
    Person owner = null;
    String line = "";
    String dvdTitle = "";
    boolean breakTest = true;

    //Adds all the new persons to the persons archive
    while(fileScan.hasNextLine() && !(line.equals("-"))) {
      line = fileScan.nextLine();
      if(!(line.equals("-"))) {
        if(findPerson(line) == null) {
          addPerson(line);
        }
      }
    }

    //Gives the persons from above their DVDs and also rents out the DVDs that
    //are rented out
    while(fileScan.hasNextLine()) {

      //Have used the '#' as the last line in the file, so that it stops at the
      //correct timing.
      if(line.equals("-") && !(line.equals("#"))) {
        breakTest = true;
        line = fileScan.nextLine();
        owner = findPerson(line);

        //A failsafe if there is something wrong with the file, kicks in if
        //the method should try to give a person that doesn't exist a DVD.
        if(owner == null) {
          System.out.println("There was an error in reading the file. " +
                              "Please check the file, and try again");
          return;
        }

        //Adds all the DVDs of one person to them, also rents away those that
        //should be rented away.
        while(breakTest == true && !(line.equals("#"))) {
          line = fileScan.nextLine();
          if(line.equals("-")) {
            breakTest = false;
          }
          else {

            //Makes sure that the file hasen't ended yet
            if(!(line.equals("#"))) {
              dvdTitle = line;
            }

            //Corrects the name of the DVDs that are rented out, given that
            //these starts with a '*'.
            if(line.startsWith("*")) {
              dvdTitle = line.substring(1);
            }
            owner.newDVD(dvdTitle);

            //Checks if the DVD is borrowed away, and if it is, it uses the
            //method borrowAwayDVD to change possession
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

  //The user interface to manually add a new person to the persons archive
  //Uses the addPerson method to do this.
  public void addPersonInterace() {
    Scanner input = new Scanner(System.in);
    String newPerson = "";
    System.out.println("What's the name of the person you would like to add?");
    newPerson = input.nextLine();
    addPerson(newPerson);
  }


  //The user interface for when a user wants to add a new dvd to his/her
  //archive. Makes sure the user doesn't own two similar dvds and that the user
  //is in the system.
  public void buyInterface() {
    Scanner input = new Scanner(System.in);
    String buyer = "";
    String dvd = "";

    System.out.println("Who have bought a dvd?");
    buyer = input.nextLine();
    System.out.println("The buyer is " + buyer);
    System.out.println("And which dvd has he/she bought?");
    dvd = input.nextLine();

    //Looks for the person called buyer and if he/she exists, and if he/she
    //doesn't exist it prints out an error message.
    if(findPerson(buyer) == null) {
      System.out.println(buyer + " is not in our system, please add " +
                          "this person before you buy a dvd");
      return;
    }

    //Looks for the DVD the buyer has bought, and if it does, makes sure
    //the person can't own two similar DVDs.
    else if(findPerson(buyer).findDVD(dvd) != null) {
      System.out.println(buyer + " allready has this dvd, it is ill " +
                          "advised to own two similar DVDs, please return it");
    }
    else {
      findPerson(buyer).newDVD(dvd);
    }
  }

  //The user interface to rent a DVD from another user. The method asks who
  //wants to rent, who that person is renting from and which DVD.
  //It gives back appropriate error messages if something is wrong on the
  //users end
  public void rentInterface() {
    Scanner input = new Scanner(System.in);
    String dvd = "";
    String borrower = "";
    String owner = "";
    Person borrow = null;
    Person own = null;
    DVD theDVD = null;

    //User interface
    System.out.println("Which person would like to borrow a DVD?");
    borrower = input.nextLine();
    borrow = findPerson(borrower);
    System.out.println("From who is he/she going to borrow from?");
    owner = input.nextLine();
    own = findPerson(owner);
    System.out.println("Which DVD is about to be borrowed?");
    dvd = input.nextLine();
    theDVD = own.findDVD(dvd);

    //Makes sure that if the borrower doesn't exists, the user gets an error
    //message and it exits the method
    if(borrow == null) {
      System.out.println(borrower + " is not in our system, please add " +
                          "this person before you buy a dvd");
      return;
    }

    //Makes sure that if the owner doesn't exists, the user gets an error
    //message and it exits the method
    if(own == null) {
      System.out.println(owner + " is not in our system, please add " +
                          "this person before you buy a dvd");
      return;
    }

    //Uses the method changePossession on the DVD in question, and says so to
    //the user
    if(theDVD != null && (theDVD.getPossession().equals(theDVD.getOwner()))) {
      theDVD.changePossession(borrow);
      System.out.println(borrower + " has now borrowed " + dvd + " from " +
                          owner);
    }

    //An error message if the owner is not in possession of the DVD
    else {
      System.out.println(owner + " is not in possession of this DVD");
    }
  }

  //Uses the printDVDs method to print all the DVDs for a spesific person
  public void showPersonInterface() {
    Scanner input = new Scanner(System.in);
    String person = "";
    System.out.println("Who would you like info for? (Press '*' for all)\n");
    person = input.nextLine();

    //Looks for the input '*', and if it gets it, it prints the info for all
    //persons in the register
    if(person.equals("*")) {
      for (Person temp: persons.values()) {
        System.out.println("\n" + temp.toString() + " owns: ");
        System.out.println(temp.printDVDs());
      }
    }

    //Prints out the info for the spesific person requested.
    else {
      System.out.print(findPerson(person).printDVDs() + "\n");
    }
  }

  //Shows info for all the users, amount of DVDs and amount of DVDs borrowed
  //away
  public void showAllInterface() {
    for (Person temp: persons.values()) {
      System.out.println(temp.toString());
      System.out.println(temp.collection() + "\n");
    }
  }

  //The user interface to return a DVD
  public void returnDVDInterface() {
    Scanner input = new Scanner(System.in);
    String dvdTitle = "";
    String owner = "";
    String borrower = "";

    //UI
    System.out.println("Who borrowed the DVD?");
    borrower = input.nextLine();
    System.out.println("Whose DVD is it?");
    owner = input.nextLine();
    System.out.println("Which DVD is it?");
    dvdTitle = input.nextLine();

    //Checks that both persons exists and if they do, makes sure that the DVD
    //also exists, and if both of those are true, the movie gets returned
    if(findPerson(owner) != null && findPerson(borrower) != null) {
      if(findPerson(owner).returnDVD(dvdTitle, findPerson(borrower))){
        System.out.println("\nThe movie has been delivered!");
      }
      else {
        System.out.println("\nThis movie doesn't exist, " +
                            "therefore it can't be delivered");
      }
    }
    else {
      System.out.println("\nOne or both of these persons do not exist in " +
                          "this system, therefore the DVD can't be delivered");
    }
  }

  //A futile attempt at printing to file
  public void printFile() throws Exception {
    PrintWriter writer = new PrintWriter("testFile.txt");
    writer.println("Testing 1");

    for(Person subject: persons.values()) {
      writer.println(subject.toString());
    }

    writer.println("-");

    for(Person subject: persons.values()) {
      writer.println(subject);
    //  for(DVD aDVD: subject.)
    }
  }

  //User interface for the menu, takes in input from the user, and initiates
  //the correct methods
  public void menuInterface() {
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

  //Prints the menu
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
