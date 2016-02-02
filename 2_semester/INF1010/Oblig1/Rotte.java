class Rotte {

  //Standard declaring of class variables, using Boolean with a capital 'B'
  //because it has three states; true, false and null; alive, wounded and dead
  private String name;
  private Boolean status;

  public Rotte(String name) {
    this.name = name;
    status = true;
  }

  //Checks the current status of the rat, and does the appropriate reaction to
  //being attacked.
  public void attackRat() {

    //Wounds the rat
    if(status) {
      System.out.println(name +
                          " the rat has gone from being alive to wounded.\n");
      status = false;
    }

    //Kills the rat
    else if(!status) {
      System.out.println(name + " the rat, sadly, has now died.\n");
      status = null;
    }
  }

  //Returns the status of the rat
  public Boolean status() {
    return status;
  }

  //Returns the name of the mouse
  public String toString() {
    return name;
  }
}
