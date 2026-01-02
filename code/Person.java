package code;

import java.util.Scanner;

abstract class Person {
    // initializes scanner for all methods to use in class
    public static final Scanner input = new Scanner(System.in);

    // initialize instance variables
    private String name;
    private int energy;
    private int health;
    private int satiation;
    private Weapon weapon;
    private int day;
    private boolean vegan = false;
    public int role;

    public static String[] activityList = {"Scavenge Walmart","Take a Nap"};
    public static String[] activityListExplain = {"Attempt to loot a Walmart.","Regain Energy"};

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
        day = 1;
    }

    /**
     * Detailed constructor for Person class, used for loading saved games
     * @param theDay current day
     * @param theHealth health of the person
     * @param theSatiation satiation of the person
     * @param theEnergy energy of the person
     * @param theVegan vegan/pacifist status of the person (1 for true, 0 for false)
     * @param theName name of the person
     */
    public Person(int theDay, int theHealth, int theSatiation, int theEnergy, int theVegan, String theName) {
        day = theDay;
        health = theHealth;
        satiation = theSatiation;
        energy = theEnergy;
        if (theVegan == 1){
            vegan = true;
        }
        else{
            vegan = false;
        }
        name = theName;

    }

    /**
     * Prints the person's information
     * Specifically used for development, as it shows all player info
     * @return string representation of person
     */
    @Override
    public String toString() {
        System.out.println("Player Information:");
        System.out.println("\tName: " + this.getName());
        System.out.println("\tEnergy: " + this.getEnergy());
        System.out.println("\tHealth: " + this.getHealth());
        System.out.println("\tSatiation: " + this.getSatiation());
        return "Player Information:\n"+"\tName: " + this.getName()+"\n\tEnergy: " + this.getEnergy()+"\n\tHealth: " + this.getHealth()+"\n\tSatiation: " + this.getSatiation();
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
        if (this.health>99){
            this.health=99;
        }
    }

    /**
     * Sets the person's energy
     * @param newEnergy player's new energy value
     */
    public void setEnergy(int newEnergy){
        this.energy = newEnergy;
        if (this.energy>99){
            this.energy=99;
        }
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

        this.setEnergy((int)(Math.random()*((this.energy+10)-this.energy+1)+this.energy));
        this.setHealth((int)(Math.random()*(-0.0109*(this.health-100)*(this.health-100)+99-this.health+1)+this.health));
        this.setSatiation((int)(Math.random()*(1*(this.satiation-10)-this.satiation+1)+this.satiation));

        System.out.println(this.name + " feels rested.");
        if (this.health<startHealth){
            System.out.println("\tHealth: " + startHealth + " -" + (startHealth-this.health) + " --> " + this.health);
        }
        else{
            System.out.println("\tHealth: " + startHealth + " +" + (this.health-startHealth) + " --> " + this.health);
        }
        System.out.println("\tEnergy: " + startEnergy + " +" + (this.energy-startEnergy) + " --> " + this.energy);
        System.out.println("\tSatiation: " + startSatiation + " -" + (startSatiation-this.satiation) + " --> " + this.satiation);
        day++;
    }

    /**
     * Sets the person's satiation
     * @param newSatiation player's new satiation value
     */
    public void setSatiation(int newSatiation){
        this.satiation = newSatiation;
        if (this.satiation>99){
            this.satiation=99;
        }
    }

    /**
     * Gets the current day
     * @return current day
     */
    public int getDay(){
        return day;
    }

    /**
     * Gets the person's vegan/pacifist status
     * @return person's vegan/pacifist status
     */
    public boolean getVegan(){
        return vegan;
    }
    
    /**
     * Sets the person's vegan/pacifist status
     */
    public void setVegan(boolean newVegan){
        this.vegan = newVegan;
    }
    
    

    /**
     * Gets the person's role
     * @return person's role
     */
    public int getRole(){
        return role;
    }

    /**
     * Simulates scavenging Walmart
     */
    public void scavengeWalmart(){
        System.out.println(this.name + " enters Walmart.");
        int startHealth = this.health;
        int startEnergy = this.energy;
        int startSatiation = this.satiation;

        System.out.println("Would you like to look for... \n\t1. Food (90%)\n\t2. Weapons (30%)\n\t3. Drugs (50%)");
        int response = input.nextInt();
        // consume /n
        input.nextLine();
        System.out.println(name + " starts to look around...");
        // split outputs based on what player is looking for
        switch (response){
            case 1:
                if (Math.random() < 0.95){
                    // initialize arrays for random food generation
                    String[] verbs = {
                            "delicious", "savory", "flavorful", "tasty", "fresh", "juicy", "crispy", "tender", "rich", "sweet", "bland", "stale", "greasy", "burnt", "soggy", "overcooked", "undercooked", "dry", "mushy", "bitter", "slimy", "rubbery", "gritty", "chalky", "stringy", "metallic", "fishy", "spongy", "gelatinous", "foamy", "moist"
                    };
                    String[] foods = {
                            "can of beans", "instant noodles", "protein bar", "bag of rice", "can of soup", "box of cereal", "piece of stale bread", "peanut butter", "crackers", "granola bar", "mystery meat", "expired yogurt", "freeze-dried meal", "spam", "canned tuna", "ramen packet", "powdered milk", "trail mix", "energy bar", "canned fruit", "apple", "banana", "orange", "pear", "carrot", "broccoli", "lettuce", "spinach", "potato", "onion", "bell pepper", "tomato", "zucchini", "corn", "cucumber", "cabbage"
                    };
                    // generates a name of format [verb] [food]
                    String foodItem = verbs[(int)(Math.random()*verbs.length)] + " " + foods[(int)(Math.random()*foods.length)];
                    System.out.println(name + " finds and eats a " + foodItem +"!");

                    // adds random int (5-20) to satiation
                    this.setSatiation(startSatiation + (int)(Math.random()*(20-5+1)+5));

                    // notifies user of increase
                    System.out.println("\tSatiation: " + startSatiation + " +" + (this.satiation-startSatiation) + " --> " + this.satiation);
                }
                else {
                    System.out.println(name + " searches a food aisle, but finds nothing and decides to leave.");
                }
                break;
            case 2:
                if (Math.random() < 0.6){
                    Weapon walmartWeapon = new Weapon((int)((Math.random()+0.5)*(5*Math.log(day)+5)));
                    System.out.println(name + " has found a weapon!");
                    System.out.println("Current weapon:");
                    weapon.weaponInfo();
                    System.out.println("Found weapon:");
                    walmartWeapon.weaponInfo();
                    System.out.println("Would you like to switch? ");
                    String switchResponse = input.nextLine();
                    Main.clear();
                    switch (switchResponse){
                        case "Yes", "yes", "y":
                            System.out.println("You are now the proud owner of a " + walmartWeapon.getName() + "!");
                            this.setWeapon(walmartWeapon);
                            break;
                        case "No", "no", "n":
                            System.out.println("You drop the weapon on the ground and forget about it.");
                            break;
                    }
                }
                else {
                    System.out.println(name + " finds nothing but empty shelves and decides to go home.");
                }
                break;
            case 3:
                if (Math.random() < 0.75){
                    // initialize arrays for random drug generation
                    String[] verbs = {
                            "sealed", "unsealed", "cracked", "broken", "dusty", "clean", "sticky", "rusted", "half-empty", "full", "moist", "intact", "unlabeled", "expired", "torn", "smashed", "moldy", "water-damaged", "warped", "pristine"
                    };
                    String[] containers = {
                            "bottle", "pouch", "bag", "container", "bottle"
                    };
                    String[] drugs = {
                            "ibuprofen", "acetaminophen", "amoxicillin", "prednisone", "metformin", "atorvastatin", "lisinopril", "sertraline", "omeprazole", "alprazolam", "Zombexin", "Neurodex", "Viroquel", "Panacure", "AdrenaMax", "Restoril-X", "Hexamycin", "Vitalex", "Regenzol", "Rhino Pill", "Advil", "Motrin", "Tylenol", "Aleve", "Augmentin", "Zithromax", "Keflex", "Zoloft", "Prozac", "Lexapro", "Xanax", "Lipitor", "Crestor", "Norvasc", "Prilosec", "Nexium", "Claritin", "Zyrtec", "Adderall", "Vicodin", "Percocet", "Benadryl"
                    };
                    // generates a name of format [verb] [container] of [drug]
                    String drugItem = verbs[(int)(Math.random()*verbs.length)] + " " + containers[(int)(Math.random()*containers.length)] + " of " + drugs[(int)(Math.random()*drugs.length)];
                    System.out.println(name + " finds a " + drugItem +" and swallows one!");

                    // adds random int (5-20) to satiation
                    this.setHealth(startHealth + (int)(Math.pow(Math.random(),2)*(50-5+1)+5));

                    // notifies user of increase
                    System.out.println("\tHealth: " + startHealth + " +" + (this.health-startHealth) + " --> " + this.health);
                }
                else {
                    System.out.println(name + " searches the pharmacy, but finds nothing and decides to leave.");
                }
                break;
        }
        this.setEnergy(startEnergy - (int)(Math.random()*(30-1+1)+1));
        System.out.println("\tEnergy: " + startEnergy + " -" + (startEnergy-this.energy) + " --> " + this.energy);
    }

    /**
     * Simulates taking a nap, increasing energy, health, and slightly decreasing satiation
     * Also prints to console the changes in stats
     */
    public void takeANap(){
        System.out.println(this.name + " starts to take a nap.");
        int startEnergy = this.energy;
        int startHealth = this.health;

        this.setEnergy((int)(Math.random()*((this.energy+10)-this.energy+1)+this.energy));
        this.setHealth((int)(Math.random()*(-0.0109*(this.health-100)*(this.health-100)+99-this.health+1)+this.health));

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
    public void zombieFight() {
        int startHealth = this.health;
        int totalDamage = 0;
        int energyLoss = 0;
        System.out.println(this.name + " ran into a zombie!");
        if (day <= 5){
            System.out.print("Use your Enter key to move through the interaction! ");
            input.nextLine();
        }
        Zombie zombie = new Zombie((int)(7*Math.log(day)+7),(int)(5*Math.log(day)+8));
        while (zombie.getHealth()>0){
            int zombieAttack = (int)(zombie.getDamage()*(0.5*Math.random()+0.75));
            if (this.health-zombieAttack<0){
                break;
            }
            System.out.print("Zombie attacks!\n\t"+this.name+"'s Health: "+this.health+" -" + zombieAttack);
            input.nextLine();
            this.health -= zombieAttack;
            totalDamage += zombieAttack;
            energyLoss += 2;
            if (this.checkDeath()){
                break;
            }
            int playerAttack = (int)(this.weapon.getDamage()*(0.5*Math.random()+0.75));
            if (playerAttack>zombie.getHealth()){
                playerAttack = zombie.getHealth();
            }
            System.out.print(this.name + " attacks!\n\tZombie's Health: "+zombie.getHealth()+" -" + playerAttack);
            input.nextLine();
            zombie.setHealth(zombie.getHealth()-playerAttack);
        }
        System.out.println(this.name + " killed the zombie!");
        System.out.println("\tHealth: " + startHealth + " -" + totalDamage + " --> " + this.health);
        System.out.println("\tEnergy: " + this.energy + " -" + energyLoss + " --> " + (this.energy-energyLoss));
    }
/**
     * checks if player is dead
     * @param player the player object
     * @param day the current day
     * @return true if player is dead, false otherwise
     */
    public boolean checkDeath(){
        if (this.getHealth()<=0){
            System.out.println(this.name+" has ran out of health! \n" + this.name + " falls over and dies from their injuries.");
            return true;
        }
        else if (this.getSatiation()<=0){
            System.out.println(this.name+" has ran out of satiation! \n" + this.name + " falls over and dies from starvation.");
            return true;
        }
        else if (this.getEnergy()<=0){
            System.out.println(this.name+" has ran out of energy! \n" + this.name + " falls over and dies from being exhausted.");
            return true;
        }
        else{
            return false;
        }
    }
}