public class Inventory {

    private Weapon weapon;
    private Armor armor;
    private Food food;
    private Firewood firewood;
    private Water water;

    public Inventory() {
        this.weapon = new Weapon("Punch", -1, 0, 0);
        this.armor = new Armor(-1, "No Armor", 0, 0);
        this.food = new Food("Food", false);
        this.firewood = new Firewood("Firewood", false);
        this.water = new Water("Water", false);
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Firewood getFirewood() {
        return firewood;
    }

    public void setFirewood(Firewood firewood) {
        this.firewood = firewood;
    }

    public Water getWater() {
        return water;
    }

    public void setWater(Water water) {
        this.water = water;
    }
}
