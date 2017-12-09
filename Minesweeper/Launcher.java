import java.util.Scanner;
import java.util.Arrays;

public class Launcher {
  
  // Board must have height and width both larger than 1
  // Number of mines must be less than or equal to HxW
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
    
    System.out.println("-----------------------------------------------------------------------------------------\n");
    
    System.out.println("\t   __  ________  ___________      _____________  _______ ");
    System.out.println("\t  /  |/  /  _/ |/ / __/ __/ | /| / / __/ __/ _ \\/ __/ _ \\");
    System.out.println("\t / /|_/ // //    / _/_\\ \\ | |/ |/ / _// _// ___/ _// , _/");
    System.out.println("\t/_/  /_/___/_/|_/___/___/ |__/|__/___/___/_/  /___/_/|_|\n\n");
   
    System.out.println("To play, insert the coordinates of the location you want to check in the format of:    ROW, COLUMN");
    System.out.println("Please select the board height, board width, and how many mines.\n");
    
    System.out.print("HEIGHT: ");
    height = scan.nextInt();
    while ((height > 18) || (height < 2)) {
      System.out.println("Height out of range. Please choose a number between 2 - 18.");
      System.out.print("HEIGHT: ");
      height = scan.nextInt();
    }
    
    System.out.print("WIDTH:  ");
    width = scan.nextInt();
    while ((width > 15) || (width < 2)) {
      System.out.println("Width out of range. Please choose a number between 2 - 15.");
      System.out.print("WIDTH:  ");
      width = scan.nextInt();
    }
    
    System.out.print("MINES:  ");
    mines = scan.nextInt();
    while ((mines > (height * width - 1)) || (mines < 1)) {
      System.out.println("Mines value out of range. Please choose a number between 1 - (HEIGHT x WIDTH).");
      System.out.print("MINES:  ");
      mines = scan.nextInt();
    }
    System.out.println();
    
    Board board = new Board(height, width, mines);
    int[][][] thisBoard = board.getBoard();
    
    board.printBoard(thisBoard);
    
    while (count < (height * width - mines)) { 
      count = 0;
      System.out.println("-----------------------------------------------------------------------------------------\n");
      System.out.print("Check square: ");
      input = thisLine.nextLine();
      input = input.replaceAll("[^-?0-9]+", " ");
      numbers = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
      point.setX(numbers[0] - 1);
      point.setY(numbers[1] - 1);
      
      while((point.getX() >= height) || (point.getX() < 0) || (point.getY() >= width) || (point.getY() < 0)) {
        System.out.println("Point is out of bounds. Please try another point.");
        System.out.print("Check square: ");
        input = thisLine.nextLine();
        input = input.replaceAll("[^-?0-9]+", " ");
        numbers = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        point.setX(numbers[0] - 1);
        point.setY(numbers[1] - 1);
      }
            
      while (logic.pointAlreadyChecked(thisBoard, point) == true) {
        System.out.println("Point already checked. Please try another point.");
        System.out.print("Check square: ");
        input = thisLine.nextLine();
        input = input.replaceAll("[^-?0-9]+", " ");
        numbers = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        point.setX(numbers[0] - 1);
        point.setY(numbers[1] - 1);
      }
          
      
      System.out.println();
      thisBoard = logic.updateBoard(thisBoard, point, height-1, width-1);
      
      for (int i=0; i<height*width; i++) {
        if (thisBoard[i / width][i % width][1] == 1) {
          count += 1;
        }
      }   
   
      board.printBoard(thisBoard);
    }
    
    System.out.println("   YOU WON! CONGRATULATIONS!!!");
  }
}
