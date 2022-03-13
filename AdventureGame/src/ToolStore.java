public class ToolStore extends NormalLocation {

    public ToolStore(Player player) {
        super(player, "Tool Store");
    }

    @Override
    boolean onLocation() {
        System.out.println("Welcome to the Tool Store...");
        boolean showMenu = true;
        while(showMenu) {
            System.out.println("1- Weapons");
            System.out.println("2- Armors");
            System.out.println("3- Exit");
            System.out.println("Select an Action...");
            int selectCase = Location.input.nextInt();
            while (selectCase < 1 || selectCase > 3) {
                System.out.println("Invalid selection, try again");
                selectCase = Location.input.nextInt();
            }
            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    showMenu=false;
                    break;
            }
        }
        return true;
    }

    public void printWeapon() {
        System.out.println("------------WEAPONS------------");
        for (Weapon w : Weapon.weapons()) {
            System.out.println("ID: " + w.getId() + "\tName: " + w.getName() + "\tPrice: " + w.getPrice() + "\tDamage: " + w.getDamage());
        }
        System.out.println("Press 0 to Exit");

    }

    public void buyWeapon() {
        System.out.println("Choose a Weapon to Buy");
        int selectWeapon = input.nextInt();
        while (selectWeapon < 0 || selectWeapon > Weapon.weapons().length) {
            System.out.println("Invalid Input, Try again...");
            selectWeapon = input.nextInt();
        }
        if(selectWeapon != 0){
            Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeapon);
            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > getPlayer().getMoney()) {
                    System.out.println("You do not have enough money...");
                } else {
                    System.out.println(selectedWeapon.getName() + " is bought!");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Remaining Money: " + this.getPlayer().getMoney());
                    System.out.println("Your previous Weapon: " + this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("Your new Weapon: " + this.getPlayer().getInventory().getWeapon().getName());

                }
            }
        }

    }

    public void buyArmor() {
        System.out.println("Choose an Armor to Buy");
        int selectArmor = input.nextInt();
        while (selectArmor < 0 || selectArmor > Armor.armors().length) {
            System.out.println("Invalid Input, Try again...");
            selectArmor = input.nextInt();
        }
        if(selectArmor != 0){
            Armor selectedArmor = Armor.getArmorObjByID(selectArmor);
            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > getPlayer().getMoney()) {
                    System.out.println("You do not have enough money...");
                } else {
                    System.out.println(selectedArmor.getName() + " is bought!");
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Remaining Money: " + this.getPlayer().getMoney());
                    System.out.println("Your previous Armor: " + this.getPlayer().getInventory().getArmor().getName());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Your new Armor: " + this.getPlayer().getInventory().getArmor().getName());
                }
            }
        }


    }

    public void printArmor() {
        System.out.println("------------ARMORS------------");
        for (Armor a : Armor.armors()) {
            System.out.println("ID: " + a.getId() + "\tName: " + a.getName() + "\tPrice: " + a.getPrice() + "\tDamage: " + a.getBlockValue());
        }
        System.out.println("Press 0 to Exit");
    }
}
