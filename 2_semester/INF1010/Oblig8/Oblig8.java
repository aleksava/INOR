import java.util.Scanner;
import java.io.*;

class Oblig8 {

  private Board sudokuBoard;

  public static void main(String[] args) {
    Oblig8 sudoku = new Oblig8("sudoku.txt");
    sudoku.sudokuBoard.showBoard();
    sudoku.sudokuBoard.opprettDatastruktur();
    //sudoku.sudokuBoard.testPossibleNumbers();
    sudoku.sudokuBoard.solve();
    //sudoku.sudokuBoard.printBoard();
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
        board[i][j] = new Route(tegnTilVerdi(line[j]), rows*columns);
      }
      i++;
    }

    return (new Board(board, rows, columns));
  }

  // Det er lov aa kopiere disse metodene inn i oppgaven uten aa bli mistenkt for fusk!
  //
  // Bruker du metodene som de er, maa du huske aa definere konstanten TOM_RUTE_TEGN
  // og klassen UgyldigVerdiUnntak med en konstruktoer som passer til new-kallet

  /**
  * Oversetter et tegn (char) til en tallverdi (int)
  *
  * @param tegn      tegnet som skal oversettes
  * @return          verdien som tegnet tilsvarer
  */
  public static int tegnTilVerdi(char tegn) {
    if (tegn == 0) {                // tom rute
        // DENNE KONSTANTEN MAA DEKLARERES
        return 0;
    } else if ('1' <= tegn && tegn <= '9') {    // tegn er i [1, 9]
        return tegn - '0';
    } else if ('A' <= tegn && tegn <= 'Z') {    // tegn er i [A, Z]
        return tegn - 'A' + 10;
    } else if (tegn == '@') {                   // tegn er @
        return 36;
    } else if (tegn == '#') {                   // tegn er #
        return 37;
    } else if (tegn == '&') {                   // tegn er &
        return 38;
    } else if ('a' <= tegn && tegn <= 'z') {    // tegn er i [a, z]
        return tegn - 'a' + 39;
    } else {                                    // tegn er ugyldig
        return -1;
    }
  }
}
