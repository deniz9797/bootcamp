import java.util.Random;
import java.util.Scanner;

public class Game {
    Scanner input = new Scanner(System.in);
    int awardGenerated;
    String award;
    public String randomAwardGenerator(){
        Random r = new Random();
        awardGenerated=r.nextInt(3)+1;
        switch(awardGenerated){
            case 1:
                award= "Money";
                break;
            case 2:
                award= "Weapon";
                break;
            case 3:
                award="Armor";
                break;
        }
        return award;
    }

    public void start() {

        System.out.println("\nWelcome to Adventure Game\n");
        System.out.println("Please Enter Your Name: \n");
        String playerName = input.nextLine();

        Player player = new Player(playerName);
        System.out.println("Welcome " + player.getPlayerName());
        System.out.println("\nThese are the character you can go with : \n");
        player.selectCharacter();
        Location location = null;
        Location cave = new Cave(player);
        Location forest = new Forest(player);
        Location river = new River(player);
        Location mine = new Mine(player);
        boolean isGameFinished = false;

        while (true) {
            player.printInfo();
            System.out.println("\n----------------PLACES----------------------\n");
            System.out.println("List of the Places that can be visited during the adventure...");
            System.out.println("1-Safe House --> Location is safe, no obstacles...");
            System.out.println("2-Tool Store --> You can buy new items...");
            System.out.println("3-Cave --> Award : Food. Be careful! There are scary Zombies!");
            System.out.println("4-Forest --> Award : Firewood. Be careful! There are thirsty Vampires!");
            System.out.println("5-River --> Award: Water. Be careful! There are huge Bears!");
            System.out.println("6-Mine --> Award: Money, Weapon or Armor. Maybe...Nothing :) Be careful! There are Snakes!");
            System.out.println("0-Exit");
            System.out.println("Select a place to go : \n");
            int selectLocation = input.nextInt();
            switch (selectLocation) {
                case 0:
                    location = null;
                    break;
                case 1:
                    if (player.getGainedAward() == 3) {
                        isGameFinished = true;
                        break;
                    }
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = cave;
                    break;
                case 4:
                    location = forest;
                    break;
                case 5:
                    location = river;
                    break;
                case 6:
                    location = mine;
                    break;
                default:
                    location = new SafeHouse(player);
            }
            if (isGameFinished) {
                System.out.println("Congrats!\nYou collected all awards.\n\nYOU WIN!!");
                break;
            }
            if (location != null && location.getIsAllObstacleDefeated()) {
                System.out.println("################################################################");
                System.out.println("\n\nYou've already defeated all obstacles in the " + location.getName() + " and get the award. Visit another place...\n\n");
                continue;
            }

            if (location == null) {
                System.out.println("\nAre you giving up? Bye Brave Heart...");
                break;
            }
            if (!location.onLocation()) {
                System.out.println("GAME OVER");
                break;
            }
        }



    }
}
