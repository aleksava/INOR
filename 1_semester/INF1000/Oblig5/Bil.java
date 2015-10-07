class Bil {
  public static void main(String[] args) {

  int km;
  double litre;
  double distanceTotal;
  double fillTank;
  double tankSize = 2;
  double fuelUsage;

  //Car is delivered with full tank
  litre = tankSize;
}
  //Enough petrol? Drive "km" kilometeres
  public void driveTrip(int km, double fuelUsage, double litre) {
    if ((fuelUsage * km) < litre) {
      litre -= fuelUsage * km;
      System.out.println("You have arrived at your destination. There's " + litre +
                          "litres left in your tank.");
      distanceTotal += km;

    }
    else {
      System.out.println("You have innsufficient amounts of fuel left in order to make that trip. " +
                          "Please select a shorter journey, or fill up the tank");
    }
  }

  //Fill the tank, if there is room for said amount of petrol
  public void fillTank(double litre, double fillTank, double tankSize) {
    if (fillTank <= (tankSize - litre)) {
      litre += fillTank;
    }
    else {
      System.out.println("You don't have room for that much fuel, please select a lower amount");
    }
  }

  //Find max driving distance, given a certain level of petrol
  public double maxDistance() {
    return (litre * fuelUsage);
  }

  //Find the total distance the car has driven
  public int totalDistance(double distanceTotal) {
    return distanceTotal;
  }
}
