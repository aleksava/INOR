import java.util.*;

class SortertEnkelListe<E extends Comparable<E> & Lik> implements
AbstraktSortertEnkelListe<E>, Iterable<E> {

   Node head, tail, pos;

  class Node {
    E data;
    Node next;

    public Node(E e) {
      data = e;
    }

    public void print() {
      if(next != null) next.print();
      System.out.println("Recursive printing: " + data.toString());
    }
  }

  private class ListeIterator implements Iterator<E> {
    Node pos = head;

    public boolean hasNext() {
      return pos.next != null;
    }

    public E next() {
      if(hasNext()) {
        pos = pos.next;
        return pos.data;
      }
      return null;
    }

    public void remove() {
    }
  }

  public boolean add(E e) {

    //Makes sure I start from the head
    pos = head;

    //If the list is empty
    if(head == null) {
      head = new Node(e);
      tail = head;
      pos = head;
      return true;
    }

    //If there is only one Node in the list
    else if(tail == head) {

      //Adds it in front
      if(pos.data.compareTo(e) < 0) {
        head = new Node(e);
        head.next = pos;
        return true;
      }

      //Adds it behind
      else {
        head.next = new Node(e);
        tail = head.next;
        return true;
      }
    }

    else {

      //Checks the first Node
      if(pos.data.compareTo(e) < 0) {
        Node temp = head;
        head = new Node(e);
        head.next = temp;
        return true;
      }

      while(pos.next != null) {
        if(pos.next.data.compareTo(e) > 0) {
          pos = pos.next;
        }

        else {
          Node temp = pos.next;
          pos.next = new Node(e);
          pos.next.next = temp;
          return true;
        }
      }

      if(pos.next == null && pos != null) {
        pos.next = new Node(e);
        tail = pos.next;
        return true;
      }
    }

    System.out.println("I was unable to add this item to the list");
    return false;
  }

  public E getWithString(String s) {
    pos = head;

    while(pos != null) {
      if(pos.data.same(s)) {
        return pos.data;
      }
      pos = pos.next;
    }

    System.out.println("Tis be not in my chest, please sod off");
    return null;
  }

  public void printAll() {
    pos = head;
    while(pos != null) {
      System.out.println(pos.data.toString());
      pos = pos.next;
    }
  }

  public void recursivePrint() {
    if(head != null) head.print();
  }

  public Iterator<E> iterator() {
    return new ListeIterator();
  }

  public int size() {
    int size = 0;
    pos = head;
    while(pos != null) {
      size ++;
      pos = pos.next;
    }

    return size;
  }
}
