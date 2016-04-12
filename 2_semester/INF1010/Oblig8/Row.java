class Row {

  private int rowID;
  private int[] numbers;

  public Row(int width, int id) {
    numbers = new int[width];
  }

  public void setValue(int v) {
    numbers[v-1] = v;
  }

  public int size() {
    return numbers.length;
  }

  public int[] possibleNumbers(int[] nums) {
    int[] posNum = new int[nums.length];
    for(int i = 0; i < numbers.length; i++) {
      if(numbers[i] != nums[i]) {
        posNum[i] = nums[i];
      }
    }

    return posNum;
  }
}
