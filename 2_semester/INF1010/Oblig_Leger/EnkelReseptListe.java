import java.util.NoSuchElementException;

class EnkelReseptListe extends SortertEnkelListe<Resept> {
  public Resept getWithString(int serial) throws NoSuchElementException {
    Resept res = super.getWithString(Integer.toString(serial));
    if(res == null) {
      throw new NoSuchElementException("This perscription doesn't exist here");
    }
    return res;
  }
}
