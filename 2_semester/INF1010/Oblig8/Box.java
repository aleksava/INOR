class Box {

  private int height;
  private int width;
  private int[] numbers;
  private int boxID;

  public Box(int h, int w, int id) {
    height = h;
    width = w;
    numbers = new int[h*w];
  }

  public void setValue(int v) {
    numbers[v-1] = v;
  }

  public int[] possibleNumbers(int[] nums) {
    int[] posNum = new int[numbers.length];
    for(int i = 0; i < nums.length; i++) {
      if(numbers[i] != nums[i]) {
        posNum[i] = nums[i];
      }
    }

    return posNum;
  }
}
