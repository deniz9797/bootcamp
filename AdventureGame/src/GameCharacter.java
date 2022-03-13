public abstract class GameCharacter {
    private int id;
    private String charName;
    private int damage;
    private int health;
    private int money;

    public GameCharacter(int id, int damage, int health, int money, String name) {
        this.id = id;
        this.damage = damage;
        this.health = health;
        this.money = money;
        this.charName = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return charName;
    }

    public void setName(String name) {
        this.charName = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
