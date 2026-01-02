package code;
class Warrior extends Person{
    // implements the activity's list and explanations to specific role
    private String[] activityListClass = {"Hunt for Food"};
    private String[] activityListExplainClass = {"Regain Satiation. Lose Energy."};

    /**
     * Constructor for Warrior class
     * @param theName applies name to the person
     */
    public Warrior(String theName) {
        super(theName);
        role = 3;
    }

    /**
     * Detailed constructor for Warrior class, used for loading saved games
     * @param theDay current day
     * @param theHealth health of the person
     * @param theSatiation satiation of the person
     * @param theEnergy energy of the person
     * @param theVegan vegan/pacifist status of the person (1 for true, 0 for false)
     * @param theName name of the person
     */
    public Warrior(int theDay, int theHealth, int theSatiation, int theEnergy, int theVegan, String theName) {
        super(theDay, theHealth, theSatiation, theEnergy, theVegan, theName);
        role = 3;
    }

    /**
     * Hunts for food
     */
    public void huntForFood() {
        if (!this.getVegan()){
            System.out.println(this.getName() + " goes out to hunt for food.");
            int startEnergy = this.getEnergy();
            int startSatiation = this.getSatiation();
            int startHealth = this.getHealth();
            String[] huntedAnimals = {
                "cottontail rabbit","jackrabbit","ground squirrel","tree squirrel","black-tailed jackrabbit","mourning dove","band-tailed pigeon","California quail","mountain quail","ring-necked pheasant","mallard duck","wood duck","green-winged macaw","Canada goose","snow goose","wild turkey","plains coyote","desert coyote","gray fox","feral hog","wild boar","pronghorn antelope","black-tailed deer","mule deer","white-tailed deer","black bear","Rocky Mountain elk","Shiras moose"
            };
            int seed = this.getWeapon().getDamage();
            if (seed>huntedAnimals.length-1){
                seed = huntedAnimals.length-1;
            }
            seed = (int)(Math.random()*(seed-0+1+0));
            String foodItem = huntedAnimals[seed];
            if (Math.random()<0.01){
                System.out.println("You find a " + foodItem + ", and for a long moment the world seems to hold its breath.");
                input.nextLine();
                System.out.println("The " + foodItem + " stands there alive, unaware of the meaning you have already given it.");
                input.nextLine();
                System.out.println("Yet something in you resists.");
                input.nextLine();
                System.out.println("The weight of the days you've endured, the violence you've already accepted as necessary, hits you in your chest.");
                input.nextLine();
                System.out.println("You realize that survival should not demand the erasure of mercy, and that not every life must be taken simply because it can be.");
                input.nextLine();
                System.out.println("In this quiet pause, you choose restraint over instinct, compassion over need.");
                input.nextLine();
                System.out.println("You lower your " + this.getWeapon().getName() + ", step back, and allow the " + foodItem + " to disappear into the forest.");
                input.nextLine();
                System.out.println("For once, the apocalypse does not claim another heartbeat. " + this.getName() + "lets the " + foodItem + " go free.");
                System.out.println("\nYou gain no satiation, but gain some satisfaction.");
                System.out.println("\nYou are now a pacifist towards animals. You will no longer be able to hunt for food.");
                this.setVegan(true);
                activityListClass = new String[] {};
                activityListExplainClass = new String[] {};
            }
            else {
                this.setSatiation(startSatiation+seed+(int)(Math.random()*(5-0+1)+0));
                this.setEnergy(startEnergy-(int)(Math.random()*(10-5+1+5)));
                System.out.println("You find, hunt, and eat an entire " + foodItem + ".");
                System.out.println("\tSatiation: " + startSatiation + " +" + (this.getSatiation()-startSatiation) + " --> " + this.getSatiation());
                if (Math.random()<0.1){
                    System.out.println("You catch food poisoning from eating the " + foodItem + " raw.");
                    this.setHealth(startHealth/5);
                    System.out.println("\tHealth: " + startHealth + " -" + (startHealth-this.getHealth()) + " --> " + this.getHealth());
                }
                else if (Math.random()<0.01){
                    System.out.println("You catch salmonella from eating the " + foodItem + " raw.");
                    this.setHealth(startHealth/5);
                    System.out.println("\tHealth: " + startHealth + " -" + (startHealth-this.getHealth()) + " --> " + this.getHealth());
                }
            }
        }
    }
    
    /**
     * Gets the activity list specific to Warrior class
     * @return activity list
     */
    @Override
    public String[] getActivityListClass() {
        return activityListClass;
    }

    /**
     * Gets the list explaining the actvities specific to Warrior class
     * @return activity explanation list
     */
    @Override
    public String[] getActivityListExplainClass() {
        return activityListExplainClass;
    }

    /**
     * Parses the activity choice specific to Warrior class
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
                this.huntForFood();
                break;
        }
    }
}