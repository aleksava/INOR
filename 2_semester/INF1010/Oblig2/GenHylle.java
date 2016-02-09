//Defining the interface for a generic Hylle
interface GenHylle <T> {

  //A mehtod that returns the size of the shelf
  public int size();

  //A method that places an item on the shelf, in a given spot
  public void place(T item, int num);

  //A method that checks if the given spot is empty
  public boolean vacant(int num);

  //A method that returns the object on the given space
  public T take(int num);
}
