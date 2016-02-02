class Mus {

  //Standard declaring of class variables, using primitive boolean to describe
  //the status of the mouse, either alive or dead, true or false
  private String name;
  private boolean status;

  public Mus(String name) {
    this.name = name;
    status = true;
  }

  //Method that kills the mouse and prints so
  public void murderMouse() {
    System.out.println(name + " the mouse has died.\n");
    status = false;
  }

  //Method that gives the status of the mouse
  public boolean status() {
    return status;
  }

  //Returns the name of the mouse
  public String toString() {
    return name;
  }
}
