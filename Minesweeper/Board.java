public class Board {
  
  int height, width, numMines;
  
  public Board(int height, int width, int numMines) {
    this.height = height;
    this.width = width;
    this.numMines = numMines;
  }
  
  public void setHeight(int height) {
    this.height = height; 
  }
  
  public int getHeight() {
    return height;
  }
  
  public void setWidth(int width) {
    this.width = width;
  }
  
  public int getWidth() {
    return width;
  }
  
  public int[][][] getBoard() {
    Mines mines = new Mines(numMines);
    Flags flags = new Flags();
    int[][][] board = createBoard(height, width);
    int[] mineList = mines.getLocations(height, width);    
    board = mines.addToBoard(board, mineList, height, width);
    board = flags.set(board, height, width);
    //printCompleteBoard(board);
    return board;
  }
  
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
  
  
  // Only used for debugging
  public void printCompleteBoard(int[][][] board) {
    for (int i=0; i<height; i++) {
      for (int k=0; k<width; k++) {
        System.out.print("||=====");
      }
      System.out.println("||");
      for (int j=0; j<width; j++) {
        if (board[i][j][0] != -1) 
          System.out.print("||  " + board[i][j][0] + "  ");
        else
          System.out.print("|| " + board[i][j][0] + "  ");
      }
      System.out.println("||");
    }
    for (int k=0; k<width; k++) {
      System.out.print("||=====");
    }
    System.out.println("||\n");
  }
  
}
