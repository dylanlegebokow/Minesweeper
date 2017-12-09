// This class displays the ascii text "Minesweeper" and "Congratulations, you won!"

public class Display {
  
  // Displays game title and instructions
  public void showTitle() {
    System.out.println("---------------------------------------------------------------------------------------------------\n");
    System.out.println("\t\t   __  ________  ___________      _____________  _______ ");
    System.out.println("\t\t  /  |/  /  _/ |/ / __/ __/ | /| / / __/ __/ _ \\/ __/ _ \\");
    System.out.println("\t\t / /|_/ // //    / _/_\\ \\ | |/ |/ / _// _// ___/ _// , _/");
    System.out.println("\t\t/_/  /_/___/_/|_/___/___/ |__/|__/___/___/_/  /___/_/|_|\n\n");
    
    System.out.println("To play, insert the coordinates of the location you want to check in the format of:    ROW, COLUMN");
    System.out.println("Please select the board height, board width, and how many mines.\n");
  }
  
  public void showWinningScreen() {
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
