package code;

import java.util.Scanner;

abstract class Person {
    private String name;
    private int energy;
    private int health;
    private int satiation;
    private Weapon weapon;
    Scanner input = new Scanner(System.in);
    public static String[] activityList = {"Scavenge Walmart","Take a Nap"};
    public static String[] activityListExplain = {"Attempt to loot. Possibility of finding zombies.","Regain Energy"};

    /*
    * Constructor for objects of class Person
    * @param theName The name of the person
    */
    public Person(String theName) {
        name = theName;
        energy = (int)(Math.random()*40+60); // 60-99
        health = (int)(Math.random()*20+70); // 70-89
        satiation = (int)(Math.random()*30+40); // 40-69
    }
    public void personInfo() {
        System.out.println("Player Information:");
        System.out.println("\tName: " + this.getName());
        System.out.println("\tEnergy: " + this.getEnergy());
        System.out.println("\tHealth: " + this.getHealth());
        System.out.println("\tSatiation: " + this.getSatiation());
    }
    public void personStatus() {
        System.out.println("Player Status:");
        System.out.println("\tEnergy: " + this.getEnergy());
        System.out.println("\tHealth: " + this.getHealth());
        System.out.println("\tSatiation: " + this.getSatiation());
    }
    public void setWeapon(Weapon newWeapon){
        this.weapon = newWeapon;
    }
    public Weapon getWeapon(){
        return this.weapon;
    }
    public void weaponInfo() {
        System.out.println("Weapon Information:");
        System.out.println("\tName: " + this.weapon.getName());
        System.out.println("\tDamage: " + this.weapon.getDamage());
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
    public int getSatiation(){
        return satiation;
    }
    public void setHealth(int newHealth){
        this.health = newHealth;
    }
    public void setEnergy(int newEnergy){
        this.energy = newEnergy;
    }
    public void sleep(){
        this.energy = (int)(Math.random()*((this.energy/2.0+50)-this.energy+1)+this.energy);
        this.health = (int)(Math.random()*((this.energy-0.01(this.energy)(this.energy))-this.energy+1)+this.energy);
        this.energy = (int)(Math.random()*((this.energy/2.0+50)-this.energy+1)+this.energy);
    }
    public void setSatiation(int newSatiation){
        this.satiation = newSatiation;
    }
    public abstract String[] getActivityListClass();
    public abstract String[] getActivityListExplainClass();
    public void printActivityList(){
        int i = 1;
        System.out.println("Here are your activity options:");
        for (; i <= activityList.length; i++){
            System.out.println("\t" + i + ": " + activityList[i-1]);
            System.out.println("\t\t" + activityListExplain[i-1]);
        }
        for (; i <= this.getActivityListClass().length + activityList.length; i++){
            System.out.println("\t" + i + ": " + this.getActivityListClass()[i-1-activityList.length]);
            System.out.println("\t\t" + this.getActivityListExplainClass()[i-1-activityList.length]);
        }
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