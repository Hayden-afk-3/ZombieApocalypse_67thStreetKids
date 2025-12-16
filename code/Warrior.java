package code;
class Warrior extends Person{
    private String[] activityListClass = {"Hunt for Food"};
    private  String[] activityListExplainClass = {"Regain Satiation. Lose Energy."};
    public Warrior(String theName) {
        super(theName);
    }
    public void huntForFood() {
    }
    @Override
    public String[] getActivityListClass() {
        return activityListClass;
    }
    @Override
    public String[] getActivityListExplainClass() {
        return activityListExplainClass;
    }
    @Override
    public void parseActivity(int choice) {
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