public abstract class AreaAwards {

    private String name;
    private boolean playerGainAward;

    public AreaAwards(String name, boolean playerGainAward) {
        this.name = name;
        this.playerGainAward = playerGainAward;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPlayerGainAward() {
        return playerGainAward;
    }

    public void setPlayerGainAward(boolean playerGainAward) {
        this.playerGainAward = playerGainAward;
    }
}
