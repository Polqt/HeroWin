public interface Fighter {


    String[] getSkills();
}


class Moraxus implements Hero, Fighter {
    private static final int BASIC_ATTACK_DAMAGE = 25;
    private static final int MAGIC_DAMAGE_SKILL_DAMAGE = 25;
    private String name;
    private int basicAttack;
    private String[] skills;
    private double damage;
    private boolean selected;
    private int health;
    private int mana;


    public Moraxus() {
        this.name = "Moraxus";
        this.basicAttack = BASIC_ATTACK_DAMAGE + 25; // Additional +25 damage for the fighter's special attribute
        this.skills = new String[]{"Matraxe", "Carnage", "Charge"};
        this.damage = MAGIC_DAMAGE_SKILL_DAMAGE;
        this.selected = false;
        this.health = 400;
        this.mana = 100;
    }


    public void displayInfo() {
        System.out.println("Fighter: " + name);
        System.out.println("Basic Attack: " + basicAttack);
        System.out.println("Skills: " + String.join(", ", skills));
        System.out.println("Damage: " + damage + "%");
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
        return health;
    }
}


class Berzerker implements Hero, Fighter {
    private static final int BASIC_ATTACK_DAMAGE = 25;
    private static final int MAGIC_DAMAGE_SKILL_DAMAGE = 25;
    private String name;
    private int basicAttack;
    private String[] skills;
    private double damage;
    private boolean selected;
    private int health;
    private int mana;




    public Berzerker() {
        this.name = "Berzerker";
        this.basicAttack = BASIC_ATTACK_DAMAGE;
        this.skills = new String[]{"Carnivorous", "Terror", "Grapple"};
        this.damage = MAGIC_DAMAGE_SKILL_DAMAGE;
        this.selected = false;
        this.health = 400;
        this.mana = 100;
    }


    public void displayInfo() {
        System.out.println("Fighter: " + name);
        this.basicAttack = BASIC_ATTACK_DAMAGE + 25; // Additional +25 damage for the fighter's special attribute
        System.out.println("Skills: " + String.join(", ", skills));
        System.out.println("Damage: " + damage + "%");
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
        return health;
    }
}
