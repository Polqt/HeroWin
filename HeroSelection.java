import java.util.List;
import java.util.Scanner;


public class HeroSelection {
    private List<Hero> heroes;


    public HeroSelection(List<Hero> heroes) {
        this.heroes = heroes;
    }


    public Hero selectHero(String playerName) {
        System.out.println("");
        System.out.println("=======================================================================================");
        System.out.println("=                                HERO SELECTION                                       =");
        System.out.println("=======================================================================================");
        System.out.println("");


        for (int i = 0; i < heroes.size(); i++) {
            System.out.println((i + 1) + ". " + heroes.get(i).getClass().getSimpleName());
        }
        System.out.println("");


        Hero selectedHero = null;
        boolean heroAlreadyChosen;


        do {
            heroAlreadyChosen = false;


            System.out.print(playerName + ", select your hero: ");
            Scanner scanner = new Scanner(System.in);
            int heroChoice = scanner.nextInt();


            selectedHero = heroes.get(heroChoice - 1);


            // Check if the selected hero has already been chosen
            for (Hero hero : heroes) {
                if (hero == selectedHero && hero.isSelected()) {
                    System.out.println("This hero has already been chosen. Please pick another one.");
                    heroAlreadyChosen = true;
                    break;
                }
            }


        } while (heroAlreadyChosen);


        // Mark the hero as selected
        selectedHero.setSelected(true);


        return selectedHero;
    }


    public List<Hero> getHeroes() {
        return heroes;
    }
}
