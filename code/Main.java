package code;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int nights = 0;
        System.out.println("Enter your name: ");
        String name = input.nextLine();
        clear();
        System.out.println("What character do you want to be?");
        System.out.println("1. Scavenger\n2. Medic\n3. Warrior");
        int role = input.nextInt();
        while (role != 1 && role != 2 && role != 3) {
            System.out.println("Invalid input. Please enter 1, 2, or 3.");
            role = input.nextInt();
        }
        clear();

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
        while (true) {
            // Game loop logic goes here
            nights++;
            if (player.getHealth() <= 0 || player.getEnergy() <= 0) {
                System.out.println("Game Over! You survived " + nights + " nights.");
                break;
            }
        }
    }
    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
