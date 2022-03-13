import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int money;
    private int initialHealth;
    private String playerName;
    private String charName;
    private Inventory inventory;
    private int gainedAward=0;
    private BattleLocation battleLocation;

    public BattleLocation getBattleLocation() {
        return battleLocation;
    }

    public void setBattleLocation(BattleLocation battleLocation) {
        this.battleLocation = battleLocation;
    }

    public int getGainedAward() {
        return gainedAward;
    }

    public void setGainedAward(int gainedAward) {
        this.gainedAward = gainedAward;
    }

    public Player(String name) {
        this.playerName = name;
        this.inventory = new Inventory();
    }
    Scanner input = new Scanner(System.in);

    public void selectCharacter() {
        GameCharacter[] characterList = {new Samurai(), new Archer(), new Knight()};
        System.out.println("################################################################");
        for (GameCharacter gamechar : characterList) {
            System.out.println("#"+"Character: " + gamechar.getName() + "\t ID: " + gamechar.getId() +"\t Damage: " + gamechar.getDamage() + "\t Health: " + gamechar.getHealth() + "\t Money: " + gamechar.getMoney());
        }
        System.out.println("################################################################");
        System.out.println("Choose one of the Character ID : ");
        int selection = input.nextInt();
        switch (selection){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }
        System.out.println("Chosen Character: " + this.getCharName());
    }
    public void initPlayer(GameCharacter gameChr) {
        this.setDamage(gameChr.getDamage());
        this.setHealth(gameChr.getHealth());
        this.setInitialHealth(gameChr.getHealth());
        this.setMoney(gameChr.getMoney());
        this.setCharName(gameChr.getName());
    }
    public void printInfo(){
        System.out.println(
                "Weapon: " + this.getInventory().getWeapon().getName() +
                        ", Armor: " + this.getInventory().getArmor().getName()+
                        ", Blocking: " + this.getInventory().getArmor().getBlockValue()+
                        ", Damage: " + this.getTotalDamage() +
                        ", Health: " + this.getHealth() +
                        ", Money: " + this.getMoney()+
                        ", Food: " + this.getInventory().getFood().isPlayerGainAward()+
                        ", Firewood: " +this.getInventory().getFirewood().isPlayerGainAward() +
                        ", Water: " + this.getInventory().getWater().isPlayerGainAward()
        );
    }

    public int getTotalDamage(){
        return damage +this.getInventory().getWeapon().getDamage();
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

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String name) {
        this.playerName = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getInitialHealth() {
        return initialHealth;
    }

    public void setInitialHealth(int initialHealth) {
        this.initialHealth = initialHealth;
    }
}
