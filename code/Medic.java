package code;
class Medic extends Person{
    // implements the activity's list and explanations to specific role
    private String[] activityListClass = {"Heal Self"};
    private String[] activityListExplainClass = {"Regain Health"};

    /**
     * Constructor for Medic class
     * @param theName applies name to the person
     */
    public Medic(String theName) {
        super(theName);
        role = 2;
    }

    /**
     * Detailed constructor for Medic class, used for loading saved games
     * @param theDay current day
     * @param theHealth health of the person
     * @param theSatiation satiation of the person
     * @param theEnergy energy of the person
     * @param theVegan vegan/pacifist status of the person (1 for true, 0 for false)
     * @param theName name of the person
     */
    public Medic(int theDay, int theHealth, int theSatiation, int theEnergy, int theVegan, String theName) {
        super(theDay, theHealth, theSatiation, theEnergy, theVegan, theName);
        role = 2;
    }

    /**
     * Heals the medic, with console printing
     */
    public void healSelf() {
        int healAmount = (int)(Math.random()*(6)+3); // 3-8
        if (healAmount+this.getHealth()>100){
            healAmount=100-this.getHealth();
        }
        System.out.println(this.getName()+" starts to heal themselves.");
        System.out.println("\tHealth: " + this.getHealth() + " +" + healAmount + " --> " + (this.getHealth()+healAmount));
        this.setHealth(this.getHealth()+healAmount);
    }

    /**
     * Gets the activity list specific to Medic class
     * @return activity list
     */
    @Override
    public String[] getActivityListClass() {
        return activityListClass;
    }

    /**
     * Gets the list explaining the actvities specific to Medic class
     * @return activity explanation list
     */
    @Override
    public String[] getActivityListExplainClass() {
        return activityListExplainClass;
    }

    /**
     * Parses the activity choice specific to Medic class
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
                this.healSelf();
                break;
        }
    }
}