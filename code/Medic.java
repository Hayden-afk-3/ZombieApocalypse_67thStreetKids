package code;
class Medic extends Person{
    private  String[] activityListClass = {"Heal Self"};
    private  String[] activityListExplainClass = {"Regain Health"};
    public Medic(String theName) {
        super(theName);
    }
    public void healSelf() {
        int healAmount = (int)(Math.random()*11+5);
        if (healAmount+this.getHealth()>100){
            healAmount=100-this.getHealth();
            System.out.println("You have healed for " + healAmount + " health points. Your health is now full at 100.");
        } 
        else {
            this.setHealth(healAmount+this.getHealth());
            System.out.println("You have healed for " + healAmount + " health points. Your health is now " + (this.getHealth()+healAmount) + ".");
        }
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
                this.healSelf();
                break;
        }
    }
}