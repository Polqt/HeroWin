public interface Tank {


    String[] getSkills();
}


class Maliken implements Hero, Tank {
    private static final int BASIC_ATTACK_DAMAGE = 20;
    private static final int MAGIC_DAMAGE_SKILL_DAMAGE = 20;
    private static final double BASE_HEALTH = 600;
    private String name;
    private int basicAttack;
    private String[] skills;
    private double health;
    private boolean selected;
    private int mana;


    public Maliken() {
        this.name = "Maliken";
        this.basicAttack = BASIC_ATTACK_DAMAGE;
        this.skills = new String[]{"Headsmash", "Taunt", "Decapitate"};
        this.health = BASE_HEALTH;
        this.selected = false;
        this.mana = 200;
    }


    public void displayInfo() {
        System.out.println("Tank: " + name);
        System.out.println("Basic Attack: " + basicAttack);
        System.out.println("Skills: " + String.join(", ", skills));
        System.out.println("Health: " + health);
    }


    public void performBasicAttack(Hero target) {
        System.out.println(name + " performs a basic attack on " + target.getClass().getSimpleName());


        // Implement basic attack logic
        target.receiveDamage(BASIC_ATTACK_DAMAGE);
    }


    public void performSkill(Hero target, int skillIndex) {
        if (skillIndex >= 0 && skillIndex < skills.length) {
            System.out.println(name + " performs skill '" + skills[skillIndex] + "' on " + target.getClass().getSimpleName());
            target.receiveDamage(MAGIC_DAMAGE_SKILL_DAMAGE);
        } else {
            System.out.println("Invalid skill index.");
        }
    }


    // Add a method in the Hero interface to handle receiving damage
    public void receiveDamage(int damage) {
        System.out.println(name + " receives " + damage + " damage.");
        // Implement logic to reduce health or handle damage as needed
        // Example: health -= damage;
    }


    public boolean isSelected() {
        return selected;
    }


    public void setSelected(boolean selected) {
        this.selected = selected;
    }


    public String getName() {
        return name;
    }


    public String[] getSkills() {
        return skills;
    }


    @Override
    public int getHealth() {
        return (int) health;
    }
}


class Kraken implements Hero, Tank {
    private static final int BASIC_ATTACK_DAMAGE = 20;
    private static final int MAGIC_DAMAGE_SKILL_DAMAGE = 20;
    private static final double BASE_HEALTH = 600;
    private String name;
    private int basicAttack;
    private String[] skills;
    private double health;
    private boolean selected;
    private int mana;


    public Kraken() {
        this.name = "Kraken";
        this.basicAttack = BASIC_ATTACK_DAMAGE;
        this.skills = new String[]{"Sear", "Release the Kraken", "Splash"};
        this.health = BASE_HEALTH;
        this.selected = false;
        this.mana = 200;
    }


    public void displayInfo() {
        System.out.println("Tank: " + name);
        System.out.println("Basic Attack: " + basicAttack);
        System.out.println("Skills: " + String.join(", ", skills));
        System.out.println("Health: " + health);
    }


    public void performBasicAttack(Hero target) {
        System.out.println(name + " performs a basic attack on " + target.getClass().getSimpleName());


        // Implement basic attack logic
        target.receiveDamage(BASIC_ATTACK_DAMAGE);
    }


    public void performSkill(Hero target, int skillIndex) {
        if (skillIndex >= 0 && skillIndex < skills.length) {
            System.out.println(name + " performs skill '" + skills[skillIndex] + "' on " + target.getClass().getSimpleName());
            target.receiveDamage(MAGIC_DAMAGE_SKILL_DAMAGE);
        } else {
            System.out.println("Invalid skill index.");
        }
    }


    // Add a method in the Hero interface to handle receiving damage
    public void receiveDamage(int damage) {
        System.out.println(name + " receives " + damage + " damage.");
        // Implement logic to reduce health or handle damage as needed
        // Example: health -= damage;
    }


    public boolean isSelected() {
        return selected;
    }


    public void setSelected(boolean selected) {
        this.selected = selected;
    }


    public String getName() {
        return name;
    }


    public String[] getSkills() {
        return skills;
    }


    @Override
    public int getHealth() {
        return (int) health;
    }
}
