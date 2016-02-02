class Bol <T> {
  private T rodent;

  //Method that checks that if the Bol is empty you can add a new rodent
  //If it's allready occupied then it prints out an error message
  public void enterBol(T rodent) {
    if(this.rodent == null) {
      this.rodent = rodent;
      return;
    }

    //The aforementioned error message
    System.out.println("Sorry, but this bol is allready occupied.\n");
  }

  //Mehtod that returns the rodent in the Bol
  public T getRodent() {
    return rodent;
  }

  //Method that checks if the Bol is empty, returns false if it is, and true
  //if the Bol is full
  public boolean isEmpty() {
    if(rodent == null) {
      return false;
    }
    return true;
  }
}
