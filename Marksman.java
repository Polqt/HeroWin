public interface Marksman {


    String[] getSkills();
}


class Klanx implements Hero, Marksman {
    private static final int BASIC_ATTACK_DAMAGE = 45;
    private static final int MAGIC_DAMAGE_SKILL_DAMAGE = 25;
    private static final double ATTACK_SPEED = 25; // Chances to attack first
    private String name;
    private int basicAttack;
    private String[] skills;
    private double attackSpeed;
    private boolean selected;
    private int health;
    private int mana;




    public Klanx() {
        this.name = "Klanx";
        this.basicAttack = BASIC_ATTACK_DAMAGE;
        this.skills = new String[]{"Ballistic", "Blast Off", "Headshot"};
        this.attackSpeed = ATTACK_SPEED;
        this.selected = false;
        this.health = 300;
        this.mana = 200;
    }


    public void displayInfo() {
        System.out.println("Marksman: " + name);
        System.out.println("Basic Attack: " + basicAttack);
        System.out.println("Skills: " + String.join(", ", skills));
        System.out.println("Attack Speed: " + attackSpeed + "%");
    }


    public void performBasicAttack(Hero target) {
        System.out.println(name + " performs a basic attack on " + target.getClass().getSimpleName());
        int totalDamage = BASIC_ATTACK_DAMAGE;


        // Always hit the target
        target.receiveDamage(totalDamage);
        System.out.println("Hits the target!");


        // Check for double attack
        if (Math.random() * 100 < ATTACK_SPEED) {
            System.out.println("Double attack!");
            target.receiveDamage(totalDamage);
        }
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
    @Override
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




class Gunblade implements Hero, Marksman {
    private static final int BASIC_ATTACK_DAMAGE = 45;
    private static final int MAGIC_DAMAGE_SKILL_DAMAGE = 25;
    private static final double ATTACK_SPEED = 25; // Chances to attack first
    private String name;
    private int basicAttack;
    private String[] skills;
    private double attackSpeed;
    private boolean selected;
    private int health;
    private int mana;


    public Gunblade() {
        this.name = "Gunblade";
        this.basicAttack = BASIC_ATTACK_DAMAGE;
        this.skills = new String[]{"Lethal Range", "Assassinate", "Piercing Shot"};
        this.attackSpeed = ATTACK_SPEED;
        this.selected = false;
        this.health = 300;
        this.mana = 200;
    }


    public void displayInfo() {
        System.out.println("Marksman: " + name);
        System.out.println("Basic Attack: " + basicAttack);
        System.out.println("Skills: " + String.join(", ", skills));
        System.out.println("Attack Speed: " + attackSpeed + "%");
    }


    public void performBasicAttack(Hero target) {
        System.out.println(name + " performs a basic attack on " + target.getClass().getSimpleName());
        int totalDamage = BASIC_ATTACK_DAMAGE;


        // Always hit the target
        target.receiveDamage(totalDamage);
        System.out.println("Hits the target!");


        // Check for double attack
        if (Math.random() * 100 < ATTACK_SPEED) {
            System.out.println("Double attack!");
            target.receiveDamage(totalDamage);
        }
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
        return health;
    }
}
