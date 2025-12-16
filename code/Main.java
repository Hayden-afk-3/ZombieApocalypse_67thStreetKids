package code;

import java.util.Scanner;

public class Main {
    private static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int day = 1;
        int choice;

        System.out.print("Enter your name: ");
        String name = input.nextLine();
        clear();

        System.out.println("What character do you want to be?");
        System.out.println("1. Scavenger\n2. Medic\n3. Warrior");
        int role = input.nextInt();
        while (role != 1 && role != 2 && role != 3) {
            System.out.println("Invalid input. Please enter 1, 2, or 3.");
            role = input.nextInt();
        }
        Person player = null;
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

        System.out.println(player.getName() + " has found a weapon!");
        player.setWeapon(new Weapon(5));
        player.weaponInfo();
        continueGame();

        while (true){
            if (checkDeath(player,day)){
                break;
            }
            System.out.println("Day " + day);
            player.personStatus();
            player.printActivityList();
            System.out.print("Activity #: ");
            choice = input.nextInt();
            player.parseActivity(choice);
            player.zombieFight(day);
            if (player.getHealth()<=0){
                System.out.println(player.getName()+" has ran out of health! \nThey fell over and died from their injuries on Day " + day + ".");
                break;
            }
            continueGame();
            
            player.sleep();
            day++;
        }
        input.close();
    }
    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void continueGame(){
        input.nextLine();
        System.out.print("Press Enter to continue...");
        input.nextLine();
        clear();
    }
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
