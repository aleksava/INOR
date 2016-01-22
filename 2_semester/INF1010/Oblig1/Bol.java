class Bol <T> {
  private T rodent;

  public void enterBol(T rodent) {
    if(this.rodent == null) {
      this.rodent = rodent;
      return;
    }

    System.out.println("Sorry, but this bol is allready occupied.\n");
  }

  public T getRodent() {
    return rodent;
  }

  public boolean isEmpty() {
    if(rodent == null) {
      return false;
    }
    return true;
  }
}
