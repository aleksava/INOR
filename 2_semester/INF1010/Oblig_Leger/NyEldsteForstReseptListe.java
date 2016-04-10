import java.util.*;

class NyEldsteForstReseptListe implements Iterable<Resept> {

  Node head, pos, tail;
  int size = 0;

  private class Node {
    Node next = null;
    Resept data;

    Node(Resept r) {
      data = r;
    }

    boolean add(Resept r) {
      if(next != null) {
        next.add(r);
      }
      else {
        next = new Node(r);
        return true;
      }
      return false;
    }
  }

  public Resept get() {
    Node temp = head;
    head = head.next;
    return temp.data;
  }

  public Resept get(String s) {
    pos = head;

    while(pos != null) {
      if(pos.data.getSerial() == Integer.parseInt(s)) {
        return pos.data;
      }
      pos = pos.next;
    }

    System.out.println("Tis be not in my chest, please sod off");
    return null;
  }


  public boolean add(Resept r) {

    if(head == null) {
      head = new Node(r);
      tail = head;
    }

    else {
      head.add(r);
      size ++;
      return true;
    }
    return false;
  }

  public int size() {
    return size;
  }

  public Iterator<Resept> iterator() {
    return new ListeIterator();
  }

  private class ListeIterator implements Iterator<Resept> {
    Node pos = head;

    public boolean hasNext() {
      return pos.next != null;
    }

    public Resept next() {
      if(hasNext()) {
        pos = pos.next;
        return pos.data;
      }
      return null;
    }

    public void remove() {
    }
  }
}
