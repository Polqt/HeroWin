import java.util.Scanner;


public class TwoVsTwoMatch {
    private Hero player1;
    private Hero player2;
    private Hero player3;
    private Hero player4;
    private Scanner scanner;


    public TwoVsTwoMatch(Hero player1, Hero player2, Hero player3, Hero player4) {
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        this.player4 = player4;
        this.scanner = new Scanner(System.in);
    }


    public void startMatch() {
        System.out.println("The match begins!");
        System.out.println("");


        while (areBothTeamsAlive()) {
            performTurn(player1, player2, player3, player4);
            if (areBothTeamsAlive()) {
                performTurn(player3, player4, player1, player2);
            }
        }


        if (player1.getHealth() <= 0 && player2.getHealth() <= 0) {
            System.out.println("Team 2 wins!");
        } else {
            System.out.println("Team 1 wins!");
        }
    }


    private boolean areBothTeamsAlive() {
        return (player1.getHealth() > 0 || player2.getHealth() > 0) && (player3.getHealth() > 0 || player4.getHealth() > 0);
    }


    private void performTurn(Hero activePlayer1, Hero activePlayer2, Hero targetPlayer1, Hero targetPlayer2) {
        System.out.println("");
        System.out.println("");
        System.out.println(activePlayer1.getName() + " and " + activePlayer2.getName() + ", it's your turn to attack.");
        System.out.print("Enter 1 for basic attack or Enter 2 for skills: ");
        int choice1 = scanner.nextInt();
        System.out.println("");


        // Check if target players are alive
        boolean target1Alive = targetPlayer1.getHealth() > 0;
        boolean target2Alive = targetPlayer2.getHealth() > 0;


        if (target1Alive || target2Alive) {
            System.out.println("Choose your targets:");


            if (target1Alive) {
                System.out.println("1: " + targetPlayer1.getName());
            }
            if (target2Alive) {
                System.out.println("2: " + targetPlayer2.getName());
            }


            System.out.print("Enter the number of your target: ");
            int targetChoice = scanner.nextInt();


            if (targetChoice == 1 && target1Alive) {
                System.out.println(targetPlayer1.getName() + ", you are the target.");
            } else if (targetChoice == 2 && target2Alive) {
                System.out.println(targetPlayer2.getName() + ", you are the target.");
            } else {
                System.out.println("Invalid target choice. Skipping turn.");
                return;
            }
        }


        if (choice1 == 1) {
            if (targetPlayer1.getHealth() > 0 && (target1Alive || !target2Alive)) {
                activePlayer1.performBasicAttack(targetPlayer1);
            }
            if (targetPlayer2.getHealth() > 0 && (target2Alive || !target1Alive)) {
                activePlayer2.performBasicAttack(targetPlayer2);
            }
        } else if (choice1 == 2) {
            displaySkills(activePlayer1);
            System.out.print(activePlayer1.getName() + ", select the skill you want to use (0-2): ");
            int skillIndex1 = scanner.nextInt();
            if (targetPlayer1.getHealth() > 0 && (target1Alive || !target2Alive)) {
                activePlayer1.performSkill(targetPlayer1, skillIndex1);
            }


            displaySkills(activePlayer2);
            System.out.print(activePlayer2.getName() + ", select the skill you want to use (0-2): ");
            int skillIndex2 = scanner.nextInt();
            if (targetPlayer2.getHealth() > 0 && (target2Alive || !target1Alive)) {
                activePlayer2.performSkill(targetPlayer2, skillIndex2);
            }
        } else {
            System.out.println("Invalid choice for " + activePlayer1.getName() + ". Skipping turn.");
        }


        // Check if one player from the opposing team is defeated
        if (targetPlayer1.getHealth() <= 0 && target1Alive) {
            System.out.println(targetPlayer1.getName() + " is defeated!");
        }
        if (targetPlayer2.getHealth() <= 0 && target2Alive) {
            System.out.println(targetPlayer2.getName() + " is defeated!");
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
