import java.util.Scanner;
import java.io.*;

class Oblig8 {

  private Board sudokuBoard;

  public static void main(String[] args) {
    Oblig8 sudoku = new Oblig8("sudoku.txt");
    sudoku.sudokuBoard.showBoard();
  }

  public Oblig8(String s) {
    sudokuBoard = readFile(s);
  }

  private Board readFile(String s) {
    Route[][] board;
    Scanner scan;
    Scanner totalScan;
    int rows = 0;
    int columns = 0;

    try {
      scan = new Scanner(new File(s));
      totalScan = new Scanner(new File(s));
    }
    catch (FileNotFoundException e) {
      System.out.println("Couldn't find the file, here's the stacktrace: ");
      e.printStackTrace();
      return null;
    }

    rows = Integer.parseInt(scan.nextLine());
    columns = Integer.parseInt(scan.nextLine());
    if(rows*columns > 4096) {
      System.out.println("The board is too large, sorry");
      return null;
    }
    board = new Route[rows*columns][rows*columns];

    int characters = 0;
    while(totalScan.hasNext()) {
      characters++;
      totalScan.next();
    }

    int i = 0;
    while(scan.hasNextLine()) {
      char[] line = scan.nextLine().toCharArray();
      for (int k = 0; k < line.length; k++) {
        if(line[k] != '.' && (Character.getNumericValue(line[k]) < 0 ||
                              Character.getNumericValue(line[k]) > 9)) {
            System.out.println(line[k] + " is an illegal character in this format");
            return null;
        }
      }

      for(int j = 0; j < line.length; j++) {
        board[i][j] = new Route(line[j], rows*columns);
        //System.out.print(board[i][j]);
      }
      //System.out.println();
      i++;
    }

    return (new Board(board, rows, columns));
  }
}
