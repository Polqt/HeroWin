import java.util.Scanner;

abstract class MenuOption { //Implements Abstraction
    public abstract void execute();
}

class ExitOption extends MenuOption { //Implements Inheritance
    public void execute() {
        System.out.println("Scared?");
        System.exit(0);
    }
}

public class HeroWin {
    public static void main(String[] args) {
        MenuOption signupOption = new SignupOption();
        MenuOption loginOption = new LoginOption();

        System.out.println("=======================================================================================");
        System.out.println("=                                Main Menu                                            =");
        System.out.println("=======================================================================================");
        System.out.println();
        System.out.println();
        System.out.println("1. Signup");
        System.out.println("2. Login");
        System.out.println();
        System.out.print("Select an option mah friend: ");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                signupOption.execute();
                break;
            case 2:
                loginOption.execute();
                break;
            default:
                System.out.println("Select a valid option mah friend");
        }
    }
}
