public class SafeHouse extends NormalLocation{
    public SafeHouse(Player player) {
        super(player, "Safe House");
    }

    @Override
    boolean onLocation() {
        System.out.println("You are at Safe House !");
        System.out.println("Health Point set to initial");
        this.getPlayer().setHealth(this.getPlayer().getInitialHealth());
        return true;
    }
}
