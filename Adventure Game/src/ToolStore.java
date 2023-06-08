public class ToolStore extends NormalLoc{

    public ToolStore(Player player) {
        super(player,"Shop");
    }

    @Override
    public boolean getLocation() {
        System.out.println("Para : " + player.getMoney());
        System.out.println("1. Weapons");
        System.out.println("2. Armors");
        System.out.println("3. Exit");
        System.out.println("Your choice : ");
        int selTool = scanner.nextInt();
        int selItemID;
        switch (selTool){
            case 1:
                selItemID = weaponMenu();
                buyWeapon(selItemID);
                break;
            case 2:
                selItemID = armorMenu();
                buyArmor(selItemID);
                break;
            default:
                break;
        }
        return true;
    }

    public int weaponMenu(){
        System.out.println("1. Pistol\t <Price : 25 - Damage : 2>");
        System.out.println("2. Sword\t <Price : 35 - Damage : 3>");
        System.out.println("3. Rifle\t <Price : 45 - Damage : 7>");
        System.out.println("4. Exit");
        System.out.println("Choose a weapon : ");
        int selWeaponID  = scanner.nextInt();
        return selWeaponID;
    }

    public int armorMenu(){
        System.out.println("1. Light  Armor\t <Para : 15 - Engelleme : 1>");
        System.out.println("2. Medium Armor\t <Para : 25 - Engelleme : 3>");
        System.out.println("3. Heavy Armor\t <Para : 40 - Engelleme : 5>");
        System.out.println("4. Exit");
        System.out.println("Choose a weapon : ");
        int selArmorID  = scanner.nextInt();
        return selArmorID;
    }

    public void buyArmor(int itemID){
        int avoid = 0 , price = 0;
        String aName = null;
        switch (itemID){
            case 1:
                avoid = 1;
                aName = "Light  Armor";
                price = 15;
                break;
            case 2:
                avoid = 3;
                aName = "Medium Armor";
                price = 25;
                break;
            case 3:
                avoid = 5;
                aName = "Heavy Armor";
                price = 40;
                break;
            case 4:
                System.out.println("Exiting the Game...");
                break;
            default:
                System.out.println("Invalid operation !");
                break;
        }
        if(price>0){
            if(player.getMoney()>=price){
                player.getInv().setArmor(avoid);
                player.getInv().setaName(aName);
                player.setMoney(player.getMoney()-price);
                System.out.println("You bought " + aName +", Blocked Damage : " + player.getInv().getArmor());
                System.out.println("Remaining money : " + player.getMoney());
            }
            else {
                System.out.println("You don't have enough money !");
            }
        }

    }

    public void buyWeapon(int itemID){
        int damage = 0 , price = 0;
        String wName = null;
        switch (itemID){
            case 1:
                damage = 2;
                wName = "Pistol";
                price = 25;
                break;
            case 2:
                damage = 3;
                wName = "Sword";
                price = 35;
                break;
            case 3:
                damage = 7;
                wName = "Rifle";
                price = 45;
                break;
            case 4:
                System.out.println("Exiting the Game...");
                break;
            default:
                System.out.println("Invalid operation !");
                break;
        }
        if(price>0){
            if(player.getMoney()>=price){
                player.getInv().setDamage(damage);
                player.getInv().setwName(wName);
                player.setMoney(player.getMoney()-price);
                System.out.println("You bought " + wName +", Blocked Damage : " + player.getDamage() + ", New Damage : " + player.getTotalDamage());
                System.out.println("Kalan Para : " + player.getMoney());
            }
            else {
                System.out.println("You don't have enough money !");
            }
        }
    }
}
