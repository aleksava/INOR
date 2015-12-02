class Emneside {

  private double viewedVersion = 1.01;
  private double liveVersion = 1.01;

  public Emneside() {
    
  }

  public void updatePage() {
    liveVersion += 0.01;
  }

  public void checkPage() {
    viewedVersion = liveVersion;
  }

  public boolean watchedPage() {
    if(viewedVersion == liveVersion) {
      return true;
    }

    return false;
  }
}
