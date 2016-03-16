import java.util.*;

interface AbstraktTabell<E> {
  public boolean addAt(E obj, int ind);
  public E getAt(int ind);
  public Iterator<E> iterator();

}
