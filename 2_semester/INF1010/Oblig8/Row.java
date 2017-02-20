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
    int[] yarr;
    int end = 0;
    int index = 0;

    for(int i = 0; i < nums.length; i++) {
      if(numbers[i] != nums[i]) {
        System.out.println(numbers[i]);
        posNum[i] = nums[i];
        System.out.print(posNum[i]);
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

/*  public int[] possibleNumbers(int[] nums) {
    int[] posNum = new int[nums.length];
    for(int i = 0; i < numbers.length; i++) {
      if(numbers[i] != nums[i]) {
        posNum[i] = nums[i];
      }
    }

    return posNum;
  }*/
}
