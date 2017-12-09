// This class deals with setting up an initial minesweeper board and displaying the board to a terminal

public class Board {
  
  int height, width, numMines;
  
  public Board(int height, int width, int numMines) {
    this.height = height;
    this.width = width;
    this.numMines = numMines; }
  
  public void setHeight(int height) {
    this.height = height; }
  
  public int getHeight() {
    return height; }
  
  public void setWidth(int width) {
    this.width = width; }
  
  public int getWidth() {
    return width; }
  
  
  // Creates a complete minesweeper gameboard, including mines and adjacent mine values (flags)
  // PARAMETERS: None
  // RETURNS: Complete minesweeper board
  public int[][][] getBoard() {
    Mines mines = new Mines(numMines);
    Flags flags = new Flags();
    int[][][] board = createBoard(height, width); // Creates the 3D grid
    int[] mineList = mines.getLocations(height, width); // Creates an array of unique integers that represents mines
    board = mines.addToBoard(board, mineList, height, width); // Adds mines to the gameboard
    board = flags.set(board, height, width); // Sets adjacent mine values (flags) for the entire board
    return board;
  }
  
  
  // Creates the 3D array that represents the minesweeper gameboard
  //    Board[i][j][0]: The values associated on the board. (IE adjacent mines, if point is a mine)
  //    Board[i][j][1]: Does this location value get shown as output? (0 = NO, 1 = YES)
  // PARAMETERS: Board HEIGHT and WIDTH
  // RETURNS: 3D gameboard with all values initialized
  private int[][][] createBoard(int height, int width) {
    int[][][] board = new int[height][width][2];
    for (int i=0; i<height; i++) {
      for (int j=0; j<width; j++) {
        board[i][j][0] = 0;
        board[i][j][1] = 0; 
      }
    }
    return board;
  } 
  
  
  // Displays the board to the user. Will only show values where BOARD[i][j][1] = 1
  // PARAMETERS: Minesweeper board
  // RETURNS: None
  public void printBoard(int[][][] board) {
    System.out.print("     ");
    for (int i=0; i<width; i++) {
      if (i<9)
        System.out.print("    " + (i+1) + "   ");
      else
        System.out.print("   " + (i+1) + "   ");
    }
    System.out.println();
    for (int i=0; i<height; i++) {
      System.out.print("     ");
      for (int k=0; k<width; k++) {
        System.out.print("|-------");
      }
      System.out.println("|");
      if (i<9)
        System.out.print(" " + (i+1) + "   ");
      else 
        System.out.print(" " + (i+1) + "  ");
      for (int j=0; j<width; j++) {
        if (board[i][j][1] == 1)
          System.out.print("|   " + board[i][j][0] + "   ");
        else 
          System.out.print("|       ");
      }
      System.out.println("|");
    }
    System.out.print("     ");
    for (int k=0; k<width; k++) {
      System.out.print("|-------");
    }
    System.out.println("|\n\n");
  }
  
}
