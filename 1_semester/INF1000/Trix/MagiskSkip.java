class MagiskSkip {

  private GodHjelper[] helpers = new GodHjelper[7];

  public void pickUpNewHelper(GodHjelper helper) {
    for(int i = 0; i < helpers.length; i++) {
      if(helpers[i] == null) {
        helpers[i] = helper;
        return;
      }
    }
    System.out.println("I'm terribly sorry, but the ship appears " +
                        "to be full");
  }
}
