class Hylle <E> implements GenHylle<E> {

  private E[] shelf;

  public Hylle(int size) {
    shelf = (E[]) new Object[100];
  }

  public int size() {
    return shelf.length;
  }

  public void place(E item, int num) {
    if(num >= shelf.length) {
      System.out.println("The shelf is to short for this spot, therefore " +
                          "the book fell off.");
      return;
    }

    if(vacant(num)) {
      shelf[num] = item;
      return;
    }

    System.out.println("Sorry, but spot number " + num + " is allready taken");
  }

  public boolean vacant(int num) {
    if(shelf[num] == null) {
      return true;
    }

    return false;
  }

  public E take(int num) {
    E obj;
    if(!vacant(num)) {
      obj = shelf[num];
      shelf[num] = null;
      return obj;
    }
    System.out.println("This spot on the shelf is, sadly, allready empty.");
    return null;
  }
}
