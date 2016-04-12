class Column {


  private int colNumber;
  private int[] numbers;

  public Column(int height) {
    numbers = new int[height];
  }

  public void setValue(int v) {
    numbers[v-1] = v;
  }
}
