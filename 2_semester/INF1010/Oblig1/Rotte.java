class Rotte {
  private String name;
  private Boolean status;

  public Rotte(String name) {
    this.name = name;
    status = true;
  }

  public void attackRat() {
    if(status) {
      System.out.println(name +
                          " the rat has gone from being alive to wounded.\n");
      status = false;
    }
    else if(!status) {
      System.out.println(name + " the rat, sadly, has now died.\n");
      status = null;
    }
  }

  public Boolean status() {
    return status;
  }

  public String toString() {
    return name;
  }
}
