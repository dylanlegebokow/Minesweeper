// This class is responsible for setting up a minesweeper game and interacting with a user
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;

public class Launcher {
  
  public static void main(String[] args) {
    
    Logic logic = new Logic();
    Display display = new Display();
    Point point = new Point(0,0);
    String input;
    int count = 0;
    Scanner scan = new Scanner(System.in);
    Scanner thisLine = new Scanner(System.in);
    int[] square = new int[2];
    int[] numbers = new int[2];
    
    int height = 0;
    int width = 0;
    int mines = 0;
   
    display.showTitle();
    
    // Prompts user for board height
    System.out.print("HEIGHT: ");
    try {
        height = scan.nextInt();
      } catch (InputMismatchException e) {
        System.out.println("Invalid input: value is not an integer. Please restart and try again.\n");
        System.exit(0);
      }
    while ((height > 18) || (height < 2)) {
      System.out.println("Height out of range. Please choose a number between 2 - 18.");
      System.out.print("HEIGHT: ");
      try {
        height = scan.nextInt();
      } catch (InputMismatchException e) {
        System.out.println("Invalid input: value is not an integer. Please restart and try again.\n");
        System.exit(0);
      }
    }
    
    // Prompts user for board width
    System.out.print("WIDTH:  ");
    try {
        width = scan.nextInt();
      } catch (InputMismatchException e) {
        System.out.println("Invalid input: value is not an integer. Please restart and try again.\n");
        System.exit(0);
      }
    while ((width > 15) || (width < 2)) {
      System.out.println("Width out of range. Please choose a number between 2 - 15.");
      System.out.print("WIDTH:  ");
      try {
        width = scan.nextInt();
      } catch (InputMismatchException e) {
        System.out.println("Invalid input: value is not an integer. Please restart and try again.\n");
        System.exit(0);
      }
    }
    
    // Prompts user for number of mines on board
    System.out.print("MINES:  ");
    try {
        mines = scan.nextInt();
      } catch (InputMismatchException e) {
        System.out.println("Invalid input: value is not an integer. Please restart and try again.\n");
        System.exit(0);
      }
    while ((mines > (height * width - 1)) || (mines < 1)) {
      System.out.println("Mines value out of range. Please choose a number between 1 - " + (height * width - 1) + ".");
      System.out.print("MINES:  ");
      try {
        mines = scan.nextInt();
      } catch (InputMismatchException e) {
        System.out.println("Invalid input: value is not an integer. Please restart and try again.\n");
        System.exit(0);
      }
    }
    System.out.println();
    
    // Creates a new minesweeper board with user imputs as parameters
    Board board = new Board(height, width, mines);
    int[][][] thisBoard = board.getBoard();
    board.printBoard(thisBoard);
    
    // Game logic: runs until user hits a mine or avoids all mines and wins the game
    while (count < (height * width - mines)) { 
      count = 0;
      System.out.println("---------------------------------------------------------------------------------------------------\n\n");
      System.out.print("Check square: ");
      input = thisLine.nextLine();
      input = input.replaceAll("[^-?0-9]+", " ");
      numbers = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
      try {
        point.setX(numbers[0] - 1);
        point.setY(numbers[1] - 1);
      } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Invalid input. Please restart and try again.");
        System.exit(0);
      }
      
      // Checks if point is within gameboard
      while((point.getX() >= height) || (point.getX() < 0) || (point.getY() >= width) || (point.getY() < 0)) {
        System.out.println("Point is out of bounds. Please try another point.");
        System.out.print("Check square: ");
        input = thisLine.nextLine();
        input = input.replaceAll("[^-?0-9]+", " ");
        numbers = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        point.setX(numbers[0] - 1);
        point.setY(numbers[1] - 1);
      }
            
      // Checks if point has already been checked
      while (logic.pointAlreadyChecked(thisBoard, point) == true) {
        System.out.println("Point already checked. Please try another point.");
        System.out.print("Check square: ");
        input = thisLine.nextLine();
        input = input.replaceAll("[^-?0-9]+", " ");
        numbers = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        point.setX(numbers[0] - 1);
        point.setY(numbers[1] - 1);
      }
          
      // Updates the gameboard
      System.out.println();
      thisBoard = logic.updateBoard(thisBoard, point, height-1, width-1);
      
      // Counts how many squares have been listed as "checked"
      for (int i=0; i<height*width; i++) {
        if (thisBoard[i / width][i % width][1] == 1) {
          count += 1;
        }
      }   
   
      board.printBoard(thisBoard);
    }
    
    display.showWinningScreen();
    
  }
}
