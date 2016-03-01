class LenkeListe<E extends Comparable<E>> {

  //The generic node class with the generic data holder
  private class Node<E> {
    E data;
    Node<E> next;
    Node<E> prev;

    //Constructor
    public Node(E d) {
      data = d;
    }
  }

  //The iterator that checks for itself whether or not it can move forward
  class ListeIterator {
    Node<E> here = ahead;
    Node<E> previous = null;

    public boolean hasNext() {
      return here.next != null;
    }
  }

  //Nodes for the list
  private Node<E> ahead;
  private Node<E> behind;

  //Method that checks if the list is empty
  public boolean tom() {
    if(ahead == null) {
      return true;
    }

    return false;
  }

  //Method that adds a new node with the data sent with it
  public void leggTil(E e) {
    Node<E> temp = new Node<E>(e);
    if(tom()) {
      ahead = temp;
      behind = temp;
    }

    else {
      behind.next = temp;
      behind = temp;
    }
  }

  //Goes through the entire list, and keeps a pointer on the smallest data
  public E fjernMinste() {
    ListeIterator iterator = new ListeIterator();
    E smallest = iterator.here.data;

    while(iterator.hasNext()) {
      if(smallest.compareTo(iterator.here.data) <= 0) {
        smallest = iterator.here.data;
      }

      iterator.previous = iterator.here;
      iterator.here = iterator.here.next;
    }

    return smallest;
  }

  //Goes through the list until it finds data matching the data sent with the
  //call of the method
  public boolean inneholder(E e) {
    ListeIterator iterator = new ListeIterator();
    E temp = iterator.here.data;

    iterator.previous = iterator.here;
    iterator.here = iterator.here.next;

    while(iterator.hasNext()) {
      if(temp.compareTo(iterator.here.data) == 0) {
        return true;
      }

      iterator.previous = iterator.here;
      iterator.here = iterator.here.next;
    }

    return false;
  }
}
