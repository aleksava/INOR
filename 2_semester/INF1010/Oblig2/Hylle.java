class Hylle <E> implements GenHylle<E> {

  //Creating the shelf, but awaiting the declaring.
  private E[] shelf;

  //A constructor that sends with the size of the shelf, and then declaring
  //the rest of the shelf.
  public Hylle(int size) {
    @Suppresswarnings ("unchecked")
    shelf = (E[]) new Object[size];
  }

  //Returns the size of the shelf.
  public int size() {
    return shelf.length;
  }

  //A method that places the given item, to the given spot on the shelf, given
  //that the shelf is large enough, and that the spot is empty.
  public void place(E item, int num) {

    //Checking if the shelf is to short for the given spot.
    if(num >= shelf.length || num < 0) {
      System.out.println("The shelf is to short for this spot, therefore " +
                          "the book fell off.");
      return;
    }

    //Checking if the given spot is empty, so that the object can be placed.
    if(vacant(num)) {
      shelf[num] = item;
      return;
    }

    //The final error message that only prints if the book fits and the spot
    //is allready taken.
    System.out.println("Sorry, but spot number " + num + " is allready taken");
  }

  //Checks if the given spot is empty.
  public boolean vacant(int num) {
    if(shelf[num] == null) {
      return true;
    }

    return false;
  }

  //Returns the object on the given spot, also checks that the spot is not
  //vacant, using the vacant(num).
  public E take(int num) {
    E obj;
    if(!vacant(num)) {
      obj = shelf[num];
      shelf[num] = null;
      return obj;
    }

    //Error message that prints if the spot is vacant.
    System.out.println("This spot on the shelf is, sadly, empty.");
    return null;
  }
}
