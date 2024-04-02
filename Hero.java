public interface Hero {
    void displayInfo();

    void performBasicAttack(Hero target);

    void performSkill(Hero target, int skillIndex);

    boolean isSelected();

    void setSelected(boolean b);
    void receiveDamage(int damage);

    String getName();

    int getHealth();
}
