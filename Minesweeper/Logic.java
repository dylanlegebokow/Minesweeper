import java.util.*;

public class Logic {
  
  Queue<Point> queue = new LinkedList<Point>();
  int x, y;
  
  
  public boolean pointAlreadyChecked(int[][][] board, Point point) {
    if (board[point.getX()][point.getY()][1] == 1) 
      return true;
    else
      return false;
  }
  
  
  public int[][][] updateBoard(int[][][] board, Point point, int height, int width) {
        
    x = point.getX();
    y = point.getY();
    if (board[x][y][0] == -1) {
      System.out.println("--------------------------- YOU HIT A MINE! PLEASE PLAY AGAIN! --------------------------");
      System.exit(0);
    }    
    else if (board[x][y][0] > 0) {
      board[x][y][1] = 1;
    }
    else { //found a zero
      queue.add(point);
      while (!queue.isEmpty()) {
        // Get next Point's x and y values
        point = queue.peek();
        x = point.getX();
        y = point.getY();
        board[x][y][1] = 1;
           
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
