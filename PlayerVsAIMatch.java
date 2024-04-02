import java.util.Scanner;


public class PlayerVsAIMatch {
    private Hero player;
    private Hero ai;
    private Scanner scanner;


    public PlayerVsAIMatch(Hero player, Hero ai) {
        this.player = player;
        this.ai = ai;
        this.scanner = new Scanner(System.in);
    }


    public void startMatch() {
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("The match begins!");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");


        while (player.getHealth() > 0 && ai.getHealth() > 0) {
            performPlayerTurn();
            if (ai.getHealth() > 0) {
                performAITurn();
            }
        }


        if (player.getHealth() <= 0) {
            System.out.println("AI wins!");
        } else {
            System.out.println("Player wins!");
        }
    }


    private void performPlayerTurn() {
        System.out.println("");
        System.out.println(player.getName() + ", it's your turn to attack.");
        System.out.print("Enter 1 for basic attack, 2 for skill attack: ");
        int choice = scanner.nextInt();
        System.out.println("");


        if (choice == 1) {
            player.performBasicAttack(ai);
        } else if (choice == 2) {
            displaySkills(player);
            System.out.print("Select the skill you want to use (0-2): ");
            int skillIndex = scanner.nextInt();
            player.performSkill(ai, skillIndex);
        } else {
            System.out.println("Invalid choice. Skipping turn.");
        }
    }


    private void performAITurn() {
        System.out.println("");
        System.out.println("AI's turn.");


        try {
            // Introduce a delay to simulate AI decision-making
            Thread.sleep(2000); // 2000 milliseconds (2 seconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        int aiChoice = (int) (Math.random() * 2) + 1;
        System.out.println("");


        if (aiChoice == 1) {
            ai.performBasicAttack(player);
        } else if (aiChoice == 2) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int skillIndex = (int) (Math.random() * 3);
            ai.performSkill(player, skillIndex);
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
