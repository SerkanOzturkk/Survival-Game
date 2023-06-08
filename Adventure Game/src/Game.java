import java.util.Scanner;

public class Game {
    Player player;
    Location location;
    Scanner scanner = new Scanner(System.in);
    public void login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Game !");
        System.out.print("Enter your name : ");
        String playerName = scanner.nextLine();
        player = new Player(playerName);
        player.selectCha();
        start();
    }

    public void start(){
        while(true){
            System.out.println();
            System.out.println("===============================================");
            System.out.println();
            System.out.println("Choose a place : ");
            System.out.println("1. Safe House --> A safe place for you, no enemy !");
            System.out.println("2. Cave --> You may encounter zombies !");
            System.out.println("3. Forest --> You may encounter vampire. !");
            System.out.println("4. River --> You may encounter bear !");
            System.out.println("5. Shop --> You can buy weapons and armor !");
            System.out.print("Where do you want to go ?");
            int selLoc = scanner.nextInt();
            while(selLoc<1 || selLoc>5){
                System.out.print("Please choose a valid location : ");
                selLoc = scanner.nextInt();
            }

            switch (selLoc){
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new Cave(player);
                    break;
                case 3:
                    location = new Forest(player);
                    break;
                case 4:
                    location = new River(player);
                    break;
                case 5:
                    location = new ToolStore(player);
                    break;
                default:
                    location = new SafeHouse(player);
                    break;
            }

            if(location.getClass().getName().equals("SafeHouse")){
                if(player.getInv().isFood() && player.getInv().isWater() && player.getInv().isFirewood()){
                    System.out.println("Congratulations You Won the Game !");
                    break;
                }
            }

            if(!location.getLocation()){
                System.out.println("Game Over !");
                break;
            }
        }
    }
}
