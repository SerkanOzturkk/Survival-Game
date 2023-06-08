import java.util.Scanner;

public class Player {
    private Inventory inv;
    private int damage,healthy,rhealthy,money;
    private String name,cName;

    Scanner scanner = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inv= new Inventory();
    }

    public void selectCha(){
        switch (chaMenu()){
            case 1:
                initPlayer("Samurai",5,21,15);
                break;
            case 2:
                initPlayer("Archer",7,18,20);
                break;
            case 3:
                initPlayer("Knight",8,24,5);
                break;
            default:
                initPlayer("Samurai",5,21,15);
                break;
        }
        System.out.println("Character : " + getcName() + " , Damage : " + getDamage() + " , Health : " + getHealthy() + " , Money : " + getMoney());
    }

    public int chaMenu(){
        System.out.println("1- Samurai \t Damage: 5 \t Health: 21 \t Money: 15");
        System.out.println("2- Archer \t Damage: 7 \t Health: 18 \t Money: 20");
        System.out.println("3- Knight \t Damage: 8 \t Health: 24 \t Money: 5");
        System.out.print("Your choice : ");
        int chaID = scanner.nextInt();

        while (chaID<1 || chaID>3){
            System.out.print("Please choose a valid character : ");
            chaID = scanner.nextInt();
        }

        return chaID;
    }

    public int getTotalDamage(){
        return this.getDamage() + this.getInv().getDamage();
    }

    public void initPlayer(String cName , int dmg , int hlthy , int mny){
        setcName(cName);
        setDamage(dmg);
        setHealthy(hlthy);
        setMoney(mny);
        setRhealthy(hlthy);
    }

    public Inventory getInv() {
        return inv;
    }

    public void setInv(Inventory inv) {
        this.inv = inv;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public int getRhealthy() {
        return rhealthy;
    }

    public void setRhealthy(int rhealthy) {
        this.rhealthy = rhealthy;
    }
}
