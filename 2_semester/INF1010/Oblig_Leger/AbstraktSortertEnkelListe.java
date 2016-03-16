import java.util.*;

interface AbstraktSortertEnkelListe<E extends Comparable<E> & Lik> {
  public boolean add(E e);
  public E getWithString(String s);
  public Iterator<E> iterator();
}
