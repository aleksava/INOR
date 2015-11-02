import java.util.HashMap;

class Person {
  private String name;

  HashMap<String, DVD> allDVDs = new HashMap<>();

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
    for(String s: allDVDs.keySet()) {
      if(s == title) {
        return allDVDs.get(s);
      }
    }
    return null;
  }

  //Printing out all the DVDs this person has
  public void printDVDs() {
    for(String key: allDVDs.keySet()) {
      System.out.print(key);
      DVD aDVD = findDVD(key);
      if(aDVD.getOwner() == aDVD.getPossession()){
        System.out.println("");
      }
      else {
        System.out.println(" borrowed by " + aDVD.getPossession());
      }
    }
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
        System.out.println("There you go, you have now borrowed " +
                            aDVD.toString() + "\n");
      }
    }
  }

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

  //Should have a sopl with all the borrowed dvds, borrowedAway dvds, and owned
  //dvds come back to this later
  public void collection() {
    int total = 0;
    int borrowedAway = 0;
    int borrowed = 0;
    for(DVD aDVD: allDVDs.values()) {
      if(aDVD.getOwner() != aDVD.getPossession() ||
          this == aDVD.getPossession()) {
        borrowed ++;
      }
      else if(aDVD.getOwner() == aDVD.getPossession()) {
        total ++;
      }
      else {
        borrowedAway ++;
      }
    }
  }


}
