package code;
class Scavenger extends Person{
    // implements the activity's list and explanations to specific role
    private  String[] activityListClass = {"Scavenge Bass Pro Shops"};
    private  String[] activityListExplainClass = {"Higher chance to find better loot."};
    
    /**
     * Constructor for Scavenger class
     * @param theName applies name to the person
     */
    public Scavenger(String theName) {
        super(theName);
        role = 1;
    }

    /**
     * Detailed constructor for Scavenger class, used for loading saved games
     * @param theDay current day
     * @param theHealth health of the person
     * @param theSatiation satiation of the person
     * @param theEnergy energy of the person
     * @param theVegan vegan/pacifist status of the person (1 for true, 0 for false)
     * @param theName name of the person
     */
    public Scavenger(int theDay, int theHealth, int theSatiation, int theEnergy, int theVegan, String theName) {
        super(theDay, theHealth, theSatiation, theEnergy, theVegan, theName);
        role = 1;
    }

    /**
     * Scavenge Bass Pro Shops
     */
    public void scavengeBassProShops() {

        System.out.println(this.getName() + " enters Bass Pro Shops.");
        int startEnergy = this.getEnergy();
        int startSatiation = this.getSatiation();

        System.out.println("Would you like to look for... \n\t1. Food (80%)\n\t2. Weapons (70%)");
        int response = input.nextInt();
        // consume /n
        input.nextLine();

        System.out.println("You start to look around...");
        // split outputs based on what player is looking for
        switch (response){
            case 1:
                if (Math.random() < 0.9){
                    // initialize arrays for random food generation
                    String[] verbs = {
                            "delicious", "savory", "flavorful", "tasty", "fresh", "juicy", "crispy", "tender", "rich", "sweet", "bland", "stale", "greasy", "burnt", "soggy", "overcooked", "undercooked", "dry", "mushy", "bitter", "slimy", "rubbery", "gritty", "chalky", "stringy", "metallic", "fishy", "spongy", "gelatinous", "foamy", "moist"
                    };
                    String[] foods = {
                            "beef jerky", "turkey jerky", "venison jerky", "smoked sausage", "summer sausage", "pepperoni stick", "trail mix", "protein bar", "granola bar", "dehydrated fruit", "freeze-dried meal", "instant oatmeal", "energy chews", "electrolyte drink mix", "powdered coffee", "powdered hot chocolate", "can of chili", "can of stew", "can of beans", "ramen packet", "peanut butter", "honey packet", "piece of hardtack", "camp ration bar", "MRE", "elk jerky", "bison jerky", "freeze-dried steak", "backcountry pasta meal", "mountain house meal"
                    };
                    // generates a name of format [verb] [food]
                    String foodItem = verbs[(int)(Math.random()*verbs.length)] + " " + foods[(int)(Math.random()*foods.length)];
                    System.out.println(this.getName() + " finds and eats a " + foodItem +"!");

                    // adds random int (5-30) to satiation
                    this.setSatiation(startSatiation + (int)((1-Math.pow(Math.random(),2))*(30-5+1)+5));

                    // notifies user of increase
                    System.out.println("\tSatiation: " + startSatiation + " +" + (this.getSatiation()-startSatiation) + " --> " + this.getSatiation());
                }
                else {
                    System.out.println(this.getName() + " searches a food aisle, but finds nothing and decides to leave.");
                }
                break;
            case 2:
                if (Math.random() < 0.85){
                    Weapon bassProWeapon = new Weapon((int)(((1-Math.pow(Math.random(),2))+0.5)*(5*Math.log(this.getDay())+7)));
                    System.out.println(this.getName() + " has found a weapon!");
                    System.out.println("Current weapon:");
                    this.getWeapon().weaponInfo();
                    System.out.println("Found weapon:");
                    bassProWeapon.weaponInfo();
                    System.out.println("Would you like to switch? ");
                    String switchResponse = input.nextLine();
                    switch (switchResponse){
                        case "Yes", "yes", "y":
                            System.out.println("You are now the proud owner of a " + bassProWeapon.getName() + "!");
                            this.setWeapon(bassProWeapon);
                            break;
                        case "No", "no", "n":
                            System.out.println("You drop the weapon on the ground and forget about it.");
                            break;
                    }

                }
                else {
                    System.out.println(this.getName() + " finds nothing but empty shelves and decides to go home.");
                }
                break;
        }
        this.setEnergy(startEnergy - (int)(Math.random()*(35-1+1)+1));
        System.out.println("\tEnergy: " + startEnergy + " -" + (startEnergy-this.getEnergy()) + " --> " + this.getEnergy());
    }

    /**
     * Gets the activity list specific to Scavenger class
     * @return activity list
     */
    @Override
    public String[] getActivityListClass() {
        return activityListClass;
    }

    /**
     * Gets the list explaining the actvities specific to Scavenger class
     * @return activity explanation list
     */
    @Override
    public String[] getActivityListExplainClass() {
        return activityListExplainClass;
    }

    /**
     * Parses the activity choice specific to Scavenger class
     * @param choice activity choice
     */
    @Override
    public void parseActivity(int choice) {
        Main.clear();
        switch (choice) {
            case 1:
                this.scavengeWalmart();
                break;
            case 2:
                this.takeANap();
                break;
            case 3:
                this.scavengeBassProShops();
                break;
        }
    }
}