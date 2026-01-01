package code;
class Warrior extends Person{
    // implements the activity's list and explanations to specific role
    private String[] activityListClass = {"Hunt for Food"};
    private  String[] activityListExplainClass = {"Regain Satiation. Lose Energy."};

    /**
     * Constructor for Warrior class
     * @param theName applies name to the person
     */
    public Warrior(String theName) {
        super(theName);
    }

    /**
     * Hunts for food
     */
    public void huntForFood() {
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