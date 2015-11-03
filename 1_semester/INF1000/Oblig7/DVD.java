class DVD {
  private String title;
  private Person owner;
  private Person possession;

  //Constructor, setting the title, owner and giving the owner possession
  public DVD (String title, Person owner) {
    this.title = title;
    this.owner = owner;
    this.possession = owner;
  }

  //Returns the title of the DVD
  public String toString() {
    return title;
  }

  //Returns the owner of the DVD
  public Person getOwner() {
    return owner;
  }

  //Returns the possession
  public Person getPossession() {
    return possession;
  }
  //Changes the possession of the DVD to the given name
  public void changePossession(Person name) {
    possession = name;
  }
}
