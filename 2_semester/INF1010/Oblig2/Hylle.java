class Hylle <T> implements GenHylle<T> {

  @SuppressWarnings("unchecked")
  private T[] shelf = (T[]) new Object[100];

  public Hylle(int size) {
    createArray(size);
  }

  public void createArray(int size) {
    @SuppressWarnings("unchecked")
    T[] shelf = (T[]) new Object[size];
  }

  public int size() {
    return shelf.length;
  }

  public void place(T item, int num) {
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

  public T take(int num) {
    T obj;
    if(!vacant(num)) {
      obj = shelf[num];
      shelf[num] = null;
      return obj;
    }
    System.out.println("This spot on the shelf is, sadly, allready empty.");
    return null;
  }
}
