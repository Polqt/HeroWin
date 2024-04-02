public interface Mage {


    String[] getSkills();
}


class Succubus implements Hero, Mage {
    private static final int BASIC_ATTACK_DAMAGE = 25;
    private static final int MAGIC_DAMAGE_SKILL_DAMAGE = 50;


    private String name;
    private int basicAttack;
    private String[] skills;
    private double magic;
    private boolean selected;
    private int health;
    private int mana;


    public Succubus() {
        this.name = "Succubus";
        this.basicAttack = BASIC_ATTACK_DAMAGE;
        this.skills = new String[]{"Mesmerize", "Entrapment", "Deceive"};
        this.magic = 25;
        this.selected = false;
        this.health = 250;
        this.mana = 500;
    }


    public void displayInfo() {
        System.out.println("Mage: " + name);
        System.out.println("Basic Attack: " + basicAttack);
        System.out.println("Skills:");
        System.out.println("Magic Damage: " + magic + "%");
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


class Riftwalker implements Hero, Mage {
    private static final int BASIC_ATTACK_DAMAGE = 25;
    private static final int MAGIC_DAMAGE_SKILL_DAMAGE = 50;


    private String name;
    private int basicAttack;
    private String[] skills;
    private double magic;
    private boolean selected;
    private int health;
    private int mana;


    public Riftwalker() {
        this.name = "Riftwalker";
        this.basicAttack = BASIC_ATTACK_DAMAGE;
        this.skills = new String[]{"Whirlbubble", "Wormhole", "Cascade Event"};
        this.magic = 25;
        this.selected = false;
        this.health = 250;
        this.mana = 500;
    }


    public void displayInfo() {
        System.out.println("Mage: " + name);
        System.out.println("Basic Attack: " + basicAttack);
        System.out.println("Skills:");
        for (String skill : skills) {
            System.out.println("  " + skill + " (Magic Damage: " + MAGIC_DAMAGE_SKILL_DAMAGE + ")");
        }
        System.out.println("Magic Damage: " + magic + "%");
    }


    public void performBasicAttack(Hero target) {
        System.out.println(name + " performs a basic attack on " + target.getClass().getSimpleName());

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

    public void receiveDamage(int damage) {
        System.out.println(name + " receives " + damage + " damage.");
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
