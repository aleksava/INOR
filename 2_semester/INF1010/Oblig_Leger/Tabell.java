import java.util.*;

class Tabell<E> implements AbstraktTabell<E>, Iterable<E> {

  private E[] table;
  private int index;

  @SuppressWarnings("unchecked")
  public Tabell(int size) {
    table = (E[]) new Object[size];
  }

  public boolean addAt(E obj, int i) {
    if(i > table.length || i < 0 || table[i] != null) {
      return false;
    }

    table[i] = obj;
    return true;
  }

  public E getAt(int i) {
    if(i >= table.length || i < 0 || table[i] == null) {
      System.out.println("Arr, tis not be possible, have a null");
      return null;
    }

    return table[i];
  }

  public Iterator<E> iterator() {
    return new ListeIterator();
  }

  private class ListeIterator implements Iterator<E> {
    public boolean hasNext() {
      if(index < 0 || index > table.length) {
        return false;
      }

      return true;
    }

    public E next() {
      if(hasNext()) {
        index ++;
        return table[index];
      }

      System.out.println("You have reached the end of the line, please sod off");
      return null;
    }

    public void remove() {

    }
  }
}
