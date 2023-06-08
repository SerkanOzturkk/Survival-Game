public class SafeHouse extends NormalLoc{

    public SafeHouse(Player player) {
        super(player, "Safe House");
    }

    @Override
    public boolean getLocation() {
        player.setHealthy(player.getRhealthy());
        System.out.println("You healed...");
        System.out.println("Now you are in the Safe House .");
        return true;
    }
}
