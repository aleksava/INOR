import java.util.ArrayList;

class PlanteHage {

  private ArrayList<Plante> gardenHau = new ArrayList<>();

  //Alle hagens planter blir vannet.
  public void vannPlanter(int clVann) {
    for(Plante plante: gardenHau) {
      plante.vannPlante(clVann);
    }
  }

  //Ny plante blir laget og satt paa den forste ledige plassen i arrayen.
  //Om hagen er full, blir det skrevet ut en selvlagd feilmelding.
  public void groPlante(int maxGrenseVann) {
    Plante newPlant = new Plante(maxGrenseVann);
    gardenHau.add(newPlant);
  }

  //Kaller paa alle plantene i hagen sin nyDag()-metode.
  public void nyDagTilAlleMinePlanter() {
    for(Plante plant: gardenHau) {
      plant.nyDag();
    }
  }

  //Returnerer antall planter.
  public int antPlanter() {
    return gardenHau.size();
  }

  //Sjekker om noen av plantene i hagen er dode. Om så, blir de slettet fra
  //arrayen. Hint: Her kan det vaere lurt aa sette plassen til null.
  public void renskOppHage() {
    if(gardenHau.isEmpty()) {
      System.out.println("There aren't any plants in your garden");
    }

    else {
      for(int i = 0; i < gardenHau.size(); i++) {
        if(!(gardenHau.get(i).erLevende())) {
          gardenHau.remove(i);
        }
      }
    }
  }
}
