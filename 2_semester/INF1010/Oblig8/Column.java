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
    int[] yarr;
    int end = 0;
    int index = 0;

    for(int i = 0; i < nums.length; i++) {
      if(numbers[i] != nums[i]) {
        posNum[i] = nums[i];
        end++;
      }
    }

    yarr = new int[end];
    for(int i = 0; i < posNum.length; i++) {
      if(posNum[i] != 0) yarr[index++] = posNum[i];
    }
    System.out.println("Yarr: " + yarr);
    return yarr;
  }
}
