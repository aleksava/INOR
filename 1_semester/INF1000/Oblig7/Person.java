import java.util.HashMap;

class Person {
  private String name;


  HashMap<String, DVD> ownedDVDs = new HashMap<>();
  HashMap<String, DVD> borrowedDVDs = new HashMap<>();

  public Person (String name) {
    this.name = name;
  }

  public String toString() {
    return name;
  }

  public void newDVD(String title) {
    DVD addDVD = new DVD(title, this)
    ownedDVDs.put(title, addDVD);
  }



}
