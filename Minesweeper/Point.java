// This class keeps track of two values, x and y, that are used to describe a point on the board.
// The x value relates to the row/height value, and the y value relates to the column/width number.

public class Point {
  
  int x, y;
  
  public Point(int x, int y) {
    this.x = x;
    this.y = y; }
  
  public void setX(int x) {
    this.x = x; }
  
  public int getX() {
    return x;  }
  
  public void setY(int y) {
    this.y = y; }
  
  public int getY() {
    return y; }
 
}
