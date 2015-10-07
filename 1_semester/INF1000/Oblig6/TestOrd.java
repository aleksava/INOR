class TestOrd {
  public static void main(String[] args) {
    String tekst = "";
    Ord test = new Ord("apekatt");
    Ord jungle = new Ord("panther");
    test.incAmount();
    System.out.println("First word: " + test.toString() + " " +
                        test.getAmount() + "\nSecond word: " +
                        jungle.toString() + " " + jungle .getAmount());
  }
}
