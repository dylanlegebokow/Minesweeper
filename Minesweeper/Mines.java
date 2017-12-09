// This class is responsible for creating which squares on a board will have mines and adds the mines
// to the board.

import java.util.ArrayList;
import java.util.Collections;

public class Mines {
  
  int numMines;
  
  public Mines(int numMines) {
    this.numMines = numMines; }
  
  public void setMines(int numMines) {
    this.numMines = numMines; }
  
  public int getMines() {
    return numMines; }
  
  // Creates a list of mine locations
  // PARAMETERS: Board HEIGHT and WIDTH
  // RETURNS: A list of integers where each integer is a mine location to be added to the board later on
  public int[] getLocations(int height, int width) {
    
    // Creates an array list, where each item is an integer ranging between 0 and (HEIGHT x WIDTH - 1)
    ArrayList<Integer> tempList = new ArrayList<Integer>();
    int[] mineList = new int[numMines];
    for (int i=0; i<(height * width); i++) {
      tempList.add(new Integer(i)); }
    
    // Shuffles the array list, and copies the first NUMMINES items to a new array
    Collections.shuffle(tempList);
    for (int i=0; i<numMines; i++) {
      mineList[i] = tempList.get(i); }
    return mineList;
  }
  
  
  // Adds specified mine locations to a minesweeper board.
  // PARAMETERS: A 3D array representing the gameboard, a list of mine locations, board HEIGHT and WIDTH
  // RETURNS: Gameboard with mine locations added
   public int[][][] addToBoard(int[][][] board, int[] mineList, int height, int width) {
    for (int i=0; i<mineList.length; i++) {
      board[mineList[i] / width][mineList[i] % width][0] = -1; }
    return board;
  }
  
}
