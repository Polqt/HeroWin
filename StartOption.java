import java.util.Scanner;
abstract class GameMode {
    public abstract void selectMode();
}

class GameMenu { //Implements Encapsulation
    private final GameMode oneVsOneMode;
    private final GameMode twoVsTwoMode;
    private final GameMode playerVsAIMode;


    public GameMenu() {
        this.oneVsOneMode = new OneVsOneMode();
        this.twoVsTwoMode = new TwoVsTwoMode();
        this.playerVsAIMode = new PlayerVsAIMode();
    }

    public void displayGameModes() {
        System.out.println();
        System.out.println("=======================================================================================");
        System.out.println("=                                Select Game Mode                                     =");
        System.out.println("=======================================================================================");
        System.out.println();
        System.out.println();
        System.out.println("1. 1 vs 1");
        System.out.println("2. 2 vs 2");
        System.out.println("3. Player vs AI");
        System.out.println();
        System.out.print("Select your game mode: ");


        Scanner scanner = new Scanner(System.in);
        int modeChoice = scanner.nextInt();


        switch (modeChoice) {
            case 1:
                oneVsOneMode.selectMode();
                break;
            case 2:
                twoVsTwoMode.selectMode();
                break;
            case 3:
                playerVsAIMode.selectMode();
                break;
            default:
                System.out.println("Select 1-3 mango");
                displayGameModes();
        }
    }
}

public class StartOption extends MenuOption {
    public void execute() {
        GameMenu gameMenu = new GameMenu();
        gameMenu.displayGameModes();
    }
}
