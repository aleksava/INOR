class Katt {
  private String name;

  public Katt(String name) {
    this.name = name;
  }

  public void onTheHunt(Bol<Mus> musebol, Bol<Rotte> rottebol) {
    if(musebol.getRodent() != null) {
      if(musebol.getRodent().status()) {
        System.out.println(name + " the cat, leapt from a bush and attacked " +
                            musebol.getRodent() + " the mouse.");
        musebol.getRodent().murderMouse();
      }
    }

    else if(rottebol.getRodent() != null) {
        System.out.println(name + " the cat, leapt from a bush and attacked " +
                          rottebol.getRodent() + " the rat.");
        rottebol.getRodent().attackRat();

    }

    else {
      System.out.println(name + " the cat didn't find any rodents. The hunt " +
                          "has ended, for now.\n");
    }
  }

  public String toString() {
    return name;
  }
}
