// This class is responsible for setting up a minesweeper game and interacting with a user

import java.util.Scanner;
import java.util.Arrays;

public class Launcher {
  
  public static void main(String[] args) {
    
    Logic logic = new Logic();
    Point point = new Point(0,0);
    String input;
    int count = 0;
    Scanner scan = new Scanner(System.in);
    Scanner thisLine = new Scanner(System.in);
    int[] square = new int[2];
    int[] numbers = new int[2];
    
    int height;
    int width;
    int mines;
    
    
    // Displays game title when running program
    System.out.println("---------------------------------------------------------------------------------------------------\n");
    System.out.println("\t\t   __  ________  ___________      _____________  _______ ");
    System.out.println("\t\t  /  |/  /  _/ |/ / __/ __/ | /| / / __/ __/ _ \\/ __/ _ \\");
    System.out.println("\t\t / /|_/ // //    / _/_\\ \\ | |/ |/ / _// _// ___/ _// , _/");
    System.out.println("\t\t/_/  /_/___/_/|_/___/___/ |__/|__/___/___/_/  /___/_/|_|\n\n");
   
    System.out.println("To play, insert the coordinates of the location you want to check in the format of:    ROW, COLUMN");
    System.out.println("Please select the board height, board width, and how many mines.\n");
    
    // Prompts user for board height
    System.out.print("HEIGHT: ");
    height = scan.nextInt();
    while ((height > 18) || (height < 2)) {
      System.out.println("Height out of range. Please choose a number between 2 - 18.");
      System.out.print("HEIGHT: ");
      height = scan.nextInt();
    }
    
    // Prompts user for board width
    System.out.print("WIDTH:  ");
    width = scan.nextInt();
    while ((width > 15) || (width < 2)) {
      System.out.println("Width out of range. Please choose a number between 2 - 15.");
      System.out.print("WIDTH:  ");
      width = scan.nextInt();
    }
    
    // Prompts user for number of mines on board
    System.out.print("MINES:  ");
    mines = scan.nextInt();
    while ((mines > (height * width - 1)) || (mines < 1)) {
      System.out.println("Mines value out of range. Please choose a number between 1 - (HEIGHT x WIDTH).");
      System.out.print("MINES:  ");
      mines = scan.nextInt();
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
      point.setX(numbers[0] - 1);
      point.setY(numbers[1] - 1);
      
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
    
    System.out.println("---------------------------------------------------------------------------------------------------\n");
    
    System.out.println("       __________  _   ____________  ___  ________  ____    ___  ______________  _   _______");
    System.out.println("      / ____/ __ \\/ | / / ____/ __ \\/   |/_  __/ / / / /   /   |/_  __/  _/ __ \\/ | / / ___/");
    System.out.println("     / /   / / / /  |/ / / __/ /_/ / /| | / / / / / / /   / /| | / /  / // / / /  |/ /\\__ \\ ");
    System.out.println("    / /___/ /_/ / /|  / /_/ / _, _/ ___ |/ / / /_/ / /___/ ___ |/ / _/ // /_/ / /|  /___/ / ");
    System.out.println("    \\____/\\____/_/ |_/\\____/_/ |_/_/  |_/_/  \\____/_____/_/  |_/_/ /___/\\____/_/ |_//____/ \n");
    
    System.out.println("                            __  ______  __  __   _       ______  _   __    ");
    System.out.println("       __/|___/|___/|_      \\ \\/ / __ \\/ / / /  | |     / / __ \\/ | / /    __/|___/|___/|_");
    System.out.println("      |    /    /    /       \\  / / / / / / /   | | /| / / / / /  |/ /    |    /    /    /");
    System.out.println("     /_ __/_ __/_ __|        / / /_/ / /_/ /    | |/ |/ / /_/ / /|  /    /_ __/_ __/_ __| ");
    System.out.println("      |/   |/   |/          /_/\\____/\\____/     |__/|__/\\____/_/ |_/      |/   |/   |/ \n");
    
    System.out.println("---------------------------------------------------------------------------------------------------\n");
  }
}
