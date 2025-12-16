package code;
class Scavenger extends Person{
    private  String[] activityListClass = {"Scavenge Bass Pro Shops"};
    private  String[] activityListExplainClass = {"High chance to find good loot. High chance of finding zombies."};
    public Scavenger(String theName) {
        super(theName);
    }
    public void scavengeBassProShops() {
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
                this.scavengeBassProShops();
                break;
        }
    }
}