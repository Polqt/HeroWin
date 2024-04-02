import java.io.*;
import java.util.Scanner;

public class SignupOption extends MenuOption {
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a new username: ");
        String newUsername = scanner.nextLine();
        System.out.print("Enter a password: ");
        String newPassword = scanner.nextLine();

        User newUser = new User(newUsername, newPassword);
        writeToFile(newUser);
        System.out.println("Signup successful!");

        // Launch start and exit options after successful signup
        MenuOption startOption = new StartOption();
        MenuOption exitOption = new ExitOption();

        startOption.execute();
    }

    private void writeToFile(User user) {
        // Save the database file within the HeroWin/src/ folder
        String filePath = "database.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(user.getUsername() + "," + user.getPassword());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
