class Route {

  private int value;
  private int totalNumbers;
  private Box box;
  private Row row;
  private Route next;
  private Column column;
  private boolean locked = true;

  public Route(int i, int dim) {
    totalNumbers = dim;
    value = (i);
    if(value < 0 || value > totalNumbers) value = 0;
    if(value == 0) locked = false;
  }

  public int get() {
    return value;
  }

  public String toString() {
    return value + "";
  }

  public boolean setBox(Box b) {
    box = b;
    if(value != 0) b.setValue(value);
    return (box == b);
  }

  public boolean setRow(Row r) {
    row = r;
    if(value != 0) r.setValue(value);
    return (row == r);
  }

  public boolean setColumn(Column c) {
    column = c;
    if(value != 0) c.setValue(value);
    return (column == c);
  }

  public void setNext(Route r) {
    this.next = r;
  }

  public int[] finnAlleMuligeTall() {
    if(!locked) {
      int[] allNumbers = new int[row.size()];
      for(int i = 0; i < allNumbers.length; i++) {
        allNumbers[i] = i + 1;
      }

      return row.possibleNumbers(column.possibleNumbers(box.possibleNumbers(allNumbers)));
    }

    return new int[]{value};
  }

  public void fillThisAndTheRest() {
    int[] possibilities = finnAlleMuligeTall();

    for(int i = 0; i < possibilities.length; i++) {
      if(possibilities[i] != 0) {
        value = possibilities[i];
        //System.out.print(possibilities[i]);
        if(next != null) next.fillThisAndTheRest();
      }
    }
  }
}
