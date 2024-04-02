import java.util.ArrayList;
import java.util.List;


public class OneVsOneMode extends GameMode {
    private HeroSelection heroSelection;


    public OneVsOneMode() {
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
        System.out.println("Good luck, mah friends!");


        Hero player1 = heroSelection.selectHero("Player 1");
        player1.displayInfo();
        System.out.println("");
        System.out.println("Player 2, it's your turn to pick.");


        Hero player2 = heroSelection.selectHero("Player 2");
        player2.displayInfo();
        System.out.println("");
        System.out.println("");
        System.out.println("");


        OneVsOneMatch match = new OneVsOneMatch(player1, player2);
        match.startMatch();
    }
}
