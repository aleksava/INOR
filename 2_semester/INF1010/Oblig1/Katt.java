class Katt {
  private String name;

  //Just a standard constructor
  public Katt(String name) {
    this.name = name;
  }

  //Method to get the cat to go hunting. The cat can only attack once per hunt.
  //It looks first for a mouse, and if it can't fint it, it looks for a rat
  public void onTheHunt(Bol<Mus> musebol, Bol<Rotte> rottebol) {

    //Checks if the mousehole is full, if it is then the cat attacks the mosue
    if(musebol.isEmpty()) {
      if(musebol.getRodent().status()) {
        System.out.println(name + " the cat, leapt from a bush and attacked " +
                            musebol.getRodent() + " the mouse.");
        musebol.getRodent().murderMouse();
      }
    }

    //Kicks in if the mousehole is empty, does the same only the cat attacks
    //the rat, and either kills or wounds it.
    else if(rottebol.isEmpty()) {
        System.out.println(name + " the cat, leapt from a bush and attacked " +
                          rottebol.getRodent() + " the rat.");
        rottebol.getRodent().attackRat();

    }

    //Kicks in if both the mousehole and rathole are both empty, the cat goes
    //home empty handed
    else {
      System.out.println(name + " the cat didn't find any rodents. The hunt " +
                          "has ended, for now.\n");
    }
  }

  //Returns the name of the cat
  public String toString() {
    return name;
  }
}
