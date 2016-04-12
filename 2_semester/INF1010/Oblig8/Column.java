class Column {


  private int columnID;
  private int[] numbers;

  public Column(int height, int id) {
    numbers = new int[height];
  }

  public void setValue(int v) {
    numbers[v-1] = v;
  }

  public int[] possibleNumbers(int[] nums) {
    int[] posNum = new int[nums.length];
    for(int i = 0; i < nums.length; i++) {
      if(numbers[i] != nums[i]) {
        posNum[i] = nums[i];
      }
    }

    return posNum;
  }
}
