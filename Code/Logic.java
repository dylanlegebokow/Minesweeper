// This class checks to see if a user has already looked at a certain point on the board, and updates the board
// whenever you select a point to check

import java.util.Queue;
import java.util.LinkedList;

public class Logic {
  
  Queue<Point> queue = new LinkedList<Point>();
  int x, y;
  
  // Checks to see if a point on the board has already been looked at
  // PARAMETERS: Minesweeper board, a point on the 3D grid
  // RETURNS: True if point already checked, False if point not checked yet
  public boolean pointAlreadyChecked(int[][][] board, Point point) {
    if (board[point.getX()][point.getY()][1] == 1) 
      return true;
    else
      return false;
  }
  
  
  // Updates the minesweeper gameboard depending on which point has been chosen.
  //   If point has 0 adjacent flags, function attempts to look at all squares adjacent to original point.
  //      If any adjacent point has more than 0 adjacent flags, sets it to checked
  //      If adjacent point also has 0 adjacent flags, adds it to a queue
  //      Function lives until queue is empty
  // PARAMETERS: Minesweeper board, a point on the 3D grid, board HEIGHT and WIDTH
  // RETURNS: Minesweeper board where point on 3D plane has been marked as viewed 
  public int[][][] updateBoard(int[][][] board, Point point, int height, int width) {
        
    x = point.getX();
    y = point.getY();
    
    // If the point the user checks is a mine
    if (board[x][y][0] == -1) {
      System.out.println("--------------------------- YOU HIT A MINE! PLEASE PLAY AGAIN! --------------------------");
      System.exit(0);
    }    
    
    // If the point the user checks has an adjacent mine value (flag value) higher than 0
    else if (board[x][y][0] > 0) {
      board[x][y][1] = 1;
    }
    
    // If the point the user checks has 0 adjacent mines 
    else {
      queue.add(point);
      while (!queue.isEmpty()) {
        
        // Get next Point's x and y values
        point = queue.peek();
        x = point.getX();
        y = point.getY();
        board[x][y][1] = 1;
        
        // If point has valid adjacent points to the left, top, and top-left
        if (x>0 && y>0) {
          if (board[x-1][y-1][1] == 0) {
            if (board[x-1][y-1][0] == 0) {
              Point point1 = new Point(x-1, y-1);
              queue.add(point1);
            }
            board[x-1][y-1][1] = 1;
          }
          if (board[x][y-1][1] == 0) {
            if (board[x][y-1][0] == 0) {
              Point point2 = new Point(x, y-1);
              queue.add(point2);
            }
            board[x][y-1][1] = 1;
          }
          if (board[x-1][y][1] == 0) {
            if (board[x-1][y][0] == 0) {
              Point point3 = new Point(x-1, y);
              queue.add(point3);
            }
            board[x-1][y][1] = 1;
          }
        }
       
        // If point has valid adjacent points to the left, bottom, and bottom-left
        if (x<height && y>0) {
          if (board[x+1][y-1][1] == 0) {
            if (board[x+1][y-1][0] == 0) {
              Point point1 = new Point(x+1, y-1);
              queue.add(point1);
            }
            board[x+1][y-1][1] = 1;
          }
          if (board[x][y-1][1] == 0) {
            if (board[x][y-1][0] == 0) {
              Point point2 = new Point(x, y-1);
              queue.add(point2);
            }
            board[x][y-1][1] = 1;
          }
          if (board[x+1][y][1] == 0) {
            if (board[x+1][y][0] == 0) {
              Point point3 = new Point(x+1, y);
              queue.add(point3);
            }
            board[x+1][y][1] = 1;
          }
        }
       
        // If point has valid adjacent points to the right, top, and top-right
        if (x>0 && y<width) {
          if (board[x-1][y+1][1] == 0) {
            if (board[x-1][y+1][0] == 0) {
              Point point1 = new Point(x-1, y+1);
              queue.add(point1);
            }
            board[x-1][y+1][1] = 1;
          }
          if (board[x][y+1][1] == 0) {
            if (board[x][y+1][0] == 0) {
              Point point2 = new Point(x, y+1);
              queue.add(point2);
            }
            board[x][y+1][1] = 1;
          }
          if (board[x-1][y][1] == 0) {
            if (board[x-1][y][0] == 0) {
              Point point3 = new Point(x-1, y);
              queue.add(point3);
            }
            board[x-1][y][1] = 1;
          }
        }
        
        // If point has valid adjacent points to the right, bottom, and bottom-right
        if (x<height && y<width) {
          if (board[x+1][y+1][1] == 0) {
            if (board[x+1][y+1][0] == 0) {
              Point point1 = new Point(x+1, y+1);
              queue.add(point1);
            }
            board[x+1][y+1][1] = 1;
          }
          if (board[x][y+1][1] == 0) {
            if (board[x][y+1][0] == 0) {
              Point point2 = new Point(x, y+1);
              queue.add(point2);
            }
            board[x][y+1][1] = 1;
          }
          if (board[x+1][y][1] == 0) {
            if (board[x+1][y][0] == 0) {
              Point point3 = new Point(x+1, y);
              queue.add(point3);
            }
            board[x+1][y][1] = 1;
          }
        }
        
        queue.remove();
      }
    }
    return board;
  }
  
}
