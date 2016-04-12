class Row {

  private int rowNumber;
  private int[] numbers;

  public Row(int width) {
    numbers = new int[width];
  }

  public void setValue(int v) {
    numbers[v-1] = v;
  }
}
