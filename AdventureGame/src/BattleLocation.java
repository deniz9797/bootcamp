import java.util.Locale;
import java.util.Random;

public abstract class BattleLocation extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;
    private boolean isAllObstacleDefeated = false;

    public BattleLocation(Player player, String name, Obstacle obstacle, String award, int maxObstacle, boolean isAllObstacleDefeated) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
        this.isAllObstacleDefeated = isAllObstacleDefeated;
    }

    @Override
    boolean onLocation() {
        if (this.getIsAllObstacleDefeated()) {
            return false;
        }
        int obsNumber = this.randomObstacleNumber();
        System.out.println("You are here: " + this.getName());
        System.out.println("Be careful! " + obsNumber + " " + this.getObstacle().getObstacleName() + " can be around");
        System.out.println("Do you want to start a Battle(Press B) or Run(Press R)?");
        String selectCase = input.nextLine().toUpperCase();
        if (selectCase.equals("B")) {
            this.setIsAllObstacleDefeated(false);
            System.out.println("\n--------------------BATTLE BEGINS--------------------\n");
            if (combat(obsNumber)) {
                return true;
            }
        }
        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("You lose!");
            return false;
        }
        return true;
    }

    public void afterHit() {
        System.out.println("Your Health Point: " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getObstacleName() + "'s Health Point: " + this.getObstacle().getHealth());
    }

    int gainedAward = 0;

    public boolean combat(int obsNumber) {
        for (int i = 1; i <= obsNumber; i++) {
            this.getObstacle().setHealth(this.getObstacle().getInitialHealth());
            playerStats();
            obstacleStats(i);
            int firstAttack = whoAttacksFirst();
            boolean firstPlayer = false;
            System.out.println("First Attack: " + firstAttack);
            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                System.out.println("\n\nBeat(Press B) or Run(R)");
                String selectCombat = input.nextLine().toUpperCase();
                if (selectCombat.equals("B")) {
                    if (firstAttack == 0 || firstPlayer == true) {
                        firstPlayer = true;
                        System.out.println("\n\nYou attacked!");
                        this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                        afterHit();
                    }
                    if (firstAttack == 1 || firstPlayer == true) {
                        firstPlayer = true;
                        if (this.getObstacle().getHealth() > 0) {
                            System.out.println("\n\nObstacle attacked!");
                            int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlockValue();
                            if (obstacleDamage < 0) {
                                obstacleDamage = 0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                            afterHit();
                        }
                    }
                } else {
                    return false;
                }
            }
            if (this.getObstacle().getHealth() < this.getPlayer().getHealth()) {
                this.setIsAllObstacleDefeated(true);
                System.out.println("#############################################");
                System.out.println("\n\nYou Defeated All Obstacles in the " + this.getName() + "\n\n");
                if(this.getName()!="Mine"){
                    System.out.println("You get : " + getObstacle().getAward());
                }
                this.getPlayer().setMoney(this.getPlayer().getMoney() + getObstacle().getAward());
                switch (this.getName()) {
                    case "Cave":
                        this.getPlayer().getInventory().getFood().setPlayerGainAward(true);
                        gainedAward = this.getPlayer().getGainedAward() + 1;
                        this.getPlayer().setGainedAward(gainedAward);
                        this.setIsAllObstacleDefeated(true);
                        System.out.println("You gained : Food");
                        break;
                    case "Forest":
                        this.getPlayer().getInventory().getFirewood().setPlayerGainAward(true);
                        gainedAward = this.getPlayer().getGainedAward() + 1;
                        this.getPlayer().setGainedAward(gainedAward);
                        this.setIsAllObstacleDefeated(true);
                        System.out.println("You gained : Firewood");
                        break;
                    case "River":
                        this.getPlayer().getInventory().getWater().setPlayerGainAward(true);
                        gainedAward = this.getPlayer().getGainedAward() + 1;
                        this.getPlayer().setGainedAward(gainedAward);
                        this.setIsAllObstacleDefeated(true);
                        System.out.println("You gained : Water");
                        break;
                    case "Mine":
                        String snakeAward = randomAwardsFromSnake();
                        int item = chanceOfGettingItem();
                        switch (snakeAward){
                            case "Nothing":
                                System.out.println("You gained Nothing");
                                break;
                            case "Weapon":
                                weaponAward(item);
                                break;
                            case "Armor":
                                armorAward(item);
                                break;
                            case "Money":
                                moneyAward(item);
                                break;
                        }
                }
                System.out.println("Your current money is : " + this.getPlayer().getMoney() + "\n\n");
                System.out.println("#############################################");
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    public void playerStats() {
        System.out.println("\nPlayer status: ");
        System.out.println("#############################################");
        System.out.println("Health: " + this.getPlayer().getHealth());
        System.out.println("Damage: " + this.getPlayer().getTotalDamage());
        System.out.println("Money: " + this.getPlayer().getMoney());
        System.out.println("Armor: " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Weapon: " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Blocking Power: " + this.getPlayer().getInventory().getArmor().getBlockValue());
    }

    public void obstacleStats(int i) {
        System.out.println("\n" + this.getObstacle().getObstacleName() + i + " status: ");
        System.out.println("#############################################");
        System.out.println("Health: " + this.getObstacle().getHealth());
        System.out.println("Damage: " + this.getObstacle().getDamage());
        System.out.println("Award: " + this.getObstacle().getAward());
    }

    public int whoAttacksFirst() {
        Random whoAttacksFirst = new Random();
        return whoAttacksFirst.nextInt(2);
        //0--> Player
        //1--> Obstacle
    }

    public int randomObstacleNumber() {
        Random r = new Random();
        return r.nextInt(3) + 1;
    }

    public void weaponAward(int item) {
        Weapon gainedWeapon;
        if (item <= 50) {
            System.out.println("\n\nYou gained Gun!");
            gainedWeapon = Weapon.getWeaponObjByID(1);
            this.getPlayer().getInventory().setWeapon(gainedWeapon);
        } else if (item <= 70) {
            System.out.println("\n\nYou gained Riffle!");

            gainedWeapon = Weapon.getWeaponObjByID(2);
            this.getPlayer().getInventory().setWeapon(gainedWeapon);

        } else if (item <= 100) {
            System.out.println("\n\nYou gained Sword!");

            gainedWeapon = Weapon.getWeaponObjByID(3);
            this.getPlayer().getInventory().setWeapon(gainedWeapon);
        }
    }

    public void armorAward(int item) {
        Armor gainedArmor;
        if (item <= 50) {
            System.out.println("\n\nYou gained Light Armor!");

            gainedArmor = Armor.getArmorObjByID(1);
            this.getPlayer().getInventory().setArmor(gainedArmor);
        } else if (item <= 70) {
            System.out.println("\n\nYou gained Heavy Armor!");

            gainedArmor = Armor.getArmorObjByID(2);
            this.getPlayer().getInventory().setArmor(gainedArmor);

        } else if (item <= 100) {
            System.out.println("\n\nYou gained Medium Armor!");

            gainedArmor = Armor.getArmorObjByID(3);
            this.getPlayer().getInventory().setArmor(gainedArmor);
        }

    }

    public void moneyAward(int item) {
        int money;
        if (item>=0&&item <= 20) {
            System.out.println("\n\nYou gained 10 Money!");
            money = this.getPlayer().getMoney() + 10;
            this.getPlayer().setMoney(money);
        } else if (item>=21 &&item <= 50) {
            System.out.println("\n\nYou gained 5 Money!");
            money = this.getPlayer().getMoney() + 5;
            this.getPlayer().setMoney(money);
        } else if (item>=52&&item <= 100) {
            System.out.println("\n\nYou gained 1 Money!");
            money = this.getPlayer().getMoney() + 1;
            this.getPlayer().setMoney(money);
        }
    }

    public String randomAwardsFromSnake() {
        int condition1;
        Random r = new Random();
        String award = null;
        condition1 = r.nextInt(100) + 1;
        if (condition1>=0&&condition1 <= 45) {
            award = "Nothing";
        } else if (condition1>=46&&condition1 <= 60) {
            award = "Weapon";
        } else if (condition1>=61&&condition1 <= 75) {
            award = "Armor";
        } else if (condition1>=76&&condition1 <= 100) {
            award = "Money";
        }
        return award;
    }

    public int chanceOfGettingItem() {
        Random r = new Random();
        int chance = r.nextInt(100) + 1;
        return chance;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
