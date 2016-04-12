class Box {

  private int height;
  private int width;
  private int[] numbers;

  public Box(int h, int w) {
    height = h;
    width = w;
    numbers = new int[h*w];
  }

  public void setValue(int v) {
    numbers[v-1] = v;
  }
}
