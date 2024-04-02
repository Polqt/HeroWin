public interface Rogue {


    String[] getSkills();
}


class Mortred implements Hero, Rogue {
    private static final int BASIC_ATTACK_DAMAGE = 35;
    private static final int MAGIC_DAMAGE_SKILL_DAMAGE = 35;
    private static final int CRITICAL_STRIKE_DAMAGE_PER_ROUND = 25;
    private String name;
    private int basicAttack;
    private String[] skills;
    private double criticalChance;
    private boolean selected;
    private int health;
    private int mana;


    public Mortred() {
        this.name = "Mortred";
        this.basicAttack = BASIC_ATTACK_DAMAGE;
        this.skills = new String[]{"Dagger", "Blink", "Backstab"};
        this.criticalChance = 25;
        this.selected = false;
        this.health = 250;
        this.mana = 250;
    }


    public void displayInfo() {
        System.out.println("Rogue: " + name);
        System.out.println("Basic Attack: " + basicAttack);
        System.out.println("Skills: " + String.join(", ", skills));
        System.out.println("Critical Chance: " + criticalChance + "%");
    }


    public void performBasicAttack(Hero target) {
        System.out.println(name + " performs a basic attack on " + target.getClass().getSimpleName());
        int totalDamage = BASIC_ATTACK_DAMAGE;


        // Check for critical strike
        if (Math.random() * 100 < criticalChance) {
            System.out.println("Critical Strike!");
            totalDamage += CRITICAL_STRIKE_DAMAGE_PER_ROUND;
        }


        target.receiveDamage(totalDamage);
    }




    public void performSkill(Hero target, int skillIndex) {
        if (skillIndex >= 0 && skillIndex < skills.length) {
            System.out.println(name + " performs skill '" + skills[skillIndex] + "' on " + target.getClass().getSimpleName());
            target.receiveDamage(MAGIC_DAMAGE_SKILL_DAMAGE);
            System.out.println(target.getName() + "'s health: " + target.getHealth());
        } else {
            System.out.println("Invalid skill index.");
        }
    }


    public void receiveDamage(int amount) {
        // Implement the logic to reduce health by the given amount
        health -= amount;
        System.out.println(name + " receives " + amount + " damage. Remaining health: " + health);
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


class Silhouette implements Hero, Rogue {
    private static final int BASIC_ATTACK_DAMAGE = 35;
    private static final int MAGIC_DAMAGE_SKILL_DAMAGE = 35;
    private static final int CRITICAL_STRIKE_DAMAGE_PER_ROUND = 25;
    private String name;
    private int basicAttack;
    private String[] skills;
    private double criticalChance;
    private boolean selected;
    private int health;
    private int mana;


    public Silhouette() {
        this.name = "Silhouette";
        this.basicAttack = BASIC_ATTACK_DAMAGE;
        this.skills = new String[]{"Disarm", "Nether Strike", "Relentless Salvo"};
        this.criticalChance = 25;
        this.selected = false;
        this.health = 250;
        this.mana = 250;
    }


    public void displayInfo() {
        System.out.println("Rogue: " + name);
        System.out.println("Basic Attack: " + basicAttack);
        System.out.println("Skills: " + String.join(", ", skills));
        System.out.println("Critical Chance: " + criticalChance + "%");
    }


    public void performBasicAttack(Hero target) {
        System.out.println(name + " performs a basic attack on " + target.getClass().getSimpleName());
        int totalDamage = BASIC_ATTACK_DAMAGE;


        // Check for critical strike
        if (Math.random() * 100 < criticalChance) {
            System.out.println("Critical Strike!");
            totalDamage += CRITICAL_STRIKE_DAMAGE_PER_ROUND;
        }


        target.receiveDamage(totalDamage);
    }


    public void performSkill(Hero target, int skillIndex) {
        if (skillIndex >= 0 && skillIndex < skills.length) {
            System.out.println(name + " performs skill '" + skills[skillIndex] + "' on " + target.getClass().getSimpleName());
            target.receiveDamage(MAGIC_DAMAGE_SKILL_DAMAGE);
            System.out.println(target.getName() + "'s health: " + target.getHealth());
        } else {
            System.out.println("Invalid skill index.");
        }
    }


    public void receiveDamage(int amount) {
        // Implement the logic to reduce health by the given amount
        health -= amount;
        System.out.println(name + " receives " + amount + " damage. Remaining health: " + health);
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
