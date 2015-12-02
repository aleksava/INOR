class GruppemoeteTest {
  public static void main(String[] args) throws Exception {
    Gruppemoete inf1000 = new Gruppemoete();
    inf1000.readFile("gruppeliste.txt");
    inf1000.attendance();
    inf1000.printAttendance();
  }
}
