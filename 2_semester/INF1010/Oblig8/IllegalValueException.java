class IllegalValueException extends Exception {

  private int value;
  
  public IllegalValueException(int i) {
    value = i;
  }

  public int getValue() {
    return value;
  }

  public IllegalValueException() {
    //Nothing to see here
  }
}
