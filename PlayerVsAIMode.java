import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class PlayerVsAIMode extends GameMode {
    private HeroSelection heroSelection;


    public PlayerVsAIMode() {
        List<Hero> heroes = new ArrayList<>();
        heroes.add(new Mortred());
        heroes.add(new Klanx());
        heroes.add(new Silhouette());
        heroes.add(new Gunblade());
        heroes.add(new Moraxus());
        heroes.add(new Berzerker());
        heroes.add(new Maliken());
        heroes.add(new Kraken());
        heroes.add(new Succubus());
        heroes.add(new Riftwalker());


        heroSelection = new HeroSelection(heroes);
    }


    public void selectMode() {
        System.out.println("Good luck, mah friend!");


        System.out.println("Player, it's time to select your hero.");
        Hero playerHero = heroSelection.selectHero("Player");
        playerHero.displayInfo();


        System.out.println("\nAI is thinking...");
        try {
            Thread.sleep(5000); // Delay the picking of an AI
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // AI randomly selects a hero that is not the same as the player's hero
        System.out.println("AI has chosen:");
        Hero aiHero = selectRandomHero(playerHero);
        aiHero.displayInfo();


        PlayerVsAIMatch match = new PlayerVsAIMatch(playerHero, aiHero);
        match.startMatch();
    }


    private Hero selectRandomHero(Hero playerHero) {
        Random random = new Random();
        List<Hero> availableHeroes = new ArrayList<>(heroSelection.getHeroes());
        availableHeroes.remove(playerHero); // Remove player's hero from the options
        int randomIndex = random.nextInt(availableHeroes.size());
        return availableHeroes.get(randomIndex);
    }
}
