import java.util.HashMap;

class Person {
  private String name;
  private HashMap<String, DVD> allDVDs = new HashMap<>();

  //Constructor
  public Person (String name) {
    this.name = name;
  }

  //Returns the name of the person i question
  public String toString() {
    return name;
  }

  //Adds a new DVD to this persons list of DVDs
  public void newDVD(String title) {
    DVD aDVD = new DVD(title, this);
    allDVDs.put(title, aDVD);
  }

  //Goes through all the keys in the entire HashMap, and finds the DVD with the
  //DVD with the matching key. Returns null if the DVD doesn't exists in this
  //persons possession
  public DVD findDVD(String title) {
    for(DVD aDVD: allDVDs.values()) {
      if(title.equals(aDVD.toString())) {
        return aDVD;
      }
    }
    return null;
  }

  //Printing out all the DVDs this person has
  public String printDVDs() {
    String printString = "";
    for(String key: allDVDs.keySet()) {
      printString += "\n" + key;
      DVD aDVD = findDVD(key);
      if(aDVD.getOwner() == aDVD.getPossession()){
        printString += "";
      }
      else {
        printString += (" borrowed by " + aDVD.getPossession().toString());
      }
    }
    return printString;
  }

  //Returns all the DVDs this person has in a HashMap
  public HashMap getAllDVDs() {
    return allDVDs;
  }

  //Returns the total amount of DVDs this person is in posession of
  public int dvdAmount() {
    return allDVDs.size();
  }

  public void borrowAwayDVD(Person name, String title) {
    DVD aDVD = findDVD(title);
    if(aDVD == null) {
      System.out.println("This DVD doesn't exist");
    }
    else {
      if(aDVD.getOwner() != aDVD.getPossession()) {
        System.out.println("Sorry but this DVD is allready borrowed away " +
                            "to " + aDVD.getPossession().toString());
      }
      else {
        aDVD.changePossession(name);
      }
    }
  }

  //Method to return a DVD, takes in the DVD title and it's borrower
  public boolean returnDVD(String title, Person borrower) {
    DVD aDVD = findDVD(title);
    if(aDVD == null) {
      return false;
    }
    if(aDVD.getPossession() == borrower) {
      aDVD.changePossession(aDVD.getOwner());
      return true;
    }
    return false;
  }

  //Prints out this persons total amount of DVDs and the amount of which are
  //borrowed away
  public String collection() {
    int total = 0;
    int borrowedAway = 0;
    String returnString = "";

    for(DVD aDVD: allDVDs.values()) {
      if(aDVD.getOwner() != aDVD.getPossession()) {
        borrowedAway ++;
        total ++;
      }
      else {
        total ++;
      }
    }
    returnString = "This person has " + total + " DVDs in his collection. " +
                    borrowedAway + " of those are borrowed away.";
    return returnString;
  }
}
