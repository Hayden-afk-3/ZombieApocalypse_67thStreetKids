package code;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Hello, welcome to zombie apocalypse!");
        System.out.println("What is your name?");
        String theName = input.nextLine();
        Person player = new Person(theName);

    }
}
