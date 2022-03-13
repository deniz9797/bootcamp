public class Obstacle {
    private int id;
    private int damage;
    private int health;
    private String obstacleName;
    private int award;
    private int initialHealth;


    public Obstacle(int id, String obstacleName, int damage, int health, int award) {
        this.id = id;
        this.damage = damage;
        this.health = health;
        this.obstacleName = obstacleName;
        this.initialHealth = health;
        this.award = award;
    }

    public String getObstacleName() {
        return obstacleName;
    }

    public void setObstacleName(String obstacleName) {
        this.obstacleName = obstacleName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        if (health < 0) {
            health = 0;
        }
        this.health = health;

    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public int getInitialHealth() {
        return initialHealth;
    }

    public void setInitialHealth(int initialHealth) {
        this.initialHealth = initialHealth;
    }
}
