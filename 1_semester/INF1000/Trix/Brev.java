class Brev {

  private String sender;
  private String recipient;
  private String[] arr = new String[100];

  public Brev(String sender, String recipient) {
    this.sender = sender;
    this.recipient = recipient;
  }

  public void skrivLinje(String text) {
    for(int i = 0; i < arr.length; i++) {
      if(arr[i] == null) {
        arr[i] = text;
        i = arr.length;
      }
    }
  }

  public void lesBrev() {
    System.out.println("\nHei, " + recipient + "!\n");
    for(int i = 0; i < arr.length; i++) {
      if(arr[i] != null) {
        System.out.println(arr[i]);
      }
      else {
        i = arr.length;
      }
    }
    System.out.println("\nHilsen fra \n" + sender + "\n");
  }
}
