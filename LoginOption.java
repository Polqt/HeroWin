import java.io.*;
import java.util.Scanner;

public class LoginOption extends MenuOption {
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String enteredUsername = scanner.nextLine();
        System.out.print("Enter your password: ");
        String enteredPassword = scanner.nextLine();

        if (checkCredentials(enteredUsername, enteredPassword)) {
            System.out.println("Login successful!");

            // Launch start and exit options after successful login
            MenuOption startOption = new StartOption();
            MenuOption exitOption = new ExitOption();

            startOption.execute();
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    private boolean checkCredentials(String enteredUsername, String enteredPassword) {
        // Access the database file within the HeroWin/src/ folder
        String filePath = "database.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].equals(enteredUsername) && parts[1].equals(enteredPassword)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
