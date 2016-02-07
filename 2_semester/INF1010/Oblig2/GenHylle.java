interface GenHylle <T> {
  public int size();
  public void place(T item, int num);
  public boolean vacant(int num);
  public T take(int num);
}
