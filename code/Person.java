package code;

abstract class Person {
    // initialize instance variables
    private String name;
    private int energy;
    private int health;
    private int satiation;
    private Weapon weapon;
    public static String[] activityList = {"Scavenge Walmart","Take a Nap"};
    public static String[] activityListExplain = {"Attempt to loot. Possibility of finding zombies.","Regain Energy"};

    // initialize abstract methods to be implemented specifically in subclasses
    public abstract String[] getActivityListClass();
    public abstract String[] getActivityListExplainClass();
    public abstract void parseActivity(int choice);

    /**
     * Constructor for objects of class Person
     * @param theName name of the person
     */
    public Person(String theName) {
        name = theName;
        energy = (int)(Math.random()*(99-60+1)+60); // 60-99
        health = (int)(Math.random()*(89-70+1)+70); // 70-89
        satiation = (int)(Math.random()*(69-40+1)+40); // 40-69
    }

    /**
     * Prints the person's information, essentialy a toString method
     * Specifically used for development, as it shows all player info
     */
    public void personInfo() {
        System.out.println("Player Information:");
        System.out.println("\tName: " + this.getName());
        System.out.println("\tEnergy: " + this.getEnergy());
        System.out.println("\tHealth: " + this.getHealth());
        System.out.println("\tSatiation: " + this.getSatiation());
    }

    /**
     * Prints the person's information, essentialy a toString method
     * Specifically used for user interaction, as it shows only useful player info
     */
    public void personStatus() {
        System.out.println("Player Status:");
        System.out.println("\tEnergy: " + this.getEnergy());
        System.out.println("\tHealth: " + this.getHealth());
        System.out.println("\tSatiation: " + this.getSatiation());
    }

    /**
     * Sets the person's weapon
     * @param newWeapon weapon to be assigned to the person
     */
    public void setWeapon(Weapon newWeapon){
        this.weapon = newWeapon;
    }
    
    /**
     * Gets the person's weapon
     * @return person's weapon
     */
    public Weapon getWeapon(){
        return this.weapon;
    }

    /**
     * Gets the person's name
     * @return person's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the person's energy
     * @return person's energy
     */
    public int getEnergy(){
        return energy;
    }

    /**
     * Gets the person's health
     * @return person's health
     */
    public int getHealth(){
        return health;
    }

    /**
     * Gets the person's satiation
     * @return person's satiation
     */
    public int getSatiation(){
        return satiation;
    }

    /**
     * Sets the person's health
     * @param newHealth player's new health value
     */
    public void setHealth(int newHealth){
        this.health = newHealth;
    }

    /**
     * Sets the person's energy
     * @param newEnergy player's new energy value
     */
    public void setEnergy(int newEnergy){
        this.energy = newEnergy;
    }

    /**
     * Simulates sleeping, increasing energy, health, and decreasing satiation
     * Also prints to console the changes in stats
     */
    public void sleep(){
        System.out.println("The sun sets and " + this.name + " starts to fall asleep.");
        int startEnergy = this.energy;
        int startHealth = this.health;
        int startSatiation = this.satiation;

        this.energy = (int)(Math.random()*((this.energy/2.0+49)-this.energy+1)+this.energy);
        this.health = (int)(Math.random()*(-0.0109*(this.health-100)*(this.health-100)+99-this.health+1)+this.health);
        this.satiation = (int)(Math.random()*(0.85*(this.satiation-10)-this.satiation+1)+this.satiation);

        System.out.println(this.name + " feels rested.");
        System.out.println("\tHealth: " + startHealth + " +" + (this.health-startHealth) + " --> " + this.health);
        System.out.println("\tEnergy: " + startEnergy + " +" + (this.energy-startEnergy) + " --> " + this.energy);
        System.out.println("\tSatiation: " + startSatiation + " -" + (startSatiation-this.satiation) + " --> " + this.satiation);
    }

    /**
     * Sets the person's satiation
     * @param newSatiation player's new satiation value
     */
    public void setSatiation(int newSatiation){
        this.satiation = newSatiation;
    }

    /**
     * Simulates scavenging Walmart
     */
    public void scavengeWalmart(){
        System.out.println(this.name + " starts to scavenge Walmart.");
        int startHealth = this.health;
        int startEnergy = this.energy;
        int startSatiation = this.satiation;

        System.out.println("Would you like to look for \n\t1. Food\n\t2. Weapon\n\t3. Supplies");
    }

    /**
     * Simulates taking a nap, increasing energy, health, and slightly decreasing satiation
     * Also prints to console the changes in stats
     */
    public void takeANap(){
        System.out.println(this.name + " starts to take a nap.");
        int startEnergy = this.energy;
        int startHealth = this.health;

        this.energy = (int)(Math.random()*((this.energy/2.0+49)-this.energy+1)+this.energy);
        this.health = (int)(Math.random()*(-0.0109*(this.health-100)*(this.health-100)+99-this.health+1)+this.health);
        this.satiation = (int)(Math.random()*(0.85*(this.satiation-10)-this.satiation+1)+this.satiation);

        System.out.println(this.name + " feels rested.");
        System.out.println("\tHealth: " + startHealth + " +" + (this.health-startHealth) + " --> " + this.health);
        System.out.println("\tEnergy: " + startEnergy + " +" + (this.energy-startEnergy) + " --> " + this.energy);
    }

    /**
     * Prints the activity list available to the player
     */
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

    /**
     * Simulates a fight between the player and a zombie
     * @param day the current day, used to scale zombie stats
     */
    public void zombieFight(int day) {
        int startHealth = this.health;
        int totalDamage = 0;
        int energyLoss = 0;
        System.out.println(this.name + " ran into a zombie!");
        Zombie zombie = new Zombie((int)(5*Math.log(day)+4),(int)(4*Math.log(day)+2));
        while (zombie.getHealth()>0){
            int zombieAttack = (int)(zombie.getDamage()*(0.5*Math.random()+0.75));
            if (this.health-zombieAttack<0){
                break;
            }
            System.out.println("Zombie attacks!\n\t"+this.name+"'s Health: "+this.health+" -" + zombieAttack);
            this.health -= zombieAttack;
            totalDamage += zombieAttack;
            energyLoss += 2;
            int playerAttack = (int)(this.weapon.getDamage()*(0.5*Math.random()+0.75));
            System.out.println(this.name + " attacks!\n\tZombie's Health: "+zombie.getHealth()+" -" + playerAttack);
            zombie.setHealth(zombie.getHealth()-playerAttack);
        }
        System.out.println(this.name + " killed the zombie!");
        System.out.println("\tHealth: " + startHealth + " -" + totalDamage + " --> " + this.health);
        System.out.println("\tEnergy: " + this.energy + " -" + energyLoss + " --> " + (this.energy-energyLoss));
    }
}