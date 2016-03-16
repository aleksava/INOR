class EldsteForstReseptListe extends EnkelReseptListe {

  public boolean add(Resept r) {

    //Make sure I start from the beginning
    pos = head;

    //If the list is empty
    if(head == null) {
      head = new Node(r);
      tail = head;
      pos = head;
      return true;
    }

    //If the list only has one item
    else if(tail == head) {

      //Adds it in front the first Node
      if(pos.data.compareTo(r) < 0) {
        head = new Node(r);
        head.next = pos;
        return true;
      }

      //Adds it behind the first Node
      else {
        head.next = new Node(r);
        tail = head.next;
        return true;
      }
    }

    else {

      //Checks the frist Node
      if(pos.data.compareTo(r) < 0) {
        Node temp = head;
        head = new Node(r);
        head.next = temp;
        return true;
      }

      //Checks the rest of the list
      while(pos.next != null) {
        if(pos.next.data.compareTo(r) > 0) {
          pos = pos.next;
        }

        else {
          Node temp = pos.next;
          pos.next = new Node(r);
          pos.next.next = temp;
          return true;
        }
      }

      if(pos.next == null && pos != null) {
        pos.next = new Node(r);
        tail = pos.next;
        return true;
      }
    }

    return false;
  }
}
