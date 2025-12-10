package code;
class Person {
    private String name;
    private int energy;
    private int health;
    /*
    * Constructor for objects of class Person
    * @param theName The name of the person
    */
    public Person(String theName) {
        name = theName;
        energy = 100;
        health = 100;
        System.out.println("Welcome " + name + " to the apocalypse!");
    }
    public void printInfo() {
        System.out.println("Player Information:");
        System.out.println("Name: " + this.getName());
        System.out.println("Energy: " + this.getEnergy());
        System.out.println("Health: " + this.getHealth()+"\n");
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

}