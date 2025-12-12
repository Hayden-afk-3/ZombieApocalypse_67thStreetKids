package code;

import java.util.Scanner;

abstract class Person {
    private String name;
    private int energy;
    private int health;
    private Weapon weapon;
    Scanner input = new Scanner(System.in);
    public static String[] activityList = {"Scavenge Walmart","Take a Nap"};
    /*
    * Constructor for objects of class Person
    * @param theName The name of the person
    */
    public Person(String theName) {
        name = theName;
        energy = 100;
        health = 100;
        System.out.println("Welcome " + name + " to the zombie apocalypse!");
    }
    public void personInfo() {
        System.out.println("Player Information:");
        System.out.println("Name: " + this.getName());
        System.out.println("Energy: " + this.getEnergy());
        System.out.println("Health: " + this.getHealth()+"\n");
    }
    public void setWeapon(Weapon newWeapon){
        this.weapon = newWeapon;
    }
    public void weaponInfo() {
        System.out.println("Weapon Information:");
        System.out.println("\tName: " + this.weapon.getName());
        System.out.println("\tDamage: " + this.weapon.getDamage()+"\n");
    }
    public String getName() {
        return name;
    }
    public int getEnergy(){
        return energy;
    }
    public int getHealth(){
        return health;
    }
    public void setHealth(int newHealth){
        this.health = newHealth;
    }
    public void setEnergy(int newEnergy){
        this.energy = newEnergy;
    }
    public abstract String[] getActivityListClass();
    public void printActivityList(){
        int i = 1;
        System.out.println("Here are your activity options:");
        for (; i <= activityList.length; i++){
            System.out.println("\t" + i + ": " + activityList[i-1]);
        }
        for (; i <= this.getActivityListClass().length + activityList.length; i++){
            System.out.println("\t" + i + ": " + this.getActivityListClass()[i-1-activityList.length]);
        }
        System.out.println("\t?: Explain choices");
    }
    public void Walmart(){
        this.energy -= 10;
        this.health += 10;
        System.out.println("You went to Walmart. Energy -10, Health +10.");
        System.out.println("You encounter a zombie while leaving Walmart!\nDo you want to fight(1) or run(2)?");
        int walChoice = input.nextInt();
        switch (walChoice) {
            case 1:
                this.health -= 15;
                System.out.println("You fought the zombie and won! Health -15.");
                break;
            case 2:
                this.energy -= 20;
                System.out.println("You ran away from the zombie! Energy -20.");
                break;
            default:
                System.out.println("Invalid input. You hesitated and the zombie attacked you! Health -20.");
                this.health -= 20;
                break;
        }

    }

}