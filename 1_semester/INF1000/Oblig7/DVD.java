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

  public String toString() {
    return title;
  }

  public Person getOwner() {
    return owner;
  }

  public void changePossession(Person name) {
    possession = name;
  }

  public Person getPossession() {
    return possession;
  }
}
