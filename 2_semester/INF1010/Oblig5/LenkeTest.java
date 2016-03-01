class LenkeTest {
  public static void main(String[] args) {
    LenkeListe<String> list = new LenkeListe<String>();

    for(int i = 0; i < 10; i++) {
      list.leggTil("hei");
    }

    list.leggTil("ku");
    list.leggTil("mamma");

    System.out.println("Testing tom(): " + list.tom());
    System.out.println("Testing fjernMinste(): " + list.fjernMinste());
    System.out.println("Testing inneholder(): " + list.inneholder("mamma"));
  }
}
