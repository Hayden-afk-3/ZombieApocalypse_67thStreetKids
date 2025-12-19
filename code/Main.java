package code;

import java.util.Scanner;

public class Main {
    // initializes scanner for all methods to use in class
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // initialize variables
        int day = 1;
        int choice;

        // grab name from user
        System.out.print("Enter your name: ");
        String name = input.nextLine();
        clear();

        // grabs role from user and verifies input
        System.out.println("What character do you want to be?");
        System.out.println("1. Scavenger\n2. Medic\n3. Warrior");
        int role = input.nextInt();
        while (role != 1 && role != 2 && role != 3) {
            System.out.println("Invalid input. Please enter 1, 2, or 3.");
            role = input.nextInt();
        }

        // sets up null player so there's no errors relating to possibly not setting player type
        Person player = null;
        
        // switch case that uses each role's constructor to set player type
        switch (role) {
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

        // main game loop
        while (true){
            // if player is dead, break loop
            if (checkDeath(player,day)){
                break;
            }

            // daily activities
            System.out.println("Day " + day);
            player.personStatus();
            player.printActivityList();
            System.out.print("Activity #: ");
            choice = input.nextInt();

            // activity choice is parsed into it's respective method
            player.parseActivity(choice);
            continueGame();
            player.zombieFight(day);

            // if player died from zombie fight, break loop
            if (player.getHealth()<=0){
                System.out.println(player.getName()+" has ran out of health! \nThey fell over and died from their injuries on Day " + day + ".");
                break;
            }
            continueGame();
            
            // player sleep method increases stats and day increments
            player.sleep();
            continueGame();
            day++;
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
        input.nextLine();
        System.out.print("Press Enter to continue...");
        input.nextLine();
        clear();
    }
    /**
     * checks if player is dead
     * @param player the player object
     * @param day the current day
     * @return true if player is dead, false otherwise
     */
    public static boolean checkDeath(Person player, int day){
        if (player.getHealth()<=0){
            System.out.println(player.getName()+" has ran out of health! \nThey fell over and died from their injuries on Day " + day + ".");
            return true;
        }
        else if (player.getSatiation()<=0){
            System.out.println(player.getName()+" has ran out of satiation! \nThey fell over and died from starvation on Day " + day + ".");
            return true;
        }
        else if (player.getEnergy()<=0){
            System.out.println(player.getName()+" has ran out of energy! \nThey fell over and died from being exhausted on Day " + day + ".");
            return true;
        }
        else{
            return false;
        }
    }
}
