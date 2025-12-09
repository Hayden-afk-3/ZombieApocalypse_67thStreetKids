package code;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = input.nextLine();
        System.out.println("What character do you want to be?");
        System.out.println("1. Scavenger\n2. Medic\n3. Warrior");
        int role = input.nextInt();
        while (role != 1 && role != 2 && role != 3) {
            System.out.println("Invalid input. Please enter 1, 2, or 3.");
            role = input.nextInt();
        }

        Person player;

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
        for (int nights = 1; nights <= 10; nights++) {
            
        }
    }
}
