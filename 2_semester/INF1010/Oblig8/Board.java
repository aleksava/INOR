class Board {

  private int rows;
  private int columns;
  private int squared;
  private Route[][] routes;

  public Board(Route[][] rs, int h, int w) {
    routes = rs;
    rows = h;
    columns = w;
    squared = h*w;
  }

  public int getColumns() {
    return columns;
  }

  public int getRows() {
    return rows;
  }

  public int boxNumber(int row, int column) {
    return row - (row%this.rows) + (column/this.columns);
  }

  public void showBoard() {
    for(int i = 0; i < routes.length; i++) {
      for(int j = 0; j < routes[i].length; j++) {
        if(j == columns){
          System.out.print("|");
        }
        if(routes[i][j].get() != 0) {
          try {
            System.out.print(verdiTilTegn(routes[i][j].get(), ' '));
          }
          catch(IllegalValueException e) {
            System.out.println("This value is not acceptable: " + e.getValue());
          }
        }
        else System.out.print(" ");
      }
      if(i == 1 || i == 3 || i == 5) System.out.println("\n---+---");
      else System.out.println();
    }
  }

  /**
  * Oversetter en tallverdi (int) til et tegn (char)
  *
  * @param verdi     verdien som skal oversettes
  * @param tom       tegnet som brukes for aa representere 0 (tom rute)
  * @return          tegnet som verdien tilsvarer
  */
  public static char verdiTilTegn(int verdi, char tom) throws IllegalValueException {
    if (verdi == 0) {                           // tom
        return tom;
    } else if (1 <= verdi && verdi <= 9) {      // tegn er i [1, 9]
        return (char) (verdi + '0');
    } else if (10 <= verdi && verdi <= 35) {    // tegn er i [A, Z]
        return (char) (verdi + 'A' - 10);
    } else if (verdi == 36) {                   // tegn er @
        return '@';
    } else if (verdi == 37) {                   // tegn er #
        return '#';
    } else if (verdi == 38) {                   // tegn er &
        return '&';
    } else if (39 <= verdi && verdi <= 64) {    // tegn er i [a, z]
        return (char) (verdi + 'a' - 39);
    } else {                                    // tegn er ugyldig
        throw new IllegalValueException(verdi);
        // HUSK DEFINISJON AV UNNTAKSKLASSE
    }
  }

  public void opprettDatastruktur() {
    Route prevRoute = null;
    Row[] rowsArr = new Row[squared];
    Box[] boxesArr = new Box[squared];
    Column[] columnsArr = new Column[squared];

    for(int i = 0; i < squared; i++) {
      boxesArr[i] = new Box(rows, columns, i);
    }

    for(int i = 0; i < squared; i++) {
      rowsArr[i] = new Row(squared, i);
    }

    for(int i = 0; i < squared; i++) {
      columnsArr[i] = new Column(squared, i);
    }

    for(int i = 0; i < squared; i++) {
      for(int j = 0; j < squared; j++) {
        this.routes[i][j].setRow(rowsArr[i]);
        this.routes[i][j].setColumn(columnsArr[j]);
        this.routes[i][j].setBox(boxesArr[boxNumber(i,j)]);
      }
    }

    for(int i = 0; i < squared; i++) {
      for(int j = 0; j < squared; j++) {
        if(prevRoute == null) {
          prevRoute = routes[i][j++];
        }
        prevRoute.setNext(routes[i][j]);
        prevRoute = routes[i][j];
      }
    }
  }

  public void testPossibleNumbers() {
    int[] possibleNumbers;
    for(int i = 0; i < routes.length; i++) {
      for(int j = 0; j < routes[i].length; j++) {
        possibleNumbers = routes[i][j].finnAlleMuligeTall();
        for(int k = 0; k < possibleNumbers.length; k++) {
          System.out.print(possibleNumbers[k]);
        }
        System.out.println("\n");
      }
    }
  }

  public void solve() {
    if(routes[0][0] != null) {
      routes[0][0].fillThisAndTheRest();
    }
    System.out.println("\n");
    showBoard();
  }

  public void printBoard() {
    for(int i = 0; i < squared; i++) {
      for(int j = 0; j < squared; j++) {
        System.out.print(routes[i][j] + " ");
      }
      System.out.println();
    }
  }
}
