package code;

import java.util.Scanner;

public class Main {
    private static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int day = 0;
        boolean gameOver = false;
        int choice;

        System.out.println("Enter your name: ");
        String name = input.nextLine();
        clear();

        System.out.println("What character do you want to be?");
        System.out.println("1. Scavenger\n2. Medic\n3. Warrior");
        int role = input.nextInt();
        while (role != 1 && role != 2 && role != 3) {
            System.out.println("Invalid input. Please enter 1, 2, or 3.");
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

        System.out.println("Your player has found a weapon!");
        player.setWeapon(new Weapon(5));
        player.weaponInfo();
        continueGame();

        while (!gameOver){
            System.out.println("Day " + day);
            player.personStatus();
            player.printActivityList();
            choice = input.nextInt();
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
        System.out.print("Press Enter to continue...");
        input.nextLine();
        //clear();
    }
}
