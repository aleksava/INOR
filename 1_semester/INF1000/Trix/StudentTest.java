class StudentTest {
  public static void main(String[] args) {
    Student s1 = new Student("Aleksander");
    Student s2 = new Student("Vebjorn");
    Student s3 = new Student("Thomas");

    s1.leggTilQuizScore(13);
    s2.leggTilQuizScore(12);
    s3.leggTilQuizScore(8);
    s1.leggTilQuizScore(15);
    s2.leggTilQuizScore(6);
    s3.leggTilQuizScore(12);
    s3.leggTilQuizScore(7);

    System.out.println("S1: " + s1.getTotalScore() + " " + s1.getAverageScore());
    System.out.println("S2: " + s2.getTotalScore() + " " + s2.getAverageScore());
    System.out.println("S3: " + s3.getTotalScore() + " " + s3.getAverageScore());

  }
}
