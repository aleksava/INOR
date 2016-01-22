class Mus {
  private String name;
  private boolean status;

  public Mus(String name) {
    this.name = name;
    status = true;
  }

  public void murderMouse() {
    System.out.println(name + " the mouse has died.\n");
    status = false;
  }

  public boolean status() {
    return status;
  }

  public String toString() {
    return name;
  }
}
