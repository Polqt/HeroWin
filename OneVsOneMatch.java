import java.util.Scanner;


public class OneVsOneMatch {
    private Hero player1;
    private Hero player2;
    private Scanner scanner;


    public OneVsOneMatch(Hero player1, Hero player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.scanner = new Scanner(System.in);
    }


    public void startMatch() {
        System.out.println("The match begins!");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");


        while (player1.getHealth() > 0 && player2.getHealth() > 0) {
            performTurn(player1, player2);
            if (player2.getHealth() > 0) {
                performTurn(player2, player1);
            }
        }


        if (player1.getHealth() <= 0) {
            System.out.println(player2.getName() + " wins!");
        } else {
            System.out.println(player1.getName() + " wins!");
        }
    }


    private void performTurn(Hero activePlayer, Hero targetPlayer) {
        System.out.println("");
        System.out.println("");
        System.out.println(activePlayer.getName() + ", it's your turn to attack.");
        System.out.print("Enter 1 for the basic attack or Enter 2 for the skills: ");
        int choice = scanner.nextInt();
        System.out.println("");


        if (choice == 1) {
            activePlayer.performBasicAttack(targetPlayer);
        } else if (choice == 2) {
            displaySkills(activePlayer);
            System.out.print("Select the skill you want to use (0-2): ");
            int skillIndex = scanner.nextInt();
            activePlayer.performSkill(targetPlayer, skillIndex);
        } else {
            System.out.println("Invalid choice. Skipping turn.");
        }
    }


    private void displaySkills(Hero hero) {
        if (hero instanceof Rogue || hero instanceof Tank || hero instanceof Fighter ||
                hero instanceof Marksman || hero instanceof Mage) {
            System.out.println("Available Skills:");
            String[] skills = hero instanceof Rogue ? ((Rogue) hero).getSkills() :
                    (hero instanceof Tank ? ((Tank) hero).getSkills() :
                            (hero instanceof Fighter ? ((Fighter) hero).getSkills() :
                                    (hero instanceof Marksman ? ((Marksman) hero).getSkills() :
                                            (hero instanceof Mage ? ((Mage) hero).getSkills() : new String[0]))));


            for (int i = 0; i < skills.length; i++) {
                System.out.println(i + ": " + skills[i]);
            }
        }
    }
}
