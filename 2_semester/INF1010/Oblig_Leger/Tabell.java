import java.util.*;

class Tabell<E> implements AbstraktTabell<E>, Iterable<E> {

  private E[] table;

  @SuppressWarnings("unchecked")
  public Tabell(int size) {
    table = (E[]) new Object[size];
  }

  public boolean addAt(E obj, int i) {
    if(i > table.length || i < 0 || table[i] != null) {
      System.out.println("hei fra add at");
      return false;
    }

    table[i] = obj;
    return true;
  }

  public E getAt(int i) {
    if(i >= table.length || i < 0 || table[i] == null) {
      return null;
    }

    return table[i];
  }

  public int firstFreeSpot() {
    for(int i = 0; i < table.length; i++) {
      if(table[i] == null) return i;
    }

    return -1;
  }

  public int length() {
    return table.length;
  }

  public Iterator<E> iterator() {
    return new ListeIterator();
  }

  private class ListeIterator implements Iterator<E> {
    int index = 0;
    int length = table.length;

    public boolean hasNext() {
      return index < table.length;
    }

    public E next() {
      return table[index ++];
    }

    public void remove() {

    }
  }
}
