// This class sets the adjacent mine value for each point on the minesweeper gameboard

public class Flags {
  
  int i, j;
  
  
  // Checks every point on the gameboard for a mine. If a mine is found, add 1 to each adjacent point
  // PARAMETERS: Minesweeper board, board HEIGHT and WIDTH
  // RETURNS: Minesweeper board with all flags (adjacent mine values) set
  public int[][][] set(int[][][] board, int height, int width) {
    for (i=1; i<height-1; i++) {
      for (j=1; j<width-1; j++) {
        // If found a mine in inner square (full board minus 1 block border on all sides)
        if (board[i][j][0] == -1) {
          if (board[i-1][j-1][0] != -1)
            board[i-1][j-1][0] += 1;
          if (board[i-1][j][0] != -1)
            board[i-1][j][0] += 1;
          if (board[i-1][j+1][0] != -1)
            board[i-1][j+1][0] += 1;
          if (board[i][j-1][0] != -1)
            board[i][j-1][0] += 1;
          if (board[i][j+1][0] != -1)
            board[i][j+1][0] += 1;
          if (board[i+1][j-1][0] != -1)
            board[i+1][j-1][0] += 1;
          if (board[i+1][j][0] != -1)
            board[i+1][j][0] += 1;
          if (board[i+1][j+1][0] != -1)
            board[i+1][j+1][0] += 1;
        }        
      }
    }
    // Checks leftmost column, minus top and bottom squares
    j=0;
    for (i=1; i<height-1; i++) {
      if (board[i][j][0] == -1) {
          if (board[i-1][j][0] != -1)
            board[i-1][j][0] += 1;
          if (board[i+1][j][0] != -1)
            board[i+1][j][0] += 1;  
          if (board[i-1][j+1][0] != -1)
            board[i-1][j+1][0] += 1;
          if (board[i][j+1][0] != -1)
            board[i][j+1][0] += 1;
          if (board[i+1][j+1][0] != -1)
            board[i+1][j+1][0] += 1;
      }
    }
    // Checks rightmost column, minus top and bottom squares 
    j=width-1;
    for (i=1; i<height-1; i++) {
      if (board[i][j][0] == -1) {
          if (board[i-1][j-1][0] != -1)
            board[i-1][j-1][0] += 1;
          if (board[i-1][j][0] != -1)
            board[i-1][j][0] += 1;       
          if (board[i][j-1][0] != -1)
            board[i][j-1][0] += 1;
          if (board[i+1][j-1][0] != -1)
            board[i+1][j-1][0] += 1;
          if (board[i+1][j][0] != -1)
            board[i+1][j][0] += 1;
      }
    }
    // Checks topmost row, minus left and right squares
    i=0;
    for (j=1; j<width-1; j++) {
      if (board[i][j][0] == -1) {
        if (board[i][j-1][0] != -1) 
          board[i][j-1][0] += 1;
        if (board[i][j+1][0] != -1)
          board[i][j+1][0] += 1;
        if (board[i+1][j-1][0] != -1)
          board[i+1][j-1][0] += 1;
        if (board[i+1][j][0] != -1)
          board[i+1][j][0] += 1;
        if (board[i+1][j+1][0] != -1)
          board[i+1][j+1][0] += 1;
      }
    }
    // Checks bottomost row, minus left and right squares
    i=height-1;
    for (j=1; j<width-1; j++) {
      if (board[i][j][0] == -1) {
        if (board[i][j-1][0] != -1) 
          board[i][j-1][0] += 1;
        if (board[i][j+1][0] != -1)
          board[i][j+1][0] += 1;
        if (board[i-1][j-1][0] != -1)
          board[i-1][j-1][0] += 1;
        if (board[i-1][j][0] != -1)
          board[i-1][j][0] += 1;
        if (board[i-1][j+1][0] != -1)
          board[i-1][j+1][0] += 1;
      }
    }    
    // Checks the four corners
    i=0;
    j=0;
    if (board[i][j][0] == -1) {
      if (board[i][j+1][0] != -1)
        board[i][j+1][0] += 1;
      if (board[i+1][j][0] != -1)
        board[i+1][j][0] += 1;
      if (board[i+1][j+1][0] != -1)
        board[i+1][j+1][0] += 1;
    }
    i=height-1;
    j=0;
    if (board[i][j][0] == -1) {
      if (board[i][j+1][0] != -1)
        board[i][j+1][0] += 1;
      if (board[i-1][j][0] != -1)
        board[i-1][j][0] += 1;
      if (board[i-1][j+1][0] != -1)
        board[i-1][j+1][0] += 1;
    }
    i=0;
    j=width-1;
    if (board[i][j][0] == -1) {
      if (board[i][j-1][0] != -1)
        board[i][j-1][0] += 1;
      if (board[i+1][j][0] != -1)
        board[i+1][j][0] += 1;
      if (board[i+1][j-1][0] != -1)
        board[i+1][j-1][0] += 1;
    }
    i=height-1;
    j=width-1;
    if (board[i][j][0] == -1) {
      if (board[i][j-1][0] != -1)
        board[i][j-1][0] += 1;
      if (board[i-1][j][0] != -1)
        board[i-1][j][0] += 1;
      if (board[i-1][j-1][0] != -1)
        board[i-1][j-1][0] += 1;
    }   
    return board;
  }
  
}