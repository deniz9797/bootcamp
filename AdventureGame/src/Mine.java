import java.util.Random;

public class Mine extends BattleLocation{

    private int awardGenerated;
    private String award;

    public Mine(Player player) {
        super(player, "Mine", new Snake(), "award", 5, false);
    }


    @Override
    public String getAward() {
        return award;
    }

    @Override
    public void setAward(String award) {
        this.award = award;
    }
}
