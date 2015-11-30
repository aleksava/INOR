class Student {

  private String name;
  private int totalScore;
  private int quizAmount;

  public Student(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void leggTilQuizScore(int score) {
    totalScore += score;
    quizAmount ++;
  }

  public int getTotalScore() {
    return totalScore;
  }

  public int getAverageScore() {
    return (totalScore/quizAmount);
  }
}
