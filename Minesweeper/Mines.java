import java.util.ArrayList;
import java.util.Collections;

public class Mines {
  
  int numMines;
  
  public Mines(int numMines) {
    this.numMines = numMines;
  }
  
  public void setMines(int numMines) {
    this.numMines = numMines; 
  }
  
  public int getMines() {
    return numMines; 
  }
  
  public int[] getLocations(int height, int width) {
    ArrayList<Integer> tempList = new ArrayList<Integer>();
    int[] mineList = new int[numMines];
    for (int i=0; i<(height * width); i++) {
      tempList.add(new Integer(i));
    }
    Collections.shuffle(tempList);
    for (int i=0; i<numMines; i++) {
      mineList[i] = tempList.get(i);
    }
    return mineList;
  }
  
   public int[][][] addToBoard(int[][][] board, int[] mineList, int height, int width) {
    for (int i=0; i<mineList.length; i++) {
      board[mineList[i] / width][mineList[i] % width][0] = -1; 
    }
    return board;
  }
  
}
