package code;

import java.util.Scanner;

public class Main {
    // initializes scanner for all methods to use in class
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // sets up null player so there's no errors relating to possibly not setting player type
        Person player = null;
        int roleChoice = 0;
        clear();

        System.out.println("1. New Game\n2. Load Game");
        int gameChoice = input.nextInt();
        // consume /n
        input.nextLine();
        clear();
        switch (gameChoice) {
            case 2:
                // day_role_health_satiation_energy_weaponAdjective_weaponWeapon_weaponVerb_weaponDamage_vegan_name_
                // example: 2_1_84_58_97_7_20_23_5_0_Cooper
                String saveDay = "";
                String saveRole = "";
                String saveHealth = "";
                String saveSatiation = "";
                String saveEnergy = "";
                String saveWeaponAdjective = "";
                String saveWeaponWeapon = "";
                String saveWeaponVerb = "";
                String saveWeaponDamage = "";
                String saveVegan = "";
                String saveName = "";
                int currentIndex = 0;

                System.out.print("Enter your saved game string: ");
                String savedGameString = input.nextLine();

                while (savedGameString.charAt(currentIndex) != '_'){
                    saveDay += savedGameString.charAt(currentIndex);
                    currentIndex++;
                }
                currentIndex++;

                while (savedGameString.charAt(currentIndex) != '_'){
                    saveRole += savedGameString.charAt(currentIndex);
                    currentIndex++;
                }
                currentIndex++;

                while (savedGameString.charAt(currentIndex) != '_'){
                    saveHealth += savedGameString.charAt(currentIndex);
                    currentIndex++;
                }
                currentIndex++;

                while (savedGameString.charAt(currentIndex) != '_'){
                    saveSatiation += savedGameString.charAt(currentIndex);
                    currentIndex++;
                }
                currentIndex++;

                while (savedGameString.charAt(currentIndex) != '_'){
                    saveEnergy += savedGameString.charAt(currentIndex);
                    currentIndex++;
                }
                currentIndex++;

                while (savedGameString.charAt(currentIndex) != '_'){
                    saveWeaponAdjective += savedGameString.charAt(currentIndex);
                    currentIndex++;
                }
                currentIndex++;

                while (savedGameString.charAt(currentIndex) != '_'){
                    saveWeaponWeapon += savedGameString.charAt(currentIndex);
                    currentIndex++;
                }
                currentIndex++;

                while (savedGameString.charAt(currentIndex) != '_'){
                    saveWeaponVerb += savedGameString.charAt(currentIndex);
                    currentIndex++;
                }
                currentIndex++;

                while (savedGameString.charAt(currentIndex) != '_'){
                    saveWeaponDamage += savedGameString.charAt(currentIndex);
                    currentIndex++;
                }
                currentIndex++;

                while (savedGameString.charAt(currentIndex) != '_'){
                    saveVegan += savedGameString.charAt(currentIndex);
                    currentIndex++;
                }
                currentIndex++;

                while (currentIndex < savedGameString.length()){
                    saveName += savedGameString.charAt(currentIndex);
                    currentIndex++;
                }
                
                switch (saveRole) {
                    case "1":
                        player = new Scavenger(Integer.valueOf(saveDay), Integer.valueOf(saveHealth), Integer.valueOf(saveSatiation), Integer.valueOf(saveEnergy), Integer.valueOf(saveVegan), saveName);
                        break;
                    case "2":
                        player = new Medic(Integer.valueOf(saveDay), Integer.valueOf(saveHealth), Integer.valueOf(saveSatiation), Integer.valueOf(saveEnergy), Integer.valueOf(saveVegan), saveName);
                        break;
                    case "3":
                        player = new Warrior(Integer.valueOf(saveDay), Integer.valueOf(saveHealth), Integer.valueOf(saveSatiation), Integer.valueOf(saveEnergy), Integer.valueOf(saveVegan), saveName);
                        break;
                }
                player.setWeapon(new Weapon(Integer.valueOf(saveWeaponAdjective), Integer.valueOf(saveWeaponWeapon), Integer.valueOf(saveWeaponVerb), Integer.valueOf(saveWeaponDamage)));
                clear();
            break;
            case 1:
                // grab name from user
                System.out.print("Enter your name: ");
                String name = input.nextLine();
                clear();

                // grabs role from user and verifies input
                System.out.println("What character do you want to be?");
                System.out.println("1. Scavenger\n2. Medic\n3. Warrior");
                roleChoice = input.nextInt();
                // consume /n
                input.nextLine();
                while (roleChoice != 1 && roleChoice != 2 && roleChoice != 3) {
                    System.out.println("Invalid input. Please enter 1, 2, or 3.");
                    roleChoice = input.nextInt();
                    // consume /n
                    input.nextLine();
                }
                        // switch case that uses each role's constructor to set player type
                switch (roleChoice) {
                    case 1:
                        player = new Scavenger(name);
                        break;
                    case 2:
                        player = new Medic(name);
                        break;
                    case 3:
                        player = new Warrior(name);
                        break;
                }
                clear();

                // switch case that uses each roleChoice's constructor to set player type
                switch (roleChoice) {
                    case 1:
                        player = new Scavenger(name);
                        break;
                    case 2:
                        player = new Medic(name);
                        break;
                    case 3:
                        player = new Warrior(name);
                        break;
                }
                clear();

                // player gets assigned weapon
                System.out.println(player.getName() + " has found a weapon!");
                player.setWeapon(new Weapon(5));
                player.getWeapon().weaponInfo();
                continueGame();
                break;
        }
        // main game loop
        while (true){
            // if player is dead, break loop
            if (player.checkDeath()){
                break;
            }

            // daily activities
            System.out.println("Day " + player.getDay());
            player.personStatus();
            player.printActivityList();
            System.out.print("Activity #: ");
            int choice = input.nextInt();
            // consume /n
            input.nextLine();

            // activity choice is parsed into it's respective method
            player.parseActivity(choice);
            continueGame();
            player.zombieFight();

            // if player died from zombie fight, break loop
            if (player.checkDeath()){
                break;
            }
            continueGame();
            
            // player sleep method increases stats and day increments
            player.sleep();
            continueGame();

            System.out.println("Would you like to quit your game?");
            boolean quitGame = false;
            switch (input.nextLine()) {
                case "Yes", "yes", "y":
                    quitGame = true;
                    String gameString = encodeGame(player);
                    System.out.println("Game saved! Encoded string:");
                    System.out.println(gameString);
                    break;
                case "No", "no", "n":
                    quitGame = false;
                    clear();
                    break;
                default:
                    quitGame = false;
                    clear();
                    break;
            }
            //continueGame();
            if (quitGame){
                break;
            }
        }
        input.close();
    }


    /**
    * clears the console
    */
    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * pauses game until user presses enter
     */
    public static void continueGame(){
        System.out.print("Press Enter to continue...");
        // String consumeResponse = input.nextLine();
        input.nextLine();
        clear();
    }

    /**
     * encodes the game state into a string for saving
     * @param player the player object
     * @return encoded game string
     */
    public static String encodeGame(Person player){
        String returnString = "";
        // day_role_health_satiation_energy_weaponNameEncode_weaponDamage_vegan_name
        returnString += player.getDay() + "_";
        returnString += player.getRole() + "_";
        returnString += player.getHealth() + "_";
        returnString += player.getSatiation() + "_";
        returnString += player.getEnergy() + "_";
        returnString += player.getWeapon().encodeWeaponName() + "_";
        returnString += player.getWeapon().getDamage() + "_";
        if (player.getVegan()){
            returnString += "1_";
        }
        else {
            returnString += "0_";
        }
        returnString += player.getName();
        return returnString;
    }
}