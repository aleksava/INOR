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

  public void showBoard() {
    for(int i = 0; i < routes.length; i++) {
      for(int j = 0; j < routes[i].length; j++) {
        if(j == columns){
          System.out.print("|");
        }
        if(routes[i][j].get() != 0) System.out.print(routes[i][j]);
        else System.out.print(" ");
      }
      if(i == 1 || i == 3 || i == 5) System.out.println("\n---+---");
      else System.out.println();
    }
  }

  public void opprettDatastruktur() {
    Box[] boxesArr = new Box[squared];
    Row[] rowsArr = new Row[squared];
    Column[] columnsArr = new Column[squared];

    for (int i = 0; i < squared; i++) {
      boxesArr[i] = new Box(rows, columns);
    }

    for (int i = 0; i < squared; i++) {
      rowsArr[i] = new Row(squared);
    }

    for(int i = 0; i < squared; i++) {
      columnsArr[i] = new Column(squared);
      for(int j = 0; j < squared; j++) {
        this.routes[i][j].setRow(rowsArr[i]);
        this.routes[i][j].setColumn(columnsArr[j]);
        this.routes[i][j].setBox(boxesArr[j]);
      }
    }
  }
}
